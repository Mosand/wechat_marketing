package com.dao;

import java.util.List;

import com.entity.Purchase;
import com.entity.UserInfo;

public interface UserDao {
	
	List<UserInfo> findUser(String id2);
	List<Purchase> findAllNextDeal(String id1,String id2);
	String saveErweima(String id1, String erweima);
	String findErweima(String id1);
	String saveInfo(String id1, String username, String avatar_url);
}
