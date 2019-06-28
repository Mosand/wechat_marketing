package com.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.entity.Address;
import com.entity.PageBean;
import com.entity.Pager;
import com.entity.Purchase;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.AddressService;
import com.service.GoodsService;
import com.service.PurchaseService;
import com.service.UserIncomeService;

public class PurchaseAction extends ActionSupport implements ModelDriven<Purchase>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id1;
	private int goods_id;
	private String goods_name;
	private int buy_num;
	private float spend;
	private String time;
	private int state;
	private String avatar_url;
	private String imgFormat;
	private String deal_num;
	private int addressID;
	private String username;
	private float ticheng;
	private float market_price;
	private float reward;
	private float admin;
	private Purchase purchase;
	private AddressService addressService ;
	private PurchaseService purchaseService;
	private List<Purchase> lists = new ArrayList<Purchase>();
	private UserIncomeService userIncomeService;
	private GoodsService goodsService;
	
	//返回前端的JSON字符串，需要提供get/set方法
    private String responseStr; 

    public String getResponseStr() {
        return responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }
	// 当前页数
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	private InputStream inputStream; //这个名字和struts.xml中对应，不能写错  
	  
    public InputStream getInputStream() {  
        return inputStream;  
    }  
  
    public void setInputStream(InputStream inputStream) {  
        this.inputStream = inputStream;  
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

	public int getBuy_num() {
		return buy_num;
	}

	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}

	public float getSpend() {
		return spend;
	}

	public void setSpend(float spend) {
		this.spend = spend;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getImgFormat() {
		return imgFormat;
	}

	public void setImgFormat(String imgFormat) {
		this.imgFormat = imgFormat;
	}

	public String getDeal_num() {
		return deal_num;
	}

	public void setDeal_num(String deal_num) {
		this.deal_num = deal_num;
	}

	public PurchaseService getPurchaseService() {
		return purchaseService;
	}

	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	@Override
	public Purchase getModel(){
		return purchase;
	}
	
	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//这个方法必须写上
    public List<Purchase> getLists() {
        return lists;
    }
    public void setLists(List<Purchase> lists) {
        this.lists = lists;
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

	public UserIncomeService getUserIncomeService() {
		return userIncomeService;
	}

	public void setUserIncomeService(UserIncomeService userIncomeService) {
		this.userIncomeService = userIncomeService;
	}

	
	
	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
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
	
    public String saveDealNum() throws UnsupportedEncodingException{ //根据id1和时间生成流水号
    	System.out.println("action.saveDealNum方法执行");
    	Purchase purchase = new Purchase();
    	Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式化
		String time1=format.format(date);
		time = time1.toString();
		purchase.setTime(time);

		List<Address> list = new ArrayList<Address>();//根据id1查询address表中address的id，作为addressID
		String result1 = addressService.findAddress(id1);
		if(result1 == null){
			return null;
		}else if(result1 == com.service.impl.AddressServiceImpl.SUCCESS){
			list = addressService.findOneAddress(id1);
			addressID = list.get(0).getAddressID();//根据id1查询address表中address的id，作为addressID
			System.out.println("lists"+lists);		
		}else if(result1 == com.service.impl.AddressServiceImpl.FAIL){
			return null;
		}
		String result = purchaseService.saveDeal(id1,username,goods_id,goods_name,buy_num,spend,time,state,avatar_url,imgFormat,deal_num,addressID);
		if(result.equals(com.service.impl.PurchaseServiceImpl.SUCCESS)){
			 inputStream = new ByteArrayInputStream("success"  
	                    .getBytes("UTF-8"));
			 ActionContext.getContext().put("user_id", id1);
			System.out.println("插入deal_num成功");
			return "iSuccess";
		}else if(result.equals(com.service.impl.PurchaseServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("fail"  
                    .getBytes("UTF-8")); 
			System.out.println("插入deal_num失败");
			return "iFail";
		}
		
		return null;
    }
    
	public String findDeal() throws UnsupportedEncodingException{//根据id1来查询id1的全部订单
		System.out.println("action.findDeal方法执行");
		String result = purchaseService.findDeal(id1);
		if(result == com.service.impl.PurchaseServiceImpl.SUCCESS){
			lists = purchaseService.findOneDeal(id1);
			System.out.println("lists"+lists);
			ActionContext.getContext().put("user_id", id1);
			return "findSuccess";
		}else if(result == com.service.impl.PurchaseServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("findfail"  
                    .getBytes("UTF-8")); 
			System.out.println("查询订单失败，没有此订单");
			return "findFail";
		}
		return null;
		
	}

	public String changeState() throws UnsupportedEncodingException{
		System.out.println("action.changeState方法执行");
    	String result = purchaseService.changeState(state,deal_num);
    	if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){
			System.out.println("订单状态更新成功");
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			System.out.println("订单状态更新失败");
		}
    	String result2 = userIncomeService.saveUserIncome(id1,goods_id,ticheng,market_price,reward,admin,username,deal_num,avatar_url,goods_name);//只接收deal_num就行了，将goods_id对应的提成等存入userincome
		if(result2 == com.service.impl.UserIncomeServiceImpl.SUCCESS){//将id1对应的purchase 的username 存入userincome
			inputStream = new ByteArrayInputStream("saveSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("save用户收入成功");
			return "saveSuccess";
		}else if(result2 == com.service.impl.UserIncomeServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("saveFail"  
                    .getBytes("UTF-8")); 
			System.out.println("save用户收入失败");
			return "saveFail";
    	
	}
    	
		return null;
}
    //找所有的交易记录
	public String findAllDeal(){
		
		PageBean<Purchase> pageBean = purchaseService.findByPage(currPage);
		
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findAll2";
	}
	
	public String findDealByNameandTime(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String time = request.getParameter("time");
		Purchase searchModel = new Purchase();
		searchModel.setUsername(username);
		searchModel.setTime(time);
		PageBean<Purchase> pageBean = purchaseService.findByPage(searchModel,currPage);
		System.out.println("service running");
		if(pageBean == null){
			return "findFail";
		}
		// 使用的是模型驱动，把信息放入值栈中，可以使用OGNL表达式获取
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findSuccess";
	}
	
	//最后我用的这种分页方法
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
	        Purchase searchModel = new Purchase();
	        searchModel.setUsername(username);
	        searchModel.setTime(time);
	        System.out.println("==============Product对象==============");
	        System.out.println(searchModel);
	        // 调用service 获取查询结果
	        Pager<Purchase> result = purchaseService.findByPage2(searchModel, pageNum, pageSize);

	        // 将pageBean存入值栈，供前端页面读取        
	        ActionContext.getContext().getValueStack().push(result);
	        // 将查询条件也压回值栈，在初始化函数中为其初始化
	        ActionContext.getContext().getValueStack().push(searchModel);
	        System.out.println("==============Pager对象==============");
	        System.out.println(result);
	        System.out.println("控制器方法完成");
	        return "findAll";
	    }
	
	//方式二：Ajax+JSON
    public String findAllJSON() {
        // 使用struts2的servlet接口，接收request里的参数
        // 商品名字参数
    	
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession seesion = request.getSession();
        HttpServletResponse response = ServletActionContext.getResponse();
        String username = request.getParameter("username");
        
        String time = request.getParameter("time");
   
        // 取得页面索引
        String pageNumStr = request.getParameter("pageNum");


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
        Purchase searchModel = new Purchase();
        searchModel.setUsername(username);
        searchModel.setTime(time);
        // 调用service 获取查询结果
        Pager<Purchase> result = purchaseService.findByPage2(searchModel, pageNum, pageSize);
        // 将查询结果封装成JSON字符串格式    
        responseStr = JSONObject.toJSONString(result);
        System.out.println(responseStr);
        // 利用response对象传回前端
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Pragma", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("text/html;charset=utf-8");     
        try {
            Writer writer = response.getWriter();
            writer.write(responseStr);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return NONE;
    }
}
