package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.PurchaseDao;
import com.entity.Purchase;

public class PurchaseDaoImpl extends HibernateDaoSupport implements PurchaseDao{

	@Override
	public String makeDeal(String id1,String goods_id,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num){
		
		deal_num = id1 + goods_id +  time ;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> findOneDeal(String id1){
		String hql="";
		if(id1==null||id1.equals(""))
			   return null;
		hql = "from purchase p where p.id1 = ? ";
		List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1);
		if(purchaselist.size()!=0){
			System.out.println("≤È—Ø≥…π¶");
			System.out.println("id1 is "+ id1);
			return purchaselist;
		}else if(purchaselist.size()==0){
			return null;
		}
		
		return null;
		
	}
	
}
