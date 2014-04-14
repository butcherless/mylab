package com.mylab.learn.myarchetype.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CreateAircraftRequest implements Serializable {
	private static final long serialVersionUID = 3456537126366787099L;

	private final String name;
	private final String registration;
	private final String companyName;

	public CreateAircraftRequest(String name, String registration, String companyName) {
		this.name = name;
		this.registration = registration;
		this.companyName = companyName;
	}

	public String getName() {
		return name;
	}

	public String getRegistration() {
		return registration;
	}

	public String getCompanyName() {
		return companyName;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.append("name", name);
		builder.append("registration", registration);
		builder.append("companyName", companyName);
		return builder.toString();
	}

}
