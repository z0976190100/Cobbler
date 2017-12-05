package com.daProject.dao.entity;

import com.daProject.dao.Enteties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class WSStateKeeper extends Enteties {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column
    String WSList = "qwertyuiop";

    public String getWSList() {
        return WSList;
    }

    public void setWSList(String WSList) {
        this.WSList = WSList;
    }
}
