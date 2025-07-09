package com.example.job_scheduler.Config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("filler")
public class FillerConfig {
    private JobQueue jobQueue;

    public JobQueue getJobQueue()
    {
        return jobQueue;
    }

    public void setJobQueue(JobQueue val){
        this.jobQueue = val;
    }

    public static class JobQueue{
        private boolean isEnabled;

        public boolean getIsEnabled(){
            return  isEnabled;
        }

        public void  setIsEnabled(boolean val){
            isEnabled = val;
        }

    }
    public boolean isEnabled;
}
