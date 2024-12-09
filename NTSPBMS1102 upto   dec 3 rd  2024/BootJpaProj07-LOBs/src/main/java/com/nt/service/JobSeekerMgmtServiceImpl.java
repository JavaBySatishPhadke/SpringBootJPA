package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeeker;
import com.nt.repository.IJobSeekerRepository;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {
	@Autowired
	private  IJobSeekerRepository  jobRepo;

	@Override
	public String registerJobSeeker(JobSeeker js) {
		int idVal=jobRepo.save(js).getJsId();
		return "JobSeeker is registered with id Value:"+idVal;
	}

	@Override
	public Optional<JobSeeker> showJobSeekerInfoById(int id) {
	    return  jobRepo.findById(id);
	}

}
