package com.service.impl;

import java.util.List;

import com.dao.PurchaseDao;
import com.entity.Purchase;
import com.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService{
	
	private PurchaseDao purchaseDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";
	
	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	@Override
	public String saveDeal(String id1,int goods_id,String goods_name,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num,int addressID) {
		// TODO Auto-generated method stub
		String result = purchaseDao.saveDeal(id1,goods_id,goods_name,buy_num,spend,time,state,avatar_url,goods_image,deal_num,addressID);
		if(result.equals("success")){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
		
	}
	
	@Override
	public String findDeal(String id1){
		
		List<Purchase> purchaselist = purchaseDao.findOneDeal(id1);
		if(purchaselist==null){
			return FAIL;
		}else
			return SUCCESS;
		
	}
	
	@Override
	public List<Purchase> findOneDeal(String id1) {
		// TODO Auto-generated method stub
		
		return purchaseDao.findOneDeal(id1);
	}
	
	@Override
	public String changeState(int state,String deal_num){
		
		String result = purchaseDao.change(state,deal_num);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}
}
