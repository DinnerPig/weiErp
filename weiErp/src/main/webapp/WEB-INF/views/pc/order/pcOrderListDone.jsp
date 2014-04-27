<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<table class="table table-striped">
	<tr>
		<th>#</th>
		<th>订单号</th>
		<th>数量</th>
		<th>卖出数量</th>
		<th>经销商</th>
		<th>手机</th>
		<th>地址</th>
		<th>留言</th>
		<th>日期</th>
	</tr>
	<c:forEach items="${orders}" var="order" varStatus="idx">
		<tr>
			<td>${idx.count}</td>
			<td>${order.serial}</td>
			<td>${order.busi.realname}</td>
			<td>${order.busi.phone}</td>
			<td>${order.address}</td>
			<td>${order.note}</td>
			<td><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
		</tr>
	</c:forEach>
</table>

<%@ include file="../page/page.jsp"%>
