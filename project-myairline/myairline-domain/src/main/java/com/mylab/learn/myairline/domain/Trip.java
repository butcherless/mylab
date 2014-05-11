package com.mylab.learn.myairline.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author cmartin
 */
@Entity
@Table(name = "TRIP")
public class Trip extends AbstractEntity {
    private Date beginDate;
    private Date endDate;

    @NotNull
    @ManyToOne(optional = false)
    private Aircraft aircraft;

    @NotNull
    @ManyToOne(optional = false)
    private Route route;

    public Trip() {
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public Route getRoute() {
        return route;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(super.toString())
                .append("beginDate", this.beginDate)
                .append("endDate", this.endDate)
                .append("aircraft", this.aircraft)
                .append("route", this.route)
                .toString();
    }
}
