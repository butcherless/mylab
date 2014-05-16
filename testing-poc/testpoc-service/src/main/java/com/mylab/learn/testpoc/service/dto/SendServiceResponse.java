package com.mylab.learn.testpoc.service.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author cmartin
 *
 */
public class SendServiceResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2083020757438734744L;

    private Boolean stored;

    public SendServiceResponse(Boolean stored) {
        this.stored = stored;
    }

    public Boolean isStored() {
        return this.stored;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("stored", this.stored)
                .toString();
    }

}
