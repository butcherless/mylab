package com.mylab.learn.testpoc.service;

public class MessageServiceException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 4338432580929058169L;

    public MessageServiceException() {
    }

    public MessageServiceException(String message) {
        super(message);
    }

    public MessageServiceException(Throwable cause) {
        super(cause);
    }

    public MessageServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
