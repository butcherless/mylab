package com.mylab.learn.jaranalyzer.service;

public class JarAnalizerException extends RuntimeException {
    private static final long serialVersionUID = -46302246771621906L;

    public JarAnalizerException(String message) {
        super(message);
    }

    public JarAnalizerException(String message, Throwable cause) {
        super(message, cause);
    }

}
