package com.example.job_scheduler.Common;

import com.example.job_scheduler.Models.JobTask;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    private final List<Thread> threads;
    private final JobQueue jobQueue;

    public ThreadPool(int activationCount, JobQueue jobQueue){
        this.threads = new ArrayList<>();
        this.jobQueue = jobQueue;
        fillPool(activationCount);
    }

    private void fillPool(int activationCount) {
        for(int i=0; i<activationCount; i++){
            threads.add(new Thread(new Worker(jobQueue), "Worker-" + i));
        }
    }

    public void start(){
        threads.forEach(Thread::start);
    }

    public void printStatus() {
        threads.forEach(t -> System.out.println(t.getName() + " - " + t.getState()));
    }
}
