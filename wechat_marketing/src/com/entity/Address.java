package com.entity;

/*
 * param解释
 * id1:个人识别码
 * region：地区
 * tel：电话号码
 * name：姓名
 * first_choice：是否设为首选
 * address：详细地址
 */

public class Address {
	
	private int id;
	private String id1;
	private String region;
	private String tel;
	private String name;
	private int first_choice;
	private String address;
	
	
	public Address(){
		
	}
	
	public Address(int id,String id1,String region,String tel,String name,int first_choice,String address){
		super();
		this.id = id;
		this.id1 = id1;
		this.region = region;
		this.tel = tel;
		this.name = name;
		this.first_choice = first_choice;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
