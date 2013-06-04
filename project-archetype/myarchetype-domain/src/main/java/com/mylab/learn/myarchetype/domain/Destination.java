package com.mylab.learn.myarchetype.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
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
public class Destination {
	@Id
	@SequenceGenerator(name = "destinationGen", sequenceName = "SEQ_DESTINATION")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "destinationGen")
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	@NotNull
	@Size(min = 3, max = 3)
	private String shortCode;

	@NotNull
	@Size(min = 1, max = 32)
	private String airportName;

	public Destination() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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
		.append("id", getId())
		.append("version", getVersion())
		.append("shortCode", this.shortCode)
		.append("airportName", this.airportName)
		.toString();
	}
	
}
