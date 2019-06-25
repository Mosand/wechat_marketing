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
			System.out.println("查询成功");						
			return goodslist;
		}else if(goodslist.size()==0){
			return null;
		}
		
		return null;

	}
	
	@Override
	public String update(int goods_id,String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image,String describe_goods,float market_price){
		
		Session se =this.getSession();
		String hql="";
		hql = "update goods_info g set g.goods_name = ? , g.price = ? , g.ticheng = ?, g.reward = ?, g.reward_num = ?,g.admin = ?, g.admin_num = ?, g.goods_image = ?, g.describe_goods = ?,g.market_price = ? where g.goods_id = ?";
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
		query.setFloat(9, market_price);
		query.setInteger(10, goods_id);
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
	
//	@Override
//	public String makeGoodsID(String goods_id, String goods_name,String time){
//		
//		goods_id = goods_name + time;
//		return goods_id;
//	}
	
	@Override
	public String add(String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image,String describe_goods,float market_price){
		
		//goods_id = this.makeGoodsID(goods_id, goods_name, time);
		Session se =this.getSession();
		String hql="";
		hql = "insert into goods_info(goods_name,price,ticheng,reward,reward_num,admin,admin_num,goods_image,describe_goods,market_price) values (?,?,?,?,?,?,?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		//query.setString(0, goods_id);
		query.setString(0, goods_name);
		query.setFloat(1, price);
		query.setFloat(2, ticheng);
		query.setFloat(3, reward);
		query.setInteger(4, reward_num);
		query.setFloat(5, admin);
		query.setInteger(6, admin_num);
		query.setString(7, goods_image);
		query.setString(8, describe_goods);
		query.setFloat(9,market_price);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
	
	@Override
	public String upload(int goods_id,String goods_image){
		Session se =this.getSession();
		goods_id = this.findGoodsId();
		String hql="";
		hql = "update goods_info g set g.goods_image = ? where g.goods_id = ?";
		Query query= se.createSQLQuery(hql);
		query.setString(0, goods_image);
		query.setInteger(1, goods_id);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
	
	@Override
	public List<GoodsInfo> findItem(int goods_id) {
		// TODO Auto-generated method stub
		String hql="";			   
		hql = "from goods_info where goods_id = ?";
		@SuppressWarnings("unchecked")
		List<GoodsInfo> goodslist=this.getHibernateTemplate().find(hql,goods_id);
		if(goodslist.size()!=0){
			//System.out.println("查询成功");						
			return goodslist;
		}else if(goodslist.size()==0){
			return null;
		}
		
		return null;

	}
	
	@Override
	public int findGoodsId() {
		// TODO Auto-generated method stub
		String hql = "";
		hql = "from goods_info order by goods_id desc ";
		@SuppressWarnings("unchecked")
		List<GoodsInfo> goodslist=this.getHibernateTemplate().find(hql);
		if(goodslist.size()!=0){
			System.out.println("查询goods成功");						
			return goodslist.get(0).getGoods_id();
		}else if(goodslist.size()==0){
			return 0;
		}
		
		return 0;
	}
}
