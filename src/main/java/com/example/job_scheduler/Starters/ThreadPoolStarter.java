package com.example.job_scheduler.Starters;

import com.example.job_scheduler.Common.JobQueue;
import com.example.job_scheduler.Common.ThreadPool;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolStarter {

    private final JobQueue jobQueue;

    @Autowired
    public ThreadPoolStarter(JobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }

    @PostConstruct
    public void startPool() {
        int poolSize = 4;
        ThreadPool threadPool = new ThreadPool(poolSize, jobQueue);
        threadPool.start();
        System.out.println("✅ Custom thread pool started with " + poolSize + " threads.");
    }
}
