<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp" %>

<input type="hidden" id="hiddenBusiId" value="${busi.id}">

<div class="container">
	<table class="table">
		<tr>
			<td>账号</td>
			<td>${busi.username}</td>
		</tr>
		<tr>
			<td>手机</td>
			<td><input type="text" value="${busi.phone}" class="form-control" id="busiPhone"></td>
		</tr>
		<tr>
			<td>QQ</td>
			<td><input type="text" value="${busi.qq}" class="form-control" id="busiQq"></td>
		</tr>
		<tr>
			<td>微信号</td>
			<td><input type="text" value="${busi.weixin}" class="form-control" id="busiWeixin"></td>
		</tr>
		<tr>
			<td>送货地址</td>
			<td>
				<textarea rows="" cols="" class="form-control" id="busiAddress">${busi.address}</textarea>
			</td>
		</tr>
	</table>
</div>

<a class="btn btn-primary btn-block my_blockBtn" onclick="busi.preSave()">保存信息</a>

