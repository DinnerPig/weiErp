<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<div class="row">
	<div class="col-md-4">
		礼品分类：
		<select class="form-control" style="width:150px;display: inline-block;" id="productType">
			<option value="">全部分类</option>
			<c:forEach items="${types}" var="type">
				<option value="${type.id}">${type.name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-md-4">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="输入礼品名" id="keyword">
         	<span class="input-group-btn">
         		<button type="button" class="btn btn-success" id="queryBtn">查询</button>
         	</span>
      	</div>
	</div>
	<div class="col-md-4">
		<button class="btn btn-success" id="addBtn">添加礼品</button>
	</div>
</div>
<p></p>
<div id="productList"></div>