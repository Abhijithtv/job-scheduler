package com.example.job_scheduler.Controllers;

import com.example.job_scheduler.Models.JobTask;
import com.example.job_scheduler.Services.JobScheduleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobScheduleService jobScheduleService;
    int counter = 100;
    public  JobController(JobScheduleService jobScheduleService){
        this.jobScheduleService = jobScheduleService;
    }


    @PostMapping
    public int Post(String meta){
        jobScheduleService.addJob(new JobTask(counter++, meta));
        return counter-1;
    }
}
