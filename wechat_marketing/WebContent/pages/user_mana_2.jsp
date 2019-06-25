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
	  <li class="selected"><a href="#" style="color: #333;">用户管理</a></li>
	  <li><a href="${webContent}pages/compa_table_1.jsp">公司报表</a></li>
	</ul>
</div>
<!--end leftnav-->

<!-- end pre_download_product_show -->

<div class="panelfix">

	<ul class="nav nav-tabs">
	    <li>
	        <a href="${webContent}pages/user_mana_1.jsp">
	            费用明细
	        </a>
	    </li>
	    <li class="active"><a href="#">收款查询</a></li>
	
	</ul>
	
	    
    <div class="tab-pane fade in active product_expenditure">
	    <form action="purchase_findDealByNameandTime" method="post" class="navbar-form navbar-left" id="goods_sure">
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
	    
		<table class="table table-hover">
		  <thead>
			<tr>
				<th>用户头像</th>						
				<th>用户名称</th>						
				<th>购买商品</th>
				<th>总价</th>
				<th>状态</th>
				<th>时间</th>
				<th>操作</th>																
			</tr>
		  </thead>
		  <tbody id="expense_list">				
<%--  					<tr>					
						<td><img src="avatar_url" class="userimg img-circle" /></td>						
						<td>用名称</td>						
						<td>对应事</td>
						<td>523</td>	
						<td>对应事</td>
						<td>523</td>
						<td><a onclick="viewAddress(id1)"><img class="viewimg" src="${webContent}img/icon/img_view.png"/></a> <a onclick="sureGoods('as12019078')"><img src="${webContent}img/icon/img_sure.png"/></a></td>															
					</tr> --%>
			<s:iterator value="list" var="d">
				<tr>
					<td><s:property value="#d.avatar_url" /></td>
					<td><s:property value="#d.username" /></td>
					<td><s:property value="#d.goods_name" /></td>							
					<td><s:property value="#d.spend" /></td>							
					<td><s:property value="#d.state" /></td>
					<td><s:property value="#d.time" /></td>	
					<td><a onclick="viewAddress('<s:property value="#d.id1" />')"><img class="viewimg" src="${webContent}img/icon/img_view.png"/></a> <a onclick="sureGoods('<s:property value="#d.deal_num" />')"><img src="${webContent}img/icon/img_sure.png"/></a></td>																			
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
						<a href="purchase_findDealByNameandTime.action?currPage=1">[首页]</a>&nbsp;&nbsp;
	                    <a href="purchase_findDealByNameandTime.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
	               </s:if> 
	               <s:if test="currPage != totalPage">
						<a href="purchase_findDealByNameandTime.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
	                    <a href="purchase_findDealByNameandTime.action?currPage=<s:property value="totalPage"/>">[尾页]<s:property value="totalPage"/></a>&nbsp;&nbsp;
	               </s:if> 
	            </span>
	            </td>
			</tr>
		</table>								
    </div>
	
</div>
<!-- end main_panel-->
<div class="modal fade" id="address_content" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">用户地址详情</h4>
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

function viewAddress(id1){
	$.post("address_findAddress?id1="+ id1,function(address) {
        $("#addresstext").html("");			
		if(address.length != 0) {
			for (var i = 0; i < address.length; i++) {
		        $("#addresstext").append(address[i].address+";");
			}
		}        
		$("#address_content").modal("show");		
	});
}

function sureGoods(deal_num){
	$.post("purchase_changeState?deal_num=" + deal_num,function(state) {
		if(state == "changeSuccess") {
			window.location.reload();				
		}
		else{alert(state);}
	});
}
	
</script> 
</body>
</html>