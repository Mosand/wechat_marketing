<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传</title>
</head>
<body>
<form action="goods_uploadGoodsImage" method="post" enctype="multipart/form-data">
     文件名：<input type="text" name="filename"/><br/>
     文件：<input type="file" name="file1"/><br/>
     	  
     	  <div class="form-group">
               		 <label for="verifycode" class="col-md-3 control-label"><font face="Microsoft YaHei">验证码：</font></label>
              		  <div class="col-md-6">
                 		  <img src="SecurityCodeImageAction" id="img"  style="cursor:hand;" alt="看不清，换一张"/>
                         <span style="color:red;" id="simg">
                         <s:property value="#request.error2"></s:property>
                          </span>
                          <!-- <a href="javascript:;" onclick="document.getElementById('img').
                           src='checkcode?'+new Date().getTime();"><span style="font-size:12px;">看不清，换一张</span></a> -->
                 		  <input type="text" name="securityCode" id="securityCode" placeholder="验证码" />
               		 </div>
          <input type = "hidden" name="goods_id" value="华为手机2019-06-04 17:48:33" ><input type="submit" value="上传文件">
          
 </form>
 
 <a href="${pageContext.request.contextPath }/displayFile">check</a>
          
</body>
</html>