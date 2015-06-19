package com.emc.gemfiresolr.gemfirereader;

import java.util.List;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.gemfire.GemfireTemplate;

import com.emc.gemfiresolr.domain.Customer;
import com.emc.gemfiresolr.repositories.CustomerRepository;

public class GemfireIndexWriter implements Tasklet {

	private static final Logger logger = LoggerFactory
			.getLogger(GemfireIndexWriter.class);

	@Autowired
	private CustomerRepository repo;

	@Autowired
	GemfireTemplate customerTemplate;

	@Value("${gemfire.getCustomerKeyQuery}")
	private String getCustomerKeyQuery;

	@Value("${solr.url}")
	private String solrUrl;

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		List<Object> cc = customerTemplate.find(getCustomerKeyQuery).asList();

		HttpSolrServer server = new HttpSolrServer(solrUrl);
		for (int i = 0; i < cc.size(); ++i) {
			SolrInputDocument doc = new SolrInputDocument();
			Customer cust = customerTemplate.get(cc.get(i));
			logger.info("CUSTOMER OBJECT : {} ", cust);
			if (null != cust) {
				doc.addField("id", cust.getId());
				doc.addField("firstname", cust.getFirstname());
				doc.addField("lastname", cust.getLastname());
				doc.addField("email", cust.getEmailAddress());
				doc.addField("gemfireurl","http://10.63.39.169:41111/"+cust.getId());
				server.add(doc);
			}
			if (i % 100 == 0)
				server.commit(); // periodically flush
		}
		
		server.commit();
		return RepeatStatus.FINISHED;
	}
}
