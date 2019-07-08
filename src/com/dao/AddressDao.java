package com.dao;

import java.util.List;

import com.entity.Address;

public interface AddressDao {
	
	List<Address> findOneAddress(String id1);
	
	String saveAddress(String id1,String region,String tel,String name,int first_choice,String address);

	String makeFisrt(int addressID, String id1, int first_choice);

	String update(int addressID, String region, String tel, String name, String address);

	String delete(int addressID);

	List<Address> findAddressById(String deal_num);
}
