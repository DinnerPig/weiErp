<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>

<c:forEach items="${products}" var="product">
	<li ontouchstart="" pid="${product.id}">
		<c:forEach items="${product.images}" var="image" varStatus="idx">
			<c:if test="${idx.count eq 1}">
				<img src="${image.url}">
			</c:if>
		</c:forEach>
		<div>
			<h4>${product.name}</h4>
			<p>${product.description}</p>
		</div>
	</li>
</c:forEach>
<c:if test="${totalPage > page}">
	<li style="height:auto">
		<button class="btn btn-success my_blockBtn" id="moreBtn" page="${page}">查看更多</button>
	</li>
</c:if>
