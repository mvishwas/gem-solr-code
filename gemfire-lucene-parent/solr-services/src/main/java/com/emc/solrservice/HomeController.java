package com.emc.solrservice;

import java.util.Locale;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws SolrServerException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void search(Locale locale, Model model) throws SolrServerException {

		HttpSolrServer solr = new HttpSolrServer("http://10.63.39.168:8983/solr/customers");

		SolrQuery query = new SolrQuery();
		query.setQuery("ipod");
		query.setRows(10);
		QueryResponse response = solr.query(query);
		SolrDocumentList results = response.getResults();
		for (int i = 0; i < results.size(); ++i) {
			System.out.println("results found are " + results.get(i));
		}
		System.out.println("end");

	}

}
