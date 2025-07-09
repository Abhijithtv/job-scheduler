package com.example.job_scheduler.Starters;

import com.example.job_scheduler.Common.JobQueue;
import com.example.job_scheduler.Common.ThreadPool;
import com.example.job_scheduler.Config.StarterConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolStarter {

    private final JobQueue jobQueue;
    private final StarterConfig starterConfig;

    @Autowired
    public ThreadPoolStarter(JobQueue jobQueue, StarterConfig starterConfig) {
        this.jobQueue = jobQueue;
        this.starterConfig = starterConfig;
    }

    @PostConstruct
    public void startPool() {
        if(!this.starterConfig.getThreadPool().isEnabled()){
            return;
        }
        int poolSize = this.starterConfig.getThreadPool().getSize();
        ThreadPool threadPool = new ThreadPool(poolSize, jobQueue);
        threadPool.start();
        System.out.println("✅ Custom thread pool started with " + poolSize + " threads.");
    }
}
