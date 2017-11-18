/*
package com.daProject.dao.entity;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.daProject.dao.entity.TechRoute;
import com.daProject.dao.entity.TOpsTRouts;

@Entity
@Table(name = "ops_routs")
public class TOpsTRouts {

   public TOpsTRouts(){};

    public TOpsTRouts(TechRoute tr, TechOperationGeneral tog){
        this.tr = tr;
        this.tog = tog;
    }


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    @Column(name = "trouts_id")
    private long techRouteId;
    public long getTechRouteId() {
        return techRouteId;
    }

    public void setTechRouteId(long techRouteId) {
        this.techRouteId = techRouteId;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private TechRoute tr;

    public void setTechRoute(TechRoute tr) {
        this.tr = tr;
    }

    public TechRoute getTechRoute() {
        return tr;
    }

    @Column(name = "tops_id")
    private long techOpId;

    public long getTechOpId() {
        return techOpId;
    }

    public void setTechOpId(long techOpId) {
        this.techOpId = techOpId;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private TechOperationGeneral tog;

    public void setTog(TechOperationGeneral tog) {
        this.tog = tog;
    }

    public TechOperationGeneral getTog() {
        return tog;
    }


}
*/
