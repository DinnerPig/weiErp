<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
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
<title>打印页面</title>
<link href="resources/js/plugin/bootstrap3/css/bootstrap.css" rel="stylesheet">
<link href="resources/style/plugin/font-awesome-4.0.1/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/style/app/pc/common/pc.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<form action="login" method="post">
			<c:if test="${error}">
				<div style="text-align: center;">
					<font color="red">账号或密码错误</font>
				</div>
			</c:if>
			<table class="my_table">
				<tr>
					<td>账号：</td>
					<td><input class="form-control" name="username" type="text"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input class="form-control" name="password" type="password"></td>
				</tr>
				<tr>
					<td colspan="2"><button class="btn btn-info">登陆</button></td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- 	js资源 -->
	<script type="text/javascript" src="resources/js/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/js/plugin/bootstrap3/js/bootstrap.min.js"></script>
</body>
</html>
