package com.dao;

public interface TgfDao {
	
	int findGoods_id(int goods_id);
	

	String save(int goods_id,float tuiguangfei1,float tuiguangfei2,float tuiguangfei3,float tuiguangfei4,float tuiguangfei5,float tuiguangfei6);
}
