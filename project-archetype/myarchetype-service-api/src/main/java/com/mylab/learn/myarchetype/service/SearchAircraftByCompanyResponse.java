package com.mylab.learn.myarchetype.service;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SearchAircraftByCompanyResponse implements Serializable {
    private static final long serialVersionUID = 1291698637547379680L;

    private final List<AircraftSumary> aircraftSumaryList;

    public SearchAircraftByCompanyResponse(List<AircraftSumary> aircraftSumaryList) {
        this.aircraftSumaryList = aircraftSumaryList;

        if (aircraftSumaryList == null) {
            throw new IllegalArgumentException("Aircraft sumary list can't be null");
        }
    }

    public Boolean hasData() {
        return !this.aircraftSumaryList.isEmpty();
    }

    public Integer aircraftCount() {
        return this.aircraftSumaryList.size();
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append("hasData", this.hasData());
        builder.append("aircraftSumaryList", aircraftSumaryList.size());
        return builder.toString();
    }

}
