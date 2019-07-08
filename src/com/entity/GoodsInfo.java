package com.entity;

/*
 * param解释
 * goods_id:商品码
 * goods_name：商品名
 * price：单价
 * ticheng：提成费
 * reward：个人奖金
 * reward_num：达标线
 * admin：Admin奖金
 * admin_num：Admin达标线
 * goods_image:商品图片
 * describe_goods:商品描述
 */

public class GoodsInfo {
	
	private int goods_id;
	private String goods_name;
	private float price;
	private float ticheng;
	private float reward;
	private int reward_num;
	private float admin;
	private int admin_num;
	private String goods_image;
	private String describe_goods;
	private float market_price;
	private String imgFormat;
	
	public GoodsInfo(int goods_id,String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image,String describe_goods,String imgFormat){
		super();
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.price = price;
		this.ticheng = ticheng;
		this.reward = reward;
		this.reward_num = reward_num;
		this.admin = admin;
		this.admin_num = admin_num;
		this.goods_image = goods_image;
		this.describe_goods = describe_goods;
		this.imgFormat = imgFormat;
	}
	
	public GoodsInfo(int goods_id){
		super();
		this.goods_id=goods_id;
	}
	public GoodsInfo(){
	}
	
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getTicheng() {
		return ticheng;
	}
	public void setTicheng(float ticheng) {
		this.ticheng = ticheng;
	}
	
	public float getReward() {
		return reward;
	}
	public void setReward(float reward) {
		this.reward = reward;
	}
	
	public int getReward_num() {
		return reward_num;
	}
	public void setReward_num(int reward_num) {
		this.reward_num = reward_num;
	}
	
	public float getAdmin() {
		return admin;
	}
	public void setAdmin(float admin) {
		this.admin = admin;
	}
	
	public int getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}
	
	public String getGoods_image() {
		return goods_image;
	}
	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}

	public String getDescribe_goods() {
		return describe_goods;
	}

	public void setDescribe_goods(String describe_goods) {
		this.describe_goods = describe_goods;
	}

	public float getMarket_price() {
		return market_price;
	}

	public void setMarket_price(float market_price) {
		this.market_price = market_price;
	}

	public String getImgFormat() {
		return imgFormat;
	}

	public void setImgFormat(String imgFormat) {
		this.imgFormat = imgFormat;
	}


	
	
}
