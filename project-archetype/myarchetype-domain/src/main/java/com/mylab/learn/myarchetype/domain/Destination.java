package com.mylab.learn.myarchetype.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author cmartin
 * 
 */
@Entity
@Table(name = "DESTINATION")
public class Destination extends AbstractEntity {

	@NotNull
	@Size(min = 3, max = 3)
	@Column(unique = true)
	private String shortCode;

	@NotNull
	@Size(min = 1, max = 32)
	private String airportName;

	public Destination() {
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		    .append(super.toString())
		    .append("shortCode", this.shortCode)
		    .append("airportName", this.airportName)
		    .toString();
	}

}
