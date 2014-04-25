<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<div class="my_orderAdr">
	<h4>订单信息</h4>
	<table class="table table-bordered my_table">
		<tr>
			<td>订单号</td>
			<td id="serial"></td>
		</tr>
		<tr>
			<td>名称</td>
			<td>${product.name}</td>
		</tr>
		<tr>
			<td>单价</td>
			<td>${product.price}</td>
		</tr>
		<tr>
			<td>数量</td>
			<td><input class="form-control" type="tel" id="amount"></td>
		</tr>
	</table>
</div>

<div class="my_orderAdr">
	<h4>收货信息</h4>
	<table class="table table-bordered my_table">
		<tr>
			<td>地址</td>
			<td><textarea rows="" cols="" class="form-control" id="address">${busi.address}</textarea></td>
		</tr>
		<tr>
			<td>留言</td>
			<td><textarea rows="" cols="" class="form-control" id="note"></textarea></td>
		</tr>
	</table>
</div>
<button class="btn btn-warning my_blockBtn" id="submitBtn" onclick="order.submit(${product.id})">提交订单</button>
<button class="btn btn-danger my_blockBtn" onclick="order.back()">返回详情</button>