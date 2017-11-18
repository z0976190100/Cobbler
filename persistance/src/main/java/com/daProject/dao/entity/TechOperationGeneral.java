package com.daProject.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "techops_general")
public class TechOperationGeneral {

    public TechOperationGeneral() {}

    public TechOperationGeneral(String title, BigInteger cost) {
        this.title = title;
        this.cost = cost;
        //this.techRoute = techRoute;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "tech_op_id")
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tog")
    private List<TechRoute> techRoutes = new ArrayList<>();

    public List<TechRoute> getTechRoutes() {
        return techRoutes;
    }

    public void setTechRoutes(List<TechRoute> techRoutes) {
        this.techRoutes = techRoutes;
    }
    /*@ManyToOne
    @JoinColumn(name = "trid")
    private TechRoute techRoute;

    public TechRoute getTechRoute() {
        return techRoute;
    }

    public void setTechRoute(TechRoute techRoute) {
        this.techRoute = techRoute;
    }*/


    @Column(name = "title")
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "cost")
    private BigInteger cost;
    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }
}


