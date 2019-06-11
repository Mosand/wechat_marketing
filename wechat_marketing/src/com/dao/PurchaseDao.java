package com.dao;

import java.util.List;

import com.entity.Purchase;

public interface PurchaseDao {

	
	String makeDeal(String id1,String time,String deal_num);
	String saveDeal(String id1,String username,int goods_id,String goods_name,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num,int addressID);
	
	List<Purchase> findOneDeal(String id1);
	String change(int state, String deal_num);
	
	
	List<Purchase> findByPage(int begin, int pageSize);
	
	int findCount();
	
	List<Purchase> findByPage(Purchase searchModel,int begin, int pageSize);
	
	int findCount(Purchase searchModel);

}
