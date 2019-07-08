<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet" href="${webContent}css/default/bootstrap-3.3.7.min.css"/>
<link rel="stylesheet" href="${webContent}css/default/bootstrap-datetimepicker.css"/>
<link rel="stylesheet" href="${webContent}css/style.css"/>
<link rel="stylesheet" href="${webContent}css/pagination.css"/>

<script src="${webContent}jquery/jquery-1.11.2.min.js"></script>
<script src="${webContent}jquery/bootstrap-3.3.7.min.js"></script>
</head>
<body> 

<!-- 登录接口 -->

<div class="login_icon">
      <ul class="nav navbar-nav navbar-right"> 
          <li><a href="${webContent}pages/login.jsp"><img src="${webContent}img/icon/main_man.png" />&nbsp;&nbsp;<%=request.getAttribute("public_name")%></a></li>
      </ul> 
</div>
<div class="clear"></div>
<!-- end header -->

<div class="leftnav">
	<ul class="nav nav-pills nav-stacked">
	  <li><a href="goods_mainPublicName">产品管理</a></li>
	  <li class="selected"><a href="#" style="color: #333;">用户管理</a></li>
	  <li><a href="transaction_compaPublic">公司报表</a></li>
	</ul>
</div>
<!--end leftnav-->
<script type="text/javascript" src="${webContent}js/jquery.pagination.js"></script>
<script type="text/javascript">  
// 点击分页按钮以后触发的动作
function handlePaginationClick(new_page_index, pagination_container) {
	$("#proForm").attr("action", "<%=path %>/userincome_findAll.action?pageNum=" + (new_page_index +1));
	$("#proForm").submit();
	return false;
}

//初始化函数
$(function(){
	$("#News-Pagination").pagination(${totalRecord}, {
        items_per_page:${pageSize}, // 每页显示多少条记录
        current_page:${currentPage} - 1, // 当前显示第几页数据
        num_display_entries:2, // 连续分页主体显示的条目数
        next_text:"下一页",
        prev_text:"上一页",
        num_edge_entries:2, // 连接分页主体，显示的条目数
        callback:handlePaginationClick, //执行的回调函数，也就是去获取新的分页数据
        load_first_page:false //防止页面一直刷新( 这条非常重要！)        
	});	
	// 初始化时就获得后台发过来的前一次的查询参数
	$("#username").val("${username}");	
});
</script>

<div class="panelfix">

	<ul class="nav nav-tabs">
	    <li class="active">
	        <a href="#">
	            费用明细
	        </a>
	    </li>
	    <li><a href="purchase_findAll">收款查询</a></li>
	
	</ul>
	
    <div class="tab-pane fade in active product_expenditure">
		    <form action="<%=path%>/userincome_findAll.action" id="proForm" method="post" class="navbar-form navbar-left">
		      <div class="form-group">
		      	  <span>用户名称</span>
		          <input type="text" class="form-control" name="username" id="username">
		      </div>		      		      
		      <button type="submit" class="btn btn-default" id="precheck">查询</button>
		    </form>	
		    	        
	<c:if test="${fn:length(dataList) gt 0 }">		    
 			<table class="table table-hover">
			  <thead>
				<tr>						
					<th>用户名称</th>						
					<th>商品名</th>
					<th>应得提成费</th>		
					<th>已得提成费</th>						
					<th>应得市场费</th>	
					<th>已得市场费</th>						
					<th>应得奖金</th>
					<th>已得奖金</th>						
					<th>应得ADMIN</th>
					<th>已得ADMIN</th>					
					<th>查看二维码</th>																				
				</tr>
			  </thead>
			  
			  <c:forEach items="${dataList}" varStatus="i">			   
				<tr>															
					<td><c:out value="${dataList[i.index][1]}"></c:out></td>
					<td><c:out value="${dataList[i.index][8]}"></c:out></td>							
					<td><c:out value="${dataList[i.index][3]}"></c:out></td>
					<td><c:out value="${dataList[i.index][11]}"></c:out></td>
					<td><c:out value="${dataList[i.index][4]}"></c:out></td>
					<td><c:out value="${dataList[i.index][13]}"></c:out></td>
					<td><c:out value="${dataList[i.index][5]}"></c:out></td>																									
					<td><c:out value="${dataList[i.index][15]}"></c:out></td>
					<td><c:out value="${dataList[i.index][6]}"></c:out></td>
					<td><c:out value="${dataList[i.index][17]}"></c:out></td>
					<td><a onclick="userincome_findErweima('<c:out value="${dataList[i.index][9]}"></c:out>'+'',''+'<c:out value="${dataList[i.index][0]}"></c:out>'+'',''+'<c:out value="${dataList[i.index][2]}"></c:out>')"><img src="${webContent}img/icon/img_view.png" data-toggle="tooltip" title="查看二维码" class="viewimg"/></a></td> 
				</tr>
			  </c:forEach>		  
			</table>		
			<br> 
			<div id="News-Pagination"></div>
	</c:if>									
	   </div>
<!-- end expenditure -->	    
	
</div>
<!-- end main_panel-->
<form action="transaction_saveTransaction" class="modal fade" id="deal_content" tabindex="-1" role="dialog" aria-hidden="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">交易详情</h4>
            </div>
            <div class="modal-body">
			   <div class="product_img">
				   <img id="preimg" src="${webContent}img/none.png" alt="erweima_img"/>　
				   <!-- <input id="selectimg" type="file" name="file1" onchange="previewFile0()" /> --> 				   　 　
			   </div>   	
			   <input type="hidden" name="goods_id" id="goods_id"/>	
				   <input type="hidden" name="user_name" value="<%=request.getAttribute("user_name")%>"/>		   
			   <input type="hidden" name="id1" id="id1"/>				   		      
               <div class="form-group">
                   <label for="">用户名称</label>
                   <input class="form-control" type="text" placeholder="" name="username" id="username1">
               </div>		         
               <div class="form-group">
                   <label for="">商品</label>
                   <input class="form-control" type="text" placeholder="" name="goods_name" id="goods_name">
               </div> 
               <div class="form-group">
                   <label for="">交易类型</label>
				    <label class="radio-inline">
				        <input type="radio" name="direction" value="提成费" checked> 提成费
				    </label>
				    <label class="radio-inline">
				        <input type="radio" name="direction" value="市场费"> 市场费
				    </label>
				    <label class="radio-inline">
				        <input type="radio" name="direction" value="奖金"> 奖金
				    </label>
				    <label class="radio-inline">
				        <input type="radio" name="direction" value="admin奖金"> admin奖金
				    </label>				    				    
               </div>                
               <div class="form-group">
                   <label for="">交易金额</label>
					<input type="text" class="form-control" name="money">
               </div>                      
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="submit" >提交</button>            
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</form>
<script src="${webContent}jquery/jquery.form.js"></script>
<script src="${webContent}jquery/bootstrap-datetimepicker.js"></script>          
<script type="text/javascript">
$(document).ready(function() {  		          
		$('#deal_content').ajaxForm(function(state) {
		if(state == "saveTransactionSuccess") {
			alert("交易信息已提交！");
			window.location.reload();
		}	
		else{alert(state);}
});     

});
<!--deal_save-->
$("#datetime").datetimepicker({
    format: 'yyyy-mm-dd',
    minView:'month',
    autoclose:true,
});	
<!--datetime-->

function userincome_findErweima(deal_num,id1,goods_id){
	$.post("userincome_findErweima?deal_num="+ deal_num+"&id1="+ id1+"&goods_id="+ goods_id,function(list) {			
		if(list.length != 0) {
			for (var i = 0; i < list.length; i++) {	

				if (list[0].erweimaFormat!=null||""){
			        $('#preimg').attr("src","${webContent}erweima_image/"+list[0].erweimaFormat);
				}
				else{
		        	$('#preimg').attr("src","${webContent}img/none.png");								
				}				
				
	        	$('#username1').attr("value",list[0].username);
	        	console.log(list[0].username);
	        	$('#id1').attr("value",list[0].id1);	        	
	        	$('#goods_name').attr("value",list[1].goods_name);	   
	        	$('#goods_id').attr("value",list[1].goods_id);	        	
	        		
			}
		}        
		$("#deal_content").modal("show");		
	});
}
<!--userincome_findErweima-->
function previewFile0() {
    var preview0=document.getElementById("preimg");
    var file0=document.getElementById("selectimg").files[0];
    // Js内置文件流
    var reader0 = new FileReader();

    // 更新img标签的src属性为图片的本地路径，就可以显示了
    reader0.onloadend = function () {
        preview0.src = reader0.result;
    }

    // 图片文件不空就显示
    if (file0) {
        reader0.readAsDataURL(file0);
    } else {
        // 图片文件是空的
        preview0.src = "${webContent}img/none.png";
    }
}
</script>
<!-- end productItem_add_img_select -->

</script> 
</body>
</html>