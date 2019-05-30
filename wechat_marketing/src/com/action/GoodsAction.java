package com.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.GoodsInfo;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.GoodsService;

public class GoodsAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -123172674311046432L;

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
	
	private GoodsService goodsService;
	
	private List<GoodsInfo> lists = new ArrayList<GoodsInfo>();
	
	private InputStream inputStream; //这个名字和struts.xml中对应，不能写错  
	  
    public InputStream getInputStream() {  
        return inputStream;  
    }  
  
    public void setInputStream(InputStream inputStream) {  
        this.inputStream = inputStream;  
    }  

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	//这个方法必须写上
    public List<GoodsInfo> getLists() {
        return lists;
    }
    public void setLists(List<GoodsInfo> lists) {
        this.lists = lists;
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

	public String getState(){
        System.out.println("传统的ajax");
        HttpServletResponse response = ServletActionContext.getResponse();
        try {
            PrintWriter out = response.getWriter();
            out.println("{\"success\":\"true\",\"type\":\"succ\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String searchGoods() throws UnsupportedEncodingException{//搜索商品，返回商品列表
		
		System.out.println("action.searchGoods方法执行");
		String result = goodsService.searchGoods();
		if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
			lists = goodsService.findGoods();
			Gson gson = new Gson();
			System.out.println("lists:"+gson.toJson(lists));//查看json格式
			return "findSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("fail"  
                    .getBytes("UTF-8")); 
			return "findFail";
		}
		return null;
		
	}
	
    public String updateGoods() throws UnsupportedEncodingException{
    	
    	System.out.println("action.updateGoods方法执行");
    	String result = goodsService.updateGoods(goods_id,goods_name,price,ticheng,reward,reward_num,admin,admin_num,goods_image,describe_goods);
    	if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){
    		inputStream = new ByteArrayInputStream("updateSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("商品更新成功");
			return "updateSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("uodateFail"  
                    .getBytes("UTF-8")); 
			System.out.println("商品更新失败");
			return "updateFail";
	}
    	return null;	
    }
    
    public String deleteGoods() throws UnsupportedEncodingException{
    	
    	System.out.println("action.deleteGoods方法执行");
    	String result = goodsService.deleteGoods(goods_id);
		if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
			inputStream = new ByteArrayInputStream("deleteSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("商品删除成功");
			return "deleteSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("deleteFail"  
                    .getBytes("UTF-8")); 
			System.out.println("商品删除失败");
			return "deleteFail";
		}
		return null;		
    }
    
    public String addGoods() throws UnsupportedEncodingException{
    	System.out.println("action.addGoods方法执行");
    	String result = goodsService.addGoods(goods_name,price,ticheng,reward,reward_num,admin,admin_num,goods_image,describe_goods);
    	if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
			inputStream = new ByteArrayInputStream("addSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("商品添加成功");
			return "addSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("addFail"  
                    .getBytes("UTF-8")); 
			System.out.println("商品添加失败");
			return "addFail";
		}
		return null;	
    }
    
}
