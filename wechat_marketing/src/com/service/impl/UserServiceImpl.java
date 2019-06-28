package com.service.impl;

import java.util.List;

import com.dao.UserDao;
import com.entity.Purchase;
import com.entity.UserInfo;
import com.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public String findDeal(String id1) {
		List<Purchase> purchaselist = userDao.findAllNextDeal(id1);
		if(purchaselist==null){
			return FAIL;
		}else{
			return SUCCESS;
		}
	}
	@Override
	public List<Purchase> findAllDirectDeal(String id1) {
		// TODO Auto-generated method stub
		return userDao.findAllNextDeal(id1);
	}
	
	@Override
	public String saveErweima(String id1,String erweima,String erweimaFormat) {
		String result = userDao.saveErweima(id1,erweima,erweimaFormat);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}
	
	@Override
	public String findErweima(String deal_num) {//根据deal_num来获取购买者的id1，来查询用户的二维码
		List<UserInfo> userlist = userDao.findErweima(userDao.findOneDeal(deal_num).get(0).getId1());
		if(userlist == null){
			return FAIL;
		}else 
			return SUCCESS;
	}
	
	@Override
	public List<UserInfo> searchErweima(String id1) {
		return userDao.findErweima(id1);
	}

	@Override
	public String saveInfo(String id1, String username, String avatar_url) {
		String result = userDao.saveInfo(id1,username,avatar_url);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}

	@Override
	public String findUsernameAvatar(String id1) {
		List<UserInfo> userlist = userDao.searchUsernameAvatar(id1);
		if(userlist==null){
			return FAIL;
		}else{
			return SUCCESS;
		}
	}

	@Override
	public List<UserInfo> searchUsernameAvatar(String id1) {
		// TODO Auto-generated method stub
		
		return userDao.searchUsernameAvatar(id1);
	}

	@Override
	public String updateUser(String id1, String id2) {
		// TODO Auto-generated method stub
		String result = userDao.updateUser(id1,id2);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}


}
