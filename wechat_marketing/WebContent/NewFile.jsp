<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>管理</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/pub/js/imgbox/css/lrtk.css"
    type="text/css" media="all" />
<script type="text/javascript"
    src="${pageContext.request.contextPath}/pub/js/imgbox/jquery.min.js"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/pub/js/imgbox/jquery.imgbox.pack.js"></script>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/pub/css/bg/style.css"
    type="text/css" media="all" />
<script type="text/javascript"
    src="${pageContext.request.contextPath}/pub/js/jquery.idTabs.min.js"></script>
 
 
</head>
 
<body
    style="margin:0px;padding:0px;overflow:hidden;padding-top:5px;widht:320px;">
　　　　　《！--用于测试传递过来的参数
    <table>
 
        <tr>
            <td>jsapi_ticket:</td>
            <td>${sign.jsapi_ticket}</td>
        </tr>
        <tr>
            <td>url:</td>
            <td>${sign.url}</td>
        </tr>
        <tr>
            <td>nonceStr:</td>
            <td>${sign.nonceStr}</td>
        </tr>
        <tr>
            <td>timestamp:</td>
            <td>"${sign.timestamp}"</td>
        </tr>
        <tr>
            <td>signature:</td>
            <td>${sign.signature}</td>
        </tr>
    </table>
 
    <h3 id="menu-scan">微信扫一扫</h3> <span class="desc">调起微信扫一扫接口</span> <button class="btn btn_primary" id="scanQRCode0">scanQRCode(微信处理结果)</button> <button class="btn btn_primary" id="scanQRCode1">scanQRCode(直接返回结果)</button> </body> <script src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script> <script type="text/javascript"> wx.config({ debug : true, appId : 'wx808ff7c908d83c7c',//必填 timestamp : "${sign.timestamp}",//必填 nonceStr : "${sign.nonceStr}",//必填 signature : "${sign.signature}",//必填 jsApiList : [ 'checkJsApi', 'scanQRCode' ]//调用的接口，必填 }); //end_config alert(location.href.split('#')[0]); wx.error(function(res) { alert("出错了：" + res.errMsg); }); // 9 微信原生接口  // 9.1.1 扫描二维码直接跳转 document.querySelector('#scanQRCode0').onclick = function () { wx.scanQRCode(); }; // 9.1.2 扫描二维码并返回结果 document.querySelector('#scanQRCode1').onclick = function () { wx.scanQRCode({ needResult: 1, desc: 'scanQRCode desc', success: function (res) { alert(JSON.stringify(res)); } }); }; </script> </html>