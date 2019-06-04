package com.service.impl;

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
	public String saveTgf(int goods_id,float tuiguangfei1,float tuiguangfei2,float tuiguangfei3,float tuiguangfei4,float tuiguangfei5,float tuiguangfei6){
		
		String result = tgfDao.save(goods_id,tuiguangfei1,tuiguangfei2,tuiguangfei3,tuiguangfei4,tuiguangfei5,tuiguangfei6);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}
}
