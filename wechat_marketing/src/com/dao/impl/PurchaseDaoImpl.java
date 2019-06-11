package com.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.PurchaseDao;
import com.entity.Purchase;

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
	
	@Override
	public String saveDeal(String id1,String username,int goods_id,String goods_name,int buy_num,float spend,String time,int state,String avatar_url,String goods_image,String deal_num,int addressID){
		
		deal_num = this.makeDeal(id1, time, deal_num);		
		Session se =this.getSession();
		String hql="";
		
		hql = "insert into purchase(id1, username,goods_id, goods_name,buy_num, spend, time, state, avatar_url, goods_image, deal_num,addressID) values(?,?,?,?,?,?,?,?,?,?,?,?)";
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
		query.setString(9, goods_image);
		query.setString(10, deal_num);
		query.setInteger(11, addressID);
		if(query.executeUpdate() == 1){
			return "success";
		}else
			return "fail";
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> findOneDeal(String id1){
		String hql="";
		if(id1==null||id1.equals(""))
			   return null;
		hql = "from purchase p where p.id1 = ? ";
		List<Purchase> purchaselist=this.getHibernateTemplate().find(hql,id1);
		if(purchaselist.size()!=0){
			System.out.println("��ѯ�ɹ�");
			System.out.println("id1 is "+ id1);
			return purchaselist;
		}else if(purchaselist.size()==0){
			return null;
		}
		 
		return null;
		
	}
	
	@Override
	public String change(int state,String deal_num){
		
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
		// ��ѯ��ҳ����
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
		// ��ѯ��ҳ����
		List<Purchase> list = new ArrayList<>();
		if((time == null || time.equals("")) && (username!=null || !username.equals(""))){
			criteria.add(Restrictions.eq("username", username));
			list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
			System.out.println("list: "+list.size());
		}
		if((username == null || username.equals("")) && (time != null || !time.equals(""))){
			criteria.add(Restrictions.like("time",time+"%"));
			list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
			System.out.println("list: "+list.size());
		}
		if (time != null && !time.equals("") && username != null && !username.equals("")) {
			criteria.add(Restrictions.like("time",time+"%"));
			criteria.add(Restrictions.eq("username", username));
			list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
			System.out.println("list: "+list.size());
		}
		
		return list;
	}
	
//	public PageBean<Purchase> findByPage(Purchase searchModel, int pageNum, int pageSize) {
//		System.out.println("dao�㷽������");
//		// ���������
//		PageBean<Purchase> result = null;
//
//		// ��Ų�ѯ����
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
//			// ��ʼ����
//			int fromIndex = pageSize * (pageNum - 1);
//
//			// ������в�ѯ������Ʒ����
//			List<Purchase> purchaseList = new ArrayList<Purchase>();
//
//			Session session = null;
//
//			// ��ȡ��Spring�йܵ�session
//			
//			session = this.getSession();
//			
//			// ��ȡquery����
//			Query hqlQuery = session.createQuery(hql.toString());
//			Query countHqlQuery = session.createQuery(countHql.toString());
//
//			// ���ò�ѯ����
//			setQueryParams(hqlQuery, paramMap);
//			setQueryParams(countHqlQuery, paramMap);
//
//			// �ӵڼ�����¼��ʼ��ѯ
//			hqlQuery.setFirstResult(fromIndex);
//
//			// һ����ѯ��������¼
//			hqlQuery.setMaxResults(pageSize);
//
//			// ��ȡ��ѯ�Ľ��
//			purchaseList = hqlQuery.list();
//
//			// ��ȡ�ܼ�¼��
//			List<?> countResult = countHqlQuery.list();
//			int totalRecord = ((Number) countResult.get(0)).intValue();
//
//			// ��ȡ��ҳ��
//			int totalPage = totalRecord / pageSize;
//			if (totalRecord % pageSize != 0) {
//				totalPage++;
//			}
//
//			// ��װpager����
//			result = new PageBean<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
//			System.out.println("dao�㷽�����н���");
//			return result;
//			
//		}
//		if((username == null || username.equals("")) && (time != null || !time.equals(""))){
//			hql = new StringBuilder("from purchase where time like :time");
//			countHql = new StringBuilder("select count(*) from purchase where time like :time");
//			paramMap.put("time", time + "%");
//			// ��ʼ����
//			int fromIndex = pageSize * (pageNum - 1);
//
//			// ������в�ѯ������Ʒ����
//			List<Purchase> purchaseList = new ArrayList<Purchase>();
//
//			Session session = null;
//
//			// ��ȡ��Spring�йܵ�session
//			
//			session = this.getSession();
//			
//			// ��ȡquery����
//			Query hqlQuery = session.createQuery(hql.toString());
//			Query countHqlQuery = session.createQuery(countHql.toString());
//
//			// ���ò�ѯ����
//			setQueryParams(hqlQuery, paramMap);
//			setQueryParams(countHqlQuery, paramMap);
//
//			// �ӵڼ�����¼��ʼ��ѯ
//			hqlQuery.setFirstResult(fromIndex);
//
//			// һ����ѯ��������¼
//			hqlQuery.setMaxResults(pageSize);
//
//			// ��ȡ��ѯ�Ľ��
//			purchaseList = hqlQuery.list();
//
//			// ��ȡ�ܼ�¼��
//			List<?> countResult = countHqlQuery.list();
//			int totalRecord = ((Number) countResult.get(0)).intValue();
//
//			// ��ȡ��ҳ��
//			int totalPage = totalRecord / pageSize;
//			if (totalRecord % pageSize != 0) {
//				totalPage++;
//			}
//
//			// ��װpager����
//			result = new PageBean<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
//			System.out.println("dao�㷽�����н���");
//			return result;
//		}
//		else if (time != null && !time.equals("") && username != null && !username.equals("")) {
//			hql = new StringBuilder("from purchase where time like :time and username =:username ");
//			countHql = new StringBuilder("select count(*) from purchase where time like :time and username =:username");
//			paramMap.put("time", time + "%");
//			paramMap.put("username",username);
//			// ��ʼ����
//			int fromIndex = pageSize * (pageNum - 1);
//
//			// ������в�ѯ������Ʒ����
//			List<Purchase> purchaseList = new ArrayList<Purchase>();
//
//			Session session = null;
//
//			// ��ȡ��Spring�йܵ�session
//			
//			session = this.getSession();
//			
//			// ��ȡquery����
//			Query hqlQuery = session.createQuery(hql.toString());
//			Query countHqlQuery = session.createQuery(countHql.toString());
//
//			// ���ò�ѯ����
//			setQueryParams(hqlQuery, paramMap);
//			setQueryParams(countHqlQuery, paramMap);
//
//			// �ӵڼ�����¼��ʼ��ѯ
//			hqlQuery.setFirstResult(fromIndex);
//
//			// һ����ѯ��������¼
//			hqlQuery.setMaxResults(pageSize);
//
//			// ��ȡ��ѯ�Ľ��
//			purchaseList = hqlQuery.list();
//
//			// ��ȡ�ܼ�¼��
//			List<?> countResult = countHqlQuery.list();
//			int totalRecord = ((Number) countResult.get(0)).intValue();
//
//			// ��ȡ��ҳ��
//			int totalPage = totalRecord / pageSize;
//			if (totalRecord % pageSize != 0) {
//				totalPage++;
//			}
//
//			// ��װpager����
//			result = new PageBean<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
//			System.out.println("dao�㷽�����н���");
//			return result;
//		}
//		return result;
//
//		
//	}
//
//	/**
//	 * ���ò�ѯ�Ĳ���
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
//		// ��ѯ��ҳ����
//		// ��Ų�ѯ����
////		Map<String, Object> paramMap = new HashMap<String, Object>();
////
////		String username = searchModel.getUsername();
////		String time = searchModel.getTime();
////		StringBuilder hql = new StringBuilder();
////		StringBuilder countHql = new StringBuilder();
//		List<Purchase> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
//		return list;
	//}
	
//	public Pager<Purchase> findByPage(Purchase searchModel, int pageNum, int pageSize) {
//
//        // ���������
//        Pager<Purchase> result = null;
//
//        // ��Ų�ѯ����
//        Map<String, Object> paramMap = new HashMap<String, Object>();
//            
//        String username = searchModel.getUsername();
//        String time = searchModel.getTime();
//        StringBuilder hql = new StringBuilder();
//        StringBuilder countHql = new StringBuilder();
//        if((time == null || time.equals("")) && (username ==null || username.equals(""))){
//			//return this.findByPage(pageNum, pageSize);
//        }
//        if((time == null || time.equals("")) && (username!=null || !username.equals(""))){
//			hql = new StringBuilder("from purchase where username =:username ");
//			countHql = new StringBuilder("select count(*) from purchase where username =:username");			
//			paramMap.put("username", username);
//			// ��ʼ����
//			int fromIndex = pageSize * (pageNum - 1);
//
//			// ������в�ѯ������Ʒ����
//			List<Purchase> purchaseList = new ArrayList<Purchase>();
//
//			Session session = null;
//
//			// ��ȡ��Spring�йܵ�session
//			
//			session = this.getSession();
//			
//			// ��ȡquery����
//			Query hqlQuery = session.createQuery(hql.toString());
//			Query countHqlQuery = session.createQuery(countHql.toString());
//
//			// ���ò�ѯ����
//			setQueryParams(hqlQuery, paramMap);
//			setQueryParams(countHqlQuery, paramMap);
//
//			// �ӵڼ�����¼��ʼ��ѯ
//			hqlQuery.setFirstResult(fromIndex);
//
//			// һ����ѯ��������¼
//			hqlQuery.setMaxResults(pageSize);
//
//			// ��ȡ��ѯ�Ľ��
//			purchaseList = hqlQuery.list();
//
//			// ��ȡ�ܼ�¼��
//			List<?> countResult = countHqlQuery.list();
//			int totalRecord = ((Number) countResult.get(0)).intValue();
//
//			// ��ȡ��ҳ��
//			int totalPage = totalRecord / pageSize;
//			if (totalRecord % pageSize != 0) {
//				totalPage++;
//			}
//
//			// ��װpager����
//			result = new Pager<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
//			System.out.println("dao�㷽�����н���");
//			return result;
//			
//		}
//		if((username == null || username.equals("")) && (time != null || !time.equals(""))){
//			hql = new StringBuilder("from purchase where time like :time");
//			countHql = new StringBuilder("select count(*) from purchase where time like :time");
//			paramMap.put("time", time + "%");
//			// ��ʼ����
//			int fromIndex = pageSize * (pageNum - 1);
//
//			// ������в�ѯ������Ʒ����
//			List<Purchase> purchaseList = new ArrayList<Purchase>();
//
//			Session session = null;
//
//			// ��ȡ��Spring�йܵ�session
//			
//			session = this.getSession();
//			
//			// ��ȡquery����
//			Query hqlQuery = session.createQuery(hql.toString());
//			Query countHqlQuery = session.createQuery(countHql.toString());
//
//			// ���ò�ѯ����
//			setQueryParams(hqlQuery, paramMap);
//			setQueryParams(countHqlQuery, paramMap);
//
//			// �ӵڼ�����¼��ʼ��ѯ
//			hqlQuery.setFirstResult(fromIndex);
//
//			// һ����ѯ��������¼
//			hqlQuery.setMaxResults(pageSize);
//
//			// ��ȡ��ѯ�Ľ��
//			purchaseList = hqlQuery.list();
//
//			// ��ȡ�ܼ�¼��
//			List<?> countResult = countHqlQuery.list();
//			int totalRecord = ((Number) countResult.get(0)).intValue();
//
//			// ��ȡ��ҳ��
//			int totalPage = totalRecord / pageSize;
//			if (totalRecord % pageSize != 0) {
//				totalPage++;
//			}
//
//			// ��װpager����
//			result = new Pager<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
//			System.out.println("dao�㷽�����н���");
//			return result;
//		}
//		else if (time != null && !time.equals("") && username != null && !username.equals("")) {
//			hql = new StringBuilder("from purchase where time like :time and username =:username ");
//			countHql = new StringBuilder("select count(*) from purchase where time like :time and username =:username");
//			paramMap.put("time", time + "%");
//			paramMap.put("username",username);
//			// ��ʼ����
//			int fromIndex = pageSize * (pageNum - 1);
//
//			// ������в�ѯ������Ʒ����
//			List<Purchase> purchaseList = new ArrayList<Purchase>();
//
//			Session session = null;
//
//			// ��ȡ��Spring�йܵ�session
//			
//			session = this.getSession();
//			
//			// ��ȡquery����
//			Query hqlQuery = session.createQuery(hql.toString());
//			Query countHqlQuery = session.createQuery(countHql.toString());
//
//			// ���ò�ѯ����
//			setQueryParams(hqlQuery, paramMap);
//			setQueryParams(countHqlQuery, paramMap);
//
//			// �ӵڼ�����¼��ʼ��ѯ
//			hqlQuery.setFirstResult(fromIndex);
//
//			// һ����ѯ��������¼
//			hqlQuery.setMaxResults(pageSize);
//
//			// ��ȡ��ѯ�Ľ��
//			purchaseList = hqlQuery.list();
//
//			// ��ȡ�ܼ�¼��
//			List<?> countResult = countHqlQuery.list();
//			int totalRecord = ((Number) countResult.get(0)).intValue();
//
//			// ��ȡ��ҳ��
//			int totalPage = totalRecord / pageSize;
//			if (totalRecord % pageSize != 0) {
//				totalPage++;
//			}
//
//			// ��װpager����
//			result = new Pager<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
//			System.out.println("dao�㷽�����н���");
//			return result;
//		}
//		return result;
//    }
//
//    /**
//     * ���ò�ѯ�Ĳ���
//     * 
//     * @param query
//     * @param paramMap
//     * @return
//     */
//    private Query setQueryParams(Query query, Map<String, Object> paramMap) {
//        if (paramMap != null && !paramMap.isEmpty()) {
//            for (Map.Entry<String, Object> param : paramMap.entrySet()) {
//                query.setParameter(param.getKey(), param.getValue());
//            }
//        }
//        return query;
//    }

//	@Override
//	public Pager<Purchase> findByPage(int pageNum, int pageSize) {
//		// TODO Auto-generated method stub
//		StringBuilder hql = new StringBuilder();
//		hql = new StringBuilder("from purchase");
//		
//		// ��ʼ����
//		int fromIndex = pageSize * (pageNum - 1);
//
//		// ������в�ѯ������Ʒ����
//		List<Purchase> purchaseList = new ArrayList<Purchase>();
//
//		Session session = null;
//
//		// ��ȡ��Spring�йܵ�session
//					
//		session = this.getSession();
//					
//		// ��ȡquery����
//		Query hqlQuery = session.createQuery(hql.toString());
//		hqlQuery.setFirstResult(fromIndex);
//
//		// һ����ѯ��������¼
//		hqlQuery.setMaxResults(pageSize);
//
//		// ��ȡ��ѯ�Ľ��
//		purchaseList = hqlQuery.list();
//
//		// ��ȡ�ܼ�¼��
//		int totalRecord = this.findCount();
//
//		// ��ȡ��ҳ��
//		int totalPage = totalRecord / pageSize;
//		if (totalRecord % pageSize != 0) {
//			totalPage++;
//		}
//
//		// ��װpager����
//		Pager<Purchase> result = new Pager<Purchase>(pageSize, pageNum, totalRecord, totalPage, purchaseList);
//		System.out.println("result:"+result);
//		return result;
//	}
}

