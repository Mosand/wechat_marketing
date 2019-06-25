package com.entity;

/*
 * param����
 * id1:����ʶ����
 * region������
 * tel���绰����
 * name������
 * first_choice���Ƿ���Ϊ��ѡ
 * address����ϸ��ַ
 */

public class Address {
	
	private int addressID;
	private String id1;
	private String region;
	private String tel;
	private String name;
	private int first_choice;
	private String address;
	
	
	public Address(){
		
	}
	
	public Address(int addressID,String id1,String region,String tel,String name,int first_choice,String address){
		super();
		this.addressID = addressID;
		this.id1 = id1;
		this.region = region;
		this.tel = tel;
		this.name = name;
		this.first_choice = first_choice;
		this.address = address;
	}
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	public String getId1() {
		return id1;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFirst_choice() {
		return first_choice;
	}
	public void setFirst_choice(int first_choice) {
		this.first_choice = first_choice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
