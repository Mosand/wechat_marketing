package com.service.impl;

import com.dao.GoodsDao;
import com.dao.TgfDao;
import com.service.TgfService;

public class TgfServiceImpl implements TgfService{
	
	private TgfDao tgfDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";
	
	public void setTgfDao(TgfDao tgfDao) {
		this.tgfDao = tgfDao;
	}
	
	@Override
	public String saveTgf(int goods_id,int startNum,float tuiguangfei,int endNum){
		
		String result = tgfDao.save(goods_id,startNum,tuiguangfei,endNum);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}
}
