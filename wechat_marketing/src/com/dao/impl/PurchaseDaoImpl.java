package com.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.PurchaseDao;
import com.entity.GoodsInfo;
import com.entity.ExpenseIncome;
import com.entity.Pager;
import com.entity.Purchase;
import com.entity.UserInfo;
import com.google.gson.Gson;

public class PurchaseDaoImpl extends HibernateDaoSupport implements PurchaseDao{

	@Override
	public String makeDeal(String id1,String time,String deal_num){
		
		time = time.trim();
		time = time.replace("-", "");
		time = time.replace(":", "");
		time = time.replace(" ", "");
		deal_num = id1 + time ;
		return deal_num;
	}
	
	public List<GoodsInfo> findPriceandGoodsImage(int goods_id){
		String hql="";
		hql = "from goods_info g where g.goods_id = ? ";
		List<GoodsInfo> goodslist=this.getHibernateTemplate().find(hql,goods_id);
		if(goodslist.size()!=0){
			System.out.println("查询成功");
			//System.out.println("单价 is "+ goodslist.get(0).getPrice());
			return goodslist;
		}else if(goodslist.size()==0){
			return null;
		}
		 
		return null;
	}
	
	public List<UserInfo> findUsernameandAvatar(String id1){
		
		String hql="";
		hql = "from user_info u where u.id1 = ? ";
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id1);
		if(userlist.size()!=0){
			System.out.println("查询成功");
			//System.out.println("单价 is "+ goodslist.get(0).getPrice());
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		 
		return null;
	}
	
	@Override
	public String saveDeal(String id1,String username,int goods_id,String goods_name,int buy_num,float spend,String time,int state,String avatar_url,String imgFormat,String deal_num,int addressID){
		
		deal_num = this.makeDeal(id1, time, deal_num);		
		Session se =this.getSession();
		String hql="";
		spend = this.findPriceandGoodsImage(goods_id).get(0).getPrice() * buy_num;
		username = this.findUsernameandAvatar(id1).get(0).getUsername();
		avatar_url = this.findUsernameandAvatar(id1).get(0).getAvatar_url();
		goods_name = this.findPriceandGoodsImage(goods_id).get(0).getGoods_name();
		imgFormat = this.findPriceandGoodsImage(goods_id).get(0).getImgFormat();
		hql = "insert into purchase(id1, username,goods_id, goods_name,buy_num, spend, time, state, avatar_url, imgFormat, deal_num,addressID) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setString(0, id1);
		query.setString(1, username);
		query.setInteger(2, goods_id);
		query.setString(3, goods_name);
		query.setInteger(4, buy_num);
		query.setFloat(5, spend);
		query.setString(6, time);
		query.setInteger(7, state);
		query.setString(8, avatar_url);
		query.setString(9, imgFormat);
		query.setString(10, deal_num);
		query.setInteger(11, addressID);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> findOneDeal(String id1){//一个顾客全部的购买记录
		String hql="";
		if(id1==null||id1.equals(""))
			   return null;
		hql = "from purchase p where p.id1 = ? ";
		List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1);
		if(purchaselist.size()!=0){
			System.out.println("查询成功");
			System.out.println("id1 is "+ id1);
			return purchaselist;
		}else if(purchaselist.size()==0){
			return null;
		}
		 
		return null;
		
	}
	
	@Override
	public String change(int state,String deal_num){//改变订单状态
		
		Session se =this.getSession();
		String hql="";
		state = 1;
		hql = "update purchase p set p.state = ? where p.deal_num = ?";
		Query query= se.createSQLQuery(hql);
		query.setInteger(0, state);
		query.setString(1, deal_num);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
	}
	
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from purchase";
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	@SuppressWarnings("null")
	@Override
	public int findCount(Purchase searchModel) {
		// TODO Auto-generated method stub
		
		String username = searchModel.getUsername();
		String time = searchModel.getTime();
		if((time == null || time.equals("")) && (username ==null || username.equals(""))){
			String hql = "select count(*) from purchase";
			@SuppressWarnings("unchecked")
			List<Long> list = this.getHibernateTemplate().find(hql);
			if(list.size()>0){
				return list.get(0).intValue();
			}
		}
		if((time == null || time.equals("")) && (username!=null || !username.equals(""))){
			String hql = "select count(*) from purchase where username = ?";
			@SuppressWarnings("unchecked")
			List<Long> list = this.getHibernateTemplate().find(hql,username);
			if(list.size()>0){
				return list.get(0).intValue();
			}
		}
		if((username == null || username.equals("")) && (time != null || !time.equals(""))){
			//Session session = this.getSession();
			String hql = "select count(*) from purchase where time like '"+time+"%' ";
			@SuppressWarnings("unchecked")
			List<Long> list = this.getHibernateTemplate().find(hql);
			if(list.size()>0){
				return list.get(0).intValue();
			}
		}
		if (time != null && !time.equals("") && username != null && !username.equals("")) {
			String hql = "select count(*) from purchase where time like '"+time+"%' "+"and username ='"+username+"'";
			@SuppressWarnings("unchecked")
			List<Long> list = this.getHibernateTemplate().find(hql);
			if(list.size()>0){
				return list.get(0).intValue();
			}
		}
				
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Purchase.class);
		// 查询分页数据
		criteria.addOrder(Order.desc("time"));
		List<Purchase> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		
		this.findCount();
		//System.out.println("list"+list.size());
		return list;
	}
	
	
	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public List<Purchase> findByPage(Purchase searchModel,int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Purchase.class);		
		String username = searchModel.getUsername();
		String time = searchModel.getTime();
		System.out.println("username: "+username);
		System.out.println("time: "+time);		
		if((time == null || time.equals("")) && (username ==null || username.equals(""))){
			return this.findByPage(begin, pageSize);
        }
		// 查询分页数据
		List<Purchase> list = new ArrayList<>();
		if((time == null || time.equals("")) && (username!=null || !username.equals(""))){
			criteria.add(Restrictions.eq("username", username));
			criteria.addOrder(Order.desc("time"));
			list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
			System.out.println("list: "+list.size());
		}
		if((username == null || username.equals("")) && (time != null || !time.equals(""))){
			criteria.add(Restrictions.like("time",time+"%"));
			criteria.addOrder(Order.desc("time"));
			list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
			System.out.println("list: "+list.size());
		}
		if (time != null && !time.equals("") && username != null && !username.equals("")) {
			criteria.add(Restrictions.like("time",time+"%"));
			criteria.add(Restrictions.eq("username", username));
			criteria.addOrder(Order.desc("time"));
			list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
			System.out.println("list: "+list.size());
		}
		
		return list;
	}

	@Override
	public List<ExpenseIncome> getSumByMonth() {
		// TODO Auto-generated method stub
		System.out.println("Dao层运行");
		Session session =this.getSession();
		String hql="";
		hql="SELECT CONCAT(YEAR(time),'-',MONTH(time)) as '月',YEAR(time) as YEAR,MONTH(time) as MONTH,IFNULL(b.income,0) as 'expense'" 
+" FROM(SELECT  STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d') as time UNION ALL "
+"SELECT  DATE_ADD(STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d'),INTERVAL 1 MONTH) as time UNION ALL "
+"SELECT  DATE_ADD(STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d'),INTERVAL 2 MONTH) as time UNION ALL "
+"SELECT  DATE_ADD(STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d'),INTERVAL 3 MONTH) as time UNION ALL "
+"SELECT  DATE_ADD(STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d'),INTERVAL 4 MONTH) as time UNION ALL "
+"SELECT  DATE_ADD(STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d'),INTERVAL 5 MONTH) as time UNION ALL "
+"SELECT  DATE_ADD(STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d'),INTERVAL 6 MONTH) as time UNION ALL "
+"SELECT  DATE_ADD(STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d'),INTERVAL 7 MONTH) as time UNION ALL "
+"SELECT  DATE_ADD(STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d'),INTERVAL 8 MONTH) as time UNION ALL "
+"SELECT  DATE_ADD(STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d'),INTERVAL 9 MONTH) as time UNION ALL "
+"SELECT  DATE_ADD(STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d'),INTERVAL 10 MONTH) as time UNION ALL "
+"SELECT  DATE_ADD(STR_TO_DATE(CONCAT(YEAR(CURDATE()),'-',1,'-',1) , '%Y-%m-%d'),INTERVAL 11 MONTH) as time) a "
+"LEFT JOIN(SELECT sum(spend) as income , CONCAT(YEAR(time),'-',MONTH(time)) as mon "
+"FROM purchase GROUP BY mon) b ON CONCAT(YEAR(time),'-',MONTH(time))=b.mon order by	year desc,month asc ";
		Query query = session.createSQLQuery(hql);
		List<ExpenseIncome> list = new ArrayList<>();
		list = query.list();
		Gson gson = new Gson();
		System.out.println("list:"+gson.toJson(list));
		return list;
	}
	
//	public PageBean<Purchase> findByPage(Purchase searchModel, int pageNum, int pageSize) {
//		System.out.println("dao层方法启动");
//		// 声明结果集
//		PageBean<Purchase> result = null;
//
//		// 存放查询参数
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//
//		String username = searchModel.getUsername();
//		String time = searchModel.getTime();
//		StringBuilder hql = new StringBuilder();
//		StringBuilder countHql = new StringBuilder();
//		if(time == null && username == null){
//			return (PageBean<Purchase>) this.findByPage(pageNum, pageSize);
//		}
//		if((time == null || time.equals("")) && (username!=null || !username.equals(""))){
//			hql = new StringBuilder("from purchase where username =:username ");
//			countHql = new StringBuilder("select count(*) from purchase where username =:username");			
//			paramMap.put("username", username);
//			// 起始索引
//			int fromIndex = pageSize * (pageNum - 1);
//
//			// 存放所有查询出的商品对象
//			List<Purchase> purchaseList = new ArrayList<Purchase>();
//
//			Session session = null;
//
//			// 获取被Spring托管的session
//			
//			session = this.getSession();
//			
//			// 获取query对象
//			Query hqlQuery = session.createQuery(hql.toString());
//			Query countHqlQuery = session.createQuery(countHql.toString());
//
//			// 设置查询参数
//			setQueryParams(hqlQuery, paramMap);
//			setQueryParams(countHqlQuery, paramMap);
//
//			// 从第几条记录开始查询
//			hqlQuery.setFirstResult(fromIndex);
//
//			// 一共查询多少条记录
//			hqlQuery.setMaxResults(pageSize);
//
//			// 获取查询的结果
//			purchaseList = hqlQuery.list();
//
//			// 获取总记录数
//			List<?> countResult = countHqlQuery.list();
//			int totalRecord = ((Number) countResult.get(0)).intValue();
//
//			// 获取总页数
//			int totalPage = totalRecord / pageSize;
//			if (totalRecord % pageSize != 0) {
//				totalPage++;
//			}
//
//			// 组装pager对象
//			result = new PageBean<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
//			System.out.println("dao层方法运行结束");
//			return result;
//			
//		}
//		if((username == null || username.equals("")) && (time != null || !time.equals(""))){
//			hql = new StringBuilder("from purchase where time like :time");
//			countHql = new StringBuilder("select count(*) from purchase where time like :time");
//			paramMap.put("time", time + "%");
//			// 起始索引
//			int fromIndex = pageSize * (pageNum - 1);
//
//			// 存放所有查询出的商品对象
//			List<Purchase> purchaseList = new ArrayList<Purchase>();
//
//			Session session = null;
//
//			// 获取被Spring托管的session
//			
//			session = this.getSession();
//			
//			// 获取query对象
//			Query hqlQuery = session.createQuery(hql.toString());
//			Query countHqlQuery = session.createQuery(countHql.toString());
//
//			// 设置查询参数
//			setQueryParams(hqlQuery, paramMap);
//			setQueryParams(countHqlQuery, paramMap);
//
//			// 从第几条记录开始查询
//			hqlQuery.setFirstResult(fromIndex);
//
//			// 一共查询多少条记录
//			hqlQuery.setMaxResults(pageSize);
//
//			// 获取查询的结果
//			purchaseList = hqlQuery.list();
//
//			// 获取总记录数
//			List<?> countResult = countHqlQuery.list();
//			int totalRecord = ((Number) countResult.get(0)).intValue();
//
//			// 获取总页数
//			int totalPage = totalRecord / pageSize;
//			if (totalRecord % pageSize != 0) {
//				totalPage++;
//			}
//
//			// 组装pager对象
//			result = new PageBean<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
//			System.out.println("dao层方法运行结束");
//			return result;
//		}
//		else if (time != null && !time.equals("") && username != null && !username.equals("")) {
//			hql = new StringBuilder("from purchase where time like :time and username =:username ");
//			countHql = new StringBuilder("select count(*) from purchase where time like :time and username =:username");
//			paramMap.put("time", time + "%");
//			paramMap.put("username",username);
//			// 起始索引
//			int fromIndex = pageSize * (pageNum - 1);
//
//			// 存放所有查询出的商品对象
//			List<Purchase> purchaseList = new ArrayList<Purchase>();
//
//			Session session = null;
//
//			// 获取被Spring托管的session
//			
//			session = this.getSession();
//			
//			// 获取query对象
//			Query hqlQuery = session.createQuery(hql.toString());
//			Query countHqlQuery = session.createQuery(countHql.toString());
//
//			// 设置查询参数
//			setQueryParams(hqlQuery, paramMap);
//			setQueryParams(countHqlQuery, paramMap);
//
//			// 从第几条记录开始查询
//			hqlQuery.setFirstResult(fromIndex);
//
//			// 一共查询多少条记录
//			hqlQuery.setMaxResults(pageSize);
//
//			// 获取查询的结果
//			purchaseList = hqlQuery.list();
//
//			// 获取总记录数
//			List<?> countResult = countHqlQuery.list();
//			int totalRecord = ((Number) countResult.get(0)).intValue();
//
//			// 获取总页数
//			int totalPage = totalRecord / pageSize;
//			if (totalRecord % pageSize != 0) {
//				totalPage++;
//			}
//
//			// 组装pager对象
//			result = new PageBean<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
//			System.out.println("dao层方法运行结束");
//			return result;
//		}
//		return result;
//
//		
//	}
//
//	/**
//	 * 设置查询的参数
//	 * 
//	 * @param query
//	 * @param paramMap
//	 * @return
//	 */
//	private Query setQueryParams(Query query, Map<String, Object> paramMap) {
//		if (paramMap != null && !paramMap.isEmpty()) {
//			for (Map.Entry<String, Object> param : paramMap.entrySet()) {
//				query.setParameter(param.getKey(), param.getValue());
//			}
//		}
//		return query;
//	}
	
//	@Override
//	public List<Purchase> findByPage(Purchase searchModel,int begin, int pageSize) {
//		// TODO Auto-generated method stub
//		DetachedCriteria criteria = DetachedCriteria.forClass(Purchase.class);
//		// 查询分页数据
//		// 存放查询参数
////		Map<String, Object> paramMap = new HashMap<String, Object>();
////
////		String username = searchModel.getUsername();
////		String time = searchModel.getTime();
////		StringBuilder hql = new StringBuilder();
////		StringBuilder countHql = new StringBuilder();
//		List<Purchase> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
//		return list;
	//}
	
	public Pager<Purchase> findByPage2(Purchase searchModel, int pageNum, int pageSize) {

        // 声明结果集
        Pager<Purchase> result = null;

        // 存放查询参数
        Map<String, Object> paramMap = new HashMap<String, Object>();
            
        String username = searchModel.getUsername();
        String time = searchModel.getTime();
        StringBuilder hql = new StringBuilder();
        StringBuilder countHql = new StringBuilder();
        if((time == null || time.equals("")) && (username ==null || username.equals(""))){
			return this.findByPage3(pageNum, pageSize);
        }
        if((time == null || time.equals("")) && (username !=null || !username.equals(""))){
			hql = new StringBuilder("from purchase where username =:username ");
			countHql = new StringBuilder("select count(*) from purchase where username =:username");			
			paramMap.put("username", username);
			// 起始索引
			int fromIndex = pageSize * (pageNum - 1);

			// 存放所有查询出的商品对象
			List<Purchase> purchaseList = new ArrayList<Purchase>();

			Session session = null;

			// 获取被Spring托管的session
			
			session = this.getSession();
			
			// 获取query对象
			Query hqlQuery = session.createQuery(hql.toString());
			Query countHqlQuery = session.createQuery(countHql.toString());

			// 设置查询参数
			setQueryParams(hqlQuery, paramMap);
			setQueryParams(countHqlQuery, paramMap);

			// 从第几条记录开始查询
			hqlQuery.setFirstResult(fromIndex);

			// 一共查询多少条记录
			hqlQuery.setMaxResults(pageSize);

			// 获取查询的结果
			purchaseList = hqlQuery.list();

			// 获取总记录数
			List<?> countResult = countHqlQuery.list();
			int totalRecord = ((Number) countResult.get(0)).intValue();

			// 获取总页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage++;
			}

			// 组装pager对象
			result = new Pager<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
			System.out.println("dao层方法运行结束");
			return result;
			
		}
		if((username == null || username.equals("")) && (time != null || !time.equals(""))){
			hql = new StringBuilder("from purchase where time like :time");
			countHql = new StringBuilder("select count(*) from purchase where time like :time");
			paramMap.put("time", time + "%");
			// 起始索引
			int fromIndex = pageSize * (pageNum - 1);

			// 存放所有查询出的商品对象
			List<Purchase> purchaseList = new ArrayList<Purchase>();

			Session session = null;

			// 获取被Spring托管的session
			
			session = this.getSession();
			
			// 获取query对象
			Query hqlQuery = session.createQuery(hql.toString());
			Query countHqlQuery = session.createQuery(countHql.toString());

			// 设置查询参数
			setQueryParams(hqlQuery, paramMap);
			setQueryParams(countHqlQuery, paramMap);

			// 从第几条记录开始查询
			hqlQuery.setFirstResult(fromIndex);

			// 一共查询多少条记录
			hqlQuery.setMaxResults(pageSize);

			// 获取查询的结果
			purchaseList = hqlQuery.list();

			// 获取总记录数
			List<?> countResult = countHqlQuery.list();
			int totalRecord = ((Number) countResult.get(0)).intValue();

			// 获取总页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage++;
			}

			// 组装pager对象
			result = new Pager<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
			System.out.println("dao层方法运行结束");
			return result;
		}
		else if (time != null && !time.equals("") && username != null && !username.equals("")) {
			hql = new StringBuilder("from purchase where time like :time and username =:username ");
			countHql = new StringBuilder("select count(*) from purchase where time like :time and username =:username");
			paramMap.put("time", time + "%");
			paramMap.put("username",username);
			// 起始索引
			int fromIndex = pageSize * (pageNum - 1);

			// 存放所有查询出的商品对象
			List<Purchase> purchaseList = new ArrayList<Purchase>();

			Session session = null;

			// 获取被Spring托管的session
			
			session = this.getSession();
			
			// 获取query对象
			Query hqlQuery = session.createQuery(hql.toString());
			Query countHqlQuery = session.createQuery(countHql.toString());

			// 设置查询参数
			setQueryParams(hqlQuery, paramMap);
			setQueryParams(countHqlQuery, paramMap);

			// 从第几条记录开始查询
			hqlQuery.setFirstResult(fromIndex);

			// 一共查询多少条记录
			hqlQuery.setMaxResults(pageSize);

			// 获取查询的结果
			purchaseList = hqlQuery.list();

			// 获取总记录数
			List<?> countResult = countHqlQuery.list();
			int totalRecord = ((Number) countResult.get(0)).intValue();

			// 获取总页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage++;
			}

			// 组装pager对象
			result = new Pager<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
			System.out.println("dao层方法运行结束");
			return result;
		}
		return result;
    }

    /**
     * 设置查询的参数
     * 
     * @param query
     * @param paramMap
     * @return
     */
    private Query setQueryParams(Query query, Map<String, Object> paramMap) {
        if (paramMap != null && !paramMap.isEmpty()) {
            for (Map.Entry<String, Object> param : paramMap.entrySet()) {
                query.setParameter(param.getKey(), param.getValue());
            }
        }
        return query;
    }

//	@Override
	public Pager<Purchase> findByPage3(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder();
		hql = new StringBuilder("from purchase");
		
		// 起始索引
		int fromIndex = pageSize * (pageNum - 1);

		// 存放所有查询出的商品对象
		List<Purchase> purchaseList = new ArrayList<Purchase>();

		Session session = null;

		// 获取被Spring托管的session
					
		session = this.getSession();
					
		// 获取query对象
		Query hqlQuery = session.createQuery(hql.toString());
		hqlQuery.setFirstResult(fromIndex);

		// 一共查询多少条记录
		hqlQuery.setMaxResults(pageSize);

		// 获取查询的结果
		purchaseList = hqlQuery.list();

		// 获取总记录数
		int totalRecord = this.findCount();

		// 获取总页数
		int totalPage = totalRecord / pageSize;
		if (totalRecord % pageSize != 0) {
			totalPage++;
		}

		// 组装pager对象
		Pager<Purchase> result = new Pager<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
		System.out.println("result:"+result);
		return result;
	}
	
	
}

