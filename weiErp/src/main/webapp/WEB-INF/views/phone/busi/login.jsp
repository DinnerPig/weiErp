<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri='http://java.sun.com/jsp/jstl/functions'%>

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
<title>经销商登陆</title>
<base href="<%=basePath%>" />
<meta charset="UTF-8" />
<meta content="width=320px, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<title>test</title>
<link href="resources/js/plugin/bootstrap3/css/bootstrap.css" rel="stylesheet">
<link href="resources/style/plugin/font-awesome-4.0.1/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/style/app/phone/common/phone.css" rel="stylesheet">
<link href="resources/style/app/phone/busi/login.css" rel="stylesheet">
</head>

<body>

	<div class="my_loginDiv" id="loginDiv">
		<h4>经销商登陆</h4>
		<hr style="width:300px;height:1px;">
		<c:if test="${error}">
			<p class="my_error">账号或密码错误</p>
		</c:if>
		<form role="form" class="form-horizontal" action="consumer/login" method="post">
			<table class="my_table table table-bordered">
				<tr>
					<td><i class="fa fa-user"></i></td>
					<td>
						<input type="text" placeholder="请输入账号" name="username"	class="form-control my_loginInput">
					</td>
				</tr>
				<tr>
					<td><i class="fa fa-key"></i></td>
					<td>
						<input type="password" placeholder="请输入密码" name="password"	class="form-control my_loginInput">
					</td>
				</tr>
			</table>
			<button class="btn btn-info btn-block" type="submit">登陆</button>
			<a class="btn btn-primary btn-block" onclick="consumer.registerPage()" href="javascript:void(0)">去注册</a>
		</form>
	</div>

	<!-- loading -->
	<div class="my_loading" id="loadingDiv">
		<div id="loaderImage" style="margin: auto;"></div>
		<p>加载中</p>
	</div>

	<!-- 	js资源 -->
	<script type="text/javascript" src="resources/js/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/js/plugin/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/utils.js"></script>
	<script type="text/javascript" src="resources/js/app/utils/loading.js"></script>
	<script type="text/javascript" src="resources/js/app/phone/consumer/consumer.js"></script>
</body>

</html>
