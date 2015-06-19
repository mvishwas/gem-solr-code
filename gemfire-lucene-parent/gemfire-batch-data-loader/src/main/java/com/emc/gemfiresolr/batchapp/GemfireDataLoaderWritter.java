package com.emc.gemfiresolr.batchapp;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.emc.gemfiresolr.domain.Customer;
import com.gemstone.gemfire.cache.Region;

public class GemfireDataLoaderWritter implements ItemWriter<Customer> {

	private Region customerRegion;

	@Override
	public void write(List<? extends Customer> items) throws Exception {
		for (Customer c : items) {
			customerRegion.put(c.getId(), c);
		}
	}

	public Region getCustomerRegion() {
		return customerRegion;
	}

	public void setCustomerRegion(Region customerRegion) {
		this.customerRegion = customerRegion;
	}

}
