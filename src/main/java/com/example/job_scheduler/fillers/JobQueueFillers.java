package com.example.job_scheduler.fillers;

import com.example.job_scheduler.Common.JobQueue;
import com.example.job_scheduler.Models.JobTask;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobQueueFillers {


    private final JobQueue jobQueue;

    @Autowired
    public JobQueueFillers(JobQueue jobQueue){
        this.jobQueue = jobQueue;
    }

    @PostConstruct
    public void  fill(){
        for(int i=0; i<20; i++){
            this.jobQueue.add(new JobTask(i, "from i="+i));
        }
    }

}
