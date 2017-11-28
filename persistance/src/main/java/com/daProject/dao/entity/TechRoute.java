package com.daProject.dao.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
@Table(name = "tech_route")
public class TechRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "tech_rout_id")
    private long id;
    @Column(name = "trout_num")
    private int tRoutNum;
    @Column(name = "model_art")
    private String modelArt;
    @Column(name = "q_number")
    private int queueNumber;
    @Column(name = "ops_list")
    private String opsList;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tech_op_id")
    private TechOperationGeneral tog;

    public TechRoute() {
    }

    public TechRoute(int tRoutNum, String modelArt, TechOperationGeneral tog, int q_num) {
        this.tRoutNum = tRoutNum;
        this.modelArt = modelArt;
        this.tog = tog;
        this.queueNumber = q_num;
    }

    public long getId() {
        return id;
    }
    public void setId(long trid) {
        this.id = trid;
    }

    public TechOperationGeneral getTog() {
        return tog;
    }
    public void setTog(TechOperationGeneral tog) {
        this.tog = tog;
    }

    public int gettRoutNum() {
        return tRoutNum;
    }
    public void settRoutNum(int tRoutNum) {
        this.tRoutNum = tRoutNum;
    }

    public String getModelArt() {
        return modelArt;
    }
    public void setModelArt(String modelArt) {
        this.modelArt = modelArt;
    }

    public int getQueueNumber() {
        return queueNumber;
    }
    public void setQueueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }

    public String getOpsList() {
        return opsList;
    }
    public void setOpsList(String opsList) {
        this.opsList = opsList;
    }
}
