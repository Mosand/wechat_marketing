package com.service.impl;

import java.util.List;

import com.dao.UserDao;
import com.entity.Purchase;
import com.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public String findDeal(String id1,String id2) {
		List<Purchase> purchaselist = userDao.findAllNextDeal(id1,id2);
		if(purchaselist==null){
			return FAIL;
		}else{
			return SUCCESS;
		}
	}
	@Override
	public List<Purchase> findAllNextDeal(String id1,String id2) {
		// TODO Auto-generated method stub
		return userDao.findAllNextDeal(id1,id2);
	}
	
	@Override
	public String saveErweima(String id1,String erweima) {
		String result = userDao.saveErweima(id1,erweima);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}
	
	@Override
	public String findErweima(String id1) {
		String result = userDao.findErweima(id1);
		if(result == null){
			return FAIL;
		}else 
			return SUCCESS;
	}
	
	@Override
	public String searchErweima(String id1) {
		return userDao.findErweima(id1);
	}
}
