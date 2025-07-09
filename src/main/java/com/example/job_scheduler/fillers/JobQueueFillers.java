package com.example.job_scheduler.fillers;

import com.example.job_scheduler.Common.JobQueue;
import com.example.job_scheduler.Config.FillerConfig;
import com.example.job_scheduler.Models.JobTask;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobQueueFillers {
    private final FillerConfig fillerConfig;
    private final JobQueue jobQueue;

    @Autowired
    public JobQueueFillers(JobQueue jobQueue, FillerConfig fillerConfig){
        this.jobQueue = jobQueue;
        this.fillerConfig = fillerConfig;
    }

    @PostConstruct
    public void  fill(){
        if(!this.fillerConfig.getJobQueue().getIsEnabled()){
            return;
        }

        for(int i=0; i<20; i++){
            this.jobQueue.add(new JobTask(i, "from i="+i));
        }
    }

}
