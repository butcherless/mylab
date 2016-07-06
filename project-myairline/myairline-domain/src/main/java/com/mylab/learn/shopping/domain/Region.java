package com.mylab.learn.shopping.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author cmartin
 *
 */
public class Region extends AbstractItem {

    private List<AbstractItem> items = new ArrayList<AbstractItem>();

    public Region() {
    }

    @Override
    public Boolean isLeaf() {
        return Boolean.FALSE;
    }

    public Boolean hasChildren() {
        return this.items.isEmpty();
    }

    public Integer childrenCount() {
        return this.items.size();
    }
}
