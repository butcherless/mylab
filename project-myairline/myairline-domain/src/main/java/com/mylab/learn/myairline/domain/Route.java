package com.mylab.learn.myairline.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author cmartin
 */
@Entity
@Table(name = "ROUTE")
public class Route extends AbstractEntity {

    @NotNull
    @Size(min = 1, max = 32)
    private String name;

    @NotNull
    @ManyToOne(optional=false)
    private Destination startDestination;

    @NotNull
    @ManyToOne(optional=false)
    private Destination stopDestination;

    public Route() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Destination getStartDestination() {
        return startDestination;
    }

    public void setStartDestination(Destination startDestination) {
        this.startDestination = startDestination;
    }

    public Destination getStopDestination() {
        return stopDestination;
    }

    public void setStopDestination(Destination stopDestination) {
        this.stopDestination = stopDestination;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(super.toString())
                .append("name", this.name)
                .append("start", this.startDestination)
                .append("stop", this.stopDestination)
                .toString();
    }
}
