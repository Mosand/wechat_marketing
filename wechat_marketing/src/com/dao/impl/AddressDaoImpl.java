package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.AddressDao;
import com.entity.Address;
import com.entity.UserInfo;

public class AddressDaoImpl extends HibernateDaoSupport implements AddressDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findOneAddress(String id1){//找到id1对应的所有地址返回给前端
		String hql="";
		if(id1==null||id1.equals(""))
			   return null;
		hql = "from address a where a.id1 = ? ";
		List<Address> addresslist=this.getHibernateTemplate().find(hql,id1);
		if(addresslist.size()!=0){
			System.out.println("查询成功");
			System.out.println("id1 is "+ id1);
			return addresslist;
		}else if(addresslist.size()==0){
			return null;
		}
		
		return null;
		
	}
	
	public List<UserInfo> findUserById1(String id1){
		
		String hql="";			   
		hql = "from user_info u where u.id1 = ?";
		@SuppressWarnings("unchecked")
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id1);
		if(userlist.size()!=0){
			System.out.println("id1查询成功");	
			System.out.println(userlist);
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		
		return null;
	}

	@Override
	public String saveAddress(String id1,String region,String tel,String name,int first_choice,String address){
		
		if(this.findUserById1(id1) == null){
			return "fail";
		}
		name = this.findUserById1(id1).get(0).getUsername();
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

	@Override
	public String makeFisrt(int addressID, String id1, int first_choice) {
		Session se =this.getSession();
		String hql="";
		first_choice = 1;
		String hql2 = "update address a set first_choice = ? where a.id1 = ?";
		Query query2= se.createSQLQuery(hql2);
		query2.setInteger(0, 0);
		query2.setString(1, id1);
		query2.executeUpdate();
		hql = "update address a set a.first_choice = ? where a.addressID = ? and a.id1 = ?";
		Query query= se.createSQLQuery(hql);
		query.setInteger(0, first_choice);
		query.setInteger(1, addressID);
		query.setString(2, id1);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}

	@Override
	public String update(int addressID, String region, String tel, String name, String address) {
		Session se =this.getSession();
		
		String hql = "update address a set a.region = ? ,a.tel = ?,a.name = ?,a.address = ? where a.addressID = ?";
		Query query= se.createSQLQuery(hql);
		query.setString(0, region);
		query.setString(1, tel);
		query.setString(2, name);
		query.setString(3, address);
		query.setInteger(4, addressID);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}

	@Override
	public String delete(int addressID) {
		Session se =this.getSession();
		String hql="";
		hql = "delete from address where addressID = ?";
		Query query= se.createSQLQuery(hql);
		query.setInteger(0, addressID);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
	
}
