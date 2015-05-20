package com.mylab.learn.jaranalyzer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class ClassFileBean {
    @GraphId
    private Long nodeId;

    @Indexed
    private String fullname;
    private Long size;

    private JarFileBean jarFileBean;

    public ClassFileBean() {
    }

    public ClassFileBean(String fullname, Long size) {
        this.fullname = fullname;
        this.size = size;
    }

    public String getFullname() {
        return fullname;
    }

    public Long getSize() {
        return size;
    }

    public void setJarFileBean(JarFileBean jarFileBean) {
        this.jarFileBean = jarFileBean;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append("fullname", this.fullname);
        builder.append("size", this.size);
        return builder.toString();
    }
}
