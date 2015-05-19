package com.mylab.learn.jaranalyzer.service;

public class ClassFileBean {
	private final String fullname;
	private final Long size;

	public ClassFileBean(String fullname, Long size) {
		this.fullname = fullname;
		this.size = size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new StringBuffer()
		    .append("ClassFileBean: fullname=")
		    .append(this.fullname)
		    .append(",size=")
		    .append(this.size)
		    .toString();
	}
}
