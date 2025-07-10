package com.example.job_scheduler.Common;

import com.example.job_scheduler.Models.JobTask;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
public class JobQueue {
    Queue<JobTask> queue;

    public JobQueue(){
        queue = new LinkedList<>();
    }

    public synchronized void add(JobTask jobTask){
        queue.add(jobTask);
        notifyAll();
    }

    public synchronized void addAll(List<JobTask> jobTasks){
        queue.addAll(jobTasks);
        notifyAll();
    }

    public synchronized JobTask poll() throws InterruptedException {
        while (queue.isEmpty()){
            wait();
        }
        return  queue.poll();
    }
}
