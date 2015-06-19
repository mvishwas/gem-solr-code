package com.emc.gemfiresolr.batchapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;

public class GemfireLoaderJobLauncher {

	private JobLauncher jobLauncher;

	private Job job;

	@Autowired
	Properties batchResources;

	public void runJob() {
		JobParametersBuilder params = new JobParametersBuilder();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		params.addLong("time", new Date().getTime());
		params.addString("gemfiredata.file.name",
				batchResources.getProperty("gemfiredata.file.name"));
		try {
			jobLauncher.run(job, params.toJobParameters());
		} catch (JobExecutionAlreadyRunningException | JobRestartException
				| JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}

	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}
