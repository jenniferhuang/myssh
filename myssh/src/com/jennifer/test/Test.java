package com.jennifer.test;

import java.util.Date;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jennifer.domain.Department;
import com.jennifer.domain.Employee;
import com.jennifer.service.imp.EmployeeService;
import com.jennifer.service.interfaces.DepartmentServiceInter;
import com.jennifer.service.interfaces.EmployeeServiceInter;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/**
		 * 1������spring����
		 */
//		User user=(User) ac.getBean("user");
//		System.out.println(user.getUsername());
		
//		WebApplicationContext ctx= WebApplicationContextUtils.getWebApplicationContext(this.getServlet.)
		
		/**
		 * 4�����Լ���Ĳ���
		 */

		Department dept=new Department();
		dept.setName("�����г���");
		DepartmentServiceInter departmentServiceInter=(DepartmentServiceInter) ac.getBean("departmentService");
		departmentServiceInter.addDepartment(dept);
		
		
		/**
		 * 2������������hibernate
		 * applicaitonContext.xml��dataSource��sessionFactory��������
		 */
//		SessionFactory sf=(SessionFactory) ac.getBean("sessionFactory");
		Employee employee=new Employee();
		employee.setName("><script>alert(123);</script>");
		employee.setPwd("123");
		employee.setGrade(1);
		employee.setEmail("luzhen3@163.com");
		employee.setHiredate(new Date());
		System.out.println(new Date());
		employee.setDepartment(dept);
//		Session s=sf.openSession();
//		Transaction ts=s.beginTransaction();
//		s.save(employee);
//		ts.commit();
		
//		
		/**
		 * 3���ֲ�����
		 * ServiceҲ���õ�applicaitonContext.xml�У���ҵ������������
		 */
		EmployeeServiceInter employeeServiceInter =(EmployeeServiceInter) ac.getBean("employeeService");
		employeeServiceInter.addEmployee(employee);
		
		


		
		
	}

	

}
