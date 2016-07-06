package com.mylab.learn.shopping.domain;

/**
 * 
 * @author cmartin
 *
 */
public class Beacon extends AbstractItem {

    private String uuid;
    private String major;
    private String minor;
    private Float strength;
    private Float longitude;
    private Float latitude;

    public Beacon() {
    }

    @Override
    public Boolean isLeaf() {
        return Boolean.TRUE;
    }

}
