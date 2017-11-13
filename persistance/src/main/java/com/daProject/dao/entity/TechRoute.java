package com.daProject.dao.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tech_route")
public class TechRoute {

    public TechRoute() {}

    public long id;
    public List opsList;
    public String  modelArt;


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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ops_routs", catalog = "test", joinColumns = {
            @JoinColumn(name = "id")},
            inverseJoinColumns = {
            @JoinColumn (name = "")
    })

    @Column(name = "ops_list")
    public List getOpsList() {
        return opsList;
    }

    public void setOpsList(List opsList) {
        this.opsList = opsList;
    }

    @Column(name = "model_art")
    public String getModelArt() {
        return modelArt;
    }

    public void setModelArt(String modelArt) {
        this.modelArt = modelArt;
    }
}
