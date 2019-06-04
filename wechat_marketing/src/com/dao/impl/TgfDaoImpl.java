package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.TgfDao;
import com.entity.GoodsInfo;

public class TgfDaoImpl extends HibernateDaoSupport implements TgfDao{

	@Override
	public int findGoods_id(int goods_id) {
		// TODO Auto-generated method stub
		String hql = "";
		hql = "from goods_info where goods_id =? ";
		@SuppressWarnings("unchecked")
		List<GoodsInfo> goodslist=this.getHibernateTemplate().find(hql,goods_id);
		if(goodslist.size()!=0){
			System.out.println("≤È—Øgoods≥…π¶");						
			return goodslist.get(0).getGoods_id();
		}else if(goodslist.size()==0){
			return 0;
		}
		
		return 0;
	}
	@Override
	public String save(int goods_id,float tuiguangfei1,float tuiguangfei2,float tuiguangfei3,float tuiguangfei4,float tuiguangfei5,float tuiguangfei6) {
		// TODO Auto-generated method stub
		goods_id = this.findGoods_id(goods_id);
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
}
