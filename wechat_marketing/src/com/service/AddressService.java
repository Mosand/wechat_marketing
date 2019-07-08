package com.service;

import java.util.List;

import com.entity.Address;


public interface AddressService {
	
	String findAddress(String id1);
	
	List<Address> findOneAddress(String id1);
	
	String saveAddress(String id1,String region,String tel,String name,int first_choice,String address);

	String makeFirst(int id, String id1, int first_choice);

	String update(int id, String region, String tel, String name, String address);

	String delete(int addressID);

	String findAddress2(String deal_num);

	List<Address> findAddressById(String deal_num);
	
	
	//List<Address> findOneAddress2(String id1);//根据id1和是否首选，查询addressID
}
