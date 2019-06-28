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
	
	public List<UserInfo> findUser2(String id2) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from user_info u where u.id2 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id2);
		if(userlist.size()!=0){
			System.out.println("id2��ѯ�ɹ�");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;

	}
	
	public List<Purchase> findAllNextDeal(String id1){//ͨ��id2����ֱ����������
		
		String id2 = id1;
		if(this.findUser2(id2) == null){
			return null;
		}else{
			int length;
			int i;
			List<Purchase> purchaseList = new ArrayList<Purchase>();
			length = this.findUser2(id2).size();
			//����id2�Ĳ�ѯ��¼�������ж��ٸ�ֱ������id1
			for(i = 0; i < length; i++){
				id1 = this.findUser2(id2).get(i).getId1();
				String hql="";
				if(id1==null||id1.equals(""))
					   return null;
				hql = "from purchase p where p.id1 = ? ";
				List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1);
				if(purchaselist.size()!=0){										
					if(purchaseList == null){
						return null;
					}else{
						//ÿ��ֱ�����ߵĹ����¼��ӵ�һ��purchaseList��
						purchaseList.addAll(purchaselist);
					}								
				}else if(purchaselist.size()==0){
					return null;
				}				
			}
			System.out.println("purchaselist1:"+purchaseList);
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
			System.out.println("id3��ѯ�ɹ�");	
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
			System.out.println("id4��ѯ�ɹ�");	
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
			System.out.println("id5��ѯ�ɹ�");	
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
			System.out.println("id6��ѯ�ɹ�");	
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
			//System.out.println("id5��ѯ�ɹ�");	
			//System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;

	}
	
public List<Purchase> findNextDeal3(String id1,String id3){//ͨ��id3����ֱ����������
		
		if(this.findUser3(id3) == null){
			return null;
		}else{
			int length;
			int i;
			List<Purchase> purchaseList = new ArrayList<Purchase>();
			length = this.findUser3(id3).size();
			System.out.println(length);
			for(i = 0; i < length; i++){
				id1 = this.findUser3(id3).get(i).getId2();//id3��ֱ��������id2
				String hql="";
				if(id1==null||id1.equals(""))
					   return null;
				hql = "from purchase p where p.id1 = ? ";
				List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1);
				if(purchaselist.size()!=0){
					System.out.println("purchase��ѯ�ɹ�");
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
			System.out.println("purchaselist:"+purchaseList);
			return purchaseList;
						
		}
		
	}
	
public List<Purchase> findNextDeal4(String id1,String id4){//ͨ��id4����ֱ����������
	
	if(this.findUser4(id4) == null){
		return null;
	}else{
		int length;
		int i;
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		length = this.findUser4(id4).size();
		System.out.println(length);
		for(i = 0; i < length; i++){
			id1 = this.findUser4(id4).get(i).getId3();//id4��ֱ��������id3
			String hql="";
			if(id1==null||id1.equals(""))
				   return null;
			hql = "from purchase p where p.id1 = ? ";
			List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1);
			if(purchaselist.size()!=0){
				System.out.println("purchase��ѯ�ɹ�");
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

public List<Purchase> findNextDeal5(String id1,String id5){//ͨ��id5����ֱ����������
	
	if(this.findUser5(id5) == null){
		return null;
	}else{
		int length;
		int i;
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		length = this.findUser5(id5).size();
		System.out.println(length);
		for(i = 0; i < length; i++){
			id1 = this.findUser5(id5).get(i).getId4();//id5��ֱ��������id4
			String hql="";
			if(id1==null||id1.equals(""))
				   return null;
			hql = "from purchase p where p.id1 = ? ";
			List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1);
			if(purchaselist.size()!=0){
				System.out.println("purchase��ѯ�ɹ�");
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

public List<Purchase> findNextDeal6(String id1,String id6){//ͨ��id6����ֱ����������
	
	if(this.findUser6(id6) == null){
		return null;
	}else{
		int length;
		int i;
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		length = this.findUser6(id6).size();
		System.out.println(length);
		for(i = 0; i < length; i++){
			id1 = this.findUser6(id6).get(i).getId5();//id6��ֱ��������id5
			String hql="";
			if(id1==null||id1.equals(""))
				   return null;
			hql = "from purchase p where p.id1 = ? ";
			List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1);
			if(purchaselist.size()!=0){
				System.out.println("purchase��ѯ�ɹ�");
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

public List<Purchase> findNextDeal7(String id1,String id7){//ͨ��id7����ֱ����������
	
	if(this.findUser7(id7) == null){
		return null;
	}else{
		int length;
		int i;
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		length = this.findUser7(id7).size();
		System.out.println(length);
		for(i = 0; i < length; i++){
			id1 = this.findUser7(id7).get(i).getId6();//id7��ֱ��������id6
			String hql="";
			if(id1==null||id1.equals(""))
				   return null;
			hql = "from purchase p where p.id1 = ? ";
			List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1);
			if(purchaselist.size()!=0){
				System.out.println("purchase��ѯ�ɹ�");
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
	public String saveErweima(String id1,String erweima,String erweimaFormat){
		Session se =this.getSession();
		String hql="";
		hql = "update user_info u set u.erweima = ?,u.erweimaFormat=? where u.id1 = ?";
		Query query= se.createSQLQuery(hql);
		query.setString(0, erweima);
		query.setString(1, erweimaFormat);
		query.setString(2, id1);
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
			//System.out.println("��ѯ�ɹ�");
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
		//System.out.println("��ѯ�ɹ�");						
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
			System.out.println("id1��ѯ�ɹ�");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;
	}



	@Override
	public String updateUser(String id1, String id2) {//��ǰ�û�id1����ɨ���û���id1����Ϊid2
		// TODO Auto-generated method stub
		Session se =this.getSession();
		String hql="";
		id2 = this.findUserById1(id2).get(0).getId1();//�õ���ɨ���û���id1��Ϊ��ǰ�û�id1��id2
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
			System.out.println("id1��ѯ�ɹ�");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;
	}
	
//	@Override
//	public List<Purchase> findAllDirectDeal(String id1){
//		
//		String id7 = null;//�Դ�id7���Ƶ�id1
//		String id6 = null;
//		String id5 = null;
//		String id4 = null;
//		String id3 = null;
//		String id2 = null;//id2 
//		
//		//����userinfo id2 ��id7��ѯuser �õ�list����
//		List<UserInfo> list7 = new ArrayList<UserInfo>();
//		List<UserInfo> list6 = new ArrayList<UserInfo>();
//		List<UserInfo> list5 = new ArrayList<UserInfo>();
//		List<UserInfo> list4 = new ArrayList<UserInfo>();
//		List<UserInfo> list3 = new ArrayList<UserInfo>();
//		List<UserInfo> list2 = new ArrayList<UserInfo>();
//		//ֱ���¼��Ĺ����¼
//		List<Purchase> purchaseList = new ArrayList<Purchase>();
//		List<Purchase> zpurchaseList = new ArrayList<Purchase>();		
//		List<Purchase> zpurchaseList2 = new ArrayList<Purchase>();
//		List<Purchase> zpurchaseList3 = new ArrayList<Purchase>();
//		List<Purchase> zpurchaseList4 = new ArrayList<Purchase>();
//		List<Purchase> zpurchaseList5 = new ArrayList<Purchase>();
//		List<Purchase> zpurchaseList6 = new ArrayList<Purchase>();
//		
//		id2 = id1;//��id1��ֵ��id2���Դ�����id1�������¼�,id2����id1���ϼ� id2 ��id7��������ֱ���¼�
//		list2 = this.findUser2(id2);
//		id3 = id1;//��id1��ֵ��id3 �Դ�����id1��������
//		list3 = this.findUser3(id3);
//		id4 = id1;//��id1��ֵ��id4 �Դ�����id1����3��
//		list4 = this.findUser4(id4);
//		id5 = id1;//��id1��ֵ��id5 �Դ�����id1����4��
//		list5 = this.findUser5(id5);
//		id6 = id1;//��id1��ֵ��id6 �Դ�����id1����5��
//		list6 = this.findUser6(id6);
//		id7 = id1;//��id1��ֵ��id7 �Դ�����id1����6��
//		list7 = this.findUser7(id7);
//		//��id1��ֵ��id2��7����7�������ֱ���¼�
//		zpurchaseList = this.findNextDeal2(id1, id2);
//		System.out.println("ֱ��list1:"+zpurchaseList);
//		System.out.println("userlist:"+list2);
//	    zpurchaseList2 = this.findNextDeal3(id1, id3);
//	    System.out.println("ֱ��list2:"+zpurchaseList2);
//	    zpurchaseList3 = this.findNextDeal4(id1, id4);
//		zpurchaseList4 = this.findNextDeal5(id1, id5);
//		zpurchaseList5 = this.findNextDeal6(id1, id6);
//		zpurchaseList6 = this.findNextDeal7(id1, id7);
//		
//		
//		
//		//û��ֱ���¼�ʱ��ֱ���¼�û��purchase
//		if(list2 == null && list3 == null && list4 == null && list5 == null && list6 == null && list7 == null){
//			return null;
//		}
//		//�����1��6�����ߣ�������ֱ�����߹����¼��ӵ�һ��list��,���������µĹ����¼�п���Ϊ��
//		else if(list2 != null && list3 != null && list4 != null && list5 != null && list6!=null && list7 != null){
//			purchaseList.addAll(zpurchaseList);
//			purchaseList.addAll(zpurchaseList2);
//			purchaseList.addAll(zpurchaseList3);
//			purchaseList.addAll(zpurchaseList4);
//			purchaseList.addAll(zpurchaseList5);
//			purchaseList.addAll(zpurchaseList6);
//			return purchaseList;
//		}
//		//ȱ��ĳһ������ʱ��,��ȱ��ĳ����������ʱ��
//		else if(list2 == null || list3 == null || list4 == null || list5 == null || list6==null || list7 == null){
//			if(list2 == null){
//				zpurchaseList = null;
//			}else if(list2 != null){
//				if(zpurchaseList == null){
//					
//				}else{
//					purchaseList.addAll(zpurchaseList);
//					//System.out.println("list2:"+purchaseList);
//				}
//				
//			}
//			if(list3 == null){
//				zpurchaseList2 = null;
//			}else if(list3 != null){
//				if(zpurchaseList2 == null){
//					
//				}else{
//					purchaseList.addAll(zpurchaseList2);
//					//System.out.println("list2:"+zpurchaseList2);
//				}
//				
//			}
//			if(list4 == null){
//				zpurchaseList3 = null;
//			}else if(list4 != null){
//				if(zpurchaseList==null){
//					
//				}else{
//					purchaseList.addAll(zpurchaseList3);
//				}
//				
//			}
//			if(list5 == null){
//				zpurchaseList4 = null;
//			}else if(list5 != null){
//				if(zpurchaseList4==null){
//					
//				}else{
//					purchaseList.addAll(zpurchaseList4);
//				}
//				
//			}
//			if(list6 == null){
//				zpurchaseList5 = null;
//			}else if(list6 != null){
//				if(zpurchaseList5==null){
//					
//				}else{
//					purchaseList.addAll(zpurchaseList5);
//				}
//				
//			}
//			if(list7 == null){
//				zpurchaseList6 = null;
//			}else if(list7 != null){
//				if(zpurchaseList6==null){
//					
//				}else{
//					purchaseList.addAll(zpurchaseList6);
//				}
//				
//			}
//			
//			return purchaseList;
//		}
//		return null;	
//	}
	
}
