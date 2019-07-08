package com.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.TransactionDao;
import com.entity.GoodsInfo;
import com.entity.Pager;
import com.entity.Purchase;
import com.entity.TransactionRecord;
import com.entity.UserInfo;
import com.google.gson.Gson;

public class TransactionDaoImpl extends HibernateDaoSupport implements TransactionDao{

	
	@Override
	public String makeDeal(String id1,String time,String deal_num){
		
		time = time.trim();
		time = time.replace("-", "");
		time = time.replace(":", "");
		time = time.replace(" ", "");
		deal_num = id1+time ;
		return deal_num;
	}
	
	public List<UserInfo> findAvatar(String id1){
		String hql="";
		if(id1==null||id1.equals(""))
			   return null;
		hql = "from user_info u where u.id1 = ? ";
		List<UserInfo> userlist=this.getHibernateTemplate().find(hql,id1);
		if(userlist.size()!=0){
			return userlist;
		}else if(userlist.size()==0){
			return null;
		}
		 
		return null;
	}
	
	public List<GoodsInfo> findGoods(int goods_id){
		String hql="";
		
		hql = "from goods_info g where g.goods_id = ? ";
		List<GoodsInfo> goodlist=this.getHibernateTemplate().find(hql,goods_id);
		if(goodlist.size()!=0){
			return goodlist;
		}else if(goodlist.size()==0){
			return null;
		}
		 
		return null;
	}
	
	@Override
	public String saveTransaction(String id1, String username, int goods_id, float money, String serial_num, String time,String direction,String avatar_url,String goods_name) {
		serial_num = this.makeDeal(id1,time, serial_num);		
		avatar_url = this.findAvatar(id1).get(0).getAvatar_url();
		goods_name = this.findGoods(goods_id).get(0).getGoods_name();
		Session se =this.getSession();
		String hql="";
		System.out.println("money:"+money);
		System.out.println("direction:"+direction);
		if(direction.equals("提成费")){
			float ticheng = money;
			hql = "insert into transaction_record(id1,username,goods_id,ticheng,serial_num,time,direction,avatar_url,goods_name) values(?,?,?,?,?,?,?,?,?)";
			Query query= se.createSQLQuery(hql);
			query.setString(0, id1);
			query.setString(1, username);
			query.setInteger(2, goods_id);
			query.setFloat(3, ticheng);
			query.setString(4, serial_num);
			query.setString(5, time);	
			query.setString(6, direction);
			query.setString(7, avatar_url);
			query.setString(8, goods_name);
			if(query.executeUpdate() == 1){
				return "success";
			}else
				return "fail";
		}
		if(direction.equals("市场费")){
			float market_price = money;
			hql = "insert into transaction_record(id1,username,goods_id,market_price,serial_num,time,direction,avatar_url,goods_name) values(?,?,?,?,?,?,?,?,?)";
			Query query= se.createSQLQuery(hql);
			query.setString(0, id1);
			query.setString(1, username);
			query.setInteger(2, goods_id);
			query.setFloat(3, market_price);
			query.setString(4, serial_num);
			query.setString(5, time);	
			query.setString(6, direction);
			query.setString(7, avatar_url);
			query.setString(8, goods_name);
			if(query.executeUpdate() == 1){
				return "success";
			}else
				return "fail";
		}
		if(direction.equals("奖金")){
			float reward = money;
			hql = "insert into transaction_record(id1,username,goods_id,reward,serial_num,time,direction,avatar_url,goods_name) values(?,?,?,?,?,?,?,?,?)";
			Query query= se.createSQLQuery(hql);
			query.setString(0, id1);
			query.setString(1, username);
			query.setInteger(2, goods_id);
			query.setFloat(3, reward);
			query.setString(4, serial_num);
			query.setString(5, time);	
			query.setString(6, direction);
			query.setString(7, avatar_url);
			query.setString(8, goods_name);
			if(query.executeUpdate() == 1){
				return "success";
			}else
				return "fail";
		}
		if(direction.equals("admin奖金")){
			float admin = money;
			hql = "insert into transaction_record(id1,username,goods_id,admin,serial_num,time,direction,avatar_url,goods_name) values(?,?,?,?,?,?,?,?,?)";
			Query query= se.createSQLQuery(hql);
			query.setString(0, id1);
			query.setString(1, username);
			query.setInteger(2, goods_id);
			query.setFloat(3, admin);
			query.setString(4, serial_num);
			query.setString(5, time);	
			query.setString(6, direction);
			query.setString(7, avatar_url);
			query.setString(8, goods_name);
			if(query.executeUpdate() == 1){
				return "success";
			}else
				return "fail";
		}
		return "";
		
		
	}


	@Override
	public List<Object> findTransaction(int begin, int pageSize) {
		// TODO Auto-generated method stub
		Session session =this.getSession();
		String hql="";
		hql="SELECT t.username, t.id1,t.time,t.direction,t.goods_id,"
+"(SELECT avatar_url from user_info WHERE user_info.id1 = u.id1) as avatar_url,"
+"(SELECT goods_name from goods_info WHERE goods_info.goods_id = u.goods_id) as goods_name,"
+"(SELECT SUM(t.ticheng) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalticheng,"
+"(SELECT SUM(t.market_price) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalmarket_price,"
+"(SELECT SUM(t.reward) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalreward,"
+"(SELECT SUM(t.admin) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totaladmin"
+" from transaction_record as t,user_income as u WHERE t.id1 = u.id1 and t.goods_id = u.goods_id";
		
		Query query = session.createSQLQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);    
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Object> list = query.list();
		Gson gson = new Gson();
		System.out.println("list:"+gson.toJson(list));
		return list; 
	}



	@Override
	public int findCount() {
		String hql = "select count(*) from transaction_record";
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}


//找收入和支出
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getSumByMonth() {
		// TODO Auto-generated method stub
		System.out.println("Dao层运行");
		Session session =this.getSession();
		String hql="";		
		hql="SELECT CONCAT(YEAR(time),'-',MONTH(time)) as 'ym',YEAR(time) as YEAR,MONTH(time) as MONTH,IFNULL(b.expense,0) as 'expense',IFNULL(c.income,0) as 'income'" 
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
				+"LEFT JOIN(SELECT sum(ticheng + market_price+reward+admin) as expense , CONCAT(YEAR(time),'-',MONTH(time)) as mon "
				+"FROM transaction_record GROUP BY mon) b ON CONCAT(YEAR(time),'-',MONTH(time))=b.mon "
				+"LEFT JOIN(SELECT sum(spend) as income , CONCAT(YEAR(time),'-',MONTH(time)) as mon "
				+" FROM purchase GROUP BY mon) c ON CONCAT(YEAR(time),'-',MONTH(time))=c.mon order by	year desc,month asc";
		Query query = session.createSQLQuery(hql);
		List<Object> list = new ArrayList<>();
		list = query.list();
		Gson gson = new Gson();
		System.out.println("list:"+gson.toJson(list));
		return list;
	}
		
	@Override
	public int findCount(TransactionRecord searchModel) {
		// TODO Auto-generated method stub
		
		String username = searchModel.getUsername();
		String time = searchModel.getTime();
		if((time == null || time.equals("")) && (username ==null || username.equals(""))){
			String hql = "select count(*) from transaction_record";
			@SuppressWarnings("unchecked")
			List<Long> list = this.getHibernateTemplate().find(hql);
			if(list.size()>0){
				return list.get(0).intValue();
			}
		}
		if((time == null || time.equals("")) && (username!=null || !username.equals(""))){
			String hql = "select count(*) from transaction_record where username = ?";
			@SuppressWarnings("unchecked")
			List<Long> list = this.getHibernateTemplate().find(hql,username);
			if(list.size()>0){
				return list.get(0).intValue();
			}
		}
		if((username == null || username.equals("")) && (time != null || !time.equals(""))){
			//Session session = this.getSession();
			String hql = "select count(*) from transaction_record where time like '"+time+"%' ";
			@SuppressWarnings("unchecked")
			List<Long> list = this.getHibernateTemplate().find(hql);
			if(list.size()>0){
				return list.get(0).intValue();
			}
		}
		if (time != null && !time.equals("") && username != null && !username.equals("")) {
			String hql = "select count(*) from transaction_record where time like '"+time+"%' "+"and username ='"+username+"'";
			@SuppressWarnings("unchecked")
			List<Long> list = this.getHibernateTemplate().find(hql);
			if(list.size()>0){
				return list.get(0).intValue();
			}
		}
				
		return 0;
	}
	
	@Override
	public List<Object> findByPage(TransactionRecord searchModel,int begin, int pageSize) {
		// TODO Auto-generated method stub
		Session session =this.getSession();	
		String username = searchModel.getUsername();
		String time = searchModel.getTime();
		System.out.println("username: "+username);
		System.out.println("time: "+time);		
		if((time == null || time.equals("")) && (username ==null || username.equals(""))){
			return this.findTransaction(begin, pageSize);
        }
		String hql="";
		List<Object> list = new ArrayList<>();
		//根据username查transaction
		if((time == null || time.equals("")) && (username!=null || !username.equals(""))){
			hql="SELECT t.username, t.id1,t.time,t.direction,t.goods_id,"
					+"(SELECT avatar_url from user_info WHERE user_info.id1 = u.id1) as avatar_url,"
					+"(SELECT goods_name from goods_info WHERE goods_info.goods_id = u.goods_id) as goods_name,"
					+"(SELECT SUM(t.ticheng) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalticheng,"
					+"(SELECT SUM(t.market_price) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalmarket_price,"
					+"(SELECT SUM(t.reward) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalreward,"
					+"(SELECT SUM(t.admin) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totaladmin"
					+" from transaction_record as t,user_income as u WHERE t.id1 = u.id1 and t.goods_id = u.goods_id and t.username=?";				
			Query query = session.createSQLQuery(hql);
			query.setString(0, username);
			query.setFirstResult(begin);
			query.setMaxResults(pageSize);    
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list = query.list();
		}
		if((username == null || username.equals("")) && (time != null || !time.equals(""))){
			hql="SELECT t.username, t.id1,t.time,t.direction,t.goods_id,"
					+"(SELECT avatar_url from user_info WHERE user_info.id1 = u.id1) as avatar_url,"
					+"(SELECT goods_name from goods_info WHERE goods_info.goods_id = u.goods_id) as goods_name,"
					+"(SELECT SUM(t.ticheng) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalticheng,"
					+"(SELECT SUM(t.market_price) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalmarket_price,"
					+"(SELECT SUM(t.reward) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalreward,"
					+"(SELECT SUM(t.admin) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totaladmin"
					+" from transaction_record as t,user_income as u WHERE t.id1 = u.id1 and t.goods_id = u.goods_id and t.time like ?%";				
			Query query = session.createSQLQuery(hql);
			query.setString(0, time);
			query.setFirstResult(begin);
			query.setMaxResults(pageSize);    
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list = query.list();
		}
		if (time != null && !time.equals("") && username != null && !username.equals("")) {
			hql="SELECT t.username, t.id1,t.time,t.direction,t.goods_id,"
					+"(SELECT avatar_url from user_info WHERE user_info.id1 = u.id1) as avatar_url,"
					+"(SELECT goods_name from goods_info WHERE goods_info.goods_id = u.goods_id) as goods_name,"
					+"(SELECT SUM(t.ticheng) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalticheng,"
					+"(SELECT SUM(t.market_price) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalmarket_price,"
					+"(SELECT SUM(t.reward) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totalreward,"
					+"(SELECT SUM(t.admin) from transaction_record as t WHERE u.id1 = t.id1 and u.goods_id = t.goods_id ) as totaladmin"
					+" from transaction_record as t,user_income as u WHERE t.id1 = u.id1 and t.goods_id = u.goods_id and t.username=? and t.time like ?%";				
			Query query = session.createSQLQuery(hql);
			query.setString(0, username);
			query.setString(1, time);
			query.setFirstResult(begin);
			query.setMaxResults(pageSize);    
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list = query.list();
		}
		
		return list;
	}
	
	public Pager<TransactionRecord> findByPage2(TransactionRecord searchModel, int pageNum, int pageSize) {

        // 声明结果集
        Pager<TransactionRecord> result = null;

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
			hql = new StringBuilder("from transaction_record where username =:username order by time desc");
			countHql = new StringBuilder("select count(*) from transaction_record where username =:username");			
			paramMap.put("username", username);
			// 起始索引
			int fromIndex = pageSize * (pageNum - 1);

			// 存放所有查询出的商品对象
			List<TransactionRecord> transactionList = new ArrayList<TransactionRecord>();

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
			transactionList = hqlQuery.list();

			// 获取总记录数
			List<?> countResult = countHqlQuery.list();
			int totalRecord = ((Number) countResult.get(0)).intValue();

			// 获取总页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage++;
			}

			// 组装pager对象
			result = new Pager<TransactionRecord>(pageSize, pageNum, totalRecord, totalPage, transactionList);
			System.out.println("dao层方法运行结束");
			return result;
			
		}
		if((username == null || username.equals("")) && (time != null || !time.equals(""))){
			hql = new StringBuilder("from transaction_record where time like :time order by time desc");
			countHql = new StringBuilder("select count(*) from transaction_record where time like :time");
			paramMap.put("time", time + "%");
			// 起始索引
			int fromIndex = pageSize * (pageNum - 1);

			// 存放所有查询出的商品对象
			List<TransactionRecord> transactionList = new ArrayList<TransactionRecord>();

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
			transactionList = hqlQuery.list();

			// 获取总记录数
			List<?> countResult = countHqlQuery.list();
			int totalRecord = ((Number) countResult.get(0)).intValue();

			// 获取总页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage++;
			}

			// 组装pager对象
			result = new Pager<TransactionRecord>(pageSize, pageNum, totalRecord, totalPage, transactionList);
			System.out.println("dao层方法运行结束");
			return result;
		}
		else if (time != null && !time.equals("") && username != null && !username.equals("")) {
			hql = new StringBuilder("from transaction_record where time like :time and username =:username order by time desc");
			countHql = new StringBuilder("select count(*) from transaction_record where time like :time and username =:username");
			paramMap.put("time", time + "%");
			paramMap.put("username",username);
			// 起始索引
			int fromIndex = pageSize * (pageNum - 1);

			// 存放所有查询出的商品对象
			List<TransactionRecord> transactionList = new ArrayList<TransactionRecord>();

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
			transactionList = hqlQuery.list();

			// 获取总记录数
			List<?> countResult = countHqlQuery.list();
			int totalRecord = ((Number) countResult.get(0)).intValue();

			// 获取总页数
			int totalPage = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				totalPage++;
			}

			// 组装pager对象
			result = new Pager<TransactionRecord>(pageSize, pageNum, totalRecord, totalPage, transactionList);
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
	public Pager<TransactionRecord> findByPage3(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder();
		hql = new StringBuilder("from transaction_record order by time desc");
		
		// 起始索引
		int fromIndex = pageSize * (pageNum - 1);

		// 存放所有查询出的商品对象
		List<TransactionRecord> transactionList = new ArrayList<TransactionRecord>();

		Session session = null;

		// 获取被Spring托管的session
					
		session = this.getSession();
					
		// 获取query对象
		Query hqlQuery = session.createQuery(hql.toString());
		hqlQuery.setFirstResult(fromIndex);

		// 一共查询多少条记录
		hqlQuery.setMaxResults(pageSize);

		// 获取查询的结果
		transactionList = hqlQuery.list();

		// 获取总记录数
		int totalRecord = this.findCount();

		// 获取总页数
		int totalPage = totalRecord / pageSize;
		if (totalRecord % pageSize != 0) {
			totalPage++;
		}

		// 组装pager对象
		Pager<TransactionRecord> result = new Pager<TransactionRecord>(pageSize, pageNum, totalRecord, totalPage, transactionList);
		System.out.println("result:"+result);
		return result;
	}
	
}

	
	
	


