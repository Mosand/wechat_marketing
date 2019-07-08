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
<link href="${webContent}css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="${webContent}css/default/bootstrap-3.3.7.min.css">
<link rel="stylesheet" href="${webContent}css/default/bootstrap-datetimepicker.css">
<link rel="stylesheet" href="${webContent}css/style.css">

<script src="${webContent}jquery/jquery-1.11.2.min.js"></script>
<script src="${webContent}jquery/jquery.form.js"></script>
<script src="${webContent}jquery/bootstrap-3.3.7.min.js"></script>
</head>
<body>     
<div>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">用户地址详情</h4>
            </div>
            <div class="modal-body">
			   <div class="user_img">
				   <img id="preimg" src="${webContent}img/add_product.png" alt="erweima_img"/>
				   <input id="newimg" type="file" name="file1" onchange="previewFile()" /> 　　　 　
			   </div> 
               <div class="form-group">
                   <label for="">用户头像</label>
				   <div class="user_img">		   
					   <img id="avatar_url" src="${webContent}img/add_product.png" alt="user_img"/>　　　 　
				   </div> 
               </div>			     			   
               <div class="form-group">
                   <label for="">用户名称</label>
                   <input class="form-control" type="text" placeholder="" name="username" id="username">
               </div>		         
               <div class="form-group">
                   <label for="">商品</label>
                   <input class="form-control" type="text" placeholder="" name="goods_name" id="goods_name">
               </div> 
               <div class="form-group">
                   <label for="">交易类型</label>
                   <input class="form-control" type="text" placeholder="" name="direction" id="direction">
               </div>                
               <div class="form-group">
                   <label for="">交易金额</label>
			   	   <textarea class="form-control" rows="1" id="spendtext"></textarea>
               </div>                      
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>