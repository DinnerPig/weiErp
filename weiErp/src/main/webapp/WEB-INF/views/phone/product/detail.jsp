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
		<title>商品详情</title>
		<base href="<%=basePath%>"/>
		<meta charset="UTF-8"/>
		<meta content="width=320px, user-scalable=0;" name="viewport"/>
		<meta content="yes" name="apple-mobile-web-app-capable" />
		<meta content="black" name="apple-mobile-web-app-status-bar-style" />
		<title>test</title>
		<link href="resources/js/plugin/bootstrap3/css/bootstrap.css" rel="stylesheet">
		<link href="resources/style/plugin/font-awesome-4.0.1/css/font-awesome.min.css" rel="stylesheet">
		<link href="resources/style/app/phone/common/phone.css" rel="stylesheet">
		<link href="resources/style/app/phone/product/detail.css" rel="stylesheet">
		<link href="resources/style/app/phone/order/order.css" rel="stylesheet">
	</head>
	<body>
			
		<div class="my_detailBlock">
			<div id="detailBlock">
				<div class="my_productImg">
					<img src="${product.mainImage}">
				</div>	
				
				<div class="my_params">
					<ul>
						<li ontouchstart="">
							<span class="my_leftParam">名称</span>
							<span>${product.name}</span>
						</li>
						<li ontouchstart="">
							<span class="my_leftParam">单价</span>
							<span>${product.price}</span>
						</li>
						<li ontouchstart="">
							<span class="my_leftParam">规格</span>
							<span>${product.standard}</span>
						</li>
					</ul>
				</div>
				
				<div class="panel panel-info">
	        		<div class="panel-heading">
	          			<h3 class="panel-title">产品描述</h3>
	        		</div>
	        		<div class="panel-body">${product.description}</div>
	      		</div>
	      		
	      		<div class="panel panel-info">
	        		<div class="panel-heading">
	          			<h3 class="panel-title">产品图片</h3>
	        		</div>
	        		<div class="panel-body">
	        			<c:forEach items="${product.images}" var="image">
							<img src="${image.url}">
						</c:forEach>
	        		</div>
	      		</div>
      		</div>
			
			<button class="btn btn-primary my_blockBtn" id="shopCarBtn" pid="${product.id}">加入购物车</button>
			<button class="btn btn-success my_blockBtn" id="orderBtn">去结算</button>
			<a class="btn btn-warning my_blockBtn" href="phone/product/show/${product.type.id}">返回</a>
			
			<!-- 订单 -->
			<div id="orderDiv" class="my_orderDiv"></div>
		</div>
		
		<!-- loading -->
		<div class="my_loading" id="loadingDiv">
			<div id="loaderImage" style="margin: auto;"></div>
			<p>加载中</p>
		</div>
	
	
	<!-- 	js资源 -->
	<script type="text/javascript" src="resources/js/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/js/plugin/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/loading.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/utils.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/product/detail.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/product/order.js"></script>
	</body>
</html>

