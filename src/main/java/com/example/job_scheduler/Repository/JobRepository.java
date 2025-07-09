package com.example.job_scheduler.Repository;

import com.example.job_scheduler.Models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobRepository extends CrudRepository<Job, UUID> {}
