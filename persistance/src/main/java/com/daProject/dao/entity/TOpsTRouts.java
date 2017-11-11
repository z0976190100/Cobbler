package com.daProject.dao.entity;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ops_routs")
public class TOpsTRouts {

    private long id;
    private long techRouteId;
    private long techOpId;
    private long queueNumber;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
@Column(name = "trout_id")
    public long getTechRouteId() {
        return techRouteId;
    }

    public void setTechRouteId(long techRouteId) {
        this.techRouteId = techRouteId;
    }
@Column(name = "tops_id")
    public long getTechOpId() {
        return techOpId;
    }

    public void setTechOpId(long techOpId) {
        this.techOpId = techOpId;
    }

    public long getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(long queueNumber) {
        this.queueNumber = queueNumber;
    }
}
