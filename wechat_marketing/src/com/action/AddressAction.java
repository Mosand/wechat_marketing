package com.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Address;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.service.AddressService;

public class AddressAction {
	
	private String id1;
	private String name;
	private String region;
	private String tel;
	private int first_choice;
	private String address;
	private int addressID;
	
	public AddressService addressService;
	private List<Address> lists = new ArrayList<Address>();
	
	private InputStream inputStream; //这个名字和struts.xml中对应，不能写错  
	  
    public InputStream getInputStream() {  
        return inputStream;  
    }  
  
    public void setInputStream(InputStream inputStream) {  
        this.inputStream = inputStream;  
    }  
	public String getId1() {
		return id1;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public int getFirst_choice() {
		return first_choice;
	}
	public void setFirst_choice(int first_choice) {
		this.first_choice = first_choice;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public AddressService getAddressService() {
		return addressService;
	}
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	public List<Address> getLists() {
		return lists;
	}
	public void setLists(List<Address> lists) {
		this.lists = lists;
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
	
	public String findAddress() throws UnsupportedEncodingException{
		
		System.out.println("action.findAddress方法执行");
		String result = addressService.findAddress(id1);
		if(result == com.service.impl.AddressServiceImpl.SUCCESS){
			lists = addressService.findOneAddress(id1);
			Gson gson = new Gson();
			System.out.println("lists:"+gson.toJson(lists));//查看json格式			
			ActionContext.getContext().put("user_id", id1);
			return "findSuccess";
		}else if(result == com.service.impl.AddressServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("findfail"  
                    .getBytes("UTF-8")); 
			System.out.println("查询地址失败，没有此地址");
			return "findFail";
		}
		return null;
	}
	
	public String saveAddress() throws UnsupportedEncodingException{
		
		System.out.println("action.saveAddress方法执行");
		String result = addressService.saveAddress(id1,region,tel,name,first_choice,address);
		if(result.equals(com.service.impl.AddressServiceImpl.SUCCESS)){
			 inputStream = new ByteArrayInputStream("success"  
	                    .getBytes("UTF-8"));
			 ActionContext.getContext().put("user_id", id1);
			System.out.println("插入地址成功");
			return "iSuccess";
		}else if(result.equals(com.service.impl.AddressServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("fail"  
                    .getBytes("UTF-8")); 
			System.out.println("插入地址失败");
			return "iFail";
		}
		
		return null;
	}
	//地址设为首选，某一时刻只有一个地址作为首选，需要addressID,以及id1来确定某地址首选
	public String makeFirstChoice() throws UnsupportedEncodingException{
		System.out.println("action.changeState方法执行");
    	String result = addressService.makeFirst(addressID,id1,first_choice);
    	if(result.equals(com.service.impl.AddressServiceImpl.SUCCESS)){
    		inputStream = new ByteArrayInputStream("makeSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("设为首选成功");
			return "makeSuccess";
		}else if(result.equals(com.service.impl.AddressServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("makeFail"  
                    .getBytes("UTF-8")); 
			System.out.println("设为首选失败");
			return "makeFail";
	}
    	return null;
	}
	
	public String updateAddress() throws UnsupportedEncodingException{
		System.out.println("action.updateAddress方法执行");
    	String result = addressService.update(addressID,region,tel,name,address);
    	if(result.equals(com.service.impl.AddressServiceImpl.SUCCESS)){
    		inputStream = new ByteArrayInputStream("updateSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("地址更新成功");
			return "updateSuccess";
		}else if(result.equals(com.service.impl.AddressServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("updateFail"  
                    .getBytes("UTF-8")); 
			System.out.println("地址更新失败");
			return "updateFail";
	}
    	return null;
	}
	
	public String deleteAddress() throws UnsupportedEncodingException{
		System.out.println("action.updateAddress方法执行");
    	String result = addressService.delete(addressID);
    	if(result.equals(com.service.impl.AddressServiceImpl.SUCCESS)){
    		inputStream = new ByteArrayInputStream("deleteSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("地址删除成功");
			return "deleteSuccess";
		}else if(result.equals(com.service.impl.AddressServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("deleteFail"  
                    .getBytes("UTF-8")); 
			System.out.println("地址删除失败");
			return "deleteFail";
	}
    	return null;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
}
