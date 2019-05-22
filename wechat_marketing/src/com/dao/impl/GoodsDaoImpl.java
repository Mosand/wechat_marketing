package com.dao.impl;

import java.util.List;

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
	

}
