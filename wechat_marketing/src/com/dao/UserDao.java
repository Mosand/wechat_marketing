package com.dao;

import java.util.List;

import com.entity.Purchase;
import com.entity.UserInfo;

public interface UserDao {
	
	//List<UserInfo> findUser(String id2);
	
	List<Purchase> findAllNextDeal(String id1);
	
	String saveErweima(String id1, String erweima,String erweimaFormat);
	
	List<UserInfo> findErweima(String id1);
	
	String saveInfo(String id1, String username, String avatar_url);
	
	List<UserInfo> searchUsernameAvatar(String id1);
	
	String updateUser(String id1, String id2);
	
	List<Purchase> findOneDeal(String deal_num) ;
	
	//List<Purchase> findAllDirectDeal(String id1);
}
