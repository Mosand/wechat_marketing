package com.service.impl;

import java.util.List;

import com.dao.GoodsDao;
import com.entity.GoodsInfo;
import com.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	
	private GoodsDao goodsDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";
	
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	
	@Override
	public String searchGoods() {
		List<GoodsInfo> goodslist = goodsDao.findGoods();
		if(goodslist==null){
			return FAIL;
		}else{
			return SUCCESS;
		}
	}
	@Override
	public List<GoodsInfo> findGoods() {
		// TODO Auto-generated method stub
		return goodsDao.findGoods();
	}
}
