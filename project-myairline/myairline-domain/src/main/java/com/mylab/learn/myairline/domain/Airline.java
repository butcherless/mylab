package com.mylab.learn.myairline.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "AIRLINE")
public class Airline extends AbstractEntity {

    @NotNull
    @Size(min = 1, max = 32)
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "airline")
    private List<Aircraft> aircrafts = new ArrayList<Aircraft>();

    public Airline() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void addAircraft(Aircraft aircraft) {
        this.aircrafts.add(aircraft);
        aircraft.setCompany(this);
    }

    public void removeAircraft(Aircraft aircraft) {
        this.aircrafts.remove(aircraft);
        aircraft.setCompany(null);
    }

    public Boolean hasAircrafts() {
        return !this.aircrafts.isEmpty();
    }

    public Integer aircraftCount() {
        return this.aircrafts.size();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(super.toString())
                .append("name", this.name)
                .append("aircrafts", this.aircrafts.size())
                .toString();
    }
}
