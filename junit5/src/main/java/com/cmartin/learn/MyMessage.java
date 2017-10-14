package com.cmartin.learn;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MyMessage implements Serializable {
    private String subject;
    private LocalDateTime dateTime;


    public MyMessage(String subject, LocalDateTime dateTime) {
        this.subject = subject;
        this.dateTime = dateTime;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
