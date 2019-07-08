package com.service;

import java.util.List;

import com.entity.TGF;

public interface TgfService {
	
	String saveTgf(int goods_id,float tuiguangfei,float tuiguangfei1,float tuiguangfei2,float tuiguangfei3,float tuiguangfei4,float tuiguangfei5,float tuiguangfei6);
	
	List<TGF> findTgf(int goods_id);
	String searchTgf(int goods_id);

	String updateTgf(int goods_id, float tuiguangfei,float tuiguangfei1, float tuiguangfei2, float tuiguangfei3, float tuiguangfei4, float tuiguangfei5, float tuiguangfei6);

}
