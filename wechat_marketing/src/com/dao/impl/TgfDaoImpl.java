package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.TgfDao;
import com.entity.GoodsInfo;

public class TgfDaoImpl extends HibernateDaoSupport implements TgfDao{

	@Override
	public int findGoods_id() {
		// TODO Auto-generated method stub
		String hql = "";
		hql = "from goods_info order by goods_id DESC";
		@SuppressWarnings("unchecked")
		List<GoodsInfo> goodslist=this.getHibernateTemplate().find(hql);
		if(goodslist.size()!=0){
			System.out.println("≤È—Øgoods≥…π¶");						
			return goodslist.get(0).getGoods_id();
		}else if(goodslist.size()==0){
			return 0;
		}
		
		return 0;
	}
	@Override
	public String save(int goods_id, int startNum, float tuiguangfei, int endNum) {
		// TODO Auto-generated method stub
		goods_id = this.findGoods_id();
		Session se =this.getSession();
		String hql="";
		hql = "insert into tgf(goods_id,startNum,tuiguangfei,endNum) values(?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setInteger(0, goods_id);
		query.setInteger(1, startNum);
		query.setFloat(2, tuiguangfei);
		query.setInteger(3, endNum);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
}
