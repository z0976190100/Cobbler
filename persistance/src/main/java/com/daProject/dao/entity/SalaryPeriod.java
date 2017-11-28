// !!!!!!!!!!!!! UNDER CONSTRUCTION !!!!!!!!!!!!!!!

package com.daProject.dao.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "salary")
public class SalaryPeriod {

    private long id;
    private String surNameId;
    private String employment;
    private BigInteger salary;



    public SalaryPeriod() { }

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

       /* @OneToMany(fetch = FetchType.LAZY, mappedBy = "valId")
        public Set<ValiData> getValiData() {
            return valiData;
        }
        public void setValiData(Set<ValiData> valiData) {
            this.valiData = valiData;
        }
        public void setValiData(ValiData vvaliData) {
            this.valiData.add(vvaliData);
        }
*/
@Column(name = "surname_id")
    public String getSurNameId() { return surNameId; }
    public void setSurNameId(String surNameId) { this.surNameId = surNameId; }

    @Column(name = "salary")
    public BigInteger getSalary() { return salary; }
    public void setSalary(BigInteger salary) { this.salary = salary; }

    @Column(name = "employment")
    public String getEmployment() { return employment; }
    public void setEmployment(String employment) { this.employment = employment; }


    @Override
    public String toString() {
        return super.toString();
    }

   /* @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
*/

}





