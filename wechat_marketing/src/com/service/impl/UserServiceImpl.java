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
		List<Purchase> purchaselist = userDao.findOneDeal(id1,id2);
		if(purchaselist==null){
			return FAIL;
		}else{
			return SUCCESS;
		}
	}
	@Override
	public List<Purchase> findOneDeal(String id1,String id2) {
		// TODO Auto-generated method stub
		return userDao.findOneDeal(id1,id2);
	}
	
	
}
