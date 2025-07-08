package com.example.job_scheduler.Services;

import com.example.job_scheduler.Common.JobQueue;
import com.example.job_scheduler.Models.JobTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobScheduleService {

    private final JobQueue jobQueue;
    @Autowired
    public JobScheduleService(JobQueue jobQueue){
        this.jobQueue = jobQueue;
    }

    public void addJob(JobTask task){
        jobQueue.add(task);
    }
}
