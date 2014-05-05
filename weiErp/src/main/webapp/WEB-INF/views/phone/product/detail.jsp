<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>

<div class="my_detailBlock">
	<div id="detailBlock">
		<div class="my_productImg">
			<img src="${product.mainImage}">
		</div>

		<div class="my_params">
			<ul>
				<li ontouchstart=""><span class="my_leftParam">名称</span> <span>${product.name}</span>
				</li>
				<li ontouchstart=""><span class="my_leftParam">单价</span> <span>${product.price}</span>
				</li>
				<li ontouchstart=""><span class="my_leftParam">规格</span> <span>${product.standard}</span>
				</li>
			</ul>
		</div>
		
		<button class="btn btn-primary my_blockBtn" id="shopCarBtn"	pid="${product.id}">加入购物车</button>
		
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">产品描述</h3>
			</div>
			<div class="panel-body">${product.description}</div>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">产品图片</h3>
			</div>
			<div class="panel-body">
				<c:forEach items="${product.images}" var="image">
					<img src="${image.url}">
				</c:forEach>
			</div>
		</div>
	</div>

</div>
