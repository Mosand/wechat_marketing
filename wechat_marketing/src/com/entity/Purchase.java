package com.entity;


/*
 * param解释
 * id1:个人识别码
 * goods_id：商品识别码
 * buy_num：购买数量
 * spend：价格
 * time：日期加时间
 * state：状态
 * avatar_url：顾客头像
 * admin_num：Admin达标线
 * goods_image:商品图片
 * deal_num：交易流水号
 */

public class Purchase {

	private String id1;
	private int goods_id;
	private String goods_name;
	private int buy_num;
	private float spend;
	private String time;
	private int state;
	private String avatar_url;
	private String goods_image;
	private String deal_num;
	private int addressID;
	
	public Purchase(){
		
	}
	
	public Purchase(String id1,int goods_id,String goods_name,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num){
		super();
		this.id1 = id1;
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.buy_num = buy_num;
		this.spend = spend;
		this.time = time;
		this.state = state;
		this.avatar_url = avatar_url;
		this.goods_image = goods_image;
		this.deal_num = deal_num;
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

	public int getBuy_num() {
		return buy_num;
	}

	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}

	public float getSpend() {
		return spend;
	}

	public void setSpend(float spend) {
		this.spend = spend;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getGoods_image() {
		return goods_image;
	}

	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}

	public String getDeal_num() {
		return deal_num;
	}

	public void setDeal_num(String deal_num) {
		this.deal_num = deal_num;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	
	
}
