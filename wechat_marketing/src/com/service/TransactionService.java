package com.service;

import java.util.List;

import com.entity.PageBean;
import com.entity.Pager;
import com.entity.TransactionRecord;

public interface TransactionService {

	String saveTransaction(String id1, String username, int goods_id, float ticheng, float market_price, float reward,
			float admin, String serial_num, String time,String direction,String avatar_url,String goods_name);
	
	PageBean<Object> findTransaction(Integer currPage);

	List<Object> getSumByMonth();

	PageBean<Object> findByPage(TransactionRecord searchModel, Integer currPage);

	Pager<TransactionRecord> findByPage2(TransactionRecord searchModel, int pageNum, int pageSize);
	
}
