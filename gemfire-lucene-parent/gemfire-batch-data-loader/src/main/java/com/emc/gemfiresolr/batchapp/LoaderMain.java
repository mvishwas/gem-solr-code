package com.emc.gemfiresolr.batchapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoaderMain {
	private static final Logger logger = LoggerFactory
			.getLogger(LoaderMain.class);

	public static void main(String[] args) {
		logger.info("**********************LOADER APPLICATION STARTED*********************");
		Long startTime = System.currentTimeMillis();
		logger.info("Start time : {} ", startTime);

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/META-INF/spring/launch-context.xml");
		GemfireLoaderJobLauncher batchLoader = context
				.getBean(GemfireLoaderJobLauncher.class);
		batchLoader.runJob();
		Long endTime = System.currentTimeMillis();
		logger.info("End time : {} ", endTime);
		logger.info("TIME TAKEN FOR DATA LOADER IN SECONDS = {} ",
				(endTime - startTime) / 1000);
	}
}
