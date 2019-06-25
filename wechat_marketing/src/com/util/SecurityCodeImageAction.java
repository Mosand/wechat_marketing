package com.util;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SecurityCodeImageAction extends ActionSupport implements
SessionAware {
private Map<String,Object> session;
private ByteArrayInputStream imageStream;
private String timestamp;//得到时间戳

public String getTimestamp() {
	return timestamp;
}

public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
}

@Override
public String execute() throws Exception{

imageStream = SecurityCode.getImageAsInputStream();
String securityCode = SecurityCode.checkstring;
session.put("checkstring", securityCode);

return SUCCESS;
}

public ByteArrayInputStream getImageStream() {
return imageStream;
}

public void setImageStream(ByteArrayInputStream imageStream) {
this.imageStream = imageStream;
}

public Map<String, Object> getSession() {
return session;
}

@Override
public void setSession(Map<String, Object> session) {
// TODO Auto-generated method stub
this.session = session;
}

}
