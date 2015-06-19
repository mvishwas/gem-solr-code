package com.emc.gemfiresolr.repositories;

import org.springframework.data.gemfire.repository.GemfireRepository;
import org.springframework.stereotype.Repository;

import com.emc.gemfiresolr.domain.Customer;

@Repository
public interface CustomerRepository extends GemfireRepository<Customer, Long> {

}
