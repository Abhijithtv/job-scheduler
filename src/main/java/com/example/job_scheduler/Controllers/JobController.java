package com.example.job_scheduler.Controllers;

import com.example.job_scheduler.Models.Job;
import com.example.job_scheduler.Models.JobInfo;
import com.example.job_scheduler.Services.Implementations.JobService;
import com.example.job_scheduler.Services.Interfaces.IJobService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/jobs")
@Validated
public class JobController {

    private final IJobService jobService;

    @Autowired
    public  JobController(IJobService jobService){
        this.jobService = jobService;
    }

    @GetMapping
    public Job Get(@RequestParam @NotNull UUID id){
        return jobService.getJob(id);
    }


    @PostMapping
    public UUID Post(@Validated @RequestBody JobInfo jobInfo){
        return jobService.addJob(jobInfo);
    }
}
