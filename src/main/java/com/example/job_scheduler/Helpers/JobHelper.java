package com.example.job_scheduler.Helpers;

import com.example.job_scheduler.Enums.JobStatus;
import com.example.job_scheduler.Models.Job;

import java.time.Instant;

public class JobHelper {
    public static void updateJobState(Job job, boolean isSuccess){
        if(job.waitPeriod==0){
            job.retryCount = isSuccess ? 0 : job.retryCount + 1;

            job.status = isSuccess || job.retryCount >3 ?
                    JobStatus.Completed.getCode() :
                    JobStatus.Failed.getCode();
        }
        else{
            job.retryCount = isSuccess ? 0 : job.retryCount + 1;

            job.status = !isSuccess && job.retryCount < 3 ?
                    JobStatus.Failed.getCode() :
                    JobStatus.Pending.getCode(); //for time being schedule it for next interval

            job.epoch = isSuccess ?
                    Instant.now().toEpochMilli() + job.waitPeriod :
                    job.epoch; //don't inc time on fail
        }

    }
}
