package com.entity;

public class UserIncome2 {
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
	private double totalticheng;
	private double total_ticheng;
	private double totalmarket_price;
	private double total_market_price;
	private double totalreward;
	private double total_reward;
	private double totaladmin;
	private double total_admin;
	
	public UserIncome2(){
		
	}
	
	public UserIncome2(int id,String id1,int goods_id,float ticheng,float market_price,float reward,float admin,String username,String deal_num,
			String avatar_url,String goods_name,double totalticheng,double total_ticheng,double totalmarket_price,double total_market_price,
			double totaladmin,double total_admin,double totalreward,double total_reward){
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
		this.totalticheng = totalticheng;
		this.total_ticheng = total_ticheng;
		this.totalmarket_price = totalmarket_price;
		this.total_market_price = total_market_price;
		this.totaladmin = totaladmin;
		this.total_admin = total_admin;
		this.totalreward = totalreward;
		this.total_reward = total_reward;
		
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

	public double getTotalticheng() {
		return totalticheng;
	}

	public void setTotalticheng(double totalticheng) {
		this.totalticheng = totalticheng;
	}

	public double getTotal_ticheng() {
		return total_ticheng;
	}

	public void setTotal_ticheng(double total_ticheng) {
		this.total_ticheng = total_ticheng;
	}

	public double getTotalmarket_price() {
		return totalmarket_price;
	}

	public void setTotalmarket_price(double totalmarket_price) {
		this.totalmarket_price = totalmarket_price;
	}

	public double getTotal_market_price() {
		return total_market_price;
	}

	public void setTotal_market_price(double total_market_price) {
		this.total_market_price = total_market_price;
	}

	public double getTotalreward() {
		return totalreward;
	}

	public void setTotalreward(double totalreward) {
		this.totalreward = totalreward;
	}

	public double getTotal_reward() {
		return total_reward;
	}

	public void setTotal_reward(double total_reward) {
		this.total_reward = total_reward;
	}

	public double getTotaladmin() {
		return totaladmin;
	}

	public void setTotaladmin(double totaladmin) {
		this.totaladmin = totaladmin;
	}

	public double getTotal_admin() {
		return total_admin;
	}

	public void setTotal_admin(double total_admin) {
		this.total_admin = total_admin;
	}

	
	
	
}
