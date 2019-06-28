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
	public String update(int goods_id,String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image,
			String describe_goods,float market_price,String imgFormat){
		
		Session se =this.getSession();
		String hql="";
		String hql2 = "SELECT u.goods_name,t.goods_name,p.goods_name from user_income u,transaction_record t,purchase p WHERE u.goods_id = ? and t.goods_id=? and p.goods_id = ?";
		Query query2= se.createSQLQuery(hql2);
		query2.setInteger(0, goods_id);
		query2.setInteger(1, goods_id);
		query2.setInteger(2, goods_id);
		List<Object> list = query2.list();
		if(list.size()==0){
			hql =  "update goods_info g  set g.goods_name = ?,"
					+ " g.price = ? , g.ticheng = ?, g.reward = ?, g.reward_num = ?,g.admin = ?, g.admin_num = ?, g.goods_image = ?, g.describe_goods = ?,g.market_price = ?,g.imgFormat=? where g.goods_id = ?";
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
			query.setString(10, imgFormat);
			query.setInteger(11, goods_id);
			if(query.executeUpdate() != 0){
				System.out.println(" dao Success");		
				return "success";
			}else
				System.out.println(" dao Fail"+query.executeUpdate());
				System.out.println(" dao Fail");
				return "fail";
		}else if(list.size()!=0){
			hql = "update goods_info g, purchase p, transaction_record t,user_income u set g.goods_name = ?,p.goods_name=?,t.goods_name=?,u.goods_name=?,"
					+ " g.price = ? , g.ticheng = ?, g.reward = ?, g.reward_num = ?,g.admin = ?, g.admin_num = ?, g.goods_image = ?, g.describe_goods = ?,g.market_price = ?,g.imgFormat=? where g.goods_id = ?"
					+ " and t.goods_id=? and p.goods_id=? and u.goods_id=?";
			//这个sql语句需要重写，userincome等表有相同goods_name就要更新，没有就不更新
			Query query= se.createSQLQuery(hql);
			query.setString(0, goods_name);
			query.setString(1, goods_name);
			query.setString(2, goods_name);
			query.setString(3, goods_name);
			query.setFloat(4, price);
			query.setFloat(5, ticheng);
			query.setFloat(6, reward);
			query.setInteger(7, reward_num);
			query.setFloat(8, admin);
			query.setInteger(9, admin_num);
			query.setString(10, goods_image);
			query.setString(11, describe_goods);
			query.setFloat(12, market_price);
			query.setString(13, imgFormat);
			query.setInteger(14, goods_id);
			query.setInteger(15, goods_id);
			query.setInteger(16, goods_id);
			query.setInteger(17, goods_id);
			if(query.executeUpdate() != 0){
				System.out.println(" dao Success");		
				return "success";
			}else
				System.out.println(" dao Fail"+query.executeUpdate());
				System.out.println(" dao Fail");
				return "fail";
		}
		return "success";
		
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
	public String add(String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,
			String goods_image,String describe_goods,float market_price,String imgFormat){
		
		//goods_id = this.makeGoodsID(goods_id, goods_name, time);
		Session se =this.getSession();
		String hql="";
		hql = "insert into goods_info(goods_name,price,ticheng,reward,reward_num,admin,admin_num,goods_image,describe_goods,market_price,imgFormat) values (?,?,?,?,?,?,?,?,?,?,?)";
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
		query.setString(10, imgFormat);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
	
	@Override
	public String upload(int goods_id,String goods_image,String imgFormat){
		Session se =this.getSession();
		goods_id = this.findGoodsId();
		String hql="";
		hql = "update goods_info g set g.goods_image = ?,g.imgFormat=? where g.goods_id = ?";
		Query query= se.createSQLQuery(hql);
		query.setString(0, goods_image);
		query.setString(1, imgFormat);
		query.setInteger(2, goods_id);
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
