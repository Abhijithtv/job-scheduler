package com.example.job_scheduler.Helpers;

public class Logger {
    //todo- make it config
    static boolean isEnabled = true;

    public static void log(String msg){
        if(isEnabled){
            System.out.println(msg);
        }
    }
}
