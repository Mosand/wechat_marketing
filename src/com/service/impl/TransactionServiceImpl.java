package com.service.impl;

import java.util.List;

import com.dao.TransactionDao;
import com.entity.PageBean;
import com.entity.Pager;
import com.entity.Purchase;
import com.entity.TransactionRecord;
import com.entity.UserIncome;
import com.service.TransactionService;

public class TransactionServiceImpl implements TransactionService{

	
	private TransactionDao transactionDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";

	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}


	@Override
	public String saveTransaction(String id1, String username, int goods_id, float money, String serial_num, String time,String direction,String avatar_url,String goods_name) {
		// TODO Auto-generated method stub
		String result = transactionDao.saveTransaction(id1,username,goods_id,money,serial_num,time,direction,avatar_url,goods_name);
		if(result.equals("success")){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return FAIL;
	}
	
	@Override
	public PageBean<Object> findTransaction(Integer currPage) {
		System.out.println("service层方法启动");
        PageBean<Object> pageBean = new PageBean<Object>();
      // 封装当前页数
        pageBean.setCurrPage(currPage);
      // 封装每页记录数
        int pageSize = 10;
        pageBean.setPageSize(pageSize);
      // 封装总记录数
      int totalRecord = transactionDao.findCount();
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
      List<Object> list = transactionDao.findTransaction(begin, pageSize);
      pageBean.setList(list);
		return pageBean;
	}


	@Override
	public List<Object> getSumByMonth() {
		// TODO Auto-generated method stub
		if(transactionDao.getSumByMonth() == null){
			return null;
		}
		return transactionDao.getSumByMonth();
	}
	
	@Override
	public PageBean<Object> findByPage(TransactionRecord searchModel, Integer currPage) {
		// TODO Auto-generated method stub
		System.out.println("service层方法启动");
		
        PageBean<Object> pageBean = new PageBean<Object>();
        // 封装当前页数
        pageBean.setCurrPage(currPage);
        // 封装每页记录数
        int pageSize = 10;
        pageBean.setPageSize(pageSize);
      // 封装总记录数
        
        int totalRecord = transactionDao.findCount(searchModel);
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
        List<Object> list = transactionDao.findByPage(searchModel,begin, pageSize);
        pageBean.setList(list);
        return pageBean;
	}
	
	
	public Pager<TransactionRecord> findByPage2(TransactionRecord searchModel, int pageNum, int pageSize) {
		System.out.println("service层方法启动");
		
		Pager<TransactionRecord> result = (Pager<TransactionRecord>) transactionDao.findByPage2(searchModel, pageNum, pageSize);
		
		return result;
	}
	
}
