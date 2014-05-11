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
    @ManyToOne(optional = false)
    private Location origin;

    @NotNull
    @ManyToOne(optional = false)
    private Location destination;

    public Route() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getDestination() {
        return destination;
    }

    public Location getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(super.toString())
                .append("name", this.name)
                .append("origin", this.origin)
                .append("destination", this.destination)
                .toString();
    }
}
