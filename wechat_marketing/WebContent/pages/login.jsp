<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String webContent = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("webContent", webContent);
%>
<!DOCTYPE html>
<html>
<head>
<title>多级分销系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="product" />

   <style>
        * { margin: 0; padding: 0; }
        html { height: 100%; }
        body { height: 100%; background: #fff url(${webContent}img/backgroud.png) 50% 50% no-repeat; background-size: cover;}
        .dowebok { position: absolute; left: 50%; top: 50%; width: 430px; height: 550px; margin: -300px 0 0 -215px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(${webContent}img/login.png) 0 0 no-repeat; }
        .form-item { position: relative; width: 360px; margin: 0 auto; padding-bottom: 30px;}
        .form-item input { width: 288px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .form-item button { width: 360px; height: 50px; border: 0; border-radius: 25px; font-size: 18px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }
        #mananame { background: url(${webContent}img/man.png) 20px 14px no-repeat; }
        #password { background: url(${webContent}img/password.png) 23px 11px no-repeat; }
        #securityCode { background: url(${webContent}img/securityCode.png) 23px 11px no-repeat; }        
        .reg-bar { width: 360px; margin: 20px auto 0; font-size: 14px; overflow: hidden;}
        .reg-bar a { color: #fff; text-decoration: none; }
        .reg-bar a:hover { text-decoration: underline; }
        .reg-bar .reg { float: left; }
        .reg-bar .forget { float: right; }
        .dowebok ::-webkit-input-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok :-moz-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok ::-moz-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok :-ms-input-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .testCode{
        }
        
        @media screen and (max-width: 500px) {
            * { box-sizing: border-box; }
            .dowebok { position: static; width: auto; height: auto; margin: 0 30px; border: 0; border-radius: 0; }
            .logo { margin: 50px auto; }
            .form-item { width: auto; }
            .form-item input, .form-item button, .reg-bar { width: 100%; }
        }
    </style>
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="js/ie6Fixpng.js"></script>
<![endif]-->
<script src="${webContent}jquery/jquery-1.11.2.min.js"></script>

</head>
<body>

<script src="${webContent}jquery/jquery.form.js"></script> 
<script type="text/javascript">
$(document).ready(function() {  
	
	$('#registform').ajaxForm(function(item) 
			{
		 		if (item=="UsernameOrPasswordError"){alert("用户名或密码错误！");}
		 		else(item=="codeError"){alert("验证码错误！");}	
			})
	})

</script>
<script type="text/javascript">

   window.onload=function(){
 
   document.getElementById("img").onclick=function(){
   this.src="SecurityCodeImageAction?timestamp="+new Date().getTime();
   
    };
    
};
</script>
<form action="manager_login" id="registform" method="post" onsubmit="return isValid()">
<div class="dowebok">
       <div class="logo"></div>
        <div class="form-item">
            <input type="text" id="mananame" autocomplete="off" name="mananame" placeholder="用户名"/>        
        </div>
        <div class="form-item">
            <input type="password" autocomplete="off" id="password" name="password" placeholder="登录密码">
        </div>
        <div class="form-item">
       		  <div class="col-md-6">
          		  <img src="SecurityCodeImageAction" id="img"  style="cursor:hand;height:50px;width:120px;" alt="看不清，换一张"/>
                  <span style="color:red;" id="simg">
                  <s:property value="#request.error2"></s:property>
                   </span>
          		       <input style="width:120px;float:right;" type="text" name="securityCode" id="securityCode" placeholder="验证码" />			              		  
        	  </div>
    	</div>        
        <div class="form-item"><button id="submit">登 录</button></div>
</div>
</form>
    

</body>
</html>