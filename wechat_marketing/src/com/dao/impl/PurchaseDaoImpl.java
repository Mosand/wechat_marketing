package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.PurchaseDao;
import com.entity.Purchase;

public class PurchaseDaoImpl extends HibernateDaoSupport implements PurchaseDao{

	@Override
	public String makeDeal(String id1,String time,String deal_num){
		
		deal_num = id1 + time ;
		return deal_num;
	}
	
	@Override
	public String saveDeal(String id1,int goods_id,String goods_name,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num,int addressID){
		
		deal_num = this.makeDeal(id1, time, deal_num);		
		Session se =this.getSession();
		String hql="";
		
		hql = "insert into purchase(id1, goods_id, goods_name,buy_num, spend, time, state, avatar_url, goods_image, deal_num,addressID) values(?,?,?,?,?,?,?,?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setString(0, id1);
		query.setInteger(1, goods_id);
		query.setString(2, goods_name);
		query.setInteger(3, buy_num);
		query.setFloat(4, spend);
		query.setString(5, time);
		query.setInteger(6, state);
		query.setString(7, avatar_url);
		query.setString(8, goods_image);
		query.setString(9, deal_num);
		query.setInteger(10, addressID);
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
	
	@Override
	public String change(int state,String deal_num){
		
		Session se =this.getSession();
		String hql="";
		state = 1;
		hql = "update purchase p set p.state = ? where p.deal_num = ?";
		Query query= se.createSQLQuery(hql);
		query.setInteger(0, state);
		query.setString(1, deal_num);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
	
}
