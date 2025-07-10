package com.example.job_scheduler.Starters;

import com.example.job_scheduler.Common.JobQueue;
import com.example.job_scheduler.Common.ThreadPool;
import com.example.job_scheduler.Config.StarterConfig;
import com.example.job_scheduler.Repository.JobRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolStarter {

    private final JobQueue jobQueue;
    private final StarterConfig starterConfig;
    private final JobRepository jobRepository;

    @Autowired
    public ThreadPoolStarter(JobQueue jobQueue, StarterConfig starterConfig, JobRepository repository) {
        this.jobQueue = jobQueue;
        this.starterConfig = starterConfig;
        this.jobRepository = repository;
    }

    @PostConstruct
    public void startPool() {
        int poolSize = this.starterConfig.getThreadPool().getSize();
        ThreadPool threadPool = new ThreadPool(poolSize, jobQueue, jobRepository);
        threadPool.fillPool();
        threadPool.start();
        System.out.println("✅ Custom thread pool started with " + poolSize + " threads.");
    }
}
