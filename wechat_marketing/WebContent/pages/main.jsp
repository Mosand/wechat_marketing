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
	  <li class="selected"><a href="#" style="color: #333;">产品管理</a></li>
	  <li><a href="userincome_findAll">用户管理</a></li>
	  <li><a href="${webContent}pages/compa_table_1.jsp">公司报表</a></li>
	</ul>
</div>
<!--end leftnav-->

<div class="panelfix" id="product_panel">

</div>
<!-- end main_panel-->

<script type="text/javascript">
	$(function() {//预加载方法
		//通过ajax请求菜单

		$.ajax({
			url : './goods_searchGoods',
			type : 'POST',
			dataType : 'json',
			success : function(list) {
				$("#product_panel").html("");
				if(list.length != 0) {
					for (var i = 0; i < list.length; i++) {
						var imgurl="";
						if (list[i].imgFormat!=null||""){
							imgurl="<img src='${webContent}goods_image/"+list[i].imgFormat;
						}
						else {imgurl="<img src='${webContent}img/none.png";}
	
						$("#product_panel").append("<div class='panel product_item'><input type='hidden' id='producuItem_"+list[i].goods_id+"'/>"+imgurl+"' class='img-rounded img_click'/><div class='product_heading'><h3 class='panel-title'>"+list[i].goods_name+"&nbsp;&nbsp;<span>"+list[i].price+"</span></h3></div></div>");
					}
				}
				$("#product_panel").append("<div class='product_item'><a data-target='#add_product' data-toggle='modal'><img src='${webContent}img/add_product.png'/></a></div>");

			   $("img.img_click").click(function() {
					var index1=$(this).siblings("input").attr("id");
					var productItem = index1.split("_")[1].substring(0);
			       $.ajax({
			           type: "POST",
			           url: "./goods_searchItem",
			           dataType: "json",
			           data: {"goods_id": productItem},
			           success: function (list) {
			        	$('#itemOperate').html("");
			        	
						if (list[0].imgFormat!=null||""){
					        $('#preimg').attr("src","${webContent}goods_image/"+list[0].imgFormat);
						}			        	

			        	$('#goods_id').attr("value",list[0].goods_id);			        	
			        	$('#goods_name').attr("value",list[0].goods_name);
			        	$('#price').attr("value",list[0].price);		        	
			        	$('#describe_goods').attr("value",list[0].describe_goods);			        	
			        	$('#ticheng').attr("value",list[0].ticheng);
			        	$('#market_price').attr("value",list[0].market_price);	
			        	$('#reward').attr("value",list[0].reward);	
			        	$('#reward_num').attr("value",list[0].reward_num);
			        	$('#admin').attr("value",list[0].admin);			        	
			        	$('#admin_num').attr("value",list[0].admin_num);
			        	$('#tuiguangfei1').attr("value",list[1].tuiguangfei1);
			        	$('#tuiguangfei2').attr("value",list[1].tuiguangfei2);
			        	$('#tuiguangfei3').attr("value",list[1].tuiguangfei3);
			        	$('#tuiguangfei4').attr("value",list[1].tuiguangfei4);	
			        	$('#tuiguangfei5').attr("value",list[1].tuiguangfei5);			 
			        	$('#tuiguangfei6').attr("value",list[1].tuiguangfei6);	
			        	$('#itemOperate').append("<a onclick='goods_deleteGoods("+list[0].goods_id+")'><img src='${webContent}img/icon/delete.png' style='margin-right:10px;'/></a><button class='btn btn-primary' type='submit'>确定更改</button><button class='btn btn-danger' data-dismiss='modal'>取消</button>");			        	
			        	
						$("#update_product").modal("show");
			           },
			           error: function (e) {alert(e)}
			       });
			   });					
			},
			error : function(msg) {
				alert(msg);
			}
		});   
	});
	
</script>
<!-- end pre_download_product_show -->

<script>
function goods_deleteGoods(goods_id) {
	$.post("goods_deleteGoods?goods_id=" + goods_id,function(state) {
		if(state == "deleteSuccess") {
			window.location.reload();
		}
	});
}

$(document).ready(function() {  		          
  		$('#add_product').ajaxForm(function(state) {
			if(state == "addSuccess") {
				window.location.reload();
			}	
			else{alert(state);}
  });
  <!--add_product_response-->   

 		          
  		$('#update_product').ajaxForm(function(state) {
		if(state == "updateSuccess") {
			window.location.reload();
		}	
		else{alert(state);}
  });
    <!--update_product_response-->   
         
  
});
</script>

 <form action="goods_updateGoods" method="post" class="modal fade" id="update_product" tabindex="-1" role="dialog" aria-labelledby="preProduct" aria-hidden="true" enctype="multipart/form-data">
  <div class="modal-dialog">
      <div class="modal-content" style="width:420px;margin:0 auto;">
           <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                   &times;
               </button>
               <h4 class="modal-title" id="preProduct">
                   产品信息
               </h4>
           </div>
           <div class="modal-body">
			   <div class="product_img">
				   <img id="preimg" src="${webContent}img/none.png" alt="product_img"/>
				   <input id="newimg" type="file" name="file1" onchange="previewFile()" /> 　　　 　
			   </div>   
			   <input type="hidden" name="goods_id" id="goods_id"/>			         
               <div class="form-group">
                   <label for="">产品名称</label>
                   <input class="form-control" type="text" placeholder="" name="goods_name" id="goods_name">
               </div>
               <div class="form-group">
                   <label for="">单价</label>
                   <input class="form-control" type="text" placeholder="" name="price" id="price">
               </div>
               <div class="form-group">
                   <label for="">产品描述</label>
                   <input class="form-control" type="text" placeholder="" name="describe_goods" id="describe_goods">
               </div>
               <div class="form-group">
                   <label for="">提成费</label>
                   <input class="form-control" type="text" placeholder="" name="ticheng" id="ticheng">
               </div>
               <div class="form-group">
                   <label for="">市场费</label>
                   <input class="form-control" type="text" placeholder="" name="market_price" id="market_price">
               </div>
               <div class="form-group">
                   <label for="">个人奖金</label>
                   <input class="form-control" type="text" placeholder="" name="reward" id="reward">
               </div>
               <div class="form-group">
                   <label for="">个人奖金的达标线</label>
                   <input class="form-control" type="text" placeholder="" name="reward_num" id="reward_num">
               </div>
               <div class="form-group">
                   <label for="">ADMIN</label>
                   <input class="form-control" type="text" placeholder="" name="admin" id="admin">
               </div>
               <div class="form-group">
                   <label for="">ADMIN的达标线</label>
                   <input class="form-control" type="text" placeholder="" name="admin_nunm" id="admin_num">
               </div>  
				<div class="propagation">
					<table class="table table-striped">
					  <caption>推广费清单</caption>
					  <tbody>
					    <tr>
					      <th>购买数量（盒）</th>
					      <th>每盒推广费（元）</th>
					    </tr>					  
					    <tr>
					      <td>(0,20]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei1" id="tuiguangfei1"></td>
					    </tr>
					    <tr>
					      <td>(20,40]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei2" id="tuiguangfei2"></td>
					    </tr>
					    <tr>
					      <td>(40,60]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei3" id="tuiguangfei3"></td>
					    </tr>
					    <tr>
					      <td>(60,80]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei4" id="tuiguangfei4"></td>
					    </tr>
					    <tr>
					      <td>(80,100]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei5" id="tuiguangfei5"></td>
					    </tr>
					    <tr>
					      <td>(100,∞]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei6" id="tuiguangfei6"></td>
					    </tr>					    					    					    					    					    
					  </tbody>
					</table>
				</div>	                   
                                                                                                                                                                                                              
           </div>
           <div class="modal-footer" id="itemOperate">
           
           </div>
       </div>
   </div>
</form> 
<!--end add_product_modal -->

<script>
    function previewFile() {
        var preview=document.getElementById("preimg");
        var file=document.getElementById("newimg").files[0];
        // Js内置文件流
        var reader = new FileReader();

        // 更新img标签的src属性为图片的本地路径，就可以显示了
        reader.onloadend = function () {
            preview.src = reader.result;
        }

        // 图片文件不空就显示
        if (file) {
            reader.readAsDataURL(file);
        } else {
            // 图片文件是空的
            preview.src = "${webContent}img/none.png";
        }
    }
</script>
<!-- end productItem_add_img_select -->

 <form action="goods_addGoods" method="post" class="modal fade" id="add_product" tabindex="-1" role="dialog" aria-labelledby="myProduct" aria-hidden="true" enctype="multipart/form-data">
  <div class="modal-dialog">
      <div class="modal-content" style="width:420px;margin:0 auto;">
           <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                   &times;
               </button>
               <h4 class="modal-title" id="myProduct">
                   产品信息
               </h4>
           </div>
           <div class="modal-body">
			   <div class="product_img">
				   <img id="demoimg" src="${webContent}img/add_product.png" alt="product_img"/>
				   <input id="selectimg" type="file" name="file1" onchange="previewFile0()" /> 　　　 　
			   </div>         
               <div class="form-group">
                   <label for="">产品名称</label>
                   <input class="form-control" type="text" placeholder="" name="goods_name">
               </div>
               <div class="form-group">
                   <label for="">单价</label>
                   <input class="form-control" type="text" placeholder="" name="price">
               </div>
               <div class="form-group">
                   <label for="">产品描述</label>
                   <input class="form-control" type="text" placeholder="" name="describe_goods">
               </div>
               <div class="form-group">
                   <label for="">提成费</label>
                   <input class="form-control" type="text" placeholder="" name="ticheng">
               </div>
               <div class="form-group">
                   <label for="">市场费</label>
                   <input class="form-control" type="text" placeholder="" name="market_price">
               </div>
               <div class="form-group">
                   <label for="">个人奖金</label>
                   <input class="form-control" type="text" placeholder="" name="reward">
               </div>
               <div class="form-group">
                   <label for="">个人奖金的达标线</label>
                   <input class="form-control" type="text" placeholder="" name="reward_num">
               </div>
               <div class="form-group">
                   <label for="">ADMIN</label>
                   <input class="form-control" type="text" placeholder="" name="admin">
               </div>
               <div class="form-group">
                   <label for="">ADMIN的达标线</label>
                   <input class="form-control" type="text" placeholder="" name="admin_num">
               </div>  
				<div class="propagation">
					<table class="table table-striped">
					  <caption>推广费清单</caption>
					  <tbody>
					    <tr>
					      <th>购买数量（盒）</th>
					      <th>每盒推广费（元）</th>
					    </tr>					  
					    <tr>
					      <td>(0,20]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei1"></td>
					    </tr>
					    <tr>
					      <td>(20,40]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei2"></td>
					    </tr>
					    <tr>
					      <td>(40,60]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei3"></td>
					    </tr>
					    <tr>
					      <td>(60,80]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei4"></td>
					    </tr>
					    <tr>
					      <td>(80,100]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei5"></td>
					    </tr>
					    <tr>
					      <td>(100,∞]</td>
					      <td><input class="form-control" type="text" placeholder="" name="tuiguangfei6"></td>
					    </tr>					    					    					    					    					    
					  </tbody>
					</table>
				</div>	                   
                                                                                                                                                                                                              
           </div>
           <div class="modal-footer">        
               <button class="btn btn-primary" type="submit" >提交</button>
               <button class="btn btn-danger" data-dismiss="modal">取消</button>
           </div>
       </div>
   </div>
</form> 
<!--end add_product_modal -->

<script>
    function previewFile0() {
        var preview0=document.getElementById("demoimg");
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
            preview0.src = "${webContent}img/add_product.png";
        }
    }
</script>
<!-- end productItem_add_img_select -->


</body>
</html>