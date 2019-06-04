package com.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Address;
import com.entity.Purchase;
import com.opensymphony.xwork2.ActionContext;
import com.service.PurchaseService;

public class PurchaseAction {

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
	
	private PurchaseService purchaseService;
	private List<Purchase> lists = new ArrayList<Purchase>();
	
	private InputStream inputStream; //这个名字和struts.xml中对应，不能写错  
	  
    public InputStream getInputStream() {  
        return inputStream;  
    }  
  
    public void setInputStream(InputStream inputStream) {  
        this.inputStream = inputStream;  
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

	public PurchaseService getPurchaseService() {
		return purchaseService;
	}

	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	
	
	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	//这个方法必须写上
    public List<Purchase> getLists() {
        return lists;
    }
    public void setLists(List<Purchase> lists) {
        this.lists = lists;
    }
	
    public String getState2(){
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
	
    public String saveDealNum() throws UnsupportedEncodingException{ //根据id1和goods_id和时间生成流水号
    	System.out.println("action.saveDealNum方法执行");
    	Purchase purchase = new Purchase();
    	Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式化
		String time1=format.format(date);
		time = time1.toString();
		purchase.setTime(time);
    	Address address = new Address();
    	addressID = address.getId();
		String result = purchaseService.saveDeal(id1,goods_id,goods_name,buy_num,spend,time,state,avatar_url,goods_image,deal_num,addressID);
		if(result.equals(com.service.impl.PurchaseServiceImpl.SUCCESS)){
			 inputStream = new ByteArrayInputStream("success"  
	                    .getBytes("UTF-8"));
			 ActionContext.getContext().put("user_id", id1);
			System.out.println("插入deal_num成功");
			return "iSuccess";
		}else if(result.equals(com.service.impl.PurchaseServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("fail"  
                    .getBytes("UTF-8")); 
			System.out.println("插入deal_num失败");
			return "iFail";
		}
		
		return null;
    }
    
	public String findDeal() throws UnsupportedEncodingException{//根据id1来查询id1的全部订单
		System.out.println("action.findDeal方法执行");
		String result = purchaseService.findDeal(id1);
		if(result == com.service.impl.PurchaseServiceImpl.SUCCESS){
			lists = purchaseService.findOneDeal(id1);
			System.out.println("lists"+lists);
			ActionContext.getContext().put("user_id", id1);
			return "findSuccess";
		}else if(result == com.service.impl.PurchaseServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("findfail"  
                    .getBytes("UTF-8")); 
			System.out.println("查询订单失败，没有此订单");
			return "findFail";
		}
		return null;
		
	}
	
	public String changeState() throws UnsupportedEncodingException{
		System.out.println("action.changeState方法执行");
    	String result = purchaseService.changeState(state,deal_num);
    	if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){
    		inputStream = new ByteArrayInputStream("changeSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("订单状态更新成功");
			return "changeSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("changeFail"  
                    .getBytes("UTF-8")); 
			System.out.println("订单状态更新失败");
			return "changeFail";
	}
    	return null;
	}
    
}
