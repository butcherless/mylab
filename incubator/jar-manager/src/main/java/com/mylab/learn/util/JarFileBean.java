package com.mylab.learn.util;

public class JarFileBean {

    private final String name;
    private final String path;
    private final String sha1Hex;

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

    public String getSha1Hex() {
        return this.sha1Hex;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return new StringBuffer()
                .append("JarFileBean: name=")
                .append(this.name)
                .append(",path=")
                .append(this.path)
                .append(",sha1Hex=")
                .append(this.sha1Hex)
                .toString();
    }
}
