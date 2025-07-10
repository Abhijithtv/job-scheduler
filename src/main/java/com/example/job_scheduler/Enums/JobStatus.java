package com.example.job_scheduler.Enums;

public enum JobStatus {
    Pending(0),
    Processing(1),
    Completed(2),
    Failed(3);

    private final int code;

    JobStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static JobStatus fromValue(int code) {
        for (JobStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid JobStatus code: " + code);
    }
}
