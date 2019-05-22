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
import com.opensymphony.xwork2.ActionSupport;
import com.service.GoodsService;

public class GoodsAction extends ActionSupport{
	//private String goods_id;
	private GoodsService goodsService;
	
	private List<GoodsInfo> lists = new ArrayList<GoodsInfo>();
	
	private InputStream inputStream; //这个名字和struts.xml中对应，不能写错  
	  
    public InputStream getInputStream() {  
        return inputStream;  
    }  
  
    public void setInputStream(InputStream inputStream) {  
        this.inputStream = inputStream;  
    }  

//	public String getGoods_id() {
//		return goods_id;
//	}
//
//	public void setGoods_id(String goods_id) {
//		this.goods_id = goods_id;
//	}

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
	
}
