package com.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.service.TgfService;

public class TgfAction {

	private int id;
	private int goods_id;
	private int startNum;
	private float tuiguangfei;
	private int endNum;
	
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
		String result = tgfService.saveTgf(goods_id,startNum,tuiguangfei,endNum);
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
