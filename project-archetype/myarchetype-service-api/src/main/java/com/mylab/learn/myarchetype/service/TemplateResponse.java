package com.mylab.learn.myarchetype.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Output data transfer object for an service operation
 * 
 * @author cmartin
 * 
 */
public class TemplateResponse implements Serializable {
	private static final long serialVersionUID = -6497550139770730644L;

	private final Boolean dummyResult;

	public TemplateResponse() {
		this.dummyResult = false;
	}

	public TemplateResponse(Boolean dummyResult) {
		this.dummyResult = dummyResult;
	}

	public Boolean getDummyResult() {
		return dummyResult;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		        .append("result", this.dummyResult)
		        .toString();
	}

}
