<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>

<c:forEach items="${orders}" var="order">
	<li ontouchstart="" orderid="${order.id}">
		<div>${order.serial}</div>
		<div><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm"/></div>
	</li>
</c:forEach>

<c:if test="${totalPage > page}">
	<li style="height:auto">
		<button class="btn btn-success my_blockBtn" id="moreBtn" page="${page}">查看更多</button>
	</li>
</c:if>