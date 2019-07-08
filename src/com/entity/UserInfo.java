package com.entity;

/*
 * param����
 * id1:����ʶ����
 * id2����һ���ĸ���ʶ����
 * id3��id2��һ���ĸ���ʶ����
 * id4��id3��һ���ĸ���ʶ����
 * id5��id4��һ���ĸ���ʶ����
 * id6��id5��һ���ĸ���ʶ����
 * id7��id6��һ���ĸ���ʶ����
 * username��id1���û���
 * avatar_url:id1���û�ͷ��
 * erweima��id1�Ķ�ά��ͼƬ��ַ
 */
public class UserInfo {

	private String id1;
	private String id2;
	private String id3;
	private String id4;
	private String id5;
	private String id6;
	private String id7;
	private String erweima;
	private String username;
	private String avatar_url;
	private String erweimaFormat;
	
	public UserInfo(){
		
	}
	
	public UserInfo(String id1,String id2,String id3,String id4,String id5,String id6,String id7,String erweima,String username,String avatar_url,String erweimaFormat){
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.id3 = id3;
		this.id4 = id4;
		this.id5 = id5;
		this.id6 = id6;
		this.id7 = id7;
		this.erweima = erweima;
		this.username = username;
		this.avatar_url = avatar_url;
		this.erweimaFormat = erweimaFormat;
		
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getErweimaFormat() {
		return erweimaFormat;
	}

	public void setErweimaFormat(String erweimaFormat) {
		this.erweimaFormat = erweimaFormat;
	}
	
	
}
