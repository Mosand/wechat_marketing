package com.dao;

import java.util.List;

import com.entity.Pager;
import com.entity.TransactionRecord;

public interface TransactionDao {

	String saveTransaction(String id1, String username, int goods_id, float ticheng, float market_price, float reward,
			float admin, String serial_num, String time,String direction,String avatar_url,String goods_name);

	String makeDeal(String id1,String time, String serial_num);

	List<Object> findTransaction(int begin, int pageSize);

	int findCount();

	List<Object> getSumByMonth();

	int findCount(TransactionRecord searchModel);

	List<Object> findByPage(TransactionRecord searchModel, int begin, int pageSize);

	Pager<TransactionRecord> findByPage2(TransactionRecord searchModel, int pageNum, int pageSize);


}
