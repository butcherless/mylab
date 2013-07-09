package com.mylab.learn.myarchetype.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "AIRCRAFT")
public class Aircraft extends AbstractEntity {

    @NotNull
    @Size(min = 4, max = 8)
    @Column(nullable=false, unique=true)
    private String registration;

    @NotNull
    @Size(min = 1, max = 32)
    private String name;

    @ManyToOne
    private Company company;

    /*
     * unidirectional OneToMany
     */
    @OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "AIRCRAFT_ID")
    private List<Destination> destinations = new ArrayList<Destination>();

    public Aircraft() {
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

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
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
        .append(super.toString())
        .append("registration", this.registration)
        .append("name", this.name)
        .append("destinations", this.destinations.size())
        .toString();
    }

}
