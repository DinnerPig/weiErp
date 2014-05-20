<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp" %>

<div class="container">
	<table class="table">
		<tr>
			<td>账号</td>
			<td>${consumer.username}</td>
		</tr>
		<tr>
			<td>真实姓名</td>
			<td><input type="text" value="${consumer.detail.trueName}" class="form-control" id="trueName"></td>
		</tr>
		<tr>
			<td>手机</td>
			<td><input type="text" value="${consumer.detail.phone}" class="form-control" id="phone"></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" value="${consumer.detail.email}" class="form-control" id="email"></td>
		</tr>
		<tr>
			<td>QQ</td>
			<td><input type="text" value="${consumer.detail.qq}" class="form-control" id="qq"></td>
		</tr>
		<tr>
			<td>收货地址</td>
			<td>
				<textarea rows="" cols="" class="form-control" id="address">${consumer.detail.address}</textarea>
			</td>
		</tr>
	</table>
</div>

<a class="btn btn-primary btn-block my_blockBtn" onclick="consumer.preModify(${consumer.id})">保存信息</a>

<c:choose>
	<c:when test="${consumer.degree == 1}">
		<a class="btn btn-success btn-block my_blockBtn" onclick="consumer.riseSharePage()">升级为分享会员</a>
	</c:when>
	<c:otherwise>
		<a class="btn btn-success btn-block my_blockBtn" onclick="consumer.riseSharePage()">银行账号信息</a>
	</c:otherwise>
</c:choose>

