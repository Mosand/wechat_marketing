package com.dao;

import java.util.List;

import com.entity.GoodsInfo;

public interface GoodsDao {
	
	List<GoodsInfo> findGoods();
}
