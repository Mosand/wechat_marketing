<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.table1 {
	border: 1px solid #ddd;
	width: 900px;
}

thead {
	background-color: lightblue;
}
</style>
</head>
<%
	// 获取请求的上下文
	String context = request.getContextPath();
%>
<link href="${pageContext.request.contextPath}/css/pagination.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
<script type="text/javascript">
// 点击分页按钮以后触发的动作
function handlePaginationClick(new_page_index, pagination_container) {
	$("#proForm").attr("action", "<%=context %>/product_findAll.action?pageNum=" + (new_page_index +1));
	$("#proForm").submit();
	return false;
}

</script>
<body>     
	<table border="0" width="900px">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">部门管理</td>
		</tr>
		<tr>
			<td align="right">
			    <a href="department_goAddDepartment.action">添加</a>
			</td>
		</tr>
	</table>
	<br/>
	<table cellspacing="0" border="1" class="table1">
		<thead>
			<tr>
				<th width="300">部门名称</th>
				<th width="300">编辑</th>
				<th width="300">删除</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="d">
				<tr>
					<td align="center"><s:property value="#d.username" /></td>
					<td align="center"><s:property value="#d.direction" /></td>
					<td align="center"><s:property value="#d.goods_name" /></td>
					<td align="center"><s:property value="#d.totalticheng" /></td>
					<td align="center"><s:property value="#d.totalmarket_price" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<br/>
	<table border="0" cellspacing="0" cellpadding="0" width="900px">
		<tr>
			<td align="right">
			<span>
			     第<s:property value="currPage" />/<s:property value="totalPage" />页
			</span>
			&nbsp;&nbsp; 
			<span>
			    总记录数：<s:property value="totalCount" />&nbsp;&nbsp;
			    每页显示:<s:property value="pageSize" /></span>&nbsp;&nbsp; 
			<span>
			   <s:if test="currPage != 1">
					<a href="transaction_findTransactionByNameandTime.action?currPage=1">[首页]</a>&nbsp;&nbsp;
                    <a href="transaction_findTransactionByNameandTime.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
               </s:if> 
               <s:if test="currPage != totalPage">
					<a href="transaction_findTransactionByNameandTime.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
                    <a href="transaction_findTransactionByNameandTime.action?currPage=<s:property value="totalPage"/>">[尾页]<s:property value="totalPage"/></a>&nbsp;&nbsp;
               </s:if> 
            </span>
            </td>
		</tr>
	</table>
	
	
</body>
</html>