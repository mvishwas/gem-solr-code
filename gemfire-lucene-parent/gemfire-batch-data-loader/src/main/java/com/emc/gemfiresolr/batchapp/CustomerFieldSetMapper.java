package com.emc.gemfiresolr.batchapp;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.emc.gemfiresolr.domain.Customer;

public class CustomerFieldSetMapper implements FieldSetMapper<Customer> {

	@Override
	public Customer mapFieldSet(FieldSet fieldSet) throws BindException {

		Customer customer = new Customer(fieldSet.readLong("KEY"));
		customer.setFirstname(fieldSet.readString("FIRSTNAME"));
		customer.setLastname(fieldSet.readString("LASTNAME"));
		customer.setAge(fieldSet.readInt("AGE"));
		customer.setEmailAddress(fieldSet.readString("EMAIL"));
		customer.setBirthDate(fieldSet.readDate("DOB"));
		customer.setBirthPlace(fieldSet.readString("PLACEOFBIRTH"));

		return customer;
	}
}
