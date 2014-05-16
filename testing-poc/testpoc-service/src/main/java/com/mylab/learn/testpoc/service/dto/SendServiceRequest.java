package com.mylab.learn.testpoc.service.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mylab.learn.testpoc.service.MessageType;

/**
 * 
 * @author cmartin
 *
 */
public class SendServiceRequest implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 6892437698669807220L;

    private final String subject;
    private final String body;

    private final MessageType messageType;

    public SendServiceRequest(MessageType messageType, String subject, String body) {
        this.messageType = messageType;
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("messageType", this.messageType)
                .append("subject", this.subject)
                .append("body", this.body)
                .toString();
    }
}
