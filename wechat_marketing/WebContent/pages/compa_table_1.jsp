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
	    <li class="active">
	        <a href="#">
	           公司报表
	        </a>
	    </li>
	    <li><a href="${webContent}pages/compa_table_2.jsp">商品详情</a></li>
	    <li><a href="${webContent}pages/compa_table_3.jsp">用户详情</a></li>	    
	
	</ul>
	
    <div class="echarts_site tab-pane fade in active">
       <script type="text/javascript" src="${webContent}jquery/echarts.min.js"></script>
       <script type="text/javascript">
	       var in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12;	
	       var out1, out2, out3, out4, out5, out6, out7, out8, out9, out10, out11, out12;	       
<!--define_params-->
			$(function() {//预加载方法
				//通过ajax请求菜单
			
				$.ajax({
					url : './transaction_findExpenseandIncome',
					type : 'POST',
					dataType : 'json',
					success : function(list) {
						in1=list[0][4];
						in2=list[1][4];
						in3=list[2][4];
						in4=list[3][4];
						in5=list[4][4];
						in6=list[5][4];
						in7=list[6][4];
						in8=list[7][4];
						in9=list[8][4];
						in10=list[9][4];
						in11=list[10][4];
						in12=list[11][4];
						
						out1=list[0][3];
						out2=list[1][3];	
						out3=list[2][3];
						out4=list[3][3];	
						out5=list[4][3];
						out6=list[5][3];	
						out7=list[6][3];	
						out8=list[7][3];	
						out9=list[8][3];	
						out10=list[9][3];
						out11=list[10][3];
						out12=list[11][3];							
					},
			});
<!--catch_params-->			
				var dom = document.getElementById("container");
				var myChart = echarts.init(dom);
				var app = {};
				option = null;
				option = {
				    title : {
				        text: '年收支概况',
				        subtext: ''
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        data:['收入','支出']
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            dataView : {show: true, readOnly: false},
				            magicType : {show: true, type: ['line', 'bar']},
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    grid: {
				        top:80,
				        x:45,
				        x2:30,
				        y2:60,
				    },				    
				    xAxis : [
				        {
				            type : 'category',
				            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value'
				        }
				    ],
				    series : [
				        {
				            name:'收入',
				            type:'bar',
				            data:[in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12],
				            markPoint : {
				                data : [
				                    {type : 'max', name: '最大值'},
				                    {type : 'min', name: '最小值'}
				                ]
				            },
				            markLine : {
				                data : [
				                    {type : 'average', name: '平均值'}
				                ]
				            }
				        },
				        {
				            name:'支出',
				            type:'bar',
				            data:[out1, out2, out3, out4, out5, out6, out7, out8, out9, out10, out11, out12],
				            markPoint : {
				                data : [
					                    {type : 'max', name: '最大值'},
					                    {type : 'min', name: '最小值'}
					                ]
				            },
				            markLine : {
				                data : [
				                    {type : 'average', name : '平均值'}
				                ]
				            }
				        }
				    ]
				};
				;
				if (option && typeof option === "object") {
				    myChart.setOption(option, true);
				}
			</script>	
		
	    </div>
<!-- end compa_table -->
	
</div>
<!-- end main_panel-->

</body>
</html>