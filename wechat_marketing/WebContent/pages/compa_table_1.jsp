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
	    <li><a href="purchase_findAll2">收入详情</a></li>
	    <li><a href="transaction_findAll">支出详情</a></li>	    
	
	</ul>
	
	<div id="container" class="echarts_site tab-pane fade in active">
       <script type="text/javascript" src="${webContent}jquery/echarts.min.js"></script>
       <script type="text/javascript">			
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
		            data:[],
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
		            data:[],
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

    $.ajax({
	           type: 'POST',
	           url: './transaction_ findExpenseandIncome',
	           cache : false,    //禁用缓存
	           dataType: "json",
	           success: function(list) {
	                var ins=[list[0][4],list[1][4],list[2][4],list[3][4],list[4][4],list[5][4],list[6][4],list[7][4],list[8][4],list[9][4],list[10][4],list[11][4]];//定义两个数组
	                var outs=[list[0][3],list[1][3],list[2][3],list[3][3],list[4][3],list[5][3],list[6][3],list[7][3],list[8][3],list[9][3],list[10][3],list[11][3]];
	
	                myChart.setOption({ //加载数据图表
		
	                        series: [
	                                 {
	                                	 name: "收入",
	                                	 data: ins
	                                 },
	                                 {
	                                	 name: "支出",
	                                	 data: outs	                                	 
	                                 }
	                        ]
  
	           	});
	           },
	           error: function(XMLHttpRequest, textStatus, errorThrown) {
	               alert("查询失败");
	           }
	       });
	   </script>	
		
	    </div>
<!-- end compa_table -->
	
</div>
<!-- end main_panel-->

</body>
</html>