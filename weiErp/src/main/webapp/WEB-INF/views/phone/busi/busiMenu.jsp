<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8" />
<title>经销商菜单</title>
<base href="<%=basePath%>" />
<meta charset="UTF-8" />
<meta content="width=320px, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<title>test</title>
<link href="resources/js/plugin/bootstrap3/css/bootstrap.css" rel="stylesheet">
<link href="resources/style/plugin/font-awesome-4.0.1/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/style/app/phone/common/phone.css" rel="stylesheet">
<link href="resources/style/app/phone/busi/busiMenu.css" rel="stylesheet">
</head>

<body>

	<div class="my_busiMenuDiv">
		<a class="btn btn-info btn-block" href="phone/product/query/type">继续下单</a>
		<a class="btn btn-primary btn-block" href="resources/model/phone/order/phoneTodoOrder.jsp">未发货订单</a>
		<a class="btn btn-success btn-block" href="resources/model/phone/order/phoneDoneOrder.jsp">已发货订单</a>
	</div>

	<!-- 	js资源 -->
	<script type="text/javascript" src="resources/js/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/js/plugin/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/utils.js"></script>
</body>
</html>

