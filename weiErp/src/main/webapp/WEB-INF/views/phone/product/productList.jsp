<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>

<c:forEach items="${products}" var="product">
	<li ontouchstart="" pid="${product.id}">
		<img src="${product.mainImage}">
		<div>
			<h4>${product.name}</h4>
			<p style="color:red">${product.price}&nbsp;元</p>
		</div>
	</li>
</c:forEach>
<c:if test="${totalPage > page}">
	<li style="height:auto">
		<button class="btn btn-success my_blockBtn" id="moreBtn" page="${page}">查看更多</button>
	</li>
</c:if>
