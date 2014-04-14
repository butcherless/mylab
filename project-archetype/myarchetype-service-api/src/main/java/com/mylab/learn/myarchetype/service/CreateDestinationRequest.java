package com.mylab.learn.myarchetype.service;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CreateDestinationRequest implements Serializable {
	private static final long serialVersionUID = -408142248388887741L;

	private final String airportName;
	private final String shortCode;

	public CreateDestinationRequest(String airportName, String shortCode) {
		this.airportName = airportName;
		this.shortCode = shortCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public String getShortCode() {
		return shortCode;
	}

	public Boolean hasData() {
		return StringUtils.isNotBlank(this.airportName) && StringUtils.isNotBlank(this.shortCode);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		        .append("airportName", this.airportName)
		        .append("shortCode", this.shortCode)
		        .append("hasData", this.hasData())
		        .toString();
	}
}
