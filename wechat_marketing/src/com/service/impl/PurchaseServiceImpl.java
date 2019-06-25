package com.service.impl;

import java.util.List;

import com.dao.PurchaseDao;
import com.entity.ExpenseIncome;
import com.entity.PageBean;
import com.entity.Pager;
import com.entity.Purchase;
import com.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService{
	
	private PurchaseDao purchaseDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";
	
	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	@Override
	public String saveDeal(String id1,String username,int goods_id,String goods_name,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num,int addressID) {
		// TODO Auto-generated method stub
		String result = purchaseDao.saveDeal(id1,username,goods_id,goods_name,buy_num,spend,time,state,avatar_url,goods_image,deal_num,addressID);
		if(result.equals("success")){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
		
	}
	
	@Override
	public String findDeal(String id1){
		
		List<Purchase> purchaselist = purchaseDao.findOneDeal(id1);
		if(purchaselist==null){
			return FAIL;
		}else
			return SUCCESS;
		
	}
	
	@Override
	public List<Purchase> findOneDeal(String id1) {
		// TODO Auto-generated method stub
		
		return purchaseDao.findOneDeal(id1);
	}
	
	@Override
	public String changeState(int state,String deal_num){
		
		String result = purchaseDao.change(state,deal_num);
		if(result == "success"){
			return SUCCESS;
		}else if(result.equals("fail")){
			return FAIL;
		}
			return null;
	}
	
	@Override
	/**
	 * 分页查询purchase的方法
	 */
	public PageBean<Purchase> findByPage(Integer currPage) {
		System.out.println("service层方法启动");
          PageBean<Purchase> pageBean = new PageBean<Purchase>();
        // 封装当前页数
          pageBean.setCurrPage(currPage);
        // 封装每页记录数
          int pageSize = 10;
          pageBean.setPageSize(pageSize);
        // 封装总记录数
        int totalRecord = purchaseDao.findCount();
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
        List<Purchase> list = purchaseDao.findByPage(begin, pageSize);
        pageBean.setList(list);
		return pageBean;
	}
	
	public PageBean<Purchase> findByPage(Purchase searchModel,Integer currPage) {
		
		System.out.println("service层方法启动");
		
        PageBean<Purchase> pageBean = new PageBean<Purchase>();
        // 封装当前页数
        pageBean.setCurrPage(currPage);
        // 封装每页记录数
        int pageSize = 10;
        pageBean.setPageSize(pageSize);
      // 封装总记录数
     
      int totalRecord = purchaseDao.findCount(searchModel);
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
      List<Purchase> list = purchaseDao.findByPage(searchModel,begin, pageSize);
      pageBean.setList(list);
	  return pageBean;
	}

	@Override
	public List<ExpenseIncome> getSumByMonth() {
		// TODO Auto-generated method stub
		if(purchaseDao.getSumByMonth() == null){
			return null;
		}
		return purchaseDao.getSumByMonth();
	}
	
	
	public Pager<Purchase> findByPage2(Purchase searchModel, int pageNum, int pageSize) {
		System.out.println("service层方法启动");
		
		Pager<Purchase> result = (Pager<Purchase>) purchaseDao.findByPage2(searchModel, pageNum, pageSize);
		
		return result;
	}
}
