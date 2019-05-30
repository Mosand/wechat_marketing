package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.GoodsDao;
import com.entity.GoodsInfo;

public class GoodsDaoImpl extends HibernateDaoSupport implements GoodsDao{
	
	
	
	@Override
	public List<GoodsInfo> findGoods() {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from goods_info";
		@SuppressWarnings("unchecked")
		List<GoodsInfo> goodslist=this.getHibernateTemplate().find(hql);
		if(goodslist.size()!=0){
			System.out.println("≤È—Ø≥…π¶");						
			return goodslist;
		}else if(goodslist.size()==0){
			return null;
		}
		
		return null;

	}
	
	@Override
	public String update(int goods_id,String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image,String describe_goods){
		
		Session se =this.getSession();
		String hql="";
		hql = "update goods_info g set g.goods_name = ? , g.price = ? , g.ticheng = ?, g.reward = ?, g.reward_num = ?,g.admin = ?, g.admin_num = ?, g.goods_image = ?, g.describe_goods = ? where g.goods_id = ?";
		Query query= se.createSQLQuery(hql);
		query.setString(0, goods_name);
		query.setFloat(1, price);
		query.setFloat(2, ticheng);
		query.setFloat(3, reward);
		query.setInteger(4, reward_num);
		query.setFloat(5, admin);
		query.setInteger(6, admin_num);
		query.setString(7, goods_image);
		query.setString(8, describe_goods);
		query.setInteger(9, goods_id);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
	
	@Override
	
	public String delete(int goods_id){
		Session se =this.getSession();
		String hql="";
		hql = "delete from goods_info where goods_id = ?";
		Query query= se.createSQLQuery(hql);
		query.setInteger(0, goods_id);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
	
	@Override
	public String add(String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image,String describe_goods){
		
		Session se =this.getSession();
		String hql="";
		hql = "insert into goods_info(goods_name,price,ticheng,reward,reward_num,admin,admin_num,goods_image,describe_goods) values (?,?,?,?,?,?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setString(0, goods_name);
		query.setFloat(1, price);
		query.setFloat(2, ticheng);
		query.setFloat(3, reward);
		query.setInteger(4, reward_num);
		query.setFloat(5, admin);
		query.setInteger(6, admin_num);
		query.setString(7, goods_image);
		query.setString(8, describe_goods);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
	
}
