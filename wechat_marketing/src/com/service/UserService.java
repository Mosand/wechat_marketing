package com.service;

import java.util.List;

import com.entity.Purchase;

public interface UserService {
	
	String findDeal(String id1,String id2);
	
	List<Purchase> findAllNextDeal(String id1,String id2);
	
	String saveErweima(String id1,String erweima);

	String findErweima(String id1);
	String searchErweima(String id1);
}
