package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.TgfDao;
import com.entity.GoodsInfo;
import com.entity.TGF;

public class TgfDaoImpl extends HibernateDaoSupport implements TgfDao{

	@Override
	public int findGoods_id() {
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
	@Override
	public String save(int goods_id,float tuiguangfei1,float tuiguangfei2,float tuiguangfei3,float tuiguangfei4,float tuiguangfei5,float tuiguangfei6) {
		// TODO Auto-generated method stub
		goods_id = this.findGoods_id();
		Session se =this.getSession();
		String hql="";
		hql = "insert into tgf(goods_id,tuiguangfei1,tuiguangfei2,tuiguangfei3,tuiguangfei4,tuiguangfei5,tuiguangfei6) values(?,?,?,?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setInteger(0, goods_id);
		query.setFloat(1, tuiguangfei1);
		query.setFloat(2, tuiguangfei2);
		query.setFloat(3, tuiguangfei3);
		query.setFloat(4, tuiguangfei4);
		query.setFloat(5, tuiguangfei5);
		query.setFloat(6, tuiguangfei6);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
	
	@Override
	public List<TGF> findTgf(int goods_id){
		
		String hql = "";
		hql = "from tgf where goods_id = ? ";
		@SuppressWarnings("unchecked")
		List<TGF> tgflist=this.getHibernateTemplate().find(hql,goods_id);
		if(tgflist.size()!=0){
			System.out.println("查询tgf成功");						
			return tgflist;
		}else if(tgflist.size()==0){
			return null;
		}
		
		return null;
	}
	@Override
	public String update(int goods_id,float tuiguangfei1, float tuiguangfei2, float tuiguangfei3, float tuiguangfei4, float tuiguangfei5, float tuiguangfei6) {
		// TODO Auto-generated method stub
		Session se = this.getSession();
		String hql = "";
		hql = "update tgf t set t.tuiguangfei1 = ? , t.tuiguangfei2 = ? , t.tuiguangfei3 = ?, t.tuiguangfei4 = ?, t.tuiguangfei5 = ?, t.tuiguangfei6 = ? where t.goods_id = ?";
		Query query= se.createSQLQuery(hql);
		query.setFloat(0, tuiguangfei1);
		query.setFloat(1, tuiguangfei2);
		query.setFloat(2, tuiguangfei3);
		query.setFloat(3, tuiguangfei4);
		query.setFloat(4, tuiguangfei5);
		query.setFloat(5, tuiguangfei6);
		query.setInteger(6, goods_id);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
}
