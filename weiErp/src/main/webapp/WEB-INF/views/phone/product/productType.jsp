<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>

<div class="my_bigType">
	<ul>
		<c:forEach items="${types}" var="type">
			<li ontouchstart="" tid="${type.id}">${type.name}</li>
		</c:forEach>
	</ul>
</div>
