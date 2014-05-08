package com.mylab.learn.myairline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
    @Column(nullable = false, unique = true)
    private String registration;

    @NotNull
    @Size(min = 1, max = 32)
    private String name;

    @ManyToOne
    private Airline airline;

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

    public void setCompany(Airline airline) {
        this.airline = airline;
    }

    public Airline getAirline() {
        return this.airline;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(super.toString())
                .append("registration", this.registration)
                .append("name", this.name)
                .toString();
    }

}
