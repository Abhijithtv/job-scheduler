package com.example.job_scheduler.Common;

import com.example.job_scheduler.Models.JobTask;
import org.springframework.beans.factory.annotation.Autowired;

public class Worker implements Runnable{
    private final JobQueue jobQueue;

    public Worker(JobQueue jobQueue){
        this.jobQueue = jobQueue;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                JobTask task = jobQueue.poll();
                task.execute();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
