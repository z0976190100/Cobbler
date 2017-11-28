package com.daProject.dao.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "techops_general")
public class TechOperationGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "tech_op_id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private BigInteger cost;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tog")
    private List<TechRoute> techRoutes = new ArrayList<>();

    public TechOperationGeneral() {}

    public TechOperationGeneral(String title, BigInteger cost) {
        this.title = title;
        this.cost = cost;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public List<TechRoute> getTechRoutes() {
        return techRoutes;
    }
    public void setTechRoutes(List<TechRoute> techRoutes) {
        this.techRoutes = techRoutes;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public BigInteger getCost() {
        return cost;
    }
    public void setCost(BigInteger cost) {
        this.cost = cost;
    }
}


