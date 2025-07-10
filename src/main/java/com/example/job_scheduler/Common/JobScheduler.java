package com.example.job_scheduler.Common;

import com.example.job_scheduler.Enums.JobStatus;
import com.example.job_scheduler.Helpers.Logger;
import com.example.job_scheduler.Models.Job;
import com.example.job_scheduler.Models.JobTask;
import com.example.job_scheduler.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobScheduler {
    private final JobQueue jobQueue;
    private final JobRepository jobRepository;

    @Autowired
    public JobScheduler(JobQueue jobQueue, JobRepository jobRepository){
        this.jobQueue = jobQueue;
        this.jobRepository = jobRepository;
    }

    @Scheduled(fixedDelay = 5000)
    public void schedule(){
        List<Job> jobsToProcess = getJobsToProcess();

        changeJobStatusToProcessing(jobsToProcess);
        jobQueue.addAll(jobsToProcess.stream()
                                     .map(x->new JobTask(x.id, x.payload))
                                     .toList());

    }

    private void changeJobStatusToProcessing(List<Job> jobsToProcess) {
        jobsToProcess.forEach(x -> x.status = JobStatus.Processing.getCode());
        jobRepository.saveAll(jobsToProcess);
    }

    private List<Job> getJobsToProcess() {
        long curTime = Instant.now().toEpochMilli();
        List<Job> jobsToProcess = new ArrayList<>();

        for (Job job : this.jobRepository.findAll()) {
            if (job.waitPeriod > curTime) continue;
            if (JobStatus.Completed.getCode() == job.status) continue;
            if (JobStatus.Processing.getCode() == job.status) continue;
            jobsToProcess.add(job);
        }

        jobsToProcess.forEach(x->Logger.log("Added to job queue (job id-"+x.id+")"));
        return jobsToProcess;
    }

}
