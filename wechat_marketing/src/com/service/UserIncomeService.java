package com.service;

import com.entity.PageBean;
import com.entity.Pager;
import com.entity.UserIncome;
import com.entity.UserIncome2;

public interface UserIncomeService {

	String saveUserIncome(String id1, int goods_id, float ticheng, float market_price, float reward, float admin,String username,String deal_num,String avatar_url,String goods_name);

	PageBean<Object> findByPage(Integer currPage);

	PageBean<Object> findByPage(UserIncome searchModel, Integer currPage);

	Pager<Object> findByPage2(UserIncome searchModel, int pageNum, int pageSize);

}
