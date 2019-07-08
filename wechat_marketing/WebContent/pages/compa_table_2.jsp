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
<style>
div{top:4px;!important}
</style>

<link href="${webContent}css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="${webContent}css/default/bootstrap-3.3.7.min.css">
<link rel="stylesheet" href="${webContent}css/default/bootstrap-datetimepicker.css">
<link rel="stylesheet" href="${webContent}css/style.css">
<link rel="stylesheet" href="${webContent}css/pagination.css"/>

<script src="${webContent}jquery/jquery-1.11.2.min.js"></script>
<script src="${webContent}jquery/jquery.form.js"></script>
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
	  <li><a href="userincome_findAll">用户管理</a></li>
	  <li class="selected"><a href="transaction_compaPublic" style="color: #333;">公司报表</a></li>
	</ul>
</div>
<!--end leftnav-->


<script type="text/javascript" src="${webContent}js/jquery.pagination.js"></script>
<script type="text/javascript">
// 点击分页按钮以后触发的动作
function handlePaginationClick(new_page_index, pagination_container) {
	$("#proForm").attr("action", "<%=path %>/purchase_findAll2.action?pageNum=" + (new_page_index +1));
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
	$("#datetime").val("${datetime}");	
});
</script>

<div class="panelfix">

	<ul class="nav nav-tabs">
	    <li>
	        <a href="transaction_compaPublic">
	           公司报表
	        </a>
	    </li>
	    <li class="active"><a href="#">收入详情</a></li>
	    <li><a href="transaction_findAll">支出详情</a></li>	    
	
	</ul>
	
    
    <div class="product_expenditure tab-pane fade in active">
   		<form action="<%=path%>/purchase_findAll.action" id="proForm" method="post" class="navbar-form navbar-left"> 
		      <div class="form-group">
		      	  <span>用户名称</span>
		          <input type="text" class="form-control" name="username" id="username">
		      </div>
		      
		      <div class="form-group">
		      	 <span>时间</span>			      
		         <input class="datetime" type="text" id="datetime" readonly class="form_datetime form-control" name="time" />
		      </div>		      
		      <button type="submit" class="btn btn-default" >查询</button>
		    </form>	    		    

	<c:if test="${fn:length(dataList) gt 0 }"> 			    
			<table class="table table-hover">
			  <thead>
				<tr>						
					<th>用户名称</th>						
					<th>购买时间</th>
					<th>购买商品</th>
					<th>购买数量</th>
					<th>总价</th>																
				</tr>
			  </thead>
			<tbody>
				<c:forEach items="${dataList}" var="p">
					<tr>
						
						<td><c:out value="${p.username }"></c:out></td>
						<td><c:out value="${p.time }"></c:out></td>
						<td><c:out value="${p.goods_name }"></c:out></td>						
						<td><c:out value="${p.buy_num }"></c:out></td>						
						<td><c:out value="${p.spend }"></c:out></td>											
					</tr>
				</c:forEach>
			</tbody>	
		</table>
<br/> 
			<div id="News-Pagination"></div>
    </c:if>	
    			
    </div>
<!-- end product_revenue -->
	
</div>
<!-- end main_panel-->

<script src="${webContent}jquery/bootstrap-datetimepicker.js"></script>          
<script type="text/javascript">
$("#datetime").datetimepicker({
    format: 'yyyy-mm-dd',
    minView:'month',
    autoclose:true,
});	

</script> 

</body>
</html>