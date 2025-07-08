package com.example.job_scheduler.Starters;

import com.example.job_scheduler.Handlers.ThreadPool;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolStarter {

    @PostConstruct
    public void startPool() {
        int poolSize = 4;
        ThreadPool threadPool = new ThreadPool(poolSize);
        threadPool.start();
        System.out.println("✅ Custom thread pool started with " + poolSize + " threads.");
    }
}
