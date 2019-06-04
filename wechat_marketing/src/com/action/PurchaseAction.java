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
	
	private InputStream inputStream; //������ֺ�struts.xml�ж�Ӧ������д��  
	  
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

	//�����������д��
    public List<Purchase> getLists() {
        return lists;
    }
    public void setLists(List<Purchase> lists) {
        this.lists = lists;
    }
	
    public String getState2(){
        System.out.println("��ͳ��ajax");
        HttpServletResponse response = ServletActionContext.getResponse();
        try {
            PrintWriter out = response.getWriter();
            out.println("{\"success\":\"true\",\"type\":\"succ\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
    public String saveDealNum() throws UnsupportedEncodingException{ //����id1��goods_id��ʱ��������ˮ��
    	System.out.println("action.saveDealNum����ִ��");
    	Purchase purchase = new Purchase();
    	Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//ʱ���ʽ��
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
			System.out.println("����deal_num�ɹ�");
			return "iSuccess";
		}else if(result.equals(com.service.impl.PurchaseServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("fail"  
                    .getBytes("UTF-8")); 
			System.out.println("����deal_numʧ��");
			return "iFail";
		}
		
		return null;
    }
    
	public String findDeal() throws UnsupportedEncodingException{//����id1����ѯid1��ȫ������
		System.out.println("action.findDeal����ִ��");
		String result = purchaseService.findDeal(id1);
		if(result == com.service.impl.PurchaseServiceImpl.SUCCESS){
			lists = purchaseService.findOneDeal(id1);
			System.out.println("lists"+lists);
			ActionContext.getContext().put("user_id", id1);
			return "findSuccess";
		}else if(result == com.service.impl.PurchaseServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("findfail"  
                    .getBytes("UTF-8")); 
			System.out.println("��ѯ����ʧ�ܣ�û�д˶���");
			return "findFail";
		}
		return null;
		
	}
	
	public String changeState() throws UnsupportedEncodingException{
		System.out.println("action.changeState����ִ��");
    	String result = purchaseService.changeState(state,deal_num);
    	if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){
    		inputStream = new ByteArrayInputStream("changeSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("����״̬���³ɹ�");
			return "changeSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("changeFail"  
                    .getBytes("UTF-8")); 
			System.out.println("����״̬����ʧ��");
			return "changeFail";
	}
    	return null;
	}
    
}
