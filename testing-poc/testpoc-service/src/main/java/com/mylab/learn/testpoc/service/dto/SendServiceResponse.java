package com.mylab.learn.testpoc.service.dto;

import java.io.Serializable;

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
}
