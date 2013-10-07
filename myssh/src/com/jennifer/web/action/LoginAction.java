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
	
	//�����¼����
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm employeeForm=(EmployeeForm)form;
		
		/**
		 * ���actionû�н���spring����ʱ������ͨ����������ȡspring����ʵ��(web.xml����ʵ����spring)
		 */
//		WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(this.getServlet().getServletContext());
//		EmployeeServiceInter employeeServiceInter =(EmployeeServiceInter) ctx.getBean("employeeServiceImp");

//		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		EmployeeServiceInter employeeServiceInter =(EmployeeServiceInter) ac.getBean("employeeServiceImp");
		
		Employee employee=new Employee();
		System.out.println("action�����ȡ��ֵΪ��id="+employeeForm.getId()+",pwd="+employeeForm.getPwd());
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
		//���������ٽ�����֤���������� ��¼ҳ�治�������֤����������Ҫ��֤
		//����1�����£�  ����2����������
		if(request.getSession().getAttribute("loginInfo")!=null){
			return mapping.findForward("ok");
		}
		return mapping.findForward("err");//�����˵�¼ҳ��
		
	}

	

	public void setEmployeeServiceInter(EmployeeServiceInter employeeServiceInter) {
		System.out.println("web����������-������spring��ܣ��Ϳ�ʼʵ�����˸�Action����ע��ֵ��employeeServiceInter(���������󷢳���action֮ǰ��ʵ����action)");
		this.employeeServiceInter = employeeServiceInter;
	}
	
	
	//����ע������
//	public ActionForward logout(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return super.execute(mapping, form, request, response);
//	}
//	
	
	
	

}
