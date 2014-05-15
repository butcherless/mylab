package com.mylab.learn.testpoc.service.dto;

import java.io.Serializable;

public class SendServiceRequest implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 6892437698669807220L;

    private final String subject;
    private final String body;

    public SendServiceRequest(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
