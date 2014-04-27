<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>

<table class="my_table">
	<tr>
		<td>订单号：</td>
		<td>${order.serial}</td>
	</tr>
	<tr>
		<td>经销商：</td>
		<td>${order.busi.realname}</td>
	</tr>
</table>



<table class="table table-striped">
	<tr>
		<th>#</th>
		<th>经销商</th>
		<th>手机</th>
		<th>地址</th>
		<th>留言</th>
		<th>日期</th>
		<th>操作</th>
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
			<td>
			    <button class="btn btn-danger" title="关闭" onclick="order.done(${order.id}, this)"><i class="fa fa-truck"></i></button>
			</td>
		</tr>
		<tr>
			<td colspan="8">
				<table class="table table-striped">
					<tr>
						<th>礼品名</th>
						<th>礼品单价</th>
						<th>礼品数量</th>
					</tr>
					<c:forEach items="${order.products}" var="product">
						<tr>
							<td>${product.product.name}</td>
							<td>${product.product.price}</td>
							<td>${product.amount}</td>
						</tr>			
					</c:forEach>
				</table>
			</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="../page/page.jsp"%>
