<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>

<input type="hidden" id="typeId" value="${typeId}">

<div class="my_query">
	<div class="input-group">
    	<input type="text" class="form-control" placeholder="输入礼品名" id="keyword">
     	<span class="input-group-btn">
     		<button type="button" class="btn btn-success" id="queryBtn">查询</button>
     	</span>
  	</div>
</div>

<div class="my_products">
	<ul id="productList"></ul>
</div>
	
