package com.service;

import java.util.List;

import com.entity.Purchase;
import com.entity.UserInfo;

public interface UserService {
	
	String findDeal(String id1);
	
	List<Purchase> findAllDirectDeal(String id1);
	
	String saveErweima(String id1,String erweima,String erweimaFormat);

	String findErweima(String deal_num);
	
	List<UserInfo> searchErweima(String id1);

	String saveInfo(String id1, String username, String avatar_url);

	String findUsernameAvatar(String id1);
	
	List<UserInfo> searchUsernameAvatar(String id1);

	String updateUser(String id1, String id2);

	
}
