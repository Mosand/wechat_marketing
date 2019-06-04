package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.UserDao;
import com.entity.GoodsInfo;
import com.entity.Purchase;
import com.entity.UserInfo;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
	@Override
	public List<UserInfo> findUser(String id2) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from user_info u where u.id2 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id2);
		if(userlist.size()!=0){
			System.out.println("id2查询成功");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;

	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Purchase> findAllNextDeal(String id1,String id2){
		
		if(this.findUser(id2) == null){
			return null;
		}else{
			int length;
			int i;
			List<Purchase> purchaseList = new ArrayList<Purchase>();;
			length = this.findUser(id2).size();
			System.out.println(length);
			for(i = 0; i < length; i++){
				id1 = this.findUser(id2).get(i).getId1();
				String hql="";
				if(id1==null||id1.equals(""))
					   return null;
				hql = "from purchase p where p.id1 = ? ";
				List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1);
				if(purchaselist.size()!=0){
					System.out.println("purchase查询成功");
					System.out.println("id1 is "+ id1);
					if(purchaseList == null){
						return null;
					}else{
						purchaseList.addAll(purchaselist);
					}								
				}else if(purchaselist.size()==0){
					return null;
				}				
			}
			return purchaseList;
						
		}
		
	}
	
	@Override
	public String saveErweima(String id1,String erweima){
		Session se =this.getSession();
		String hql="";
		hql = "update user_info u set u.erweima = ? where u.id1 = ?";
		Query query= se.createSQLQuery(hql);
		query.setString(0, erweima);
		query.setString(1, id1);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
	
	@Override
	public String findErweima(String id1){
		Session se =this.getSession();
		String hql="";
		hql = "from user_info where id1 = ?";
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id1);
		if(userlist.size()!=0){
			System.out.println("查询成功");						
			return userlist.get(0).getErweima();
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;
	}
}
