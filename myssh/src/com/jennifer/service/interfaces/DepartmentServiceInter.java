package com.jennifer.service.interfaces;

import java.io.Serializable;
import java.util.List;

import com.jennifer.domain.Department;

public interface DepartmentServiceInter {
	public Department findById(Serializable id);
	public List<Department> showDepartment();
	public void addDepartment(Department deparment);
	

}
