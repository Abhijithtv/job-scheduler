package com.example.job_scheduler.Services.Interfaces;

import com.example.job_scheduler.Models.Job;
import com.example.job_scheduler.Models.JobInfo;

import java.util.UUID;

public interface IJobService {
    public UUID addJob(JobInfo jobInfo);
    public Job getJob(UUID id);
}
