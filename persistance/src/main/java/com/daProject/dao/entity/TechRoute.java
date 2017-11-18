package com.daProject.dao.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "tech_route")
public class TechRoute {

    public TechRoute() {
    }

    public TechRoute(int tRoutNum, String modelArt, TechOperationGeneral tog, int q_num) {
        this.tRoutNum = tRoutNum;
        this.modelArt = modelArt;
        this.tog = tog;
        this.queueNumber = q_num;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "tech_rout_id")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long trid) {
        this.id = trid;
    }


    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<TechOperationGeneral> togList = new ArrayList<>();

    public List<TechOperationGeneral> getTogList() {
        return togList;
    }

    public void setTogList(List<TechOperationGeneral> togList) {
        this.togList = togList;
    }*/
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tech_op_id")
    private TechOperationGeneral tog;

    public TechOperationGeneral getTog() {
        return tog;
    }

    public void setTog(TechOperationGeneral tog) {
        this.tog = tog;
    }

    @Column(name = "trout_num")
    private int tRoutNum;

    public int gettRoutNum() {
        return tRoutNum;
    }

    public void settRoutNum(int tRoutNum) {
        this.tRoutNum = tRoutNum;
    }

    @Column(name = "model_art")
    private String modelArt;

    public String getModelArt() {
        return modelArt;
    }

    public void setModelArt(String modelArt) {
        this.modelArt = modelArt;
    }

    @Column(name = "q_number")
    private int queueNumber;

    public int getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }

    /*@Column(name = "tops_id")*/
    /*private int topsId;
    public int getTopsId() {
        return topsId;
    }

    public void setTopsId(int topsId) {
        this.topsId = topsId;
    }
*/

    @Column(name = "ops_list")
    private String opsList;

    public String getOpsList() {
        return opsList;
    }

    public void setOpsList(String opsList) {
        this.opsList = opsList;
    }
}
