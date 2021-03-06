<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>

<c:forEach items="${orders}" var="order">
	<li ontouchstart="">
		<div>${order.serial}</div>
		<div><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm"/></div>
	</li>
	<li class="my_todoOrderDetail">
		<table class="my_table">
			<c:forEach items="${order.products}" var="orderProduct">
				<tr>
					<td>礼品名：</td>
					<td>${orderProduct.product.name}</td>
				</tr>
				<tr>
					<td>单价：</td>
					<td>${orderProduct.product.price}</td>
				</tr>
				<tr>
					<td>数量：</td>
					<td>${orderProduct.amount}</td>
				</tr>
			</c:forEach>
			<tr>
				<td style="width:85px;">收货地址：</td>
				<td>${order.address}</td>
			</tr>
			<tr>
				<td>留言：</td>
				<td>${order.note}</td>
			</tr>
		</table>
	</li>
</c:forEach>
