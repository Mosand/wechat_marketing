package com.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.PurchaseDao;

public class PurchaseDaoImpl extends HibernateDaoSupport implements PurchaseDao{

	@Override
	public String makeDeal(String id1,String goods_id,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num){
		
		deal_num = id1 + goods_id + buy_num + spend + time + state + avatar_url+goods_image;
		return deal_num;
	}
	
	@Override
	public String saveDeal(String id1,String goods_id,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num){
		
		deal_num = this.makeDeal(id1, goods_id, buy_num, spend, time, state, avatar_url, goods_image, deal_num);		
		Session se =this.getSession();
		String hql="";
		
		hql = "insert into purchase(id1, goods_id, buy_num, spend, time, state, avatar_url, goods_image, deal_num) values(?,?,?,?,?,?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setString(0, id1);
		query.setString(1, goods_id);
		query.setInteger(2, buy_num);
		query.setFloat(3, spend);
		query.setString(4, time);
		query.setInteger(5, state);
		query.setString(6, avatar_url);
		query.setString(7, goods_image);
		query.setString(8, deal_num);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
		
	}
	
}
