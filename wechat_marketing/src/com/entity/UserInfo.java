package com.entity;

/*
 * param解释
 * id1:个人识别码
 * id2：下一级的个人识别码
 * id3：id2下一级的个人识别码
 * id4：id3下一级的个人识别码
 * id5：id4下一级的个人识别码
 * id6：id5下一级的个人识别码
 * id7：id6下一级的个人识别码
 * username：id1的用户名
 * avatar_url:id1的用户头像
 * erweima：id1的二维码图片地址
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
