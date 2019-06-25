package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.ManagerDao;
import com.entity.Manager;

public class ManagerDaoImpl extends HibernateDaoSupport implements ManagerDao{

	@Override
	public List<Manager> findByName(String mananame,String password) {
		String hql1="";
		if(mananame == null|| mananame.equals(""))
			   return null;
		hql1="from manager where mananame = ? and password = ?";
	    @SuppressWarnings("unchecked")
		List<Manager> manager=this.getHibernateTemplate().find(hql1,mananame,password);
	    
	    return manager;
	}
}
