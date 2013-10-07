package com.jennifer.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.jennifer.domain.Department;
import com.jennifer.domain.Employee;
import com.jennifer.service.interfaces.DepartmentServiceInter;
import com.jennifer.service.interfaces.EmployeeServiceInter;
import com.jennifer.web.forms.EmployeeForm;

public class EmployeeAction extends DispatchAction {
	private DepartmentServiceInter departmentService;
	private EmployeeServiceInter  employeeService;
	
	//点击添加操作，转到添加页面处理
	public ActionForward addEmpUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//查询出所有部门，提供部门下拉框的值
		try {
			List<Department> list=departmentService.showDepartment();
			request.setAttribute("depts", list);
			return mapping.findForward("addEmpUI");
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("err");
		}
		
	}
	
	
	
	//真正处理执行添加操作
	public ActionForward addEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm employeeForm=(EmployeeForm) form;
		
		System.out.println("表单内容：传到服务器后，在这边可以采用regex类再次验证数据合法性");
		System.out.println(employeeForm.getName()+" "+employeeForm.getPwd()+" "+employeeForm.getEmail()
				+" "+employeeForm.getGrade()+" "+employeeForm.getDept_id());
		Department dept=departmentService.findById(employeeForm.getDept_id());
		System.out.println("所在部门："+dept.getDept_id()+" "+dept.getName());
		Employee employee=new Employee();
		employee.setName(employeeForm.getName());
		employee.setPwd(employeeForm.getPwd());
		employee.setEmail(employeeForm.getEmail());
		employee.setGrade(employeeForm.getGrade());
		employee.setHiredate(new Date());
		employee.setDepartment(dept);
		
		try {
			employeeService.addEmployee(employee);
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace(); //运行时异常，添加不成功。 比如数据库异常等
			return mapping.findForward("err");
		}
		
	}

	//分页展示用户列表
	public ActionForward empList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String pageSize=request.getParameter("pageSize");
		String pageNow=request.getParameter("pageNow");

		try {
			List<Employee> list=employeeService.findByPage(pageSize, pageNow);
			int rowCount=employeeService.getRowCount();
			int pageCount=(rowCount-1)/Integer.parseInt(pageSize)+1;
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageSize",pageSize);
			request.setAttribute("rowCount", rowCount);
			
			request.setAttribute("emps", list);
			return mapping.findForward("empList");
			
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("err");
			
		}

		
		
	}


	
	
	public void setDepartmentService(DepartmentServiceInter departmentService) {
		this.departmentService = departmentService;
	}

	public void setEmployeeService(EmployeeServiceInter employeeService) {
		this.employeeService = employeeService;
	}

}
