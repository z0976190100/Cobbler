package com.daProject.dao.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "work_sheet")
public class WorkSheet extends WorkSheetUnit {

    public static volatile boolean syncRequired = false;
    public static volatile boolean workSheetStringGlobalState = false;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "work_sheet_id")
    private long id;

    @Column(name = "op_tag_id")
    private String operationTagId;

    @Column(name = "is_checked")
    private Boolean isChecked;

    @Column(name = "checker_id")
    private long checkerId;

    public WorkSheet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperationTagId() {
        return operationTagId;
    }

    public void setOperationTagId(String operationTagId) {
        this.operationTagId = operationTagId;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    public long getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(long checkerId) {
        this.checkerId = checkerId;
    }
}
