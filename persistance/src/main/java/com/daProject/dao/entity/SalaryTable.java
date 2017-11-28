
//!!!!!!!!!!!!!!!!! UNDER CONSTRUCTION !!!!!!!!!!!!!

package com.daProject.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "salary_table")
public class SalaryTable {

    public long id;
    public Date date;
}
