<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="my_query">
	<div class="input-group">
	    <input type="text" class="form-control" placeholder="输入订单号" id="keyword">
	    <span class="input-group-btn">
	    	<button type="button" class="btn btn-success" id="queryBtn">查询</button>
	    </span>
 	</div>
</div>		

<div class="my_orderList">
	<div>订单号</div>
	<div>下单日期</div>
	<ul id="orderList"></ul>
</div>
