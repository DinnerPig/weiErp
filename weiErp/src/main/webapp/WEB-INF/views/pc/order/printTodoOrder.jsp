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

	<div class="container" style="text-align: center;width: 960px;" id="validPrintDiv">
		<h2>发货单</h2>
		<table class="table">
			<tr>
				<td>订单号：${order.serial}</td>
				<td>经销商：${order.busi.realname}</td>
			</tr>
			<tr>
				<td>手机：${order.busi.phone}</td>
				<td>收货地址：${order.address}</td>
			</tr>
			<tr>
				<td>留言：${order.note}</td>
				<td>下单日期：<fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
			</tr>
		</table>
		<table class="table table-striped my_orderTable">
			<tr>
				<th>#</th>
				<th>礼品编号</th>
				<th>礼品名</th>
				<th>单价</th>
				<th>数量</th>
				<th>合计</th>
			</tr>
			<c:forEach items="${order.products}" var="orderProduct" varStatus="idx">
				<tr>
					<td>${idx.count}</td>
					<th>${orderProduct.product.serial}</th>
					<td>${orderProduct.product.name}</td>
					<td>${orderProduct.product.price}</td>
					<td>${orderProduct.amount}</td>
					<td>${orderProduct.product.price * orderProduct.amount}&nbsp;元</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div style="text-align: center;">
		<button class="btn btn-success" onclick="myPrint()">打印订单</button>
	</div>
	
	<!-- 	js资源 -->
	<script type="text/javascript" src="resources/js/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/js/plugin/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function myPrint() {
		    var newstr = document.getElementById("validPrintDiv").innerHTML;
		    var oldstr = document.body.innerHTML;
		    document.body.innerHTML = newstr;
		    window.print();
		    document.body.innerHTML = oldstr; 
		}
	</script>
</body>
</html>
