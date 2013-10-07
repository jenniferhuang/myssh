package com.jennifer.domain;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private Integer dept_id;
	private String name;
	private Set employee=new HashSet(0);

	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer deptId) {
		dept_id = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getEmployee() {
		return employee;
	}
	public void setEmployee(Set employee) {
		this.employee = employee;
	}
	

}
