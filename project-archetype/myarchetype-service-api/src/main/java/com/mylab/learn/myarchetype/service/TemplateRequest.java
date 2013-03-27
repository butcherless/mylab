package com.mylab.learn.myarchetype.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Input data transfer object for an service operation
 * 
 * @author cmartin
 * 
 */
public class TemplateRequest implements Serializable {
	private static final long serialVersionUID = -5360439715061005597L;

	private final String dummyProperty;

	public TemplateRequest(String dummyProperty) {
		this.dummyProperty = dummyProperty;
	}

	public Boolean hasData() {
		return (this.dummyProperty != null)	&& (this.dummyProperty.length() > 0);
	}

	public String getDummyProperty() {
		return this.dummyProperty;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("dummyProperty", this.dummyProperty)
		.append("hasData", this.hasData())
		.toString();
	}
	
}
