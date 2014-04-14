package com.mylab.learn.myarchetype.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SearchAircraftByCompanyRequest implements Serializable {
	private static final long serialVersionUID = 8820668088172084901L;
	private final String companyName;

	public SearchAircraftByCompanyRequest(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.append("companyName", companyName).toString();
		return builder.toString();
	}

}
