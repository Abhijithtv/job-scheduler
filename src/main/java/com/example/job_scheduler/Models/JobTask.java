package com.example.job_scheduler.Models;


public class JobTask{
    int jobId;
    String meta;

    public JobTask(int jobId, String meta){
        this.jobId = jobId;
        this.meta = meta;
    }

    public void execute(){
        System.out.println("Execution started by ="+ jobId);
        for(int i=0; i<=100; i++){
            System.out.println("job id -"+ jobId +"...."+i+"% complete" + "(thread -"+Thread.currentThread().getName()+")");
        }
    }

}
