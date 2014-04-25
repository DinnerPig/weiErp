
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
		<title>已发货订单</title>
		<link href="resources/js/plugin/bootstrap3/css/bootstrap.css" rel="stylesheet">
		<link href="resources/style/plugin/font-awesome-4.0.1/css/font-awesome.min.css" rel="stylesheet">
		<link href="resources/style/app/phone/common/phone.css" rel="stylesheet">
		<link href="resources/style/app/phone/order/order.css" rel="stylesheet">
	</head>
	<body>
		<div class="my_orderList">
			<table class="my_table">
				<tr>
					<td>礼品名：</td>
					<td>${order.product.name}</td>
				</tr>
				<tr>
					<td>单价：</td>
					<td>${order.product.price}</td>
				</tr>
				<tr>
					<td>数量：</td>
					<td>${order.amount}</td>
				</tr>
				<tr>
					<td>卖出：</td>
					<td>
						<input class="form-control" id="outAmount" value="${order.outAmount}">
					</td>
				</tr>
				<tr>
					<td style="width:85px;">收货地址：</td>
					<td>${order.address}</td>
				</tr>
				<tr>
					<td>留言：</td>
					<td>${order.note}</td>
				</tr>
			</table>
		</div>
		
		<button class="btn btn-success btn-block my_blockBtn" onclick="order.updateOutAmount(${order.id})">保存修改</button>
		
		<!-- loading -->
		<div class="my_loading" id="loadingDiv">
			<div id="loaderImage" style="margin: auto;"></div>
			<p>加载中</p>
		</div>
	
	<!-- 	js资源 -->
	<script type="text/javascript" src="resources/js/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/js/plugin/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/product/order.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/loading.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/utils.js"></script>
	</body>
</html>
