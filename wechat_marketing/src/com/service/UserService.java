package com.service;

import java.util.List;

import com.entity.Purchase;
import com.entity.UserInfo;

public interface UserService {
	
	//String searchUser(String id2);
	String findDeal(String id1,String id2);
	//List<UserInfo> findUser(String id2);
	
	List<Purchase> findOneDeal(String id1,String id2);
	
}
