package com.mylab.learn.shopping.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author cmartin
 *
 */
public class Path extends AbstractEntity {

    private Date beginDate;
    private Date endDate;

    private List<Event> events = new ArrayList<Event>();

    public Path() {
    }

    public Boolean hasEvents() {
        return this.events.isEmpty();
    }

    public Integer eventCount() {
        return this.events.size();
    }

    public void addEvent(final Event event) {
        this.events.add(event);
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
