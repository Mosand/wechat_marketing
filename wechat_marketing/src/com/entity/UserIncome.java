package com.entity;

public class UserIncome {
	
	private int id;
	private String id1;
	private int goods_id;
	private float ticheng;
	private float market_price;
	private float reward;
	private float admin;
	private String username;
	private String avatar_url;
	private String goods_name;
	private String deal_num;
	
	public UserIncome(){
		
	}
	
	public UserIncome(int id,String id1,int goods_id,float ticheng,float market_price,float reward,float admin,String username,String deal_num,String avatar_url,String goods_name){
		super();
		this.id = id;
		this.id1 = id1;
		this.goods_id = goods_id;
		this.ticheng = ticheng;
		this.market_price = market_price;
		this.reward = reward;
		this.admin = admin;
		this.username = username;
		this.deal_num = deal_num;
		this.avatar_url = avatar_url;
		this.goods_name = goods_name;
	}

	
	
	public String getDeal_num() {
		return deal_num;
	}

	public void setDeal_num(String deal_num) {
		this.deal_num = deal_num;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
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

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public float getTicheng() {
		return ticheng;
	}

	public void setTicheng(float ticheng) {
		this.ticheng = ticheng;
	}

	public float getMarket_price() {
		return market_price;
	}

	public void setMarket_price(float market_price) {
		this.market_price = market_price;
	}

	public float getReward() {
		return reward;
	}

	public void setReward(float reward) {
		this.reward = reward;
	}

	public float getAdmin() {
		return admin;
	}

	public void setAdmin(float admin) {
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
