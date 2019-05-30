package com.dao;

import java.util.List;

import com.entity.GoodsInfo;

public interface GoodsDao {
	
	List<GoodsInfo> findGoods();
	
	String update(int goods_id,String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image,String describe_goods);
	
	String delete(int goods_id);
	
	String add(String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image,String describe_goods);
}
