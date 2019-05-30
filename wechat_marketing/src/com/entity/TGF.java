package com.entity;

public class TGF {
	
	private int goods_id;
	private int id;
	private int startNum;
	private float tuiguangfei;
	private int endNum;
	
	public TGF(){
		
	}

	public TGF(int goods_id,int id,int startNum,float tuiguangfei,int endNum){
		super();
		this.goods_id = goods_id;
		this.id = id;
		this.startNum = startNum;
		this.tuiguangfei = tuiguangfei;
		this.endNum = endNum;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public float getTuiguangfei() {
		return tuiguangfei;
	}

	public void setTuiguangfei(float tuiguangfei) {
		this.tuiguangfei = tuiguangfei;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	
	
}
