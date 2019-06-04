package com.service;

import java.util.List;

import com.entity.Purchase;

public interface PurchaseService {
	
	String saveDeal(String id1,int goods_id,String goods_name,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num,int addressID);
	
	String findDeal(String id1);
	
	List<Purchase> findOneDeal(String id1);

	String changeState(int state, String deal_num);
}
