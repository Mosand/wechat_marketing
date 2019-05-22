package com.service.impl;

import com.dao.PurchaseDao;
import com.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService{
	
	private PurchaseDao purchaseDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";
	
	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	@Override
	public String saveDeal(String id1,String goods_id,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num) {
		// TODO Auto-generated method stub
		String result = purchaseDao.saveDeal(id1,goods_id,buy_num,spend,time,state,avatar_url,goods_image,deal_num);
		if(result.equals("success")){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
		
	}
	
}
