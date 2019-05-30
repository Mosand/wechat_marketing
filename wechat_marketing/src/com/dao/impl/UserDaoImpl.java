package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.UserDao;
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
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;

	}
	
	@Override
	public List<Purchase> findOneDeal(String id1,String id2){
		
		if(this.findUser(id2) == null){
			return null;
		}else{
			id1 = this.findUser(id2).get(0).getId1();
		}
		
		String hql="";
		if(id1==null||id1.equals(""))
			   return null;
		hql = "from purchase p where p.id1 = ? ";
		List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1);
		if(purchaselist.size()!=0){
			System.out.println("查询成功");
			System.out.println("id1 is "+ id1);
			return purchaselist;
		}else if(purchaselist.size()==0){
			return null;
		}
		 
		return null;
		
	}
}
