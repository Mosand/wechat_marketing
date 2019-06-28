package com.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.GoodsInfo;
import com.entity.PageBean;
import com.entity.Pager;
import com.entity.Purchase;
import com.entity.TransactionRecord;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.service.PurchaseService;
import com.service.TransactionService;

public class TransactionAction {
	
	private int id;
	private String id1;
	private int goods_id;
	private float ticheng;
	private float market_price;
	private float reward;
	private float admin;
	private String username;
	private String deal_num;
	private String time;
	private String serial_num;
	private String direction;
	private String avatar_url;
	private String goods_name;
	
	private PurchaseService purchaseService;
	public TransactionService transactionService;
	private List<Object> lists = new ArrayList<Object>();
	private List<Object> lists3 = new ArrayList<>();
	
	public List<Object> getLists3() {
		return lists3;
	}
	public void setLists3(List<Object> lists3) {
		this.lists3 = lists3;
	}

	
	public PurchaseService getPurchaseService() {
		return purchaseService;
	}
	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

		// 当前页数
		private Integer currPage = 1;
		public void setCurrPage(Integer currPage) {
			this.currPage = currPage;
		}
	public List<Object> getLists() {
		return lists;
	}

	public void setLists(List<Object> lists) {
		this.lists = lists;
	}


	private InputStream inputStream; //这个名字和struts.xml中对应，不能写错  
	  
    public InputStream getInputStream() {  
        return inputStream;  
    }  
  
    public void setInputStream(InputStream inputStream) {  
        this.inputStream = inputStream;  
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public float getTicheng() {
		return ticheng;
	}

	public void setTicheng(float ticheng) {
		this.ticheng = ticheng;
	}

	public float getMarket_price() {
		return market_price;
	}

	public void setMarket_price(float market_price) {
		this.market_price = market_price;
	}

	public float getReward() {
		return reward;
	}

	public void setReward(float reward) {
		this.reward = reward;
	}

	public float getAdmin() {
		return admin;
	}

	public void setAdmin(float admin) {
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDeal_num() {
		return deal_num;
	}

	public void setDeal_num(String deal_num) {
		this.deal_num = deal_num;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public TransactionService getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}  
     
	public String getSerial_num() {
		return serial_num;
	}

	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getAvatar_url() {
		return avatar_url;
	}
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	
	
	public String getState2(){
        System.out.println("传统的ajax");
        HttpServletResponse response = ServletActionContext.getResponse();
        try {
            PrintWriter out = response.getWriter();
            out.println("{\"success\":\"true\",\"type\":\"succ\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public String saveTransaction() throws UnsupportedEncodingException{
		
		System.out.println("action.saveTransaction方法执行");
		
		TransactionRecord transaction = new TransactionRecord();
    	Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式化
		String time1=format.format(date);
		time = time1.toString();
		transaction.setTime(time);
		String result = transactionService.saveTransaction(id1,username,goods_id,ticheng,market_price,reward,admin,serial_num,time,direction,avatar_url,goods_name);
		if(result.equals(com.service.impl.AddressServiceImpl.SUCCESS)){
			 inputStream = new ByteArrayInputStream("saveTransactionSuccess"  
	                    .getBytes("UTF-8"));
			 //ActionContext.getContext().put("user_id", id1);
			System.out.println("插入交易成功");
			return "saveSuccess";
		}else if(result.equals(com.service.impl.AddressServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("saveTransactionFail"  
                    .getBytes("UTF-8")); 
			System.out.println("插入交易失败");
			return "saveFail";
		}
		
		return null;
	}

	//找所有的支出
	public String findTransaction() throws UnsupportedEncodingException{
		
		System.out.println("action.findTransaction方法执行");
		
		PageBean<Object> pageBean = transactionService.findTransaction(currPage);
		
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findAll2";		
		
	}
	
	//根据username和time找支出  怎么把条件一起带入进行第二页的查询
	public String findTransactionByNameandTime(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String time = request.getParameter("time");
		TransactionRecord searchModel = new TransactionRecord();
		searchModel.setUsername(username);
		searchModel.setTime(time);
		PageBean<Object> pageBean = transactionService.findByPage(searchModel,currPage);
		System.out.println("service running");
		if(pageBean == null){
			return "findFail";
		}
		// 使用的是模型驱动，把信息放入值栈中，可以使用OGNL表达式获取
		ActionContext.getContext().getValueStack().push(pageBean);
		ActionContext.getContext().getValueStack().push(searchModel);
		return "findSuccess";
	}
	
	//分页查询transaction_record
	public String findAll() {
        System.out.println("控制器方法启动");
        // 使用struts2的servlet接口，接收request里的参数
        // 商品名字参数
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String time = request.getParameter("time");


        // 校验pageNum参数输入合法性
        String pageNumStr = request.getParameter("pageNum");
        System.out.println("前端给的pageNum是："+pageNumStr);

        int pageNum = 1; // 默认显示第几页数据
        if (pageNumStr != null && !"".equals(pageNumStr.trim())) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        int pageSize = 5; // 默认每页显示多少条记录
        String pageSizeStr = request.getParameter("pageSize");
        if (pageSizeStr != null && !"".equals(pageSizeStr.trim())) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // 组装模糊查询条件
        TransactionRecord searchModel = new TransactionRecord();
        searchModel.setUsername(username);
        searchModel.setTime(time);
        System.out.println("==============Product对象==============");
        System.out.println(searchModel);
        // 调用service 获取查询结果
        Pager<TransactionRecord> result = transactionService.findByPage2(searchModel, pageNum, pageSize);

        // 将pageBean存入值栈，供前端页面读取        
        ActionContext.getContext().getValueStack().push(result);
        // 将查询条件也压回值栈，在初始化函数中为其初始化
        ActionContext.getContext().getValueStack().push(searchModel);
        System.out.println("==============Pager对象==============");
        System.out.println(result);
        System.out.println("控制器方法完成");
        return "findAll";
    }
	
	//支出报表 收入报表
	public String findExpenseandIncome(){
		
		System.out.println("action.findExpenseandIncome方法执行");
		if(transactionService.getSumByMonth() == null){
			return "findExpenseFail";
		}
		lists = transactionService.getSumByMonth();//支出 收入
//		if(purchaseService.getSumByMonth() == null){
//			return "findIncomeFail";
//		}
//		lists2 = purchaseService.getSumByMonth();//收入
//		lists3.addAll(lists);
//		lists3.addAll(lists2);

		return "findExpenseIncome";
	}
	
	
	
}
