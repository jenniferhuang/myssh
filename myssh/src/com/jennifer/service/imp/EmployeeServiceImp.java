package com.jennifer.service.imp;

import java.io.Serializable;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Transactional;

import com.jennifer.domain.Employee;
import com.jennifer.service.interfaces.EmployeeServiceInter;


@Transactional
public class EmployeeServiceImp implements EmployeeServiceInter {
	
	SessionFactory sf=null;

	public void addEmployee(Employee employee) {
//		Session s=sf.openSession();
//		Transaction ts=s.beginTransaction();
//		s.save(employee);
//		ts.commit();
		sf.getCurrentSession().save(employee);

	}

	public void delEmployee(Serializable id) {
		// TODO Auto-generated method stub

	}

	public List<Employee> showEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(Serializable id) {
		// TODO Auto-generated method stub

	}

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		System.out.println("setSessionFactory");
		this.sf = sf;
	}

	public Employee checkLogin(Employee employee) {
		String hql="from Employee where id=? and pwd=?";  //注意，面向对象查找，from domain的类名
		Employee e=(Employee)sf.getCurrentSession().createQuery(hql).setString(0, employee.getId().toString()).setString(1, employee.getPwd()).uniqueResult();
		return e;
	}

}
