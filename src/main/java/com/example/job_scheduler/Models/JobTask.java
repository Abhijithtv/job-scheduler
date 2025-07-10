package com.example.job_scheduler.Models;


import java.util.UUID;

public class JobTask{
    public UUID jobId;
    public String payload;

    public JobTask(UUID jobId, String payload){
        this.jobId = jobId;
        this.payload = payload;
    }

    public void execute() throws InterruptedException {
        System.out.println("Execution started by thread" + Thread.currentThread().getName());
        Thread.sleep(10_000);

        System.out.println("Job completed for id-" + jobId + "& payload-" + payload);
    }

}
