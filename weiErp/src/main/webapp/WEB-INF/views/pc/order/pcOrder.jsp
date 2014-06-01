<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<div class="row">
	<div class="col-md-4">
		经销商：
		<select class="form-control" style="width:150px;display: inline-block;" id="consumerId">
			<option value="">全部分类</option>
			<c:forEach items="${consumers}" var="consumer">
				<option value="${consumer.id}">${consumer.detail.trueName}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-md-4">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="输入订单号" id="keyword">
         	<span class="input-group-btn">
         		<button type="button" class="btn btn-success" id="queryBtn">查询</button>
         	</span>
      	</div>
	</div>
</div>
<hr>
<div id="orderList"></div>