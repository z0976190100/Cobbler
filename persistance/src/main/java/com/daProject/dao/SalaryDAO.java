//!!!!!!!!!!!!!! UNDER CONSTRUCTION !!!!!!!!!!!!!!!!!!!!

package com.daProject.dao;

import com.daProject.dao.entity.SalaryPeriod;
import com.daProject.dao.entity.User;

public interface SalaryDAO {

public void addSalary (SalaryPeriod salaryPeriod);
void updateSalary (SalaryPeriod newSalaryPeriod);
SalaryPeriod getSalaryBySurname (User surname);
}
