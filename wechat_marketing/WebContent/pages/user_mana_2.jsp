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
	  <li class="selected"><a href="userincome_findAll" style="color: #333;">用户管理</a></li>
	  <li><a href="transaction_compaPublic">公司报表</a></li>
	</ul>
</div>
<!--end leftnav-->

<script type="text/javascript" src="${webContent}js/jquery.pagination.js"></script>
<script type="text/javascript">
// 点击分页按钮以后触发的动作
function handlePaginationClick(new_page_index, pagination_container) {
	$("#proForm").attr("action", "<%=path %>/purchase_findAll.action?pageNum=" + (new_page_index +1));
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
	$("#datetime").val("${time}");	
});
</script>

<div class="panelfix">

	<ul class="nav nav-tabs">
	    <li>
	        <a href="userincome_findAll">
	            费用明细
	        </a>
	    </li>
	    <li class="active"><a href="#">收款查询</a></li>
	
	</ul>
	
	    
    <div class="tab-pane fade in active product_expenditure">
   		<form action="<%=path%>/purchase_findAll.action" id="proForm" method="post" class="navbar-form navbar-left"> 
	      <div class="form-group">
	      	  <span>用户名称</span>
	          <input type="text" class="form-control" name="username" id="username">
	      </div>
	      
	      <div class="form-group">
	      	 <span>时间</span>			      
	         <input class="datetime" type="text" id="datetime" readonly class="form_datetime form-control" name="time" />
	      </div>		      
	      <button type="submit" class="btn btn-default" id="precheck">查询</button>
	    </form>	    
	
	<c:if test="${fn:length(dataList) gt 0 }">    
		<table class="table table-hover">
		  <thead>
			<tr>						
				<th>用户名称</th>						
				<th>购买商品</th>
				<th>总价</th>
				<th>状态</th>
				<th>时间</th>
				<th>操作</th>																
			</tr>
		  </thead>
			<tbody>
				<c:forEach items="${dataList}" var="p">
					<tr>
						
						<td><c:out value="${p.username }"></c:out></td>
						<td><c:out value="${p.goods_name }"></c:out></td>
						<td><c:out value="${p.spend }"></c:out></td>
<c:if test="${p.state==1}"><td><c:out value="已确认"></c:out></td>	</c:if>	
<c:if test="${p.state==0}"><td><c:out value="未确认"></c:out></td>	</c:if>													
	<%-- 					<td><c:out value="${p.state }"></c:out></td>	 --%>					
						<td><c:out value="${p.time }"></c:out></td>
						<td><a onclick="viewAddress('<c:out value="${p.deal_num}"></c:out>')"><img class="viewimg" src="${webContent}img/icon/img_view.png" data-toggle="tooltip" title="查看收货地址" /></a> <a onclick="sureGoods('<c:out value="${p.deal_num }"></c:out>'+'',''+'<c:out value="${p.state }"></c:out>')"><img src="${webContent}img/icon/img_sure.png" data-toggle="tooltip" title="确认交易" /></a></td>												
					</tr>
				</c:forEach>
			</tbody>	
		</table>
<br/> 
			<div id="News-Pagination"></div>
    </c:if>
						
    </div>
	
</div>
<!-- end main_panel-->
<div class="modal fade" id="address_content" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">交易详情</h4>
            </div>
            <div class="modal-body">
			  <div class="form-group">
			    <textarea class="form-control" rows="3" id="addresstext"></textarea>
			  </div>          
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<script src="${webContent}jquery/bootstrap-datetimepicker.js"></script>          
<script type="text/javascript">
$("#datetime").datetimepicker({
    format: 'yyyy-mm-dd',
    minView:'month',
    autoclose:true,
});	
<!--datetime-->

function viewAddress(deal_num){
	$.post("purchase_findAddress?deal_num="+ deal_num,function(address) {
        $("#addresstext").html("");			
		if(address.length != 0) {
			for (var i = 0; i < address.length; i++) {
		        $("#addresstext").append(address[i].address+";");
			}
		}        
		$("#address_content").modal("show");		
	});
}

function sureGoods(deal_num,state){
	if(state!=1)
	{$.post("purchase_changeState?deal_num=" + deal_num,function(state) {
		if(state == "saveSuccess") {
			alert("确认交易成功！");	
			location.reload(true);
		}
		else{alert(state);}
	});
	}
	else{return 0;}
}
	
</script> 
</body>
</html>