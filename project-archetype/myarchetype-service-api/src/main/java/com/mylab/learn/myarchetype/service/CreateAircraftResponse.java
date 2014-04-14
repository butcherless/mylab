package com.mylab.learn.myarchetype.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CreateAircraftResponse implements Serializable {
	private static final long serialVersionUID = -4128430927914309557L;
	private final OperationResultEnum operationResult;

	public CreateAircraftResponse(OperationResultEnum operationResult) {
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
