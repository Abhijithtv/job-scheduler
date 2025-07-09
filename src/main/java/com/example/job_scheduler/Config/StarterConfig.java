package com.example.job_scheduler.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
//
//@Component
//@ConfigurationProperties(prefix = "starter")
//public class StarterConfig {
//    private ThreadPool threadPool;
//
//    public ThreadPool GetThreadPoolConfig(){
//        return threadPool;
//    }
//
//
//    public static  class ThreadPool{
//        private  int size;
//        private  boolean isEnabled;
//
//        public int GetSize(){
//            return size;
//        }
//
//        public boolean IsEnabled(){
//            return isEnabled;
//        }
//    }
//}


@Configuration
@ConfigurationProperties(prefix = "starter")
public class StarterConfig {

    private ThreadPool threadPool;

    public ThreadPool getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(ThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    public static class ThreadPool {
        private int size;
        private boolean isEnabled;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public boolean isEnabled() {
            return isEnabled;
        }

        public void setEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
        }
    }
}