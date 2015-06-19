package com.emc.gemfiresolr.gemfirereader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

public class GemfireReaderJobLauncher {

	private JobLauncher jobLauncher;

	private Job job;

	public void runJob() {
		JobParametersBuilder params = new JobParametersBuilder();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		params.addLong("time", new Date().getTime());
		try {
			jobLauncher.run(job, params.toJobParameters());
		} catch (Exception e) {
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
