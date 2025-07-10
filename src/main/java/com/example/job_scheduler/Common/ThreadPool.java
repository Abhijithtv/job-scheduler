package com.example.job_scheduler.Common;

import com.example.job_scheduler.Models.JobTask;
import com.example.job_scheduler.Repository.JobRepository;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    private final List<Thread> threads;
    private final JobQueue jobQueue;
    private final JobRepository jobRepository;
    private final int activationCount;

    public ThreadPool(int activationCount, JobQueue jobQueue, JobRepository jobRepository){
        this.threads = new ArrayList<>();
        this.jobQueue = jobQueue;
        this.jobRepository = jobRepository;
        this.activationCount = activationCount;
    }

    public void fillPool() {
        for(int i=0; i<activationCount; i++){
            threads.add(new Thread(new Worker(jobQueue, jobRepository), "Worker-" + i));
        }
    }

    public void start(){
        threads.forEach(Thread::start);
    }

    public void printStatus() {
        threads.forEach(t -> System.out.println(t.getName() + " - " + t.getState()));
    }
}
