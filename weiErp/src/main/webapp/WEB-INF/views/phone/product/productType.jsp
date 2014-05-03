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
		<title>商品类别</title>
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
	</head>
	
	<body>
	
		<!-- 导航 -->
		<div class="my-navi clearfix">
			<div class="my-naviActive" onclick="home.menu('center')">个人中心</div>
			<div onclick="home.menu('shopCar')">购物车</div>
			<div onclick="home.menu('product')">商品列表</div>
			<div onclick="home.menu('logout')">注销</div>
		</div>
		
		<!-- 内容 -->
		<div class="my-mainContents">
			<div class="my_news"></div>
			
			<div class="my_bigType">
				<ul>
					<c:forEach items="${types}" var="type">
						<li ontouchstart="" tid="${type.id}">${type.name}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		
	
	<!-- 	js资源 -->
	<script type="text/javascript" src="resources/js/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/js/plugin/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/loading.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/product/productType.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/utils.js"></script>
	</body>
</html>

