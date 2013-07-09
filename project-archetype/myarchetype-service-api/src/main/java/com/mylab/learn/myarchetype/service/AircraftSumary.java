package com.mylab.learn.myarchetype.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AircraftSumary implements Serializable {
    private static final long serialVersionUID = -5916319208325015688L;

    private final String name;
    private final String registration;

    public AircraftSumary(String name, String registration) {
        this.name = name;
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public String getRegistration() {
        return registration;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append("name", name);
        builder.append("registration", registration);
        return builder.toString();
    }   
}
