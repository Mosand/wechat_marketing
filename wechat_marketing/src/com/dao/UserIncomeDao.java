package com.dao;

import java.util.List;

import com.entity.GoodsInfo;
import com.entity.Pager;
import com.entity.Purchase;
import com.entity.UserIncome;
import com.entity.UserIncome2;
import com.entity.UserInfo;

public interface UserIncomeDao {

	String saveUserIncome(String id1, int goods_id, float ticheng, float market_price, float reward,float admin,String username,String deal_num,String avatar_url,String goods_name);

	List<GoodsInfo> findItem(int goods_id);
	
	List<Purchase> findOneDeal(String deal_num);

	List<UserInfo> findUser(String id2);
	
	List<Purchase> findAllNextDeal(String id1,String id2);

	int findCount();

	List<Object> findByPage(int begin, int pageSize);

	int findCount(UserIncome searchModel);

	List<Object> findByPage(UserIncome searchModel, int begin, int pageSize);

	Pager<Object> findByPage2(UserIncome searchModel, int pageNum, int pageSize);

}
