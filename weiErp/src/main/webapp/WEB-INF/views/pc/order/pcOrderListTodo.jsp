<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>

<c:forEach items="${orders}" var="order">
	<h4 class="my_underLine">基本信息</h4>
	<table class="my_orderTable">
		<tr>
			<td>订单号：</td>
			<td>${order.serial}</td>
		</tr>
		<tr>
			<td>经销商：</td>
			<td>${order.busi.realname}</td>
		</tr>
		<tr>
			<td>手机：</td>
			<td>${order.busi.phone}</td>
		</tr>
		<tr>
			<td>收货地址：</td>
			<td>${order.address}</td>
		</tr>
		<tr>
			<td>留言：</td>
			<td>${order.note}</td>
		</tr>
		<tr>
			<td>下单日期：</td>
			<td><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
		</tr>
	</table>
	<h4 class="my_underLine">订单产品</h4>
	<table class="table table-striped my_orderTable">
		<tr>
			<th>#</th>
			<th>礼品名</th>
			<th>单价</th>
			<th>数量</th>
			<th>合计</th>
		</tr>
		<c:forEach items="${order.products}" var="orderProduct" varStatus="idx">
			<tr>
				<td>${idx.count}</td>
				<td>${orderProduct.product.name}</td>
				<td>${orderProduct.product.price}</td>
				<td>${orderProduct.amount}</td>
				<td>${orderProduct.product.price * orderProduct.amount}&nbsp;元</td>
			</tr>
		</c:forEach>
	</table>
	<h4>
		<a href="javascript:void(0)" onclick="order.done(${order.id}, this)">确认送货&nbsp;<i class="fa fa-truck"></i></a>
		&emsp;
		<a href="javascript:void(0)" onclick="order.remove(${order.id}, this)">删除订单&nbsp;<i class="fa fa-trash-o"></i></a>
	</h4>
	<hr>
</c:forEach>


<%@ include file="../page/page.jsp"%>
