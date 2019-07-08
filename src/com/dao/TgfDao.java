package com.dao;

import java.util.List;

import com.entity.TGF;

public interface TgfDao {
	
	int findGoods_id();
	
	List<TGF> findTgf(int goods_id);

	String save(int goods_id,float tuiguangfei,float tuiguangfei1,float tuiguangfei2,float tuiguangfei3,float tuiguangfei4,float tuiguangfei5,float tuiguangfei6);

	String update(int goods_id, float tuiguangfei,float tuiguangfei1, float tuiguangfei2, float tuiguangfei3, float tuiguangfei4, float tuiguangfei5, float tuiguangfei6);
}
