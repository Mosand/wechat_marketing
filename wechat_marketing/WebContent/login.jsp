<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登陆</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="js/ie6Fixpng.js"></script>
<![endif]-->
<script type="text/javascript">

   window.onload=function(){
 
   document.getElementById("img").onclick=function(){
   this.src="SecurityCodeImageAction?timestamp="+new Date().getTime();
   
    };
    
};
</script>
</head>

<body>
<div class="headerBar">
	<div class="logoBar login_logo">
		<div class="comWidth">
			<div class="logo fl">
				<a href="#"><img src="${pageContext.request.contextPath }/images/logo.jpg" alt="慕课网"></a>
			</div>
			<h3 class="welcome_title">欢迎登陆</h3>
		</div>
	</div>
</div>
<form action="manager_login" class="form-horizontal" id="registform" method="post" onsubmit="return isValid()">
         		   <div class="form-group">
           		     <label class="text-info text-align:center col-md-7 control-label"><h2><font face="Microsoft YaHei">用户登录</font></h2></label>
           		 </div>
           			 <div class="form-group">
               		 <label for="username" class="col-md-3 control-label"><font face="Microsoft YaHei">用户名：</font></label>
               		 <div class="col-md-7">
                 		  <input type="text" class="form-control" id="mananame" name="mananame" placeholder="用户名">
              		  </div>
              		  
          		  </div>
          		  <div class="form-group">
               		 <label for="pwd" class="col-md-3 control-label"><font face="Microsoft YaHei">登录密码：</font></label>
              		  <div class="col-md-7">
                 		  <input type="password" class="form-control" id="password" name="password" placeholder="登录密码">
               		 </div>
           		 </div>
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
               		 <a href="">忘记用户名/密码？</a>
           		 </div>
            		 <div class="form-group">
               		 	<label  class="text-danger col-md-8 control-label"><font face="Microsoft YaHei">${msg }</font></label>
           		 	</div>
            		 <div class="form-group">
             		  		 	<div class="col-md-4 col-md-offset-5">
                		 		  <button type="submit" class="btn btn-success"  ><font face="Microsoft YaHei">登录</font></button>    	  
               				 	</div>
           				 </div>
           				 
           			
        		 </form>
<div class="hr_25"></div>
<div class="footer">
	<p><a href="#">慕课简介</a><i>|</i><a href="#">慕课公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234</p>
	<p>Copyright &copy; 2006 - 2014 慕课版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p>
	<p class="web"><a href="#"><img src="${pageContext.request.contextPath }/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath }/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath }/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath }/images/webLogo.jpg" alt="logo"></a></p>
</div>
</body>
</html>
