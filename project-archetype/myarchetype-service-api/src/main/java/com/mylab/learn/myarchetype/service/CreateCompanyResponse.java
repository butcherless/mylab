package com.mylab.learn.myarchetype.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CreateCompanyResponse implements Serializable {
    private static final long serialVersionUID = -3990860942956501641L;

    public CreateCompanyResponse() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .toString();
    }
}
