/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.emc.gemfiresolr.domain;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.gemfire.mapping.Region;
import org.springframework.util.Assert;

@Region
public class Customer extends AbstractPersistentEntity {

	private static final long serialVersionUID = -3860687524824507124L;

	/*
	 * @javax.persistence.Id
	 * 
	 * @org.springframework.data.annotation.Id
	 */
	//private String key;

	private String emailAddress;
	private Integer age;
	private String firstname, lastname;
	private Set<Address> addresses = new HashSet<Address>();

	private String additionalName;
	private String affiliation;
	private Date birthDate;
	private String birthPlace;

	private Date deathDate;
	private String deathPlace;

	/**
	 * Creates a new {@link Customer} from the given parameters.
	 * 
	 * @param id
	 *            the unique id;
	 * @param emailAddress
	 *            must not be {@literal null} or empty.
	 * @param firstname
	 *            must not be {@literal null} or empty.
	 * @param lastname
	 *            must not be {@literal null} or empty.
	 */
	/*
	 * public Customer(Long id, EmailAddress emailAddress, String firstname,
	 * String lastname) { super(id); Assert.hasText(firstname);
	 * Assert.hasText(lastname); Assert.notNull(emailAddress);
	 * 
	 * this.firstname = firstname; this.lastname = lastname; this.emailAddress =
	 * emailAddress; }
	 */

	public Customer(Long id) {
		super(id);
	}

	/**
	 * Adds the given {@link Address} to the {@link Customer}.
	 * 
	 * @param address
	 *            must not be {@literal null}.
	 */
	public void add(Address address) {

		Assert.notNull(address);
		this.addresses.add(address);
	}

	/**
	 * Returns the firstname of the {@link Customer}.
	 * 
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname of the {@link Customer}.
	 * 
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Returns the lastname of the {@link Customer}.
	 * 
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname of the {@link Customer}.
	 * 
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Returns the {@link EmailAddress} of the {@link Customer}.
	 * 
	 * @return
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the emailAddress of the {@link Customer}.
	 * 
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Return the {@link Customer}'s addresses.
	 * 
	 * @return
	 */
	public Set<Address> getAddresses() {
		return Collections.unmodifiableSet(addresses);
	}

	public String getAdditionalName() {
		return additionalName;
	}

	public void setAdditionalName(String additionalName) {
		this.additionalName = additionalName;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathPlace() {
		return deathPlace;
	}

	public void setDeathPlace(String deathPlace) {
		this.deathPlace = deathPlace;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [emailAddress=");
		builder.append(emailAddress);
		builder.append(", age=");
		builder.append(age);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append(", lastname=");
		builder.append(lastname);
		builder.append(", addresses=");
		builder.append(addresses);
		builder.append(", additionalName=");
		builder.append(additionalName);
		builder.append(", affiliation=");
		builder.append(affiliation);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", birthPlace=");
		builder.append(birthPlace);
		builder.append(", deathDate=");
		builder.append(deathDate);
		builder.append(", deathPlace=");
		builder.append(deathPlace);
		builder.append("]");
		return builder.toString();
	}

	

}
