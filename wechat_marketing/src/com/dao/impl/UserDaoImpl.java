package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;

	}
	
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Purchase> findAllNextDeal(String id1,String id2){//通过id2来找直接线下数量
		
		if(this.findUser(id2) == null){
			return null;
		}else{
			int length;
			int i;
			List<Purchase> purchaseList = new ArrayList<Purchase>();
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
	
	public List<UserInfo> findUser3(String id3) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from user_info u where u.id3 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id3);
		if(userlist.size()!=0){
			System.out.println("id2查询成功");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;

	}
	
	public List<UserInfo> findUser4(String id4) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from user_info u where u.id4 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id4);
		if(userlist.size()!=0){
			System.out.println("id4查询成功");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;

	}
	
	
	public List<UserInfo> findUser5(String id5) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from user_info u where u.id5 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id5);
		if(userlist.size()!=0){
			System.out.println("id5查询成功");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;

	}
	
	public List<UserInfo> findUser6(String id6) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from user_info u where u.id6 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id6);
		if(userlist.size()!=0){
			System.out.println("id6查询成功");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;

	}
	
	public List<UserInfo> findUser7(String id7) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from user_info u where u.id7 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id7);
		if(userlist.size()!=0){
			//System.out.println("id5查询成功");	
			//System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;

	}
	
public List<Purchase> findNextDeal3(String id1,String id3){//通过id3来找直接线下数量
		
		if(this.findUser(id3) == null){
			return null;
		}else{
			int length;
			int i;
			List<Purchase> purchaseList = new ArrayList<Purchase>();
			length = this.findUser(id3).size();
			System.out.println(length);
			for(i = 0; i < length; i++){
				id1 = this.findUser(id3).get(i).getId2();//id3的直接线下是id2
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
	
public List<Purchase> findNextDeal4(String id1,String id4){//通过id4来找直接线下数量
	
	if(this.findUser(id4) == null){
		return null;
	}else{
		int length;
		int i;
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		length = this.findUser(id4).size();
		System.out.println(length);
		for(i = 0; i < length; i++){
			id1 = this.findUser(id4).get(i).getId3();//id4的直接线下是id3
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

public List<Purchase> findNextDeal5(String id1,String id5){//通过id5来找直接线下数量
	
	if(this.findUser(id5) == null){
		return null;
	}else{
		int length;
		int i;
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		length = this.findUser(id5).size();
		System.out.println(length);
		for(i = 0; i < length; i++){
			id1 = this.findUser(id5).get(i).getId4();//id3的直接线下是id2
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

public List<Purchase> findNextDeal6(String id1,String id6){//通过id6来找直接线下数量
	
	if(this.findUser(id6) == null){
		return null;
	}else{
		int length;
		int i;
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		length = this.findUser(id6).size();
		System.out.println(length);
		for(i = 0; i < length; i++){
			id1 = this.findUser(id6).get(i).getId5();//id6的直接线下是id5
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

public List<Purchase> findNextDeal7(String id1,String id7){//通过id7来找直接线下数量
	
	if(this.findUser(id7) == null){
		return null;
	}else{
		int length;
		int i;
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		length = this.findUser(id7).size();
		System.out.println(length);
		for(i = 0; i < length; i++){
			id1 = this.findUser(id7).get(i).getId6();//id7的直接线下是id6
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
	
	public List<Purchase> findOneDeal(String deal_num) {
		String hql="";
		if(deal_num==null||deal_num.equals(""))
			   return null;
		hql = "from purchase p where p.deal_num = ?";
		@SuppressWarnings("unchecked")
		List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,deal_num);
		if(purchaselist.size()!=0){
			//System.out.println("查询成功");
			//System.out.println("deal_num is "+ deal_num);
			return purchaselist;
		}else if(purchaselist.size()==0){
			return null;
		}
		 
		return null;

	}
	
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<UserInfo> findErweima(String id1){
		String hql="";
		hql = "from user_info where id1 = ?";
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id1);
		if(userlist.size()!=0){
		//System.out.println("查询成功");						
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;
	}

	@Override
	public String saveInfo(String id1, String username, String avatar_url) {
		Session se =this.getSession();
		String hql="";
		hql = "insert into user_info(id1,username,avatar_url) values(?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setString(0, id1);
		query.setString(1, username);
		query.setString(2, avatar_url);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}

	@Override
	public List<UserInfo> searchUsernameAvatar(String id1) {
		
		String hql="";			   
		hql = "from user_info u where u.id1 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id1);
		if(userlist.size()!=0){
			System.out.println("id1查询成功");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;
	}



	@Override
	public String updateUser(String id1, String id2) {//当前用户id1，被扫码用户的id1命名为id2
		// TODO Auto-generated method stub
		Session se =this.getSession();
		String hql="";
		id2 = this.findUserById1(id2).get(0).getId1();//得到被扫码用户的id1作为当前用户id1的id2
		String id3 = this.findUserById1(id2).get(0).getId2();
		String id4 = this.findUserById1(id2).get(0).getId3();
		String id5 = this.findUserById1(id2).get(0).getId4();
		String id6 = this.findUserById1(id2).get(0).getId5();
		String id7 = this.findUserById1(id2).get(0).getId6();
		hql = "update user_info set id2 = ?,id3 = ?,id4 = ?,id5 = ?,id6 = ?,id7 = ? where id1 = ?";
		Query query= se.createSQLQuery(hql);
		query.setString(0, id2);
		query.setString(1, id3);
		query.setString(2, id4);
		query.setString(3, id5);
		query.setString(4, id6);
		query.setString(5, id7);
		query.setString(6, id1);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}


	public List<UserInfo> findUserById1(String id1){
		
		String hql="";			   
		hql = "from user_info u where u.id1 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id1);
		if(userlist.size()!=0){
			System.out.println("id1查询成功");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;
	}

	
	
}
