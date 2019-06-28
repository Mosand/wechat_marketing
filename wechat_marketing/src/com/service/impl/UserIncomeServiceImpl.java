package com.service.impl;

import java.util.List;

import com.dao.UserIncomeDao;
import com.entity.PageBean;
import com.entity.Pager;
import com.entity.Purchase;
import com.entity.UserIncome;
import com.entity.UserIncome2;
import com.service.UserIncomeService;

public class UserIncomeServiceImpl implements UserIncomeService{
	
	private UserIncomeDao userIncomeDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";
	
	public void setUserIncomeDao(UserIncomeDao userIncomeDao) {
		this.userIncomeDao = userIncomeDao;
	}
	
	@Override
	public String saveUserIncome(String id1, int goods_id, float ticheng, float market_price, float reward,float admin,
			String username ,String deal_num,String avatar_url,String goods_name) {
		String result = userIncomeDao.saveUserIncome(id1,goods_id,ticheng,market_price,reward,admin,username,deal_num,avatar_url,goods_name);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}

	@Override
	public PageBean<Object> findByPage(Integer currPage) {
		System.out.println("service层方法启动");
        PageBean<Object> pageBean = new PageBean<Object>();
      // 封装当前页数
        pageBean.setCurrPage(currPage);
      // 封装每页记录数
        int pageSize = 10;
        pageBean.setPageSize(pageSize);
      // 封装总记录数
      int totalRecord = userIncomeDao.findCount();
      System.out.println("totalRecord: "+totalRecord);
      pageBean.setTotalCount(totalRecord);
      // 封装页数
      int totalPage;
      if(totalRecord % pageSize == 0){
      	totalPage = totalRecord / pageSize;
      }else{
      	totalPage = totalRecord / pageSize + 1; 
      }
      pageBean.setTotalPage(totalPage);
      // 封装当前页记录
      int begin = (currPage - 1) * pageSize;
      List<Object> list = userIncomeDao.findByPage(begin, pageSize);
      pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Object> findByPage(UserIncome searchModel, Integer currPage) {
		// TODO Auto-generated method stub
		System.out.println("service层方法启动");
		
        PageBean<Object> pageBean = new PageBean<Object>();
        // 封装当前页数
        pageBean.setCurrPage(currPage);
        // 封装每页记录数
        int pageSize = 10;
        pageBean.setPageSize(pageSize);
      // 封装总记录数
        
        int totalRecord = userIncomeDao.findCount(searchModel);
        System.out.println("totalRecord: "+totalRecord);
        pageBean.setTotalCount(totalRecord);
        // 封装页数
        int totalPage;
        if(totalRecord % pageSize == 0){
        	totalPage = totalRecord / pageSize;
        }else{
        	totalPage = totalRecord / pageSize + 1; 
        }
        pageBean.setTotalPage(totalPage);
        // 封装当前页记录
        int begin = (currPage - 1) * pageSize;
        List<Object> list = userIncomeDao.findByPage(searchModel,begin, pageSize);
        pageBean.setList(list);
        return pageBean;
	}

	
	public Pager<Object> findByPage2(UserIncome searchModel, int pageNum, int pageSize) {
		System.out.println("service层方法启动");
		
		Pager<Object> result = (Pager<Object>) userIncomeDao.findByPage2(searchModel, pageNum, pageSize);
		
		return result;
	}
}
