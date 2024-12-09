package com.nt.service;

import java.util.Optional;

import com.nt.entity.JobSeeker;

public interface IJobSeekerMgmtService {
    public  String   registerJobSeeker(JobSeeker js);
    public   Optional<JobSeeker>   showJobSeekerInfoById(int id);
}
