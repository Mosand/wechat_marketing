package com.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.GoodsInfo;
import com.entity.PageBean;
import com.entity.Pager;
import com.entity.Purchase;
import com.entity.UserIncome;
import com.entity.UserIncome2;
import com.entity.UserInfo;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.service.GoodsService;
import com.service.PurchaseService;
import com.service.UserIncomeService;
import com.service.UserService;

public class UserIncomeAction {

	
	private int id;
	private String id1;
	private int goods_id;
	private float ticheng;
	private float market_price;
	private float reward;
	private float admin;
	private String username;
	private String deal_num;
	private String avatar_url;
	private String goods_name;
	private String user_name;
	
	private UserIncomeService userIncomeService;
	private GoodsService goodsService;
	private UserService userService;
	private PurchaseService purchaseService;
	
	private List<GoodsInfo> lists = new ArrayList<GoodsInfo>();
	private List<UserInfo> lists2 = new ArrayList<UserInfo>();
	private List<Object> lists3 = new ArrayList<>();
	private InputStream inputStream;
	
	// 当前页数
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
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

	public PurchaseService getPurchaseService() {
		return purchaseService;
	}

	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<GoodsInfo> getLists() {
		return lists;
	}

	public void setLists(List<GoodsInfo> lists) {
		this.lists = lists;
	}

	public List<UserInfo> getLists2() {
		return lists2;
	}

	public void setLists2(List<UserInfo> lists2) {
		this.lists2 = lists2;
	}
	
	public List<Object> getLists3() {
		return lists3;
	}

	public void setLists3(List<Object> lists3) {
		this.lists3 = lists3;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	
	public String saveUserIncome() throws UnsupportedEncodingException{
		
		System.out.println("action.saveIncome方法执行");
		String result = userIncomeService.saveUserIncome(id1,goods_id,ticheng,market_price,reward,admin,username,deal_num,avatar_url,goods_name);
		if(result == com.service.impl.UserIncomeServiceImpl.SUCCESS){
			inputStream = new ByteArrayInputStream("saveUSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("save用户收入成功");
			return "saveUserIncomeSuccess";
		}else if(result == com.service.impl.UserIncomeServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("saveUFail"  
                    .getBytes("UTF-8")); 
			System.out.println("save用户收入失败");
			return "saveUserIncomeFail";
		}
		return null;
	}
	
	public String findErweima() throws UnsupportedEncodingException{
		System.out.println("action.findErweima方法执行");
		
		String result = userService.findErweima(id1);//从user_info表里查erweima,username和avatar_url			
		//从goods_info表里查goods_name
		if(result == com.service.impl.UserServiceImpl.SUCCESS){
			//w我返回给前端的数据，这些内容都有
			System.out.println("goods_id:"+goods_id);
			String result2 = goodsService.searchItem(goods_id);
			System.out.println("id1:"+id1);
			lists2 = userService.searchErweima(id1);			
			System.out.println("查询 二维码成功");
			if(result2.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
				lists = goodsService.findItem(goods_id);
				Gson gson = new Gson();
				//查看json格式
				lists3.addAll(lists2);
				lists3.addAll(lists);//将查询的数据，userinfo 的list2 和goods_info 的list 合并传入前端
				System.out.println("lists3:"+gson.toJson(lists3));
				return "findErSuccess";
			}else if(result2.equals(com.service.impl.GoodsServiceImpl.FAIL)){
				inputStream = new ByteArrayInputStream("fail"  
	                    .getBytes("UTF-8")); 				
			}
		}else if(result == com.service.impl.UserServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("fail"  
                    .getBytes("UTF-8")); 
			System.out.println("查询二维码失败");
			return "findErFail";
			
		}
					
		return null;
	}

	public String findAllIncome() throws UnsupportedEncodingException{
		
		System.out.println("action.findUserIncome方法执行");
		
		PageBean<Object> pageBean = userIncomeService.findByPage(currPage);
		
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findAll2";
		
	}
	
	public String findIncomeByName(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		//String time = request.getParameter("time");
		UserIncome searchModel = new UserIncome();
		searchModel.setUsername(username);
		
		//searchModel.setTime(time);
		PageBean<Object> pageBean = userIncomeService.findByPage(searchModel,currPage);
		System.out.println("service running");
		if(pageBean == null){
			return "findFail";
		}
		// 使用的是模型驱动，把信息放入值栈中，可以使用OGNL表达式获取
		ActionContext.getContext().getValueStack().push(pageBean);
		//把查询条件压入值栈
		ActionContext.getContext().getValueStack().push(searchModel);
		return "findSuccess";
	}
	
	//最后我用的这种分页方法
		 public String findAll() {
		        System.out.println("控制器方法启动");
		        // 使用struts2的servlet接口，接收request里的参数
		        // 商品名字参数
		        HttpServletRequest request = ServletActionContext.getRequest();
		        String username = request.getParameter("username");		   
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
		        UserIncome searchModel = new UserIncome();
		        searchModel.setUsername(username);		     
		        System.out.println("==============Userincome对象==============");
		        System.out.println(searchModel);
		        // 调用service 获取查询结果
		        Pager<Object> result = userIncomeService.findByPage2(searchModel, pageNum, pageSize);

		        // 将pageBean存入值栈，供前端页面读取        
		        ActionContext.getContext().getValueStack().push(result);
		        // 将查询条件也压回值栈，在初始化函数中为其初始化
		        ActionContext.getContext().getValueStack().push(searchModel);
		        System.out.println("==============Pager对象==============");
		        System.out.println(result);
		        System.out.println("username:"+username);
		        System.out.println("控制器方法完成");
		        HttpServletRequest request2 = ServletActionContext.getRequest();
	        	request2.setAttribute("public_name",ManagerAction.public_name);
		        return "findAll";
		    }	
	
}