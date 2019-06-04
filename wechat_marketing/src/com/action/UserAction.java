package com.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Purchase;
import com.opensymphony.xwork2.ActionContext;
import com.service.UserService;

public class UserAction {

	private String id1;
	private String id2;
	private String id3;
	private String id4;
	private String id5;
	private String id6;
	private String id7;
	private String erweima;
	
	private UserService userService;
	private List<Purchase> lists = new ArrayList<Purchase>();
	
	private InputStream inputStream;

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getId3() {
		return id3;
	}

	public void setId3(String id3) {
		this.id3 = id3;
	}

	public String getId4() {
		return id4;
	}

	public void setId4(String id4) {
		this.id4 = id4;
	}

	public String getId5() {
		return id5;
	}

	public void setId5(String id5) {
		this.id5 = id5;
	}

	public String getId6() {
		return id6;
	}

	public void setId6(String id6) {
		this.id6 = id6;
	}

	public String getId7() {
		return id7;
	}

	public void setId7(String id7) {
		this.id7 = id7;
	}

	public String getErweima() {
		return erweima;
	}

	public void setErweima(String erweima) {
		this.erweima = erweima;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Purchase> getLists() {
		return lists;
	}

	public void setLists(List<Purchase> lists) {
		this.lists = lists;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public String getState2(){
        System.out.println("传统的ajax");
        HttpServletResponse response = ServletActionContext.getResponse();
        try {
            PrintWriter out = response.getWriter();
            out.println("{\"success\":\"true\",\"type\":\"succ\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public String findNextDeal() throws UnsupportedEncodingException{//查找所有下级购买情况
		
		System.out.println("action.findNextDeal方法执行");
		
		String result = userService.findDeal(id1,id2);
		if(result == com.service.impl.UserServiceImpl.SUCCESS){
			lists = userService.findAllNextDeal(id1,id2);
			ActionContext.getContext().put("user_id", id2);
			System.out.println("lists"+lists);
			return "findSuccess";
		}else if(result == com.service.impl.UserServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("findfail"  
                    .getBytes("UTF-8")); 
			System.out.println("查询订单失败，没有此订单");
			return "findFail";
		}
		return null;
	}
	
	public String saveErweima() throws UnsupportedEncodingException{
		
		System.out.println("action.saveErweima方法执行");
		
		String result = userService.saveErweima(id1,erweima);
		if(result == com.service.impl.UserServiceImpl.SUCCESS){
			inputStream = new ByteArrayInputStream("saveSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("save 二维码成功");
			return "saveSuccess";
		}else if(result == com.service.impl.UserServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("saveFail"  
                    .getBytes("UTF-8")); 
			System.out.println("save 二维码失败");
			return "saveFail";
		}
		return null;
	}
	
	public String findErweima() throws UnsupportedEncodingException{
		System.out.println("action.saveErweima方法执行");
		
		String result = userService.findErweima(id1);
		if(result == com.service.impl.UserServiceImpl.SUCCESS){
			String erweima = userService.searchErweima(id1);
			inputStream = new ByteArrayInputStream(erweima 
                    .getBytes("UTF-8")); 
			System.out.println("查询 二维码成功");
			return "findErSuccess";
		}else if(result == com.service.impl.UserServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("saveErFail"  
                    .getBytes("UTF-8")); 
			System.out.println(" 二维码失败");
			return "findErFail";
		}
		return null;
	}
}
