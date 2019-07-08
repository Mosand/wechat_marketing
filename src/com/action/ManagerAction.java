package com.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.entity.Manager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ManagerService;

public class ManagerAction extends ActionSupport implements SessionAware{

	private String mananame;
	private String password;
	private InputStream inputStream;
	private String securityCode;
	private Map<String, Object> session;
	public static String public_name;
	
	private ManagerService managerService;

	public String getMananame() {
		return mananame;
	}

	public void setMananame(String mananame) {
		this.mananame = mananame;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
//	public static String getPublic_name() {
//		return public_name;
//	}
//
//	public static void setPublic_name(String public_name) {
//		ManagerAction.public_name = public_name;
//	}

	public String login() throws UnsupportedEncodingException{
		System.out.println("action.login方法执行");
		
		List<Manager> manager = managerService.findByName(mananame,password);
		if(manager == null || manager.size()==0){
			inputStream = new ByteArrayInputStream("UsernameOrPasswordError"  
                  .getBytes("UTF-8")); 
			System.out.println("用户名或密码错误");	
			return "WrongUser";
		}
		String serverCode = (String) session.get("checkstring");
		if(serverCode == null){
			inputStream = new ByteArrayInputStream("codeError"  
                    .getBytes("UTF-8")); 
  			System.out.println("验证码错误");
        	return "WrongUser";
		}
        if(!serverCode.equalsIgnoreCase(securityCode)){
        	inputStream = new ByteArrayInputStream("codeError"  
                    .getBytes("UTF-8")); 
  			System.out.println("验证码错误");
        	return "WrongUser";

        }
        
        	HttpServletRequest request = ServletActionContext.getRequest();
        	public_name = mananame;
        	request.setAttribute("public_name",public_name);
        	
        	System.out.println("user_name:"+mananame);
        	inputStream = new ByteArrayInputStream("rightUser"  
                    .getBytes("UTF-8")); 
  			System.out.println("right user");
			return "RightUser";
			
	}
}
