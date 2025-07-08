package com.example.job_scheduler.Handlers;

import com.example.job_scheduler.Models.JobTask;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    private final List<Thread> threads;

    public ThreadPool(int activationCount){
        threads = new ArrayList<>();
        fillPool(activationCount);
    }

    private void fillPool(int activationCount) {
        for(int i=0; i<activationCount; i++){
            threads.add(new Thread(new JobTask(), "Worker-" + i));
        }
    }

    public void start(){
        threads.forEach(Thread::start);
    }

    public void printStatus() {
        threads.forEach(t -> System.out.println(t.getName() + " - " + t.getState()));
    }
}
