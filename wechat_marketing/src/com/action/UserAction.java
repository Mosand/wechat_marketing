package com.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.GoodsInfo;
import com.entity.Purchase;
import com.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.service.GoodsService;
import com.service.UserService;

public class UserAction {

	private String id1;
	private String username;
	private String id2;
	private String id3;
	private String id4;
	private String id5;
	private String id6;
	private String id7;
	private String erweima;
	private String avatar_url;
	
	private UserService userService;
	private GoodsService goodsService;
	private List<Purchase> lists = new ArrayList<Purchase>();
	private List<UserInfo> lists2 = new ArrayList<UserInfo>();
	private InputStream inputStream;

	private File file1;
	//��ǰ�ϴ����ļ���
	private String file1FileName;
	//�ļ�����(MIME)
	@SuppressWarnings("unused")
	private String file1ContentType;
	
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	   }		
	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getId3() {
		return id3;
	}

	public void setId3(String id3) {
		this.id3 = id3;
	}

	public String getId4() {
		return id4;
	}

	public void setId4(String id4) {
		this.id4 = id4;
	}

	public String getId5() {
		return id5;
	}

	public void setId5(String id5) {
		this.id5 = id5;
	}

	public String getId6() {
		return id6;
	}

	public void setId6(String id6) {
		this.id6 = id6;
	}

	public String getId7() {
		return id7;
	}

	public void setId7(String id7) {
		this.id7 = id7;
	}

	public String getErweima() {
		return erweima;
	}

	public void setErweima(String erweima) {
		this.erweima = erweima;
	}
	
	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Purchase> getLists() {
		return lists;
	}

	public void setLists(List<Purchase> lists) {
		this.lists = lists;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public GoodsService getGoodsService() {
		return goodsService;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	public List<UserInfo> getLists2() {
		return lists2;
	}
	public void setLists2(List<UserInfo> lists2) {
		this.lists2 = lists2;
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
	
	public String findNextDeal() throws UnsupportedEncodingException{//���������¼��������
		
		System.out.println("action.findNextDeal����ִ��");
		
		String result = userService.findDeal(id1,id2);
		if(result == com.service.impl.UserServiceImpl.SUCCESS){
			lists = userService.findAllNextDeal(id1,id2);
			ActionContext.getContext().put("user_id", id2);
			ActionContext.getContext().put("user_name", username);
			System.out.println("lists"+lists);
			return "findSuccess";
		}else if(result == com.service.impl.UserServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("findfail"  
                    .getBytes("UTF-8")); 
			System.out.println("��ѯ����ʧ�ܣ�û�д˶���");
			return "findFail";
		}
		return null;
	}
	
	//��ά���ǵ�ַ��������ͼƬ������Ʒ�ϴ����ƣ������ϴ��Ͳ鿴
	public String saveErweima() throws IOException{
		
		System.out.println("action.saveErweima����ִ��");
		String path="WebContent/avatar_image";
	    String target=ServletActionContext.getServletContext().getRealPath(path);
	    if(file1FileName != null){	    	
	    	UserInfo userInfo = new UserInfo();
	    	//String prefix=file1FileName.substring(file1FileName.lastIndexOf(".")+1);//��ȡͼƬ��׺
	    	//String goodsid = String.valueOf(goods_id);	    	
	    	//file1FileName = file1FileName.replaceFirst(file1FileName, goodsid+"."+prefix);//��goods_id+��׺����ͼƬ����
	    	File destFile=new File(target,file1FileName); 	
		    System.out.println("destFile:"+destFile);
		    //���ϴ����ļ���������Ŀ���ļ���
		    FileUtils.copyFile(file1, destFile);		
		    erweima=destFile.getPath();
			System.out.println("erweima:"+erweima);
			userInfo.setErweima(erweima);
	    }
	    if(file1FileName == null){
	    	File destFile=new File(target,"demo.png");
	    	//FileUtils.copyFile(file1, destFile);
	    	UserInfo userInfo = new UserInfo();
	    	erweima=destFile.getPath();
			System.out.println("erweima:"+erweima);
			userInfo.setErweima(erweima);
	    }
		String result = userService.saveErweima(id1,erweima);
		if(result == com.service.impl.UserServiceImpl.SUCCESS){
			inputStream = new ByteArrayInputStream("saveSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("save ��ά��ɹ�");
			return "saveSuccess";
		}else if(result == com.service.impl.UserServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("saveFail"  
                    .getBytes("UTF-8")); 
			System.out.println("save ��ά��ʧ��");
			return "saveFail";
		}
		return null;
	}
	
	public String findErweima() throws UnsupportedEncodingException{
		System.out.println("action.saveErweima����ִ��");
		
		String result = userService.findErweima(id1);
		//String result2 = userService.findUsernameAvatar(id1);
		//String result3 = userService.findGoodsName(goods_id);
		if(result == com.service.impl.UserServiceImpl.SUCCESS){
			lists2 = userService.searchErweima(id1);
//			inputStream = new ByteArrayInputStream(erweima 
//                    .getBytes("UTF-8")); 
//			System.out.println("��ѯ ��ά��ɹ�");
			return "findErSuccess";
		}else if(result == com.service.impl.UserServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("saveErFail"  
                    .getBytes("UTF-8")); 
			System.out.println(" ��ά��ʧ��");
			return "findErFail";
		}
		return null;
	}
	
	
	//�û�id1,������ͷ��Ĵ�ȡ��
	public String saveId1andUsernameandAvatar() throws UnsupportedEncodingException {
		System.out.println("action.saveUsernameandAvatar����ִ��");
		String result = userService.saveInfo(id1,username,avatar_url);
		if(result == com.service.impl.UserServiceImpl.SUCCESS){
			inputStream = new ByteArrayInputStream("saveUSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("save�û���Ϣ�ɹ�");
			return "saveInfoSuccess";
		}else if(result == com.service.impl.UserServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("saveUFail"  
                    .getBytes("UTF-8")); 
			System.out.println("save�û���Ϣʧ��");
			return "saveInfoFail";
		}
		return null;
		
	}
	
	//user_info�������Ϣ���߲���롣
	public String updateUser() throws UnsupportedEncodingException{//ɨ��ʱ����ô˷�������id1��id2-id7
		System.out.println("action.saveUsernameandAvatar����ִ��");
		String result = userService.updateUser(id1,id2);
		if(result == com.service.impl.UserServiceImpl.SUCCESS){
			inputStream = new ByteArrayInputStream("updateUserSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("update�û���Ϣ�ɹ�");
			return "updateUserSuccess";
		}else if(result == com.service.impl.UserServiceImpl.FAIL){
			inputStream = new ByteArrayInputStream("updateUserFail"  
                    .getBytes("UTF-8")); 
			System.out.println("save�û���Ϣʧ��");
			return "updateUserFail";
		}
		return null;
	}
	
}
