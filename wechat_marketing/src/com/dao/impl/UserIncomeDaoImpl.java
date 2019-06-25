package com.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.UserIncomeDao;
import com.entity.GoodsInfo;
import com.entity.Pager;
import com.entity.Purchase;
import com.entity.TGF;
import com.entity.TransactionRecord;
import com.entity.UserIncome;
import com.entity.UserIncome2;
import com.entity.UserInfo;
import com.google.gson.Gson;

public class UserIncomeDaoImpl extends HibernateDaoSupport implements UserIncomeDao{

	
	@Override
	public List<GoodsInfo> findItem(int goods_id) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from goods_info where goods_id = ?";
		@SuppressWarnings("unchecked")
		List<GoodsInfo> goodslist=this.getHibernateTemplate().find(hql,goods_id);
		if(goodslist.size()!=0){
			//System.out.println("��ѯ�ɹ�");						
			return goodslist;
		}else if(goodslist.size()==0){
			return null;
		}
		
		return null;

	}
	
	@Override
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
	
	
	@Override
	public List<UserInfo> findUser(String id2) {
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
	
	public List<Purchase> findAllNextDeal(String id1,String id2){
		if(this.findUser(id2) == null){
			return null;
		}else{
			int length;
			int i;
			List<Purchase> purchaseList = new ArrayList<Purchase>();
			length = this.findUser(id2).size();
			System.out.println("length:"+length);
			for(i = 0; i < length; i++){
				id1 = this.findUser(id2).get(i).getId1();
				String hql="";
				if(id1==null||id1.equals(""))
					   return null;
				hql = "from purchase p where p.id1 = ? ";
				@SuppressWarnings("unchecked")
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
	
	public List<TGF> findTgf(int goods_id){
		
		String hql="";
		hql = "from tgf t where t.goods_id = ?";
		@SuppressWarnings("unchecked")
		List<TGF> tgflist=this.getHibernateTemplate().find(hql,goods_id);
		if(tgflist.size()!=0){
			System.out.println("tgf��ѯ�ɹ�");	
			
			return tgflist;
		}else if(tgflist.size()==0){
			return null;
		}
		
		return null;
	}
	
	public List<UserInfo> findUserAll(String id1) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from user_info u where u.id1 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id1);
		if(userlist.size()!=0){
			System.out.println("id2��ѯ�ɹ�");	
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
			System.out.println("id2��ѯ�ɹ�");	
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
			System.out.println("id2��ѯ�ɹ�");	
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
			System.out.println("id2��ѯ�ɹ�");	
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
			System.out.println("id2��ѯ�ɹ�");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;
		}
	
	public List<UserInfo> findUser3(String id3) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from user_info u where u.id3 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id3);
		if(userlist.size()!=0){
			System.out.println("id2��ѯ�ɹ�");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;
		}
	
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
	
	public List<Purchase> findDealByIdandGoodsId(String id1,int goods_id) {
		String hql="";
		
		hql = "from purchase p where p.id1 = ? and p.goods_id = ?";
		@SuppressWarnings("unchecked")
		List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1,goods_id);
		if(purchaselist.size()!=0){
			//System.out.println("��ѯ�ɹ�");			
			return purchaselist;
		}else if(purchaselist.size()==0){
			return null;
		}
		 
		return null;

	}
	
	
	public List<Purchase> findNextDeal3(String id1,String id3){//ͨ��id3����ֱ����������
		
		if(this.findUser(id3) == null){
			return null;
		}else{
			int length;
			int i;
			List<Purchase> purchaseList = new ArrayList<Purchase>();
			length = this.findUser(id3).size();
			System.out.println(length);
			for(i = 0; i < length; i++){
				id1 = this.findUser(id3).get(i).getId2();//id3��ֱ��������id2
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
	
public List<Purchase> findNextDeal4(String id1,String id4){//ͨ��id4����ֱ����������
	
	if(this.findUser(id4) == null){
		return null;
	}else{
		int length;
		int i;
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		length = this.findUser(id4).size();
		System.out.println(length);
		for(i = 0; i < length; i++){
			id1 = this.findUser(id4).get(i).getId3();//id4��ֱ��������id3
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
	
		if(this.findUser(id5) == null){
			return null;
		}else{
			int length;
			int i;
			List<Purchase> purchaseList = new ArrayList<Purchase>();
			length = this.findUser(id5).size();
			System.out.println(length);
			for(i = 0; i < length; i++){
				id1 = this.findUser(id5).get(i).getId4();//id3��ֱ��������id2
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
	
	if(this.findUser(id6) == null){
		return null;
	}else{
		int length;
		int i;
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		length = this.findUser(id6).size();
		System.out.println(length);
		for(i = 0; i < length; i++){
			id1 = this.findUser(id6).get(i).getId5();//id6��ֱ��������id5
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
	
		if(this.findUser(id7) == null){
			return null;
		}else{
			int length;
			int i;
			List<Purchase> purchaseList = new ArrayList<Purchase>();
			length = this.findUser(id7).size();
			System.out.println(length);
			for(i = 0; i < length; i++){
				id1 = this.findUser(id7).get(i).getId6();//id7��ֱ��������id6
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
	
	public List<UserInfo> findRootUser(String id1) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from user_info u where u.id2 is null and id1 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id1);
		if(userlist.size()!=0){
			System.out.println("id2��ѯ�ɹ�");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;
		}	
	

	@SuppressWarnings("unused")
	@Override
	public String saveUserIncome(String id1, int goods_id, float ticheng, float market_price, float reward,float admin,
			String username,String deal_num,String avatar_url,String goods_name) {
		// TODO Auto-generated method stub
		Session se =this.getSession();
		String hql="";
		id1 = this.findOneDeal(deal_num).get(0).getId1();//��ȡ���������¼�Ĺ˿�id1��
		goods_id = this.findOneDeal(deal_num).get(0).getGoods_id();//��ȡ���������¼����Ʒid��
		avatar_url = this.findUserAll(id1).get(0).getAvatar_url();
		goods_name = this.findItem(goods_id).get(0).getGoods_name();
		int length;
		int i;
		//String id2 = id1;//��id1��ֵ��id2���Դ�����id1�������¼�,id2����id1���ϼ� id2 ��id7��������ֱ���¼�������ֻд��id2��
		int count = 0;
		//ֱ���¼���������
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		//����userinfo id2 ��id7��ѯuser �õ�list����
		List<UserInfo> list7 = new ArrayList<UserInfo>();
		List<UserInfo> list6 = new ArrayList<UserInfo>();
		List<UserInfo> list5 = new ArrayList<UserInfo>();
		List<UserInfo> list4 = new ArrayList<UserInfo>();
		List<UserInfo> list3 = new ArrayList<UserInfo>();
		List<UserInfo> list2 = new ArrayList<UserInfo>();
		//ֱ���¼��Ĺ����¼
		List<Purchase> zpurchaseList = new ArrayList<Purchase>();		
		List<Purchase> zpurchaseList2 = new ArrayList<Purchase>();
		List<Purchase> zpurchaseList3 = new ArrayList<Purchase>();
		List<Purchase> zpurchaseList4 = new ArrayList<Purchase>();
		List<Purchase> zpurchaseList5 = new ArrayList<Purchase>();
		List<Purchase> zpurchaseList6 = new ArrayList<Purchase>();
		//����¼��Ĺ����¼
		List<Purchase> purchaseList = new ArrayList<Purchase>();		
		List<Purchase> purchaseList2 = new ArrayList<Purchase>();//����id1 �� goods_id�ҵ����˹���ò�Ʒ������buy_num֮��
		List<Purchase> purchaseList3 = new ArrayList<Purchase>();
		List<Purchase> purchaseList4 = new ArrayList<Purchase>();
		List<Purchase> purchaseList5 = new ArrayList<Purchase>();
		List<Purchase> purchaseList6 = new ArrayList<Purchase>();
		String id7 = null;//�Դ�id7���Ƶ�id1
		String id6 = null;
		String id5 = null;
		String id4 = null;
		String id3 = null;
		String id2 = null;//id2 �����ظ�
		String id11 = null;//id1 �����ظ�
		
		//����¼���������
		int buy_num = 0;
		int buy_num1 = 0;
		int buy_num2 = 0;
		int buy_num3 = 0;
		int buy_num4 = 0;
		int buy_num5 = 0;
		int buy_num6 = 0;
		int buy_num7 = 0;
		int buy_num8 = 0;
		int buy_num9 = 0;
		int buy_num10 = 0;
		int buy_num11 = 0;
		int buy_num12 = 0;
		int buy_num13 = 0;
		int buy_num14 = 0;
		int buy_num15 = 0;
		
		//��ֵ����1��6
		int length1 = 0;
		int length2 = 0;
		int length3 = 0;
		int length4 = 0;
		int length5 = 0;
		int length6 = 0;
		
		id2 = id1;//��id1��ֵ��id2���Դ�����id1�������¼�,id2����id1���ϼ� id2 ��id7��������ֱ���¼�������ֻд��id2��
		list2 = this.findUser2(id2);
		id3 = id1;//��id1��ֵ��id3 �Դ�����id1��������
		list3 = this.findUser3(id3);
		id4 = id1;//��id1��ֵ��id4 �Դ�����id1����3��
		list4 = this.findUser4(id4);
		id5 = id1;//��id1��ֵ��id5 �Դ�����id1����4��
		list5 = this.findUser5(id5);
		id6 = id1;//��id1��ֵ��id6 �Դ�����id1����5��
		list6 = this.findUser6(id6);
		id7 = id1;//��id1��ֵ��id7 �Դ�����id1����6��
		list7 = this.findUser7(id7);
		
		//��id1��ֵ��id2��7����7�������ֱ���¼�
		zpurchaseList = this.findAllNextDeal(id1, id2);
	    zpurchaseList2 = this.findNextDeal3(id1, id3);
		zpurchaseList3 = this.findNextDeal4(id1, id4);
		zpurchaseList4 = this.findNextDeal5(id1, id5);
		zpurchaseList5 = this.findNextDeal6(id1, id6);
		zpurchaseList6 = this.findNextDeal7(id1, id7);
		
	if(0 < this.findOneDeal(deal_num).get(0).getBuy_num() && this.findOneDeal(deal_num).get(0).getBuy_num() <= 20){
		
		//��ֱ������ʱ�򣬹�������Ϊ��ǰ�û���������
		if(list2 == null && list3 == null && list4 == null && list5 == null && list6 == null && list7 == null){			
			int count1 = this.findOneDeal(deal_num).get(0).getBuy_num();
			ticheng = this.findItem(goods_id).get(0).getTicheng() * count1;
			System.out.println("��� = :"+ticheng);
			
			//��ֱ������ʱ�򣬹�������Ϊ��ǰ��������
			market_price = 0;
			// ������������� �н���
			if(count1 > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * count1;
			}else{
				reward = 0;
			}
			
			admin = 0;
			username = this.findOneDeal(deal_num).get(0).getUsername();
		}
		//�����1��6������
		else if(list2 != null && list3 != null && list4 != null && list5 != null && list6!=null && list7 != null){
			length1 = zpurchaseList.size();
			if(zpurchaseList.size()==0){
				count2 = 0;
			}
			for(i = 0; i < length1; i++){
				if(goods_id == zpurchaseList.get(i).getGoods_id()){
					count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length2 = zpurchaseList2.size();
			if(zpurchaseList2.size()==0){
				count3 = 0;
			}
			for(i = 0; i < length2; i++){
				if(goods_id == zpurchaseList2.get(i).getGoods_id()){
					count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length3 = zpurchaseList3.size();
			if(zpurchaseList3.size()==0){
				count4 = 0;
			}
			for(i = 0; i < length3; i++){
				if(goods_id == zpurchaseList3.get(i).getGoods_id()){
					count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length4 = zpurchaseList4.size();
			if(zpurchaseList4.size()==0){
				count5 = 0;
			}
			for(i = 0; i < length4; i++){
				if(goods_id == zpurchaseList4.get(i).getGoods_id()){
					count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length5 = zpurchaseList5.size();
			if(zpurchaseList5.size()==0){
				count6 = 0;
			}
			for(i = 0; i < length5; i++){
				if(goods_id == zpurchaseList5.get(i).getGoods_id()){
					count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length6 = zpurchaseList6.size();
			if(zpurchaseList6.size()==0){
				count7 = 0;
			}
			for(i = 0; i < length6; i++){
				if(goods_id == zpurchaseList6.get(i).getGoods_id()){
					count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			count = count2 + count3 + count4 + count5 + count6 + count7;
			
			//�Ҽ�����߹����¼��list2 ��list7�����м������
			
			//list2�ļ������Ϊ0
			buy_num = 0;
			//list3�ļ������Ϊid3��id1�����¼
			int llength = list3.size();
			for(i = 0;i<llength;i++){
				id11 = list3.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
				System.out.println("id11:"+id11);
				//û�й����¼
				if(purchaseList2 == null){
					buy_num1 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
						System.out.println("buy_num1:"+buy_num1);
				}
			}
			}
			//list4�ļ�����߹����¼
			int llength2 = list4.size();
			for(i = 0;i<llength2;i++){
				id11 = list4.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					 buy_num2 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num2:"+buy_num1);
			}								
				id2 = list4.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num3 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num3:"+buy_num2);
			}
			}
			
			//list5�ļ�����߹����¼
			int llength3 = list5.size();
			for(i = 0;i<llength3;i++){
				id11 = list5.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num4 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list5.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num5 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list5.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num6 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}
			
			//list6�ļ�����߹����¼
			int llength4 = list6.size();
			for(i = 0;i<llength4;i++){
				id11 = list6.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num7 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list6.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num8 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list6.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num9 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				id4 = list6.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num10 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			
			}
			
			//list7�����߹����¼
			int llength5 = list7.size();
			for(i = 0;i<llength5;i++){
				id11 = list7.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num11 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list7.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num12 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list7.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num13 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				
				id4 = list7.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num14 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num4;
				
				id5 = list7.get(i).getId5();//��ȡ���м������id5
				purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList6 == null){
					buy_num15 = 0;
				}else{
					length = purchaseList6.size();								
					for(int j = 0; j < length; j++){						
						buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}			
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	
			//����reward
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;
			
			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			System.out.println("�Լ���buy_num:" + this.findOneDeal(deal_num).get(0).getBuy_num());
			System.out.println("ticheng:" + ticheng);
			float tuiguangfei1 = this.findTgf(goods_id).get(0).getTuiguangfei1();
			float market_price1 = tuiguangfei1 * count;	
			System.out.println("tuiguangfei1:"+tuiguangfei1);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);		
			//ȱ��ĳһ������ʱ��,��ȱ��ĳ����������ʱ��
		}else if(list2 == null || list3 == null || list4 == null || list5 == null || list6==null || list7 == null){
			 if(list2 == null){
				 count2 = 0;
			 }else{
				 length1 = zpurchaseList.size();
					if(zpurchaseList.size()==0){
						count2 = 0;
					}
					for(i = 0; i < length1; i++){
						if(goods_id == zpurchaseList.get(i).getGoods_id()){
							count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			 
			 buy_num = 0;
			 
			 if(list3 == null){
				 count3 = 0;
			 }else{
				 length2 = zpurchaseList2.size();
					if(zpurchaseList2.size()==0){
						count3 = 0;
					}
					for(i = 0; i < length2; i++){
						if(goods_id == zpurchaseList2.get(i).getGoods_id()){
							count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			if(list3!=null){
				//list3�ļ������Ϊid3��id1�����¼
				int llength = list3.size();
				for(i = 0;i<llength;i++){
					id11 = list3.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
					System.out.println("id11:"+id11);
					//û�й����¼
					if(purchaseList2 == null){
						buy_num1 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
							System.out.println("buy_num1:"+buy_num1);
					}
				}
				}
			}
			
				
			if(list4 == null){
				count4 = 0;
			}else{
				if(zpurchaseList3 == null){
					count4 = 0;
				}else{
					length3 = zpurchaseList3.size();
					if(zpurchaseList3.size()==0){
						count4 = 0;
					}
					for(i = 0; i < length3; i++){
						if(goods_id == zpurchaseList3.get(i).getGoods_id()){
							count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
						}		
					}
				}
				
			}
			if(list4!=null){
				//list4�ļ�����߹����¼
				int llength2 = list4.size();
				for(i = 0;i<llength2;i++){
					id11 = list4.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						 buy_num2 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num2:"+buy_num1);
				}								
					id2 = list4.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num3 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num3:"+buy_num2);
				}
				}
			}
			
			
			if(list5 == null){
				count5 = 0;
			}else{
				length4 = zpurchaseList4.size();
				if(zpurchaseList4.size()==0){
					count5 = 0;
				}
				for(i = 0; i < length4; i++){
					if(goods_id == zpurchaseList4.get(i).getGoods_id()){
						count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			//list5�ļ�����߹����¼
			if(list5 != null){
				int llength3 = list5.size();
				for(i = 0;i<llength3;i++){
					id11 = list5.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num4 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list5.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num5 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list5.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num6 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}
			}
			
			
			if(list6 == null){
				count6 =0;
			}else{
				length5 = zpurchaseList5.size();
				if(zpurchaseList5.size()==0){
					count6 = 0;
				}
				for(i = 0; i < length5; i++){
					if(goods_id == zpurchaseList5.get(i).getGoods_id()){
						count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list6!=null){
				//list6�ļ�����߹����¼
				int llength4 = list6.size();
				for(i = 0;i<llength4;i++){
					id11 = list6.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num7 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list6.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num8 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list6.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num9 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					id4 = list6.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num10 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				
				}
			}
			
			
			if(list7==null){
				count7 = 0;
			}else{
				length6 = zpurchaseList6.size();
				if(zpurchaseList6.size()==0){
					count7 = 0;
				}
				for(i = 0; i < length6; i++){
					if(goods_id == zpurchaseList6.get(i).getGoods_id()){
						count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			
			if(list7 != null){
				//list7�����߹����¼
				int llength5 = list7.size();
				for(i = 0;i<llength5;i++){
					id11 = list7.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num11 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list7.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num12 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list7.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num13 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					
					id4 = list7.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num14 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num4;
					
					id5 = list7.get(i).getId5();//��ȡ���м������id5
					purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList6 == null){
						buy_num15 = 0;
					}else{
						length = purchaseList6.size();								
						for(int j = 0; j < length; j++){						
							buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}		
			}
			
			
			count = count2 + count3 + count4 + count5 + count6 + count7;
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;

			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			System.out.println("�Լ���buy_num:" + this.findOneDeal(deal_num).get(0).getBuy_num());
			System.out.println("ticheng:" + ticheng);
			float tuiguangfei1 = this.findTgf(goods_id).get(0).getTuiguangfei1();
			float market_price1 = tuiguangfei1 * count;	
			System.out.println("tuiguangfei1:"+tuiguangfei1);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);
			
		}
	}

	
	if(20 < this.findOneDeal(deal_num).get(0).getBuy_num() && this.findOneDeal(deal_num).get(0).getBuy_num() <= 40){
		
		//��ֱ������ʱ�򣬹�������Ϊ��ǰ�û���������
		if(list2 == null && list3 == null && list4 == null && list5 == null && list6 == null && list7 == null){			
			int count1 = this.findOneDeal(deal_num).get(0).getBuy_num();
			ticheng = this.findItem(goods_id).get(0).getTicheng() * count1;
			System.out.println("��� = :"+ticheng);
			
			//��ֱ������ʱ�򣬹�������Ϊ��ǰ��������
			market_price = 0;
			// ������������� �н���
			if(count1 > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * count1;
			}else{
				reward = 0;
			}
			
			admin = 0;
			username = this.findOneDeal(deal_num).get(0).getUsername();
		}
		//�����1��6������
		else if(list2 != null && list3 != null && list4 != null && list5 != null && list6!=null && list7 != null){
			length1 = zpurchaseList.size();
			if(zpurchaseList.size()==0){
				count2 = 0;
			}
			for(i = 0; i < length1; i++){
				if(goods_id == zpurchaseList.get(i).getGoods_id()){
					count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length2 = zpurchaseList2.size();
			if(zpurchaseList2.size()==0){
				count3 = 0;
			}
			for(i = 0; i < length2; i++){
				if(goods_id == zpurchaseList2.get(i).getGoods_id()){
					count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length3 = zpurchaseList3.size();
			if(zpurchaseList3.size()==0){
				count4 = 0;
			}
			for(i = 0; i < length3; i++){
				if(goods_id == zpurchaseList3.get(i).getGoods_id()){
					count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length4 = zpurchaseList4.size();
			if(zpurchaseList4.size()==0){
				count5 = 0;
			}
			for(i = 0; i < length4; i++){
				if(goods_id == zpurchaseList4.get(i).getGoods_id()){
					count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length5 = zpurchaseList5.size();
			if(zpurchaseList5.size()==0){
				count6 = 0;
			}
			for(i = 0; i < length5; i++){
				if(goods_id == zpurchaseList5.get(i).getGoods_id()){
					count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length6 = zpurchaseList6.size();
			if(zpurchaseList6.size()==0){
				count7 = 0;
			}
			for(i = 0; i < length6; i++){
				if(goods_id == zpurchaseList6.get(i).getGoods_id()){
					count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			count = count2 + count3 + count4 + count5 + count6 + count7;
			
			//�Ҽ�����߹����¼��list2 ��list7�����м������
			
			//list2�ļ������Ϊ0
			buy_num = 0;
			//list3�ļ������Ϊid3��id1�����¼
			int llength = list3.size();
			for(i = 0;i<llength;i++){
				id11 = list3.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
				System.out.println("id11:"+id11);
				//û�й����¼
				if(purchaseList2 == null){
					buy_num1 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
						System.out.println("buy_num1:"+buy_num1);
				}
			}
			}
			//list4�ļ�����߹����¼
			int llength2 = list4.size();
			for(i = 0;i<llength2;i++){
				id11 = list4.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					 buy_num2 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num2:"+buy_num1);
			}								
				id2 = list4.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num3 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num3:"+buy_num2);
			}
			}
			
			//list5�ļ�����߹����¼
			int llength3 = list5.size();
			for(i = 0;i<llength3;i++){
				id11 = list5.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num4 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list5.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num5 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list5.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num6 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}
			
			//list6�ļ�����߹����¼
			int llength4 = list6.size();
			for(i = 0;i<llength4;i++){
				id11 = list6.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num7 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list6.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num8 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list6.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num9 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				id4 = list6.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num10 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			
			}
			
			//list7�����߹����¼
			int llength5 = list7.size();
			for(i = 0;i<llength5;i++){
				id11 = list7.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num11 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list7.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num12 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list7.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num13 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				
				id4 = list7.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num14 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num4;
				
				id5 = list7.get(i).getId5();//��ȡ���м������id5
				purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList6 == null){
					buy_num15 = 0;
				}else{
					length = purchaseList6.size();								
					for(int j = 0; j < length; j++){						
						buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}			
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;

			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			float tuiguangfei2 = this.findTgf(goods_id).get(0).getTuiguangfei2();
			float market_price1 = tuiguangfei2 * count;	
			System.out.println("tuiguangfei2:"+tuiguangfei2);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);		
			//ȱ��ĳһ������ʱ��,��ȱ��ĳ����������ʱ��
		}else if(list2 == null || list3 == null || list4 == null || list5 == null || list6==null || list7 == null){
			 if(list2 == null){
				 count2 = 0;
			 }else{
				 length1 = zpurchaseList.size();
					if(zpurchaseList.size()==0){
						count2 = 0;
					}
					for(i = 0; i < length1; i++){
						if(goods_id == zpurchaseList.get(i).getGoods_id()){
							count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			 
			 buy_num = 0;
			 
			 if(list3 == null){
				 count3 = 0;
			 }else{
				 length2 = zpurchaseList2.size();
					if(zpurchaseList2.size()==0){
						count3 = 0;
					}
					for(i = 0; i < length2; i++){
						if(goods_id == zpurchaseList2.get(i).getGoods_id()){
							count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			 
			 if(list3 != null){
				//list3�ļ������Ϊid3��id1�����¼
					int llength = list3.size();
					for(i = 0;i<llength;i++){
						id11 = list3.get(i).getId1();//��ȡ���м������id1
						purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
						System.out.println("id11:"+id11);
						//û�й����¼
						if(purchaseList2 == null){
							buy_num1 = 0;
						}else{
							length = purchaseList2.size();								
							for(int j = 0; j < length; j++){						
								buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
								System.out.println("buy_num1:"+buy_num1);
						}
					}
					}
			 }
			
				
			if(list4 == null){
				count4 = 0;
			}else{
				length3 = zpurchaseList3.size();
				if(zpurchaseList3.size()==0){
					count4 = 0;
				}
				for(i = 0; i < length3; i++){
					if(goods_id == zpurchaseList3.get(i).getGoods_id()){
						count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			
			if(list4!=null){
				//list4�ļ�����߹����¼
				int llength2 = list4.size();
				for(i = 0;i<llength2;i++){
					id11 = list4.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						 buy_num2 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num2:"+buy_num1);
				}								
					id2 = list4.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num3 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num3:"+buy_num2);
				}
				}
			}
			
			
			if(list5 == null){
				count5 = 0;
			}else{
				length4 = zpurchaseList4.size();
				if(zpurchaseList4.size()==0){
					count5 = 0;
				}
				for(i = 0; i < length4; i++){
					if(goods_id == zpurchaseList4.get(i).getGoods_id()){
						count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list5!=null){
				//list5�ļ�����߹����¼
				int llength3 = list5.size();
				for(i = 0;i<llength3;i++){
					id11 = list5.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num4 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list5.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num5 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list5.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num6 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}
			}
			
			
			if(list6 == null){
				count6 =0;
			}else{
				length5 = zpurchaseList5.size();
				if(zpurchaseList5.size()==0){
					count6 = 0;
				}
				for(i = 0; i < length5; i++){
					if(goods_id == zpurchaseList5.get(i).getGoods_id()){
						count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list6!=null){
				//list6�ļ�����߹����¼
				int llength4 = list6.size();
				for(i = 0;i<llength4;i++){
					id11 = list6.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num7 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list6.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num8 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list6.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num9 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					id4 = list6.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num10 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				
				}
			}
			
			
			if(list7==null){
				count7 = 0;
			}else{
				length6 = zpurchaseList6.size();
				if(zpurchaseList6.size()==0){
					count7 = 0;
				}
				for(i = 0; i < length6; i++){
					if(goods_id == zpurchaseList6.get(i).getGoods_id()){
						count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list7!=null){
				//list7�����߹����¼
				int llength5 = list7.size();
				for(i = 0;i<llength5;i++){
					id11 = list7.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num11 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list7.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num12 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list7.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num13 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					
					id4 = list7.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num14 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num4;
					
					id5 = list7.get(i).getId5();//��ȡ���м������id5
					purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList6 == null){
						buy_num15 = 0;
					}else{
						length = purchaseList6.size();								
						for(int j = 0; j < length; j++){						
							buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}	
			}
							
			count = count2 + count3 + count4 + count5 + count6 + count7;//ֱ�����߹�������
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	//������߹�������
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;

			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			float tuiguangfei2 = this.findTgf(goods_id).get(0).getTuiguangfei2();
			float market_price1 = tuiguangfei2 * count;	
			System.out.println("tuiguangfei1:"+tuiguangfei2);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);
			
		}
	}
	
	if(40 < this.findOneDeal(deal_num).get(0).getBuy_num() && this.findOneDeal(deal_num).get(0).getBuy_num() <= 60){
		
		//��ֱ������ʱ�򣬹�������Ϊ��ǰ�û���������
		if(list2 == null && list3 == null && list4 == null && list5 == null && list6 == null && list7 == null){			
			int count1 = this.findOneDeal(deal_num).get(0).getBuy_num();
			ticheng = this.findItem(goods_id).get(0).getTicheng() * count1;
			System.out.println("��� = :"+ticheng);
			
			//��ֱ������ʱ�򣬹�������Ϊ��ǰ��������
			market_price = 0;
			// ������������� �н���
			if(count2 > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * count1;
			}else{
				reward = 0;
			}
			
			admin = 0;
			username = this.findOneDeal(deal_num).get(0).getUsername();
		}
		//�����1��6������
		else if(list2 != null && list3 != null && list4 != null && list5 != null && list6!=null && list7 != null){
			length1 = zpurchaseList.size();
			if(zpurchaseList.size()==0){
				count2 = 0;
			}
			for(i = 0; i < length1; i++){
				if(goods_id == zpurchaseList.get(i).getGoods_id()){
					count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length2 = zpurchaseList2.size();
			if(zpurchaseList2.size()==0){
				count3 = 0;
			}
			for(i = 0; i < length2; i++){
				if(goods_id == zpurchaseList2.get(i).getGoods_id()){
					count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length3 = zpurchaseList3.size();
			if(zpurchaseList3.size()==0){
				count4 = 0;
			}
			for(i = 0; i < length3; i++){
				if(goods_id == zpurchaseList3.get(i).getGoods_id()){
					count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length4 = zpurchaseList4.size();
			if(zpurchaseList4.size()==0){
				count5 = 0;
			}
			for(i = 0; i < length4; i++){
				if(goods_id == zpurchaseList4.get(i).getGoods_id()){
					count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length5 = zpurchaseList5.size();
			if(zpurchaseList5.size()==0){
				count6 = 0;
			}
			for(i = 0; i < length5; i++){
				if(goods_id == zpurchaseList5.get(i).getGoods_id()){
					count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length6 = zpurchaseList6.size();
			if(zpurchaseList6.size()==0){
				count7 = 0;
			}
			for(i = 0; i < length6; i++){
				if(goods_id == zpurchaseList6.get(i).getGoods_id()){
					count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			count = count2 + count3 + count4 + count5 + count6 + count7;
			
			//�Ҽ�����߹����¼��list2 ��list7�����м������
			
			//list2�ļ������Ϊ0
			buy_num = 0;
			//list3�ļ������Ϊid3��id1�����¼
			int llength = list3.size();
			for(i = 0;i<llength;i++){
				id11 = list3.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
				System.out.println("id11:"+id11);
				//û�й����¼
				if(purchaseList2 == null){
					buy_num1 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
						System.out.println("buy_num1:"+buy_num1);
				}
			}
			}
			//list4�ļ�����߹����¼
			int llength2 = list4.size();
			for(i = 0;i<llength2;i++){
				id11 = list4.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					 buy_num2 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num2:"+buy_num1);
			}								
				id2 = list4.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num3 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num3:"+buy_num2);
			}
			}
			
			//list5�ļ�����߹����¼
			int llength3 = list5.size();
			for(i = 0;i<llength3;i++){
				id11 = list5.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num4 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list5.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num5 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list5.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num6 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}
			
			//list6�ļ�����߹����¼
			int llength4 = list6.size();
			for(i = 0;i<llength4;i++){
				id11 = list6.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num7 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list6.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num8 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list6.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num9 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				id4 = list6.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num10 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			
			}
			
			//list7�����߹����¼
			int llength5 = list7.size();
			for(i = 0;i<llength5;i++){
				id11 = list7.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num11 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list7.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num12 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list7.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num13 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				
				id4 = list7.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num14 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num4;
				
				id5 = list7.get(i).getId5();//��ȡ���м������id5
				purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList6 == null){
					buy_num15 = 0;
				}else{
					length = purchaseList6.size();								
					for(int j = 0; j < length; j++){						
						buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}			
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;

			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			float tuiguangfei3 = this.findTgf(goods_id).get(0).getTuiguangfei3();
			float market_price1 = tuiguangfei3 * count;	
			System.out.println("tuiguangfei2:"+tuiguangfei3);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);		
			//ȱ��ĳһ������ʱ��,��ȱ��ĳ����������ʱ��
		}else if(list2 == null || list3 == null || list4 == null || list5 == null || list6==null || list7 == null){
			 if(list2 == null){
				 count2 = 0;
			 }else{
				 length1 = zpurchaseList.size();
					if(zpurchaseList.size()==0){
						count2 = 0;
					}
					for(i = 0; i < length1; i++){
						if(goods_id == zpurchaseList.get(i).getGoods_id()){
							count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			 
			 buy_num = 0;
			 
			 if(list3 == null){
				 count3 = 0;
			 }else{
				 length2 = zpurchaseList2.size();
					if(zpurchaseList2.size()==0){
						count3 = 0;
					}
					for(i = 0; i < length2; i++){
						if(goods_id == zpurchaseList2.get(i).getGoods_id()){
							count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			
			 if(list3!=null){
				//list3�ļ������Ϊid3��id1�����¼
					int llength = list3.size();
					for(i = 0;i<llength;i++){
						id11 = list3.get(i).getId1();//��ȡ���м������id1
						purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
						System.out.println("id11:"+id11);
						//û�й����¼
						if(purchaseList2 == null){
							buy_num1 = 0;
						}else{
							length = purchaseList2.size();								
							for(int j = 0; j < length; j++){						
								buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
								System.out.println("buy_num1:"+buy_num1);
						}
					}
					}
			 }
			
				
			if(list4 == null){
				count4 = 0;
			}else{
				length3 = zpurchaseList3.size();
				if(zpurchaseList3.size()==0){
					count4 = 0;
				}
				for(i = 0; i < length3; i++){
					if(goods_id == zpurchaseList3.get(i).getGoods_id()){
						count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			
			if(list4!=null){
				//list4�ļ�����߹����¼
				int llength2 = list4.size();
				for(i = 0;i<llength2;i++){
					id11 = list4.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						 buy_num2 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num2:"+buy_num1);
				}								
					id2 = list4.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num3 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num3:"+buy_num2);
				}
				}	
			}
			
			
			if(list5 == null){
				count5 = 0;
			}else{
				length4 = zpurchaseList4.size();
				if(zpurchaseList4.size()==0){
					count5 = 0;
				}
				for(i = 0; i < length4; i++){
					if(goods_id == zpurchaseList4.get(i).getGoods_id()){
						count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list5!=null){
				//list5�ļ�����߹����¼
				int llength3 = list5.size();
				for(i = 0;i<llength3;i++){
					id11 = list5.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num4 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list5.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num5 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list5.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num6 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}
			}
			
			
			if(list6 == null){
				count6 =0;
			}else{
				length5 = zpurchaseList5.size();
				if(zpurchaseList5.size()==0){
					count6 = 0;
				}
				for(i = 0; i < length5; i++){
					if(goods_id == zpurchaseList5.get(i).getGoods_id()){
						count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list6!=null){
				//list6�ļ�����߹����¼
				int llength4 = list6.size();
				for(i = 0;i<llength4;i++){
					id11 = list6.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num7 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list6.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num8 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list6.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num9 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					id4 = list6.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num10 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				
				}
			}
			
			
			if(list7==null){
				count7 = 0;
			}else{
				length6 = zpurchaseList6.size();
				if(zpurchaseList6.size()==0){
					count7 = 0;
				}
				for(i = 0; i < length6; i++){
					if(goods_id == zpurchaseList6.get(i).getGoods_id()){
						count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list7!=null){
				//list7�����߹����¼
				int llength5 = list7.size();
				for(i = 0;i<llength5;i++){
					id11 = list7.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num11 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list7.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num12 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list7.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num13 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					
					id4 = list7.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num14 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num4;
					
					id5 = list7.get(i).getId5();//��ȡ���м������id5
					purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList6 == null){
						buy_num15 = 0;
					}else{
						length = purchaseList6.size();								
						for(int j = 0; j < length; j++){						
							buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}		
			}			
			
			count = count2 + count3 + count4 + count5 + count6 + count7;
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;

			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			float tuiguangfei3 = this.findTgf(goods_id).get(0).getTuiguangfei3();
			float market_price1 = tuiguangfei3 * count;	
			System.out.println("tuiguangfei1:"+tuiguangfei3);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);
			
		}
	}
	
	if(60 < this.findOneDeal(deal_num).get(0).getBuy_num() && this.findOneDeal(deal_num).get(0).getBuy_num() <= 80){
		
		//��ֱ������ʱ�򣬹�������Ϊ��ǰ�û���������
		if(list2 == null && list3 == null && list4 == null && list5 == null && list6 == null && list7 == null){			
			int count1 = this.findOneDeal(deal_num).get(0).getBuy_num();
			ticheng = this.findItem(goods_id).get(0).getTicheng() * count1;
			System.out.println("��� = :"+ticheng);
			
			//��ֱ������ʱ�򣬹�������Ϊ��ǰ��������
			market_price = 0;
			// ������������� �н���
			if(count2 > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * count1;
			}else{
				reward = 0;
			}
			
			admin = 0;
			username = this.findOneDeal(deal_num).get(0).getUsername();
		}
		//�����1��6������
		else if(list2 != null && list3 != null && list4 != null && list5 != null && list6!=null && list7 != null){
			length1 = zpurchaseList.size();
			if(zpurchaseList.size()==0){
				count2 = 0;
			}
			for(i = 0; i < length1; i++){
				if(goods_id == zpurchaseList.get(i).getGoods_id()){
					count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length2 = zpurchaseList2.size();
			if(zpurchaseList2.size()==0){
				count3 = 0;
			}
			for(i = 0; i < length2; i++){
				if(goods_id == zpurchaseList2.get(i).getGoods_id()){
					count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length3 = zpurchaseList3.size();
			if(zpurchaseList3.size()==0){
				count4 = 0;
			}
			for(i = 0; i < length3; i++){
				if(goods_id == zpurchaseList3.get(i).getGoods_id()){
					count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length4 = zpurchaseList4.size();
			if(zpurchaseList4.size()==0){
				count5 = 0;
			}
			for(i = 0; i < length4; i++){
				if(goods_id == zpurchaseList4.get(i).getGoods_id()){
					count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length5 = zpurchaseList5.size();
			if(zpurchaseList5.size()==0){
				count6 = 0;
			}
			for(i = 0; i < length5; i++){
				if(goods_id == zpurchaseList5.get(i).getGoods_id()){
					count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length6 = zpurchaseList6.size();
			if(zpurchaseList6.size()==0){
				count7 = 0;
			}
			for(i = 0; i < length6; i++){
				if(goods_id == zpurchaseList6.get(i).getGoods_id()){
					count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			count = count2 + count3 + count4 + count5 + count6 + count7;
			
			//�Ҽ�����߹����¼��list2 ��list7�����м������
			
			//list2�ļ������Ϊ0
			buy_num = 0;
			//list3�ļ������Ϊid3��id1�����¼
			int llength = list3.size();
			for(i = 0;i<llength;i++){
				id11 = list3.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
				System.out.println("id11:"+id11);
				//û�й����¼
				if(purchaseList2 == null){
					buy_num1 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
						System.out.println("buy_num1:"+buy_num1);
				}
			}
			}
			//list4�ļ�����߹����¼
			int llength2 = list4.size();
			for(i = 0;i<llength2;i++){
				id11 = list4.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					 buy_num2 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num2:"+buy_num1);
			}								
				id2 = list4.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num3 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num3:"+buy_num2);
			}
			}
			
			//list5�ļ�����߹����¼
			int llength3 = list5.size();
			for(i = 0;i<llength3;i++){
				id11 = list5.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num4 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list5.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num5 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list5.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num6 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}
			
			//list6�ļ�����߹����¼
			int llength4 = list6.size();
			for(i = 0;i<llength4;i++){
				id11 = list6.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num7 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list6.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num8 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list6.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num9 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				id4 = list6.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num10 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			
			}
			
			//list7�����߹����¼
			int llength5 = list7.size();
			for(i = 0;i<llength5;i++){
				id11 = list7.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num11 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list7.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num12 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list7.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num13 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				
				id4 = list7.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num14 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num4;
				
				id5 = list7.get(i).getId5();//��ȡ���м������id5
				purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList6 == null){
					buy_num15 = 0;
				}else{
					length = purchaseList6.size();								
					for(int j = 0; j < length; j++){						
						buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}			
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;

			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			float tuiguangfei4 = this.findTgf(goods_id).get(0).getTuiguangfei4();
			float market_price1 = tuiguangfei4 * count;	
			System.out.println("tuiguangfei2:"+tuiguangfei4);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);		
			//ȱ��ĳһ������ʱ��,��ȱ��ĳ����������ʱ��
		}else if(list2 == null || list3 == null || list4 == null || list5 == null || list6==null || list7 == null){
			 if(list2 == null){
				 count2 = 0;
			 }else{
				 length1 = zpurchaseList.size();
					if(zpurchaseList.size()==0){
						count2 = 0;
					}
					for(i = 0; i < length1; i++){
						if(goods_id == zpurchaseList.get(i).getGoods_id()){
							count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			 
			 buy_num = 0;
			 
			 if(list3 == null){
				 count3 = 0;
			 }else{
				 length2 = zpurchaseList2.size();
					if(zpurchaseList2.size()==0){
						count3 = 0;
					}
					for(i = 0; i < length2; i++){
						if(goods_id == zpurchaseList2.get(i).getGoods_id()){
							count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			
			if(list3!=null){
				//list3�ļ������Ϊid3��id1�����¼
				int llength = list3.size();
				for(i = 0;i<llength;i++){
					id11 = list3.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
					System.out.println("id11:"+id11);
					//û�й����¼
					if(purchaseList2 == null){
						buy_num1 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
							System.out.println("buy_num1:"+buy_num1);
					}
				}
				}
			}
			
				
			if(list4 == null){
				count4 = 0;
			}else{
				length3 = zpurchaseList3.size();
				if(zpurchaseList3.size()==0){
					count4 = 0;
				}
				for(i = 0; i < length3; i++){
					if(goods_id == zpurchaseList3.get(i).getGoods_id()){
						count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list4!=null){
				//list4�ļ�����߹����¼
				int llength2 = list4.size();
				for(i = 0;i<llength2;i++){
					id11 = list4.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						 buy_num2 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num2:"+buy_num1);
				}								
					id2 = list4.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num3 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num3:"+buy_num2);
				}
				}
			}
			
			if(list5 == null){
				count5 = 0;
			}else{
				length4 = zpurchaseList4.size();
				if(zpurchaseList4.size()==0){
					count5 = 0;
				}
				for(i = 0; i < length4; i++){
					if(goods_id == zpurchaseList4.get(i).getGoods_id()){
						count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list5!=null){
				//list5�ļ�����߹����¼
				int llength3 = list5.size();
				for(i = 0;i<llength3;i++){
					id11 = list5.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num4 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list5.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num5 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list5.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num6 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}
			}
			
			
			if(list6 == null){
				count6 =0;
			}else{
				length5 = zpurchaseList5.size();
				if(zpurchaseList5.size()==0){
					count6 = 0;
				}
				for(i = 0; i < length5; i++){
					if(goods_id == zpurchaseList5.get(i).getGoods_id()){
						count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list6!=null){
				//list6�ļ�����߹����¼
				int llength4 = list6.size();
				for(i = 0;i<llength4;i++){
					id11 = list6.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num7 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list6.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num8 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list6.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num9 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					id4 = list6.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num10 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				
				}
			}
			
			
			if(list7==null){
				count7 = 0;
			}else{
				length6 = zpurchaseList6.size();
				if(zpurchaseList6.size()==0){
					count7 = 0;
				}
				for(i = 0; i < length6; i++){
					if(goods_id == zpurchaseList6.get(i).getGoods_id()){
						count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list7!=null){
				//list7�����߹����¼
				int llength5 = list7.size();
				for(i = 0;i<llength5;i++){
					id11 = list7.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num11 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list7.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num12 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list7.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num13 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					
					id4 = list7.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num14 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num4;
					
					id5 = list7.get(i).getId5();//��ȡ���м������id5
					purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList6 == null){
						buy_num15 = 0;
					}else{
						length = purchaseList6.size();								
						for(int j = 0; j < length; j++){						
							buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}		
			}
			
			
			count = count2 + count3 + count4 + count5 + count6 + count7;
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;

			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			float tuiguangfei4 = this.findTgf(goods_id).get(0).getTuiguangfei4();
			float market_price1 = tuiguangfei4 * count;	
			System.out.println("tuiguangfei1:"+tuiguangfei4);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);
			
		}
	}
	
	if(80 < this.findOneDeal(deal_num).get(0).getBuy_num() && this.findOneDeal(deal_num).get(0).getBuy_num() <= 100){
		
		//��ֱ������ʱ�򣬹�������Ϊ��ǰ�û���������
		if(list2 == null && list3 == null && list4 == null && list5 == null && list6 == null && list7 == null){			
			int count1 = this.findOneDeal(deal_num).get(0).getBuy_num();
			ticheng = this.findItem(goods_id).get(0).getTicheng() * count1;
			System.out.println("��� = :"+ticheng);
			
			//��ֱ������ʱ�򣬹�������Ϊ��ǰ��������
			market_price = 0;
			// ������������� �н���
			if(count2 > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * count1;
			}else{
				reward = 0;
			}
			
			admin = 0;
			username = this.findOneDeal(deal_num).get(0).getUsername();
		}
		//�����1��6������
		else if(list2 != null && list3 != null && list4 != null && list5 != null && list6!=null && list7 != null){
			length1 = zpurchaseList.size();
			if(zpurchaseList.size()==0){
				count2 = 0;
			}
			for(i = 0; i < length1; i++){
				if(goods_id == zpurchaseList.get(i).getGoods_id()){
					count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length2 = zpurchaseList2.size();
			if(zpurchaseList2.size()==0){
				count3 = 0;
			}
			for(i = 0; i < length2; i++){
				if(goods_id == zpurchaseList2.get(i).getGoods_id()){
					count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length3 = zpurchaseList3.size();
			if(zpurchaseList3.size()==0){
				count4 = 0;
			}
			for(i = 0; i < length3; i++){
				if(goods_id == zpurchaseList3.get(i).getGoods_id()){
					count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length4 = zpurchaseList4.size();
			if(zpurchaseList4.size()==0){
				count5 = 0;
			}
			for(i = 0; i < length4; i++){
				if(goods_id == zpurchaseList4.get(i).getGoods_id()){
					count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length5 = zpurchaseList5.size();
			if(zpurchaseList5.size()==0){
				count6 = 0;
			}
			for(i = 0; i < length5; i++){
				if(goods_id == zpurchaseList5.get(i).getGoods_id()){
					count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length6 = zpurchaseList6.size();
			if(zpurchaseList6.size()==0){
				count7 = 0;
			}
			for(i = 0; i < length6; i++){
				if(goods_id == zpurchaseList6.get(i).getGoods_id()){
					count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			count = count2 + count3 + count4 + count5 + count6 + count7;
			
			//�Ҽ�����߹����¼��list2 ��list7�����м������
			
			//list2�ļ������Ϊ0
			buy_num = 0;
			//list3�ļ������Ϊid3��id1�����¼
			int llength = list3.size();
			for(i = 0;i<llength;i++){
				id11 = list3.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
				System.out.println("id11:"+id11);
				//û�й����¼
				if(purchaseList2 == null){
					buy_num1 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
						System.out.println("buy_num1:"+buy_num1);
				}
			}
			}
			//list4�ļ�����߹����¼
			int llength2 = list4.size();
			for(i = 0;i<llength2;i++){
				id11 = list4.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					 buy_num2 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num2:"+buy_num1);
			}								
				id2 = list4.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num3 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num3:"+buy_num2);
			}
			}
			
			//list5�ļ�����߹����¼
			int llength3 = list5.size();
			for(i = 0;i<llength3;i++){
				id11 = list5.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num4 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list5.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num5 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list5.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num6 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}
			
			//list6�ļ�����߹����¼
			int llength4 = list6.size();
			for(i = 0;i<llength4;i++){
				id11 = list6.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num7 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list6.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num8 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list6.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num9 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				id4 = list6.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num10 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			
			}
			
			//list7�����߹����¼
			int llength5 = list7.size();
			for(i = 0;i<llength5;i++){
				id11 = list7.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num11 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list7.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num12 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list7.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num13 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				
				id4 = list7.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num14 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num4;
				
				id5 = list7.get(i).getId5();//��ȡ���м������id5
				purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList6 == null){
					buy_num15 = 0;
				}else{
					length = purchaseList6.size();								
					for(int j = 0; j < length; j++){						
						buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}			
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;

			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			
			
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			float tuiguangfei5 = this.findTgf(goods_id).get(0).getTuiguangfei5();
			float market_price1 = tuiguangfei5 * count;	
			System.out.println("tuiguangfei2:"+tuiguangfei5);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);		
			//ȱ��ĳһ������ʱ��,��ȱ��ĳ����������ʱ��
		}else if(list2 == null || list3 == null || list4 == null || list5 == null || list6==null || list7 == null){
			 if(list2 == null){
				 count2 = 0;
			 }else{
				 length1 = zpurchaseList.size();
					if(zpurchaseList.size()==0){
						count2 = 0;
					}
					for(i = 0; i < length1; i++){
						if(goods_id == zpurchaseList.get(i).getGoods_id()){
							count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			 
			 buy_num = 0;
			 
			 if(list3 == null){
				 count3 = 0;
			 }else{
				 length2 = zpurchaseList2.size();
					if(zpurchaseList2.size()==0){
						count3 = 0;
					}
					for(i = 0; i < length2; i++){
						if(goods_id == zpurchaseList2.get(i).getGoods_id()){
							count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			
			if(list3!=null){
				//list3�ļ������Ϊid3��id1�����¼
				int llength = list3.size();
				for(i = 0;i<llength;i++){
					id11 = list3.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
					System.out.println("id11:"+id11);
					//û�й����¼
					if(purchaseList2 == null){
						buy_num1 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
							System.out.println("buy_num1:"+buy_num1);
					}
				}
				} 
			}
			
				
			if(list4 == null){
				count4 = 0;
			}else{
				length3 = zpurchaseList3.size();
				if(zpurchaseList3.size()==0){
					count4 = 0;
				}
				for(i = 0; i < length3; i++){
					if(goods_id == zpurchaseList3.get(i).getGoods_id()){
						count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list4!=null){
				//list4�ļ�����߹����¼
				int llength2 = list4.size();
				for(i = 0;i<llength2;i++){
					id11 = list4.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						 buy_num2 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num2:"+buy_num1);
				}								
					id2 = list4.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num3 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num3:"+buy_num2);
				}
				}
			}
			
			
			if(list5 == null){
				count5 = 0;
			}else{
				length4 = zpurchaseList4.size();
				if(zpurchaseList4.size()==0){
					count5 = 0;
				}
				for(i = 0; i < length4; i++){
					if(goods_id == zpurchaseList4.get(i).getGoods_id()){
						count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list5!=null){
				//list5�ļ�����߹����¼
				int llength3 = list5.size();
				for(i = 0;i<llength3;i++){
					id11 = list5.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num4 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list5.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num5 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list5.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num6 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}	
			}
			
			
			if(list6 == null){
				count6 =0;
			}else{
				length5 = zpurchaseList5.size();
				if(zpurchaseList5.size()==0){
					count6 = 0;
				}
				for(i = 0; i < length5; i++){
					if(goods_id == zpurchaseList5.get(i).getGoods_id()){
						count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list6!=null){
				//list6�ļ�����߹����¼
				int llength4 = list6.size();
				for(i = 0;i<llength4;i++){
					id11 = list6.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num7 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list6.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num8 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list6.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num9 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					id4 = list6.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num10 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				
				}
			}
			
			
			if(list7==null){
				count7 = 0;
			}else{
				length6 = zpurchaseList6.size();
				if(zpurchaseList6.size()==0){
					count7 = 0;
				}
				for(i = 0; i < length6; i++){
					if(goods_id == zpurchaseList6.get(i).getGoods_id()){
						count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list7!=null){
				//list7�����߹����¼
				int llength5 = list7.size();
				for(i = 0;i<llength5;i++){
					id11 = list7.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num11 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list7.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num12 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list7.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num13 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					
					id4 = list7.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num14 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num4;
					
					id5 = list7.get(i).getId5();//��ȡ���м������id5
					purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList6 == null){
						buy_num15 = 0;
					}else{
						length = purchaseList6.size();								
						for(int j = 0; j < length; j++){						
							buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}		
			}
			
			
			count = count2 + count3 + count4 + count5 + count6 + count7;
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;

			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			float tuiguangfei5 = this.findTgf(goods_id).get(0).getTuiguangfei5();
			float market_price1 = tuiguangfei5 * count;	
			System.out.println("tuiguangfei1:"+tuiguangfei5);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);
			
		}
	}
	
	if(100 < this.findOneDeal(deal_num).get(0).getBuy_num()){
		
		//��ֱ������ʱ�򣬹�������Ϊ��ǰ�û���������
		if(list2 == null && list3 == null && list4 == null && list5 == null && list6 == null && list7 == null){			
			int count1 = this.findOneDeal(deal_num).get(0).getBuy_num();
			ticheng = this.findItem(goods_id).get(0).getTicheng() * count1;
			System.out.println("��� = :"+ticheng);
			
			//��ֱ������ʱ�򣬹�������Ϊ��ǰ��������
			market_price = 0;
			// ������������� �н���
			if(count2 > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * count1;
			}else{
				reward = 0;
			}
			
			admin = 0;
			username = this.findOneDeal(deal_num).get(0).getUsername();
		}
		//�����1��6������
		else if(list2 != null && list3 != null && list4 != null && list5 != null && list6!=null && list7 != null){
			length1 = zpurchaseList.size();
			if(zpurchaseList.size()==0){
				count2 = 0;
			}
			for(i = 0; i < length1; i++){
				if(goods_id == zpurchaseList.get(i).getGoods_id()){
					count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length2 = zpurchaseList2.size();
			if(zpurchaseList2.size()==0){
				count3 = 0;
			}
			for(i = 0; i < length2; i++){
				if(goods_id == zpurchaseList2.get(i).getGoods_id()){
					count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length3 = zpurchaseList3.size();
			if(zpurchaseList3.size()==0){
				count4 = 0;
			}
			for(i = 0; i < length3; i++){
				if(goods_id == zpurchaseList3.get(i).getGoods_id()){
					count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length4 = zpurchaseList4.size();
			if(zpurchaseList4.size()==0){
				count5 = 0;
			}
			for(i = 0; i < length4; i++){
				if(goods_id == zpurchaseList4.get(i).getGoods_id()){
					count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length5 = zpurchaseList5.size();
			if(zpurchaseList5.size()==0){
				count6 = 0;
			}
			for(i = 0; i < length5; i++){
				if(goods_id == zpurchaseList5.get(i).getGoods_id()){
					count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			length6 = zpurchaseList6.size();
			if(zpurchaseList6.size()==0){
				count7 = 0;
			}
			for(i = 0; i < length6; i++){
				if(goods_id == zpurchaseList6.get(i).getGoods_id()){
					count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
				}		
			}
			
			count = count2 + count3 + count4 + count5 + count6 + count7;
			
			//�Ҽ�����߹����¼��list2 ��list7�����м������
			
			//list2�ļ������Ϊ0
			buy_num = 0;
			//list3�ļ������Ϊid3��id1�����¼
			int llength = list3.size();
			for(i = 0;i<llength;i++){
				id11 = list3.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
				System.out.println("id11:"+id11);
				//û�й����¼
				if(purchaseList2 == null){
					buy_num1 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
						System.out.println("buy_num1:"+buy_num1);
				}
			}
			}
			//list4�ļ�����߹����¼
			int llength2 = list4.size();
			for(i = 0;i<llength2;i++){
				id11 = list4.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					 buy_num2 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num2:"+buy_num1);
			}								
				id2 = list4.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num3 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
					System.out.println("buy_num3:"+buy_num2);
			}
			}
			
			//list5�ļ�����߹����¼
			int llength3 = list5.size();
			for(i = 0;i<llength3;i++){
				id11 = list5.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num4 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list5.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num5 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list5.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num6 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}
			
			//list6�ļ�����߹����¼
			int llength4 = list6.size();
			for(i = 0;i<llength4;i++){
				id11 = list6.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num7 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list6.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num8 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list6.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num9 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				id4 = list6.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num10 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			
			}
			
			//list7�����߹����¼
			int llength5 = list7.size();
			for(i = 0;i<llength5;i++){
				id11 = list7.get(i).getId1();//��ȡ���м������id1
				purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
				//û�й����¼
				if(purchaseList2 == null){
					buy_num11 = 0;
				}else{
					length = purchaseList2.size();								
					for(int j = 0; j < length; j++){						
						buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num1;
				id2 = list7.get(i).getId2();//��ȡ���м������id2
				purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
				//û�й����¼
				if(purchaseList3 == null){
					buy_num12 = 0;
				}else{
					length = purchaseList3.size();								
					for(int j = 0; j < length; j++){						
						buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num2;
				id3 = list7.get(i).getId3();//��ȡ���м������id3
				purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList4 == null){
					buy_num13 = 0;
				}else{
					length = purchaseList4.size();								
					for(int j = 0; j < length; j++){						
						buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num3;
				
				id4 = list7.get(i).getId4();//��ȡ���м������id4
				purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList5 == null){
					buy_num14 = 0;
				}else{
					length = purchaseList5.size();								
					for(int j = 0; j < length; j++){						
						buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
				//buy_num += buy_num4;
				
				id5 = list7.get(i).getId5();//��ȡ���м������id5
				purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
				//û�й����¼
				if(purchaseList6 == null){
					buy_num15 = 0;
				}else{
					length = purchaseList6.size();								
					for(int j = 0; j < length; j++){						
						buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
				}
			}
			}			
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;

			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			float tuiguangfei6 = this.findTgf(goods_id).get(0).getTuiguangfei6();
			float market_price1 = tuiguangfei6 * count;	
			System.out.println("tuiguangfei2:"+tuiguangfei6);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);		
			//ȱ��ĳһ������ʱ��,��ȱ��ĳ����������ʱ��
		}else if(list2 == null || list3 == null || list4 == null || list5 == null || list6==null || list7 == null){
			 if(list2 == null){
				 count2 = 0;
			 }else{
				 length1 = zpurchaseList.size();
					if(zpurchaseList.size()==0){
						count2 = 0;
					}
					for(i = 0; i < length1; i++){
						if(goods_id == zpurchaseList.get(i).getGoods_id()){
							count2 += zpurchaseList.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ��id1��ֵ��id2�¼��ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			 
			 buy_num = 0;
			 
			 if(list3 == null){
				 count3 = 0;
			 }else{
				 length2 = zpurchaseList2.size();
					if(zpurchaseList2.size()==0){
						count3 = 0;
					}
					for(i = 0; i < length2; i++){
						if(goods_id == zpurchaseList2.get(i).getGoods_id()){
							count3 += zpurchaseList2.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id3�ĸò�Ʒ�Ĺ�������֮��
						}		
					}
			 }
			
			 if(list3!=null){
				//list3�ļ������Ϊid3��id1�����¼
					int llength = list3.size();
					for(i = 0;i<llength;i++){
						id11 = list3.get(i).getId1();//��ȡ���м������id1
						purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);
						System.out.println("id11:"+id11);
						//û�й����¼
						if(purchaseList2 == null){
							buy_num1 = 0;
						}else{
							length = purchaseList2.size();								
							for(int j = 0; j < length; j++){						
								buy_num1 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��
								System.out.println("buy_num1:"+buy_num1);
						}
					}
					}
			 }
			
				
			if(list4 == null){
				count4 = 0;
			}else{
				length3 = zpurchaseList3.size();
				if(zpurchaseList3.size()==0){
					count4 = 0;
				}
				for(i = 0; i < length3; i++){
					if(goods_id == zpurchaseList3.get(i).getGoods_id()){
						count4 += zpurchaseList3.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id4�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list4!=null){
				//list4�ļ�����߹����¼
				int llength2 = list4.size();
				for(i = 0;i<llength2;i++){
					id11 = list4.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						 buy_num2 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num2 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num2:"+buy_num1);
				}								
					id2 = list4.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num3 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num3 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
						System.out.println("buy_num3:"+buy_num2);
				}
				}	
			}
			
			
			if(list5 == null){
				count5 = 0;
			}else{
				length4 = zpurchaseList4.size();
				if(zpurchaseList4.size()==0){
					count5 = 0;
				}
				for(i = 0; i < length4; i++){
					if(goods_id == zpurchaseList4.get(i).getGoods_id()){
						count5 += zpurchaseList4.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id5�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list5!=null){
				//list5�ļ�����߹����¼
				int llength3 = list5.size();
				for(i = 0;i<llength3;i++){
					id11 = list5.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num4 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num4 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list5.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num5 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num5 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list5.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num6 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num6 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}
			}
			
			
			if(list6 == null){
				count6 =0;
			}else{
				length5 = zpurchaseList5.size();
				if(zpurchaseList5.size()==0){
					count6 = 0;
				}
				for(i = 0; i < length5; i++){
					if(goods_id == zpurchaseList5.get(i).getGoods_id()){
						count6 += zpurchaseList5.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id6�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list6!=null){
				//list6�ļ�����߹����¼
				int llength4 = list6.size();
				for(i = 0;i<llength4;i++){
					id11 = list6.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num7 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num7 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list6.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num8 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num8 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list6.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num9 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num9 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					id4 = list6.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid4�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num10 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num10 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				
				}
			}
			
			
			if(list7==null){
				count7 = 0;
			}else{
				length6 = zpurchaseList6.size();
				if(zpurchaseList6.size()==0){
					count7 = 0;
				}
				for(i = 0; i < length6; i++){
					if(goods_id == zpurchaseList6.get(i).getGoods_id()){
						count7 += zpurchaseList6.get(i).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼�id1��ֵ��id7�ĸò�Ʒ�Ĺ�������֮��
					}		
				}
			}
			if(list7!=null){
				//list7�����߹����¼
				int llength5 = list7.size();
				for(i = 0;i<llength5;i++){
					id11 = list7.get(i).getId1();//��ȡ���м������id1
					purchaseList2 = this.findDealByIdandGoodsId(id11, goods_id);//��ȡid11�Ĺ����¼									
					//û�й����¼
					if(purchaseList2 == null){
						buy_num11 = 0;
					}else{
						length = purchaseList2.size();								
						for(int j = 0; j < length; j++){						
							buy_num11 += purchaseList2.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num1;
					id2 = list7.get(i).getId2();//��ȡ���м������id2
					purchaseList3 = this.findDealByIdandGoodsId(id2, goods_id);//��ȡid22�Ĺ����¼
					//û�й����¼
					if(purchaseList3 == null){
						buy_num12 = 0;
					}else{
						length = purchaseList3.size();								
						for(int j = 0; j < length; j++){						
							buy_num12 += purchaseList3.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num2;
					id3 = list7.get(i).getId3();//��ȡ���м������id3
					purchaseList4 = this.findDealByIdandGoodsId(id3, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList4 == null){
						buy_num13 = 0;
					}else{
						length = purchaseList4.size();								
						for(int j = 0; j < length; j++){						
							buy_num13 += purchaseList4.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num3;
					
					id4 = list7.get(i).getId4();//��ȡ���м������id4
					purchaseList5 = this.findDealByIdandGoodsId(id4, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList5 == null){
						buy_num14 = 0;
					}else{
						length = purchaseList5.size();								
						for(int j = 0; j < length; j++){						
							buy_num14 += purchaseList5.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
					//buy_num += buy_num4;
					
					id5 = list7.get(i).getId5();//��ȡ���м������id5
					purchaseList6 = this.findDealByIdandGoodsId(id5, goods_id);//��ȡid3�Ĺ����¼
					//û�й����¼
					if(purchaseList6 == null){
						buy_num15 = 0;
					}else{
						length = purchaseList6.size();								
						for(int j = 0; j < length; j++){						
							buy_num15 += purchaseList6.get(j).getBuy_num();//��ȡ�ò�Ʒ����ֱ���¼��ĸò�Ʒ�Ĺ�������֮��						
					}
				}
				}
			}
					
			//ֱ�����߹�������֮��
			count = count2 + count3 + count4 + count5 + count6 + count7;
			//������߹�������֮��
			buy_num =  buy_num15 + buy_num14 + buy_num13 + buy_num12 + buy_num11 + buy_num10 + buy_num9 
					+ buy_num8 + buy_num7 + buy_num6 +buy_num5 + buy_num4 + buy_num3 + buy_num2 + buy_num1;	
			if(this.findOneDeal(deal_num).get(0).getBuy_num() + count > this.findItem(goods_id).get(0).getReward_num()){
				reward = this.findItem(goods_id).get(0).getReward() * (this.findOneDeal(deal_num).get(0).getBuy_num() + count);
			}else
				reward = 0;

			//����admin �����ǰid1Ϊ���ڵ㣬��û������ʱ�򣬼������������ߵĹ�������
			if(this.findRootUser(id1) != null){
				int buy_numAll = count + buy_num;//�������ߵĹ�������֮�ͣ�����������ߺ�ֱ������
				if(buy_numAll > this.findItem(goods_id).get(0).getAdmin_num()){
					admin = this.findItem(goods_id).get(0).getAdmin();
				}else{
					admin = 0;
				}
			}else
				admin = 0;
			
			username = this.findOneDeal(deal_num).get(0).getUsername();
			//�ò�Ʒ��������*�ò�Ʒ����ɷѵ��� �ò�Ʒ���������ǣ��ò�Ʒ�Լ���������+�ò�Ʒֱ�����߹���������
			ticheng = this.findItem(goods_id).get(0).getTicheng() * (count + this.findOneDeal(deal_num).get(0).getBuy_num());
			System.out.println("ticheng:"+ticheng);
			float tuiguangfei6 = this.findTgf(goods_id).get(0).getTuiguangfei6();
			float market_price1 = tuiguangfei6 * count;	
			System.out.println("tuiguangfei1:"+tuiguangfei6);
			System.out.println("count:"+count);
			System.out.println("market_price1:"+market_price1);
			float tuiguangfei = this.findTgf(goods_id).get(0).getTuiguangfei();
			System.out.println("tuiguangfei:"+tuiguangfei);
			float market_price2 = tuiguangfei * buy_num;
			System.out.println("market_price2:"+market_price2);
			System.out.println("buy_num:"+buy_num);
			market_price = market_price1 + market_price2;
			System.out.println("market_price:"+market_price);
			
		}
	}
	
			
		hql = "insert into user_income(id1, goods_id, ticheng, market_price, reward, admin,username,deal_num,avatar_url,goods_name) values(?,?,?,?,?,?,?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setString(0, id1);
		query.setInteger(1, goods_id);
		query.setFloat(2, ticheng);
		query.setFloat(3, market_price);
		query.setFloat(4, reward);
		query.setFloat(5, admin);
		query.setString(6, username);
		query.setString(7, deal_num);
		query.setString(8, avatar_url);
		query.setString(9, goods_name);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from user_income";
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Object> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "";
		hql = "SELECT u.id1, u.username,u.goods_id,u.ticheng,u.market_price,u.reward,u.admin,"
+"(SELECT avatar_url from user_info WHERE user_info.id1 = u.id1) as avatar_url,(SELECT goods_name from goods_info WHERE goods_info.goods_id = u.goods_id) as goods_name,"
+"(SELECT SUM(t.ticheng) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalticheng,"
+"(SELECT ifnull(totalticheng,0)) as total_ticheng,"+"(SELECT SUM(t.market_price) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalmarket_price,"
+"(SELECT ifnull(totalmarket_price,0)) as total_market_price,"+"(SELECT SUM(t.reward) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalreward,"
+"(SELECT ifnull(totalreward,0)) as total_reward,"+"(SELECT SUM(t.admin) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totaladmin,"
+"(SELECT ifnull(totaladmin,0)) as total_admin"+" from user_income as u";
		Query query = session.createSQLQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);    
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Object> list = query.list();
		return list; 
	
	}

	@SuppressWarnings("null")
	@Override
	public int findCount(UserIncome searchModel) {
		// TODO Auto-generated method stub
		
		
		String username = searchModel.getUsername();
		
		if(username ==null || username.equals("")){
			String hql = "select count(*) from user_income";
			@SuppressWarnings("unchecked")
			List<Long> list = this.getHibernateTemplate().find(hql);
			if(list.size()>0){
				return list.get(0).intValue();
			}
		}
		if( username!=null || !username.equals("")){
			String hql = "select count(*) from user_income where username = ?";
			@SuppressWarnings("unchecked")
			List<Long> list = this.getHibernateTemplate().find(hql,username);
			if(list.size()>0){
				return list.get(0).intValue();
			}
		}		
		return 0;
	}

	@Override
	public List<Object> findByPage(UserIncome searchModel, int begin, int pageSize) {
		// TODO Auto-generated method stub
		
		String username = searchModel.getUsername();
		if(username ==null || username.equals("")){
			return this.findByPage(begin, pageSize);
		}
		if(username !=null || !username.equals("")){
			Session session = this.getSession();
			String hql = "";
			hql = "SELECT u.id1, u.username,u.goods_id,u.ticheng,u.market_price,u.reward,u.admin,"
	+"(SELECT avatar_url from user_info WHERE user_info.id1 = u.id1) as avatar_url,(SELECT goods_name from goods_info WHERE goods_info.goods_id = u.goods_id) as goods_name,"
	+"(SELECT SUM(t.ticheng) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalticheng,"
	+"(SELECT ifnull(totalticheng,0)) as total_ticheng,"+"(SELECT SUM(t.market_price) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalmarket_price,"
	+"(SELECT ifnull(totalmarket_price,0)) as total_market_price,"+"(SELECT SUM(t.reward) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalreward,"
	+"(SELECT ifnull(totalreward,0)) as total_reward,"+"(SELECT SUM(t.admin) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totaladmin,"
	+"(SELECT ifnull(totaladmin,0)) as total_admin"+" from user_income as u"
	+" WHERE u.username = ?";
			Query query = session.createSQLQuery(hql);
			query.setString(0, username);
			query.setFirstResult(begin);
			query.setMaxResults(pageSize);    
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			List<Object> list = query.list();
			return list; 
		}
		return null;
	}
	//��ҳ��ѯ
	public Pager<UserIncome2> findByPage2(UserIncome searchModel, int pageNum, int pageSize) {

        // ���������
        Pager<UserIncome2> result = null;

        // ��Ų�ѯ����
        Map<String, Object> paramMap = new HashMap<String, Object>();
            
        String username = searchModel.getUsername();
        
        if( (username == null || username.equals(""))){
			return this.findByPage3(pageNum, pageSize);
        }
        if( (username !=null || !username.equals(""))){
        	String hql = "";
			hql = "SELECT u.id1, u.username,u.goods_id,u.ticheng,u.market_price,u.reward,u.admin,"
	+"(SELECT SUM(t.ticheng) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalticheng,"
	+"(SELECT ifnull(totalticheng,0)) as total_ticheng,"+"(SELECT SUM(t.market_price) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalmarket_price,"
	+"(SELECT ifnull(totalmarket_price,0)) as total_market_price,"+"(SELECT SUM(t.reward) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalreward,"
	+"(SELECT ifnull(totalreward,0)) as total_reward,"+"(SELECT SUM(t.admin) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totaladmin,"
	+"(SELECT ifnull(totaladmin,0)) as total_admin"+" from user_income as u"
	+" WHERE u.username =:username";
						
			paramMap.put("username", username);
			// ��ʼ����
			int fromIndex = pageSize * (pageNum - 1);

			// ������в�ѯ������Ʒ����
			List<UserIncome2> userincomeList = new ArrayList<UserIncome2>();

			Session session = null;

			// ��ȡ��Spring�йܵ�session
			
			session = this.getSession();
			
			// ��ȡquery����
			Query hqlQuery = session.createSQLQuery(hql.toString());

			// ���ò�ѯ����
			setQueryParams(hqlQuery, paramMap);

			// �ӵڼ�����¼��ʼ��ѯ
			hqlQuery.setFirstResult(fromIndex);

			// һ����ѯ��������¼
			hqlQuery.setMaxResults(pageSize);

			// ��ȡ��ѯ�Ľ��
			userincomeList = hqlQuery.list();

			// ��ȡ�ܼ�¼��
			
			int totalRecord = this.findCount(searchModel);

			// ��ȡ��ҳ��
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage++;
			}
			Gson gson = new Gson();
			System.out.println("userincomelist:"+gson.toJson(userincomeList));
			// ��װpager����
			result = new Pager<UserIncome2>(pageSize, pageNum, totalRecord, totalPage, userincomeList);
			System.out.println("dao�㷽�����н���");
			return result;
		}
        return result;
    }

    /**
     * ���ò�ѯ�Ĳ���
     * 
     * @param query
     * @param paramMap
     * @return
     */
    private Query setQueryParams(Query query, Map<String, Object> paramMap) {
        if (paramMap != null && !paramMap.isEmpty()) {
            for (Map.Entry<String, Object> param : paramMap.entrySet()) {
                query.setParameter(param.getKey(), param.getValue());
            }
        }
        return query;
    }

//	@Override
	public Pager<UserIncome2> findByPage3(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "";
		hql = "SELECT u.id1, u.username,u.goods_id,u.ticheng,u.market_price,u.reward,u.admin,"
				+"(SELECT avatar_url from user_info WHERE user_info.id1 = u.id1) as avatar_url,(SELECT goods_name from goods_info WHERE goods_info.goods_id = u.goods_id) as goods_name,"
				+"(SELECT SUM(t.ticheng) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalticheng,"
				+"(SELECT ifnull(totalticheng,0)) as total_ticheng,"+"(SELECT SUM(t.market_price) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalmarket_price,"
				+"(SELECT ifnull(totalmarket_price,0)) as total_market_price,"+"(SELECT SUM(t.reward) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalreward,"
				+"(SELECT ifnull(totalreward,0)) as total_reward,"+"(SELECT SUM(t.admin) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totaladmin,"
				+"(SELECT ifnull(totaladmin,0)) as total_admin"+" from user_income as u";
		//hql = "select * from user_income ";
		
		// ��ʼ����
		int fromIndex = pageSize * (pageNum - 1);

		// ������в�ѯ������Ʒ����
		List<UserIncome2> userincomeList = new ArrayList<UserIncome2>();

		Session session = null;

		// ��ȡ��Spring�йܵ�session
					
		session = this.getSession();
					
		// ��ȡquery����
		Query hqlQuery = session.createSQLQuery(hql);
		hqlQuery.setFirstResult(fromIndex);

		// һ����ѯ��������¼
		hqlQuery.setMaxResults(pageSize);

		// ��ȡ��ѯ�Ľ��
		userincomeList = hqlQuery.list();

		// ��ȡ�ܼ�¼��
		int totalRecord = this.findCount();

		// ��ȡ��ҳ��
		int totalPage = totalRecord / pageSize;
		if (totalRecord % pageSize != 0) {
			totalPage++;
		}
		
		Gson gson = new Gson();
		System.out.println("userincomelist:"+gson.toJson(userincomeList));
		// ��װpager����
		Pager<UserIncome2> result = new Pager<UserIncome2>(pageSize, pageNum, totalRecord, totalPage, userincomeList);
		System.out.println("result:"+result);
		return result;
	}

}


