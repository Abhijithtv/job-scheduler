package com.example.job_scheduler.Common;

import com.example.job_scheduler.Models.Job;
import com.example.job_scheduler.Models.JobTask;
import com.example.job_scheduler.Repository.JobRepository;
import com.example.job_scheduler.Helpers.JobHelper;

public class Worker implements Runnable{
    private final JobQueue jobQueue;
    private final JobRepository jobRepository;

    public Worker(JobQueue jobQueue, JobRepository jobRepository){
        this.jobQueue = jobQueue;
        this.jobRepository = jobRepository;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            boolean isSuccess = false;
            JobTask task = null;
            try {
                task = jobQueue.poll();
                task.execute();
                isSuccess = true;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Exception ignored){
                //add log to fail
                assert task != null;
                System.out.println("task with id-"+task.jobId+" has failed");
            }
            handleTaskStatus(task, isSuccess);
        }
    }

    private void handleTaskStatus(JobTask task, boolean isSuccess) {
        if(task==null) return;

        Job job = jobRepository.findById(task.jobId).orElse(null);

        if(job == null){
            return;
        }
        JobHelper.updateJobState(job, isSuccess);
        jobRepository.save(job);
    }
}
