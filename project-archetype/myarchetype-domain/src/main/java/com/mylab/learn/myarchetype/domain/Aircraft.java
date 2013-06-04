package com.mylab.learn.myarchetype.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "AIRCRAFT")
public class Aircraft {
	@Id
	@SequenceGenerator(name = "aircraftGen", sequenceName = "SEQ_AIRCRAFT")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "aircraftGen")
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	@NotNull
	@Size(min = 4, max = 32)
	private String registration;

	@NotNull
	@Size(min = 1, max = 32)
	private String name;

	/*
	 * unidirectional OneToMany
	 */
	@OneToMany(cascade= {CascadeType.ALL}, orphanRemoval=true)
	@JoinColumn(name="AIRCRAFT_ID")
	private List<Destination> destinations = new ArrayList<Destination>();

	public Aircraft() {
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

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}
	
	public List<Destination> getDestinations() {
		return destinations;
	}
	
	public void addDestination(Destination destination) {
		this.destinations.add(destination);
	}

	public Boolean hasDestinations() {
		return !this.destinations.isEmpty();
	}
	
	public Integer destinationCount() {
		return this.destinations.size();
	}

	public void removeDestination(Destination destination) {
		this.destinations.remove(destination);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("version", getVersion())
		.append("registration", this.registration)
		.append("name", this.name)
		.append("destinations", this.destinations.size())
		.toString();
	}

}
