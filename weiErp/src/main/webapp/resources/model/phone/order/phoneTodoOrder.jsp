
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>"/>
		<meta charset="UTF-8"/>
		<base href="<%=basePath%>"/>
		<meta charset="UTF-8"/>
		<meta content="width=320px, user-scalable=0;" name="viewport"/>
		<meta content="yes" name="apple-mobile-web-app-capable" />
		<meta content="black" name="apple-mobile-web-app-status-bar-style" />
		<title>未发货订单</title>
		<link href="resources/js/plugin/bootstrap3/css/bootstrap.css" rel="stylesheet">
		<link href="resources/style/plugin/font-awesome-4.0.1/css/font-awesome.min.css" rel="stylesheet">
		<link href="resources/style/app/phone/common/phone.css" rel="stylesheet">
		<link href="resources/style/app/phone/order/order.css" rel="stylesheet">
	</head>
	<body>
		<div class="my_orderList">
			<div>订单号</div>
			<div>下单日期</div>
			<ul id="orderList"></ul>
		</div>
		
		<!-- loading -->
		<div class="my_loading" id="loadingDiv">
			<div id="loaderImage" style="margin: auto;"></div>
			<p>加载中</p>
		</div>
	
	<!-- 	js资源 -->
	<script type="text/javascript" src="resources/js/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/js/plugin/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/order/phoneTodoOrder.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/loading.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/utils.js"></script>
	</body>
</html>

