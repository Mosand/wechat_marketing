package com.service;

import java.util.List;
import com.entity.GoodsInfo;

public interface GoodsService {
	
	String searchGoods();
	
	List<GoodsInfo> findGoods();
	String updateGoods(int goods_id,String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image,String describe_goods,float market_price,String imgFormat);
	
	String deleteGoods(int goods_id);
	
	String addGoods(String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image,String describe_goods,float market_price,String imgFormat);
	
	String upload(int goods_id,String goods_image,String imgFormat);
	
	String searchItem(int goods_id);
	
	List<GoodsInfo> findItem(int goods_id);
	
	int findGoodsId();

	//String findGoodsName(int goods_id);
	//List<GoodsInfo> searchGoodsName(int goods_id);
}
