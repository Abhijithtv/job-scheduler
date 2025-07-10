package com.example.job_scheduler.Helpers;

import com.example.job_scheduler.Enums.JobStatus;
import com.example.job_scheduler.Models.Job;
import com.example.job_scheduler.Models.JobInfo;

import java.util.UUID;

public class JobBuilder {
    public static Job Build(JobInfo jobInfo){
        Job job = new Job();
        job.id = UUID.randomUUID();
        job.payload = jobInfo.getPayload();
        job.waitPeriod = jobInfo.getWaitPeriod();
        job.status = JobStatus.Pending.getCode();
        return job;
    }
}
