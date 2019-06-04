package com.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.GoodsInfo;
import com.google.gson.Gson;
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
	private float market_price;
	
	private GoodsService goodsService;
	
	private List<GoodsInfo> lists = new ArrayList<GoodsInfo>();
	
	private InputStream inputStream; //这个名字和struts.xml中对应，不能写错  
	
	//对应表单的file1  <input type="file" name="file1"/>
	private File file1;
	//当前上传的文件名
	private String file1FileName;
	//文件类型(MIME)
	private String file1ContentType;
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	   }		
	
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
	
	
	public float getMarket_price() {
		return market_price;
	}
	public void setMarket_price(float market_price) {
		this.market_price = market_price;
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
    	String result = goodsService.updateGoods(goods_id,goods_name,price,ticheng,reward,reward_num,admin,admin_num,goods_image,describe_goods,market_price);
    	if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){
    		inputStream = new ByteArrayInputStream("updateSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("商品更新成功");
			return "updateSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("updateFail"  
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
		//goodsInfo.setGoods_id(goods_id);
    	String result = goodsService.addGoods(goods_name,price,ticheng,reward,reward_num,admin,admin_num,goods_image,describe_goods,market_price);
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
    
    
    public String uploadGoodsImage() throws IOException{
    	
    	System.out.println("action.uploadGoodsImage方法执行");
    	String path="/image";
	    String target=ServletActionContext.getServletContext().getRealPath(path);
	    
	    if(file1FileName != null){
	    	File destFile=new File(target,file1FileName);
		    System.out.println("destFile:"+destFile);
		    //把上传的文件，拷贝到目标文件中
		    FileUtils.copyFile(file1, destFile);
		    GoodsInfo goodsInfo = new GoodsInfo();
		    goods_image=destFile.getPath();
			System.out.println("goods_url:"+goods_image);
			goodsInfo.setGoods_image(goods_image);
			String result=goodsService.upload(goods_id,goods_image);
			if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
				inputStream = new ByteArrayInputStream("uploadSuccess"  
	                    .getBytes("UTF-8")); 
				System.out.println("商品图片上传成功");
				return "uploadSuccess";
			}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
				inputStream = new ByteArrayInputStream("uploadaddFail"  
	                    .getBytes("UTF-8")); 
				System.out.println("商品图片上传失败");
				return "uploadFail";
			}	
	    }
		return null;
    }
    
    public String searchItem() throws UnsupportedEncodingException{
    	
    	System.out.println("action.searchItem方法执行");
		String result = goodsService.searchItem(goods_id);
		if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
			lists = goodsService.findItem(goods_id);
			Gson gson = new Gson();
			System.out.println("lists:"+gson.toJson(lists));//查看json格式
			return "findItemSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("fail"  
                    .getBytes("UTF-8")); 
			return "findItemFail";
		}
		return null;
    }
}
