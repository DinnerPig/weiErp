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
		<title>官网</title>
		<base href="<%=basePath%>"/>
		<meta charset="UTF-8"/>
		<meta content="width=320px, user-scalable=0;" name="viewport"/>
		<meta content="yes" name="apple-mobile-web-app-capable" />
		<meta content="black" name="apple-mobile-web-app-status-bar-style" />
		<title>test</title>
		<link href="resources/js/plugin/bootstrap3/css/bootstrap.css" rel="stylesheet">
		<link href="resources/style/plugin/font-awesome-4.0.1/css/font-awesome.min.css" rel="stylesheet">
		<link href="resources/style/app/phone/common/phone.css" rel="stylesheet">
		<link href="resources/style/app/phone/home/home.css" rel="stylesheet">
	</head>
	
	<body>
	
		<div class="my_news">
			<img alt="" src="resources/images/phone/logo.jpg">
		</div>
		
		<div class="my_menuBlock">
			<div class="my_menuLeft my_contactMenu" name="menu">
				<i class="fa fa-phone"></i>&nbsp;联系我们
			</div>
			<div class="my_menuLeft my_contactRMenu" name="menu"></div>
			<div class="my_menuLeft my_busiMenu" name="menu_busi">
				<i class="fa fa-shopping-cart"></i><br>
				经销商入口
			</div>
			<div class="my_menuLeft" style="height: 100px;background: transparent;" name="menu">
				<div name="menu"></div>
				<div name="menu"></div>
				<div name="menu"></div>
				<div name="menu"></div>
			</div>
			<div class="my_menuLeft my_bottomRightMenu" name="menu"></div>
			<div class="my_menuLeft my_bottomLeftMenu" name="menu"></div>
			<div class="my_menuLeft my_bottomMenu" name="menu"></div>
		</div>
		
	
	<!-- 	js资源 -->
	<script type="text/javascript" src="resources/js/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/js/plugin/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/home/home.js"></script>
	</body>
</html>

