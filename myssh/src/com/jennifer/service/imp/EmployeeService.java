package com.jennifer.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;


import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Transactional;

import com.jennifer.domain.Department;
import com.jennifer.domain.Employee;
import com.jennifer.service.interfaces.EmployeeServiceInter;


@Transactional
public class EmployeeService implements EmployeeServiceInter {
	SessionFactory sf=null;

	public void addEmployee(Employee employee) {
//		Session s=sf.openSession();
//		Transaction ts=s.beginTransaction();
//		s.save(employee);
//		ts.commit();
		System.out.println("添加的数据："+employee.getName()+" "+employee.getPwd()+" "+employee.getEmail()
				+" "+employee.getGrade()+" "+employee.getHiredate()+" "+employee.getDepartment().getName());
	
		sf.getCurrentSession().save(employee);

	}

	public void delEmployee(Serializable id) {
		// TODO Auto-generated method stub

	}

	public List<Employee> showEmployee() {
		String hql="from Employee";
		List<Employee> list= sf.getCurrentSession().createQuery(hql).list();
		return list;
	}
	
	public int getRowCount(){
		List<Employee> list=this.showEmployee();
		return list.size();
	}
	

	public void updateEmployee(Serializable id) {
		// TODO Auto-generated method stub

	}


	public Employee checkLogin(Employee employee) {
		String hql="from Employee where id=? and pwd=?";  //注意，面向对象查找，from domain的类名
		Employee e=(Employee)sf.getCurrentSession().createQuery(hql).setString(0, employee.getId().toString()).setString(1, employee.getPwd()).uniqueResult();
		//解决懒加载问题方案1
//		Hibernate.initialize(Department.class);
//		System.out.println("所在部门："+e.getDepartment().getName());
		return e;
	}
	

	public void setSf(SessionFactory sf) {
		System.out.println("setSessionFactory");
		this.sf = sf;
	}

	public List<Employee> findByPage(String pageSize, String pageNow) {
		String hql="from Employee order by id";
		int first=(Integer.parseInt(pageNow)-1)*(Integer.parseInt(pageSize));
		int count=Integer.parseInt(pageSize);
		List<Employee> list=sf.getCurrentSession().createQuery(hql).setFirstResult(first).setMaxResults(count).list();
		System.out.println("取出的数目："+list.size());
		return list;
	}

}
