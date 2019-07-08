package com.dao;

import java.util.List;

import com.entity.ExpenseIncome;
import com.entity.Pager;
import com.entity.Purchase;

/**
 * 根据查询条件，查询商品分页信息
 * 
 * @param searchModel
 *            封装查询条件
 * @param pageNum
 *            查询第几页数据
 * @param pageSize
 *            每页显示多少条记录
 * @return 查询结果
 */

public interface PurchaseDao {

	
	String makeDeal(String id1,String time,String deal_num);
	String saveDeal(String id1,String username,int goods_id,String goods_name,int buy_num,float spend,String time,int state,String avatar_url,String imgFormat,String deal_num,int addressID);
	
	List<Purchase> findOneDeal(String id1);
	String change(int state, String deal_num);
	
	
	List<Purchase> findByPage(int begin, int pageSize);
	
	int findCount();
	
	List<Purchase> findByPage(Purchase searchModel,int begin, int pageSize);
	
	int findCount(Purchase searchModel);
	
	List<ExpenseIncome> getSumByMonth();
	
	Pager<Purchase> findByPage2(Purchase searchModel, int pageNum, int pageSize);

}
