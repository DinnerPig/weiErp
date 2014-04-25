<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<div class="row">
	<div class="col-md-4">
		经销商：
		<select class="form-control" style="width:150px;display: inline-block;" id="busiId">
			<option value="">全部分类</option>
			<c:forEach items="${busis}" var="busi">
				<option value="${busi.id}">${busi.realname}</option>
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
<p></p>
<div id="orderList"></div>