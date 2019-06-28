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
	
	//����ǰ�˵�JSON�ַ�������Ҫ�ṩget/set����
    private String responseStr; 

    public String getResponseStr() {
        return responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }
	// ��ǰҳ��
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	private InputStream inputStream; //������ֺ�struts.xml�ж�Ӧ������д��  
	  
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

	//�����������д��
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
        System.out.println("��ͳ��ajax");
        HttpServletResponse response = ServletActionContext.getResponse();
        try {
            PrintWriter out = response.getWriter();
            out.println("{\"success\":\"true\",\"type\":\"succ\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
    public String saveDealNum() throws UnsupportedEncodingException{ //����id1��ʱ��������ˮ��
    	System.out.println("action.saveDealNum����ִ��");
    	Purchase purchase = new Purchase();
    	Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//ʱ���ʽ��
		String time1=format.format(date);
		time = time1.toString();
		purchase.setTime(time);

		List<Address> list = new ArrayList<Address>();//����id1��ѯaddress����address��id����ΪaddressID
		String result1 = addressService.findAddress(id1);
		if(result1 == null){
			return null;
		}else if(result1 == com.service.impl.AddressServiceImpl.SUCCESS){
			list = addressService.findOneAddress(id1);
			addressID = list.get(0).getAddressID();//����id1��ѯaddress����address��id����ΪaddressID
			System.out.println("lists"+lists);		
		}else if(result1 == com.service.impl.AddressServiceImpl.FAIL){
			return null;
		}
		String result = purchaseService.saveDeal(id1,username,goods_id,goods_name,buy_num,spend,time,state,avatar_url,imgFormat,deal_num,addressID);
		if(result.equals(com.service.impl.PurchaseServiceImpl.SUCCESS)){
			 inputStream = new ByteArrayInputStream("success"  
	                    .getBytes("UTF-8"));
			 ActionContext.getContext().put("user_id", id1);
			System.out.println("����deal_num�ɹ�");
			return "iSuccess";
		}else if(result.equals(com.service.impl.PurchaseServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("fail"  
                    .getBytes("UTF-8")); 
			System.out.println("����deal_numʧ��");
			return "iFail";
		}
		
		return null;
    }
    
	public String findDeal() throws UnsupportedEncodingException{//����id1����ѯid1��ȫ������
		System.out.println("action.findDeal����ִ��");
		String result = purchaseService.findDeal(id1);
		if(result == com.service.impl.PurchaseServiceImpl.SUCCESS){
			lists = purchaseService.findOneDeal(id1);
			System.out.println("lists"+lists);
			ActionContext.getContext().put("user_id", id1);
			return "findSuccess";
		}else if(result == com.service.impl.PurchaseServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("findfail"  
                    .getBytes("UTF-8")); 
			System.out.println("��ѯ����ʧ�ܣ�û�д˶���");
			return "findFail";
		}
		return null;
		
	}

	public String changeState() throws UnsupportedEncodingException{
		System.out.println("action.changeState����ִ��");
    	String result = purchaseService.changeState(state,deal_num);
    	if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){
			System.out.println("����״̬���³ɹ�");
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			System.out.println("����״̬����ʧ��");
		}
    	String result2 = userIncomeService.saveUserIncome(id1,goods_id,ticheng,market_price,reward,admin,username,deal_num,avatar_url,goods_name);//ֻ����deal_num�����ˣ���goods_id��Ӧ����ɵȴ���userincome
		if(result2 == com.service.impl.UserIncomeServiceImpl.SUCCESS){//��id1��Ӧ��purchase ��username ����userincome
			inputStream = new ByteArrayInputStream("saveSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("save�û�����ɹ�");
			return "saveSuccess";
		}else if(result2 == com.service.impl.UserIncomeServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("saveFail"  
                    .getBytes("UTF-8")); 
			System.out.println("save�û�����ʧ��");
			return "saveFail";
    	
	}
    	
		return null;
}
    //�����еĽ��׼�¼
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
		// ʹ�õ���ģ������������Ϣ����ֵջ�У�����ʹ��OGNL���ʽ��ȡ
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findSuccess";
	}
	
	//������õ����ַ�ҳ����
	 public String findAll() {
	        System.out.println("��������������");
	        // ʹ��struts2��servlet�ӿڣ�����request��Ĳ���
	        // ��Ʒ���ֲ���
	        HttpServletRequest request = ServletActionContext.getRequest();
	        String username = request.getParameter("username");
	       
	        String time = request.getParameter("time");


	        // У��pageNum��������Ϸ���
	        String pageNumStr = request.getParameter("pageNum");
	        System.out.println("ǰ�˸���pageNum�ǣ�"+pageNumStr);

	        int pageNum = 1; // Ĭ����ʾ�ڼ�ҳ����
	        if (pageNumStr != null && !"".equals(pageNumStr.trim())) {
	            pageNum = Integer.parseInt(pageNumStr);
	        }

	        int pageSize = 5; // Ĭ��ÿҳ��ʾ��������¼
	        String pageSizeStr = request.getParameter("pageSize");
	        if (pageSizeStr != null && !"".equals(pageSizeStr.trim())) {
	            pageSize = Integer.parseInt(pageSizeStr);
	        }

	        // ��װģ����ѯ����
	        Purchase searchModel = new Purchase();
	        searchModel.setUsername(username);
	        searchModel.setTime(time);
	        System.out.println("==============Product����==============");
	        System.out.println(searchModel);
	        // ����service ��ȡ��ѯ���
	        Pager<Purchase> result = purchaseService.findByPage2(searchModel, pageNum, pageSize);

	        // ��pageBean����ֵջ����ǰ��ҳ���ȡ        
	        ActionContext.getContext().getValueStack().push(result);
	        // ����ѯ����Ҳѹ��ֵջ���ڳ�ʼ��������Ϊ���ʼ��
	        ActionContext.getContext().getValueStack().push(searchModel);
	        System.out.println("==============Pager����==============");
	        System.out.println(result);
	        System.out.println("�������������");
	        return "findAll";
	    }
	
	//��ʽ����Ajax+JSON
    public String findAllJSON() {
        // ʹ��struts2��servlet�ӿڣ�����request��Ĳ���
        // ��Ʒ���ֲ���
    	
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession seesion = request.getSession();
        HttpServletResponse response = ServletActionContext.getResponse();
        String username = request.getParameter("username");
        
        String time = request.getParameter("time");
   
        // ȡ��ҳ������
        String pageNumStr = request.getParameter("pageNum");


        int pageNum = 1; // Ĭ����ʾ�ڼ�ҳ����
        if (pageNumStr != null && !"".equals(pageNumStr.trim())) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        int pageSize = 5; // Ĭ��ÿҳ��ʾ��������¼
        String pageSizeStr = request.getParameter("pageSize");
        if (pageSizeStr != null && !"".equals(pageSizeStr.trim())) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // ��װģ����ѯ����
        Purchase searchModel = new Purchase();
        searchModel.setUsername(username);
        searchModel.setTime(time);
        // ����service ��ȡ��ѯ���
        Pager<Purchase> result = purchaseService.findByPage2(searchModel, pageNum, pageSize);
        // ����ѯ�����װ��JSON�ַ�����ʽ    
        responseStr = JSONObject.toJSONString(result);
        System.out.println(responseStr);
        // ����response���󴫻�ǰ��
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
