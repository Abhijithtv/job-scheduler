package com.example.job_scheduler.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

//todo-add indexing
@RedisHash(value = "Job")
public class Job {
    @Id
    public UUID id;
    public int failCount;
    public int retryCount;
    public long epoch;
    public int status; // 2 done, 1 scheduled, 0 ignore
    public long waitPeriod;
    public String payload;

}
