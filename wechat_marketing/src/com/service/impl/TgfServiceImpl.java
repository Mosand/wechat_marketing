package com.service.impl;

import java.util.List;

import com.dao.TgfDao;
import com.entity.TGF;
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
	
	@Override
	public String searchTgf(int goods_id) {
		List<TGF> tgflist = tgfDao.findTgf(goods_id);
		if(tgflist==null){
			return FAIL;
		}else{
			return SUCCESS;
		}
	}
	@Override
	public List<TGF> findTgf(int goods_id) {
		// TODO Auto-generated method stub
		return tgfDao.findTgf(goods_id);
	}
	
	@Override
	public String updateTgf(int goods_id,float tuiguangfei1,float tuiguangfei2,float tuiguangfei3,float tuiguangfei4,float tuiguangfei5,float tuiguangfei6) {
		String result = tgfDao.update(goods_id,tuiguangfei1,tuiguangfei2,tuiguangfei3,tuiguangfei4,tuiguangfei5,tuiguangfei6);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
		return null;
	}
}
