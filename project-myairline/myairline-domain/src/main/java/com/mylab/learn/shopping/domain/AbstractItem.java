package com.mylab.learn.shopping.domain;

/**
 * 
 * @author cmartin
 *
 */
public abstract class AbstractItem extends AbstractEntity {

    private AbstractInfo abstractInfo;

    public AbstractItem() {
    }

    public abstract Boolean isLeaf();

    public void setAbstractInfo(AbstractInfo abstractInfo) {
        this.abstractInfo = abstractInfo;
    }

    public AbstractInfo getAbstractInfo() {
        return abstractInfo;
    }
}
