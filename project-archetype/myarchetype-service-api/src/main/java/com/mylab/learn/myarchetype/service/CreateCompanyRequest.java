package com.mylab.learn.myarchetype.service;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CreateCompanyRequest implements Serializable {
    private static final long serialVersionUID = 213281951522189101L;

    private final String name;

    public CreateCompanyRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean hasData() {
        return StringUtils.isNotBlank(this.name);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("dummyProperty", this.name)
                .append("hasData", this.hasData())
                .toString();
    }
}
