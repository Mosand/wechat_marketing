package com.service;

import java.util.List;
import com.entity.GoodsInfo;

public interface GoodsService {
	
	String searchGoods();
	List<GoodsInfo> findGoods();
}
