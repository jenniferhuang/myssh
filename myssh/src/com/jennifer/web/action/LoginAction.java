package com.jennifer.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jennifer.service.imp.EmployeeService;
import com.jennifer.service.interfaces.EmployeeServiceInter;
import com.jennifer.web.forms.EmployeeForm;
import com.jennifer.domain.Employee;

public class LoginAction extends DispatchAction {
	private EmployeeServiceInter employeeServiceInter;
	
	//处理登录请求
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm employeeForm=(EmployeeForm)form;
		
		/**
		 * 如果action没有交给spring管理时，我们通过下面语句获取spring容器实例(web.xml配置实例化spring)
		 */
//		WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(this.getServlet().getServletContext());
//		EmployeeServiceInter employeeServiceInter =(EmployeeServiceInter) ctx.getBean("employeeServiceImp");

//		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		EmployeeServiceInter employeeServiceInter =(EmployeeServiceInter) ac.getBean("employeeServiceImp");
		
		Employee employee=new Employee();
		System.out.println("action里面获取表单值为：id="+employeeForm.getId()+",pwd="+employeeForm.getPwd());
		employee.setId(employeeForm.getId());
		employee.setPwd(employeeForm.getPwd());
		employee=employeeServiceInter.checkLogin(employee);
		if(employee!=null){
			request.getSession().setAttribute("loginInfo", employee);
			return mapping.findForward("ok");
		}else{
			return mapping.findForward("err");
		}
		
	}
	
	public ActionForward goMainFrame(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		//必须对身份再进行验证，除了请求 登录页面不用身份验证，其他都需要验证
		//方案1，如下；  方案2，过滤器。
		if(request.getSession().getAttribute("loginInfo")!=null){
			return mapping.findForward("ok");
		}
		return mapping.findForward("err");//返回了登录页面
		
	}

	

	public void setEmployeeServiceInter(EmployeeServiceInter employeeServiceInter) {
		System.out.println("web服务器启动-》加载spring框架，就开始实例化了该Action，并注入值：employeeServiceInter(区别：在请求发出到action之前就实例化action)");
		this.employeeServiceInter = employeeServiceInter;
	}
	
	
	//处理注销请求
//	public ActionForward logout(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return super.execute(mapping, form, request, response);
//	}
//	
	
	
	

}
