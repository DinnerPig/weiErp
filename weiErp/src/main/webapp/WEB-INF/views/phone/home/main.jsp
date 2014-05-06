<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>"/>
		<meta charset="UTF-8"/>
		<title>微商城</title>
		<base href="<%=basePath%>"/>
		<meta charset="UTF-8"/>
		<meta content="width=320px, user-scalable=0;" name="viewport"/>
		<meta content="yes" name="apple-mobile-web-app-capable" />
		<meta content="black" name="apple-mobile-web-app-status-bar-style" />
		<title>test</title>
		<link href="resources/js/plugin/bootstrap3/css/bootstrap.css" rel="stylesheet">
		<link href="resources/style/plugin/font-awesome-4.0.1/css/font-awesome.min.css" rel="stylesheet">
		<link href="resources/style/app/phone/common/phone.css" rel="stylesheet">
		<link href="resources/style/app/phone/product/productType.css" rel="stylesheet">
		<link href="resources/style/app/phone/busi/busiMenu.css" rel="stylesheet">
		<link href="resources/style/app/phone/product/product.css" rel="stylesheet">
		<link href="resources/style/app/phone/product/detail.css" rel="stylesheet">
		<link href="resources/style/app/phone/order/order.css" rel="stylesheet">
	</head>
	
	<body>
	
		<!-- 导航 -->
		<div class="my-navi clearfix">
			<div onclick="home.menu(this, 'center')">个人中心</div>
			<div onclick="home.menu(this, 'shopCar')">购物车</div>
			<div class="my-naviActive" onclick="home.menu(this, 'product')" id="menuProduct">商品列表</div>
			<div onclick="home.menu(this, 'order')">订单</div>
		</div>
		
		<!-- 内容 -->
		<div class="my-mainContents" id="mainContents"></div>
		
		<!-- loading -->
		<div class="my_loading" id="loadingDiv">
			<div id="loaderImage" style="margin: auto;"></div>
			<p>加载中</p>
		</div>
	
	<!-- 	js资源 -->
	<script type="text/javascript" src="resources/js/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/js/plugin/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/loading.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/product/productType.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/utils.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/home/home.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/busi/phoneBusi.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/product/product.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/product/detail.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/product/order.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/order/phoneTodoOrder.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/order/phoneDoneOrder.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			home.menu(document.getElementById("menuProduct"), "product"); 
		});
	</script>
	</body>
</html>
