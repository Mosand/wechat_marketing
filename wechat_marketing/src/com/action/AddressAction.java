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
import com.service.AddressService;

public class AddressAction {
	
	private String id1;
	private String name;
	private String region;
	private String tel;
	private int first_choice;
	private String address;
	
	private AddressService addressService;
	private List<Address> lists = new ArrayList<Address>();
	
	private InputStream inputStream; //������ֺ�struts.xml�ж�Ӧ������д��  
	  
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
        System.out.println("��ͳ��ajax");
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
		
		System.out.println("action.findAddress����ִ��");
		String result = addressService.findAddress(id1);
		if(result == com.service.impl.AddressServiceImpl.SUCCESS){
			lists = addressService.findOneAddress(id1);
			System.out.println("lists"+lists);
			return "findSuccess";
		}else if(result == com.service.impl.AddressServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("findfail"  
                    .getBytes("UTF-8")); 
			System.out.println("��ѯ��ַʧ�ܣ�û�д˵�ַ");
			return "findFail";
		}
		return null;
	}
	
	public String saveAddress() throws UnsupportedEncodingException{
		
		System.out.println("action.saveAddress����ִ��");
		String result = addressService.saveAddress(id1,region,tel,name,first_choice,address);
		if(result.equals(com.service.impl.AddressServiceImpl.SUCCESS)){
			 inputStream = new ByteArrayInputStream("success"  
	                    .getBytes("UTF-8"));   
			System.out.println("�����ַ�ɹ�");
			return "iSuccess";
		}else if(result.equals(com.service.impl.AddressServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("fail"  
                    .getBytes("UTF-8")); 
			System.out.println("�����ַʧ��");
			return "iFail";
		}
		
		return null;
	}
}