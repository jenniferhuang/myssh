package com.jennifer.service.imp;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.jennifer.domain.Department;
import com.jennifer.service.interfaces.DepartmentServiceInter;

@Transactional
public class DepartmentService implements DepartmentServiceInter{

	private SessionFactory sf;
	public void addDepartment(Department deparment) {
		sf.getCurrentSession().save(deparment);
		
	}
	
	
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


	public Department findById(Serializable id) {
		Department dept=(Department) sf.getCurrentSession().load(Department.class, id);
		return dept;
	}


	public List<Department> showDepartment() {
		String hql="from Department";
		List<Department> list=sf.getCurrentSession().createQuery(hql).list();
		return list;
	}
	

}
