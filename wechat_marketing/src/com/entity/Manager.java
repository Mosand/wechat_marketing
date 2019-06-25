package com.entity;

public class Manager {

	private String mananame;
	private String password;
	private int id;
	
	public Manager(){
		
	}
	
	public Manager(int id,String mananame,String password){
		super();
		this.id = id;
		this.mananame = mananame;
		this.password = password;
	}

	public String getMananame() {
		return mananame;
	}

	public void setMananame(String mananame) {
		this.mananame = mananame;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
