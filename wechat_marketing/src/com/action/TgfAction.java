package com.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.GoodsInfo;
import com.service.TgfService;

public class TgfAction {

	private int id;
	private int goods_id;
	private float tuiguangfei1;
	private float tuiguangfei2;
	private float tuiguangfei3;
	private float tuiguangfei4;
	private float tuiguangfei5;
	private float tuiguangfei6;
	
	
	private TgfService tgfService;
	
	
	private InputStream inputStream;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getGoods_id() {
		return goods_id;
	}


	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}


	public float getTuiguangfei1() {
		return tuiguangfei1;
	}


	public void setTuiguangfei1(float tuiguangfei1) {
		this.tuiguangfei1 = tuiguangfei1;
	}


	public float getTuiguangfei2() {
		return tuiguangfei2;
	}


	public void setTuiguangfei2(float tuiguangfei2) {
		this.tuiguangfei2 = tuiguangfei2;
	}


	public float getTuiguangfei3() {
		return tuiguangfei3;
	}


	public void setTuiguangfei3(float tuiguangfei3) {
		this.tuiguangfei3 = tuiguangfei3;
	}


	public float getTuiguangfei4() {
		return tuiguangfei4;
	}


	public void setTuiguangfei4(float tuiguangfei4) {
		this.tuiguangfei4 = tuiguangfei4;
	}


	public float getTuiguangfei5() {
		return tuiguangfei5;
	}


	public void setTuiguangfei5(float tuiguangfei5) {
		this.tuiguangfei5 = tuiguangfei5;
	}


	public float getTuiguangfei6() {
		return tuiguangfei6;
	}


	public void setTuiguangfei6(float tuiguangfei6) {
		this.tuiguangfei6 = tuiguangfei6;
	}


	public TgfService getTgfService() {
		return tgfService;
	}


	public void setTgfService(TgfService tgfService) {
		this.tgfService = tgfService;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
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
	
	public String saveTgf() throws UnsupportedEncodingException{
		
		System.out.println("action.saveTgf方法执行");
		GoodsInfo goodsInfo = new GoodsInfo();
		goodsInfo.setGoods_id(goods_id);
		String result = tgfService.saveTgf(goods_id,tuiguangfei1,tuiguangfei2,tuiguangfei3,tuiguangfei4,tuiguangfei5,tuiguangfei6);
		if(result.equals(com.service.impl.TgfServiceImpl.SUCCESS)){//search success
			inputStream = new ByteArrayInputStream("saveSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("推广费添加成功");
			return "saveSuccess";
		}else if(result.equals(com.service.impl.TgfServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("saveFail"  
                    .getBytes("UTF-8")); 
			System.out.println("推广费添加失败");
			return "saveFail";
		}
		return null;	
	}
}
