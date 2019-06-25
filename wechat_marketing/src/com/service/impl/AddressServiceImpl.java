package com.service.impl;

import java.util.List;

import com.dao.AddressDao;
import com.entity.Address;
import com.service.AddressService;

public class AddressServiceImpl implements AddressService{
	
	private AddressDao addressDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	@Override
	public String findAddress(String id1){
		
		List<Address> addresslist = addressDao.findOneAddress(id1);
		if(addresslist==null){
			return FAIL;
		}else
			return SUCCESS;
		
	}
	
	@Override
	public List<Address> findOneAddress(String id1) {
		// TODO Auto-generated method stub
		return addressDao.findOneAddress(id1);
	}
	
	@Override
	public String saveAddress(String id1,String region,String tel,String name,int first_choice,String address) {
		// TODO Auto-generated method stub
		String result = addressDao.saveAddress(id1,region,tel,name,first_choice,address);
		if(result.equals("success")){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
		
	}
	@Override
	public String makeFirst(int id, String id1, int first_choice) {
		String result = addressDao.makeFisrt(id,id1,first_choice);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}
	@Override
	public String update(int id, String region, String tel, String name, String address) {
		// TODO Auto-generated method stub
		String result = addressDao.update(id,region,tel,name,address);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}
	@Override
	public String delete(int addressID) {
		// TODO Auto-generated method stub
		String result = addressDao.delete(addressID);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return FAIL;
	}
	
	
}
