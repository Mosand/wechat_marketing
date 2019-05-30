package com.dao;

public interface TgfDao {
	
	int findGoods_id();
	
	String save(int goods_id,int startNum,float tuiguangfei,int endNum);
}
