package com.dao;

import java.util.List;

import com.entity.ExpenseIncome;
import com.entity.Pager;
import com.entity.Purchase;

/**
 * ���ݲ�ѯ��������ѯ��Ʒ��ҳ��Ϣ
 * 
 * @param searchModel
 *            ��װ��ѯ����
 * @param pageNum
 *            ��ѯ�ڼ�ҳ����
 * @param pageSize
 *            ÿҳ��ʾ��������¼
 * @return ��ѯ���
 */

public interface PurchaseDao {

	
	String makeDeal(String id1,String time,String deal_num);
	String saveDeal(String id1,String username,int goods_id,String goods_name,int buy_num,float spend,String time,int state,String avatar_url,String imgFormat,String deal_num,int addressID);
	
	List<Purchase> findOneDeal(String id1);
	String change(int state, String deal_num);
	
	
	List<Purchase> findByPage(int begin, int pageSize);
	
	int findCount();
	
	List<Purchase> findByPage(Purchase searchModel,int begin, int pageSize);
	
	int findCount(Purchase searchModel);
	
	List<ExpenseIncome> getSumByMonth();
	
	Pager<Purchase> findByPage2(Purchase searchModel, int pageNum, int pageSize);

}
