package com.dao;

import java.util.List;

import com.entity.Purchase;

public interface PurchaseDao {

	
	String makeDeal(String id1,String goods_id,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num);
	String saveDeal(String id1,String goods_id,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num);
	
	List<Purchase> findOneDeal(String id1);
}
