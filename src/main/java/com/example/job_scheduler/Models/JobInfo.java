package com.example.job_scheduler.Models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class JobInfo {

    @NotNull(message = "Payload must not be null")
    private String payload;

    @Min(value = 0, message = "Wait period must be >= 0")
    private long waitPeriod;
    
    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public long getWaitPeriod() {
        return waitPeriod;
    }

    public void setWaitPeriod(long waitPeriod) {
        this.waitPeriod = waitPeriod;
    }
}

