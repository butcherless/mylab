package com.mylab.learn.jaranalyzer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class JarFileBean {
    @GraphId
    Long nodeId;

    @Indexed
    private String name;
    private String path;
    @Indexed(unique = true)
    private String sha1Hex;

    public JarFileBean() {
    }

    public JarFileBean(String name, String path, String sha1Hex) {
        this.name = name;
        this.path = path;
        this.sha1Hex = sha1Hex;
    }

    public String getFullname() {
        return new StringBuilder("/")
                .append(path)
                .append(name)
                .append(".jar")
                .toString();
    }

    public Long getNodeId() {
        return nodeId;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getSha1Hex() {
        return this.sha1Hex;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append("name", this.name);
        builder.append("path", this.path);
        builder.append("sha1Hex", this.sha1Hex);
        builder.append("nodeId", this.nodeId);
        return builder.toString();
    }
}
