<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<table class="table table-striped">
	<tr>
		<th>#</th>
		<th>编号</th>
		<th>类型</th>
		<th>主图</th>
		<th>名称</th>
		<th>规格</th>
		<th>单价</th>
		<th>图片</th>
		<th>描述</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${products}" var="product" varStatus="idx">
		<tr>
			<td>${idx.count}</td>
			<td>${product.serial}</td>
			<td>${product.type.name}</td>
			<td>
				<img alt="" src="${product.mainImage}?imageView/1/w/50/h/50" onclick="product.showBigImg(this)">
			</td>
			<td>${product.name}</td>
			<td>${product.standard}</td>
			<td>${product.price}</td>
			<td>
				<c:forEach items="${product.images}" var="image">
					<img src="${image.url}?imageView/1/w/50/h/50" onclick="product.showBigImg(this)">
				</c:forEach>
			</td>
			<td>${product.description}</td>
			<td>
				<button class="btn btn-success" title="修改" onclick="product.modal(${product.id})"><i class="fa fa-pencil"></i></button>
			    <button class="btn btn-danger" title="删除" onclick="product.del(${product.id}, this)"><i class="fa fa-trash-o"></i></button>
			</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="../page/page.jsp"%>
