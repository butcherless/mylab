package com.mylab.learn.myarchetype.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Template entity for simple persistence operations
 * 
 * @author cmartin
 * 
 */
@Entity
@Table(name = "TABLE_TEMPLATE")
public class TemplateEntity extends AbstractEntity {

    @NotNull
    @Size(min = 8, max = 64)
    private String name;

    /**
     * default constructor
     */
    public TemplateEntity() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(super.toString())
                .append("name", this.name)
                .toString();
    }
}
