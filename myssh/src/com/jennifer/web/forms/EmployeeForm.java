package com.jennifer.web.forms;

import org.apache.struts.action.ActionForm;

import com.jennifer.domain.Department;

public class EmployeeForm extends ActionForm {
	private Integer id;
	private String name;
	private String pwd;
	private String email;
	private Integer grade;
	private Integer dept_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		System.out.println("实例化表单，并注入id值");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		System.out.println("实例化表单，并注入pwd值");
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer deptId) {
		dept_id = deptId;
	}

	

}
