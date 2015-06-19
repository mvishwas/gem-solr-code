package com.emc.gemfiresolr.gemfirereader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReaderMain {
	private static final Logger logger = LoggerFactory
			.getLogger(ReaderMain.class);

	public static void main(String[] args) {
		logger.info("********************** INDEX APPLICATION STARTED *********************");
		Long startTime = System.currentTimeMillis();
		logger.info("Start time : {} ", startTime);
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/META-INF/spring/launch-context.xml");

		GemfireReaderJobLauncher batchReader = context
				.getBean(GemfireReaderJobLauncher.class);
		batchReader.runJob();
		Long endTime = System.currentTimeMillis();
		logger.info("End time : {} ", endTime);
		logger.info("TIME TAKEN FOR INDEXING DATA IN SECONDS = {} ",
				(endTime - startTime) / 1000);
	}

}
