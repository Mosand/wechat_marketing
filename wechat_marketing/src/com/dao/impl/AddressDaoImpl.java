package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.AddressDao;
import com.entity.Address;

public class AddressDaoImpl extends HibernateDaoSupport implements AddressDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findOneAddress(String id1){
		String hql="";
		if(id1==null||id1.equals(""))
			   return null;
		hql = "from address a where a.id1 = ? ";
		List<Address> addresslist=this.getHibernateTemplate().find(hql,id1);
		if(addresslist.size()!=0){
			System.out.println("≤È—Ø≥…π¶");
			System.out.println("id1 is "+ id1);
			return addresslist;
		}else if(addresslist.size()==0){
			return null;
		}
		
		return null;
		
	}
	
	@Override
	public String saveAddress(String id1,String region,String tel,String name,int first_choice,String address){
				
		Session se =this.getSession();
		String hql="";
		
		hql = "insert into address(id1, region, tel, name, first_choice, address) values(?,?,?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setString(0, id1);
		query.setString(1, region);
		query.setString(2, tel);
		query.setString(3, name);
		query.setInteger(4, first_choice);
		query.setString(5, address);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
		
	}
	
}
