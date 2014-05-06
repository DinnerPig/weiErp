<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp" %>

<div class="my_busiMenuDiv">
	<a class="btn btn-primary btn-block" onclick="order.queryOrder('todo')" href="javascript:void(0)">未发货订单</a>
	<a class="btn btn-success btn-block" onclick="order.queryOrder('done')" href="javascript:void(0)">已发货订单</a>
</div>


