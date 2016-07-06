package com.mylab.learn.shopping.domain;

import java.util.Date;

/**
 * 
 * @author cmartin
 *
 */
public class Event extends AbstractEntity {
    private Date date;
    private AbstractItem abstractItem;

    public Event() {
    }

    public void setAbstractItem(AbstractItem abstractItem) {
        this.abstractItem = abstractItem;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
