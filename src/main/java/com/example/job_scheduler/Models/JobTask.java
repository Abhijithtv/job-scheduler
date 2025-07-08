package com.example.job_scheduler.Models;

public class JobTask implements Runnable{

    @Override
    public void run() {
        /*
            while(no task to do){
                wait();
                exec();
            }
            wait for
         */
        System.out.println("Waiting for task");
    }
}
