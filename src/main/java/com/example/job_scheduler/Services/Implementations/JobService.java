package com.example.job_scheduler.Services.Implementations;

import com.example.job_scheduler.Helpers.JobBuilder;
import com.example.job_scheduler.Models.Job;
import com.example.job_scheduler.Models.JobInfo;
import com.example.job_scheduler.Repository.JobRepository;
import com.example.job_scheduler.Services.Interfaces.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JobService implements IJobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    @Override
    public Job getJob(UUID id){
        return this.jobRepository.findById(id).orElse(null);
    }


    @Override
    public UUID addJob(JobInfo jobInfo){
        Job job = JobBuilder.Build(jobInfo);
        this.jobRepository.save(job);
        return job.id;
    }
}
