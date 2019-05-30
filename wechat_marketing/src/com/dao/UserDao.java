package com.dao;

import java.util.List;

import com.entity.GoodsInfo;
import com.entity.Purchase;
import com.entity.UserInfo;

public interface UserDao {
	
	List<UserInfo> findUser(String id2);
	List<Purchase> findOneDeal(String id1,String id2);
}
