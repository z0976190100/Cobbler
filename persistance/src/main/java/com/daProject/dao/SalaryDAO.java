package com.daProject.dao;

import com.daProject.dao.entity.Salary;
import com.daProject.dao.entity.User;

public interface SalaryDAO {

public void addSalary (Salary salary);
void updateSalary (Salary newSalary);
Salary getSalaryBySurname (User surname);
}
