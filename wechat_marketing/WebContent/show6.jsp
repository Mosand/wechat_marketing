<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	$("#proForm").attr("action", "<%=context %>/userincome_findAll.action?pageNum=" + (new_page_index +1));
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


<body>
	<div>
		<form action="<%=context %>/userincome_findAll.action" id="proForm" method="post">
			商品名称 <input type="text" name="username" id="username" style="width: 120px" > &nbsp; 			
		<input type="submit" value="查询">
		</form>
	</div>
<c:if test="${fn:length(dataList) gt 0 }">
<table border="1px" cellspacing="0px"
				style="border-collapse: collapse">
				<thead>
					<tr height="30">
				
				<td align="center">用户名</td>
				<td align="center">商品名</td>
				<td align="center">应得提成</td>
				<td align="center">已得提成</td>
				<td align="center">应得市场费</td>
				<td align="center">已得市场费</td>
				<td align="center">应得奖励</td>
				<td align="center">已得奖励</td>
				<td align="center">应得admin奖金</td>
				<td align="center">已得admin奖金</td>
				<td align="center">deal_num</td>
					</tr>
				</thead>
					
						<tr>
																									
							<td><c:out value="${dataList[0][1]}"></c:out></td>
							<td><c:out value="${dataList[0][8]}"></c:out></td>							
							<td><c:out value="${dataList[0][3]}"></c:out></td>
							<td><c:out value="${dataList[0][11]}"></c:out></td>
							<td><c:out value="${dataList[0][4]}"></c:out></td>
							<td><c:out value="${dataList[0][13]}"></c:out></td>
							<td><c:out value="${dataList[0][5]}"></c:out></td>																									
							<td><c:out value="${dataList[0][15]}"></c:out></td>
							<td><c:out value="${dataList[0][6]}"></c:out></td>
							<td><c:out value="${dataList[0][17]}"></c:out></td>
							<td><c:out value="${dataList[0][9]}"></c:out></td>
						</tr>
						<tr>
																								
							<td><c:out value="${dataList[1][1]}"></c:out></td>
							<td><c:out value="${dataList[1][8]}"></c:out></td>							
							<td><c:out value="${dataList[1][3]}"></c:out></td>
							<td><c:out value="${dataList[1][11]}"></c:out></td>
							<td><c:out value="${dataList[1][4]}"></c:out></td>
							<td><c:out value="${dataList[1][13]}"></c:out></td>
							<td><c:out value="${dataList[1][5]}"></c:out></td>																									
							<td><c:out value="${dataList[1][15]}"></c:out></td>
							<td><c:out value="${dataList[1][6]}"></c:out></td>
							<td><c:out value="${dataList[1][17]}"></c:out></td>
							<td><c:out value="${dataList[1][9]}"></c:out></td>
						</tr>
					
			</table>
			<br> 
			<div id="News-Pagination"></div>
	</c:if>
	<span>
			    总记录数：<s:property value="totalRecord" />&nbsp;&nbsp;
			    每页显示:<s:property value="pageSize" /></span>&nbsp;&nbsp; 
	<span>
	<div>后台传来的当前页:${currentPage}</div>
</body>
</html>