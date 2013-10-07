package com.jennifer.service.interfaces;

import java.io.Serializable;
import java.util.List;

import com.jennifer.domain.Employee;

public interface EmployeeServiceInter {
	public void addEmployee(Employee employee);
	public List<Employee> showEmployee();
	public int getRowCount();
	public List<Employee> findByPage(String pageSize,String pageNow);
	public void delEmployee(Serializable id);
	public void updateEmployee(Serializable id);
	public Employee checkLogin(Employee employee);
	

}
