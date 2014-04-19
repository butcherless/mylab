package com.mylab.learn.myarchetype.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CreateDestinationResponse implements Serializable {
    private static final long serialVersionUID = 8510039486145309162L;
    private final OperationResultEnum operationResult;

    public CreateDestinationResponse(OperationResultEnum operationResult) {
        this.operationResult = operationResult;
    }

    public OperationResultEnum getOperationResult() {
        return operationResult;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append("operationResult", this.operationResult);
        return builder.toString();
    }
}
