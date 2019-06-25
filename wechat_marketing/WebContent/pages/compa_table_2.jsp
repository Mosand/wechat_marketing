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
div{top:4px;!important}
</style>

<link href="${webContent}css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="${webContent}css/default/bootstrap-3.3.7.min.css">
<link rel="stylesheet" href="${webContent}css/default/bootstrap-datetimepicker.css">
<link rel="stylesheet" href="${webContent}css/style.css">

<script src="${webContent}jquery/jquery-1.11.2.min.js"></script>
<script src="${webContent}jquery/jquery.form.js"></script>
<script src="${webContent}jquery/bootstrap-3.3.7.min.js"></script>
</head>
<body> 

<!-- 登录接口 -->
<!-- <%=request.getAttribute("user_id")%> <%=request.getAttribute("user_name")%>-->
<div class="login_icon">
      <ul class="nav navbar-nav navbar-right"> 
          <li><a href="${webContent}pages/userIndex.jsp"><img src="${webContent}img/icon/main_man.png" />&nbsp;&nbsp;<%=request.getAttribute("user_name")%></a></li>
      </ul> 
</div>
<div class="clear"></div>
<!-- end header -->

<div class="leftnav">
	<ul class="nav nav-pills nav-stacked">
	  <li><a href="${webContent}pages/main.jsp">产品管理</a></li>
	  <li><a href="#">用户管理</a></li>
	  <li class="selected"><a href="#" style="color: #333;">公司报表</a></li>
	</ul>
</div>
<!--end leftnav-->

<div class="panelfix">

	<ul class="nav nav-tabs">
	    <li>
	        <a href="${webContent}pages/compa_table_1.jsp">
	           公司报表
	        </a>
	    </li>
	    <li class="active"><a href="#">商品详情</a></li>
	    <li><a href="${webContent}pages/compa_table_3.jsp">用户详情</a></li>	    
	
	</ul>
	
    
    <div class="product_expenditure tab-pane fade in active">
		    <form action="#" method="post" class="navbar-form navbar-left" id="compa_table">
		      <div class="form-group">
		      	  <span>用户名称</span>
		          <input type="text" class="form-control" name="username">
		      </div>
		      
		      <div class="form-group">
		      	 <span>时间</span>			      
		         <input class="datetime" type="text" id="datetime" readonly class="form_datetime form-control" name="time" />
		      </div>		      
		      <button type="submit" class="btn btn-default" >查询</button>
		    </form>	    
		    
		    <div class="revenue_detail">
		        <span>收入：</span>
		        <span id="pr_in" class="text_ad">23</span>
		        <span>支出：</span>
		        <span id="pr_out" class="text_ad">25</span>			        
		    </div>
		    
			<table class="table table-hover">
			  <thead>
				<tr>
					<th>用户头像</th>						
					<th>用户名称</th>						
					<th>购买时间</th>
					<th>购买商品</th>
					<th>购买数量</th>
					<th>总价</th>																
				</tr>
			  </thead>
			  <tbody id="prevenue_list">
				<s:iterator value="list" var="d">
					<tr>
						<td><s:property value="#d.avatar_url" /></td>
						<td><s:property value="#d.username" /></td>
					<!-- 后台通过id1查 -->
						<td><s:property value="#d.time" /></td>							
						<td><s:property value="#d.goods_name" /></td>
						<td><s:property value="#d.buy_num" /></td>
						<td><s:property value="#d.spend" /></td>								
					</tr>
				</s:iterator>								  				  				  
			  </tbody>
			</table>
<br/>
			<table>
				<tr>
					<td>
					<span>
				     第<s:property value="currPage" />/<s:property value="totalPage" />页
				</span>
				&nbsp;&nbsp; 
				<span>
				    总记录数：<s:property value="totalCount" />&nbsp;&nbsp;
				    每页显示:<s:property value="pageSize" /></span>&nbsp;&nbsp; 
				<span>
				   <s:if test="currPage != 1">
						<a href="#.action?currPage=1">[首页]</a>&nbsp;&nbsp;
	                    <a href="#.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
	               </s:if> 
	               <s:if test="currPage != totalPage">
						<a href="#.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
	                    <a href="#?currPage=<s:property value="totalPage"/>">[尾页]<s:property value="totalPage"/></a>&nbsp;&nbsp;
	               </s:if> 
	            </span>
	            </td>
			</tr>
		</table>				
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