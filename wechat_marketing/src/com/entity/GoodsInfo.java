package com.entity;

/*
 * param����
 * goods_id:��Ʒ��
 * goods_name����Ʒ��
 * price������
 * ticheng����ɷ�
 * reward�����˽���
 * reward_num�������
 * admin��Admin����
 * admin_num��Admin�����
 * goods_image:��ƷͼƬ
 */

public class GoodsInfo {
	
	private String goods_id;
	private String goods_name;
	private float price;
	private float ticheng;
	private float reward;
	private int reward_num;
	private float admin;
	private int admin_num;
	private String goods_image;
	
	public GoodsInfo(String goods_id,String goods_name,float price,float ticheng,float reward,int reward_num,float admin,int admin_num,String goods_image){
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
	}
	
	public GoodsInfo(String goods_id){
		super();
		this.goods_id=goods_id;
	}
	public GoodsInfo(){
	}
	
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
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
	
	
}