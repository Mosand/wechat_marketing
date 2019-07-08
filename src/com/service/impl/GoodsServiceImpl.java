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
	
	@Override
	public String updateGoods(int goods_id,String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image,
			String describe_goods,float market_price,String imgFormat){
		
		String result = goodsDao.update(goods_id,goods_name,price,ticheng,reward,reward_num,admin,admin_num,goods_image,describe_goods,market_price,imgFormat);
		if(result == "success"){
			return SUCCESS;
		}else if(result =="fail"){
			return FAIL;
		}
			return null;
	}
	
	@Override
	public String deleteGoods(int goods_id){
		
		String result = goodsDao.delete(goods_id);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
		return null;
	}
	
	@Override
	public String addGoods(String goods_name,float price,float ticheng,float reward,int reward_num,
			float admin,int admin_num,String goods_image,String describe_goods,float market_price,String imgFormat){
		
		String result = goodsDao.add(goods_name,price,ticheng,reward,reward_num,admin,admin_num,goods_image,describe_goods,market_price,imgFormat);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}
	
	@Override
	public String upload(int goods_id,String goods_image,String imgFormat){
		String result = goodsDao.upload(goods_id,goods_image,imgFormat);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}
	
	
	@Override
	public String searchItem(int goods_id) {
		List<GoodsInfo> goodslist = goodsDao.findItem(goods_id);
		if(goodslist==null){
			return FAIL;
		}else{
			return SUCCESS;
		}
	}
	@Override
	public List<GoodsInfo> findItem(int goods_id) {
		// TODO Auto-generated method stub
		return goodsDao.findItem(goods_id);
	}
	
	@Override
	public int findGoodsId() {
		// TODO Auto-generated method stub
		return goodsDao.findGoodsId();
	}

//	@Override
//	public String findGoodsName(int goods_id) {
//		List<GoodsInfo> goodslist = goodsDao.searchGoodsName();
//		if(goodslist==null){
//			return FAIL;
//		}else{
//			return SUCCESS;
//		}
//	}
//
//	@Override
//	public List<GoodsInfo> searchGoodsName(int goods_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}
