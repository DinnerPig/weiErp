<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<button class="btn btn-success" id="addBtn">新增经销商账号</button>
<p></p>
<table class="table table-striped">
	<tr>
		<th>#</th>
		<th>编号</th>
		<th>账号</th>
		<th>密码</th>
		<th>真实姓名</th>
		<th>手机</th>
		<th>收货地址</th>
		<th>QQ</th>
		<th>微信号</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${busis}" var="busi" varStatus="idx">
		<tr>
			<td>${idx.count}</td>
			<td>${busi.serial}</td>
			<td>${busi.username}</td>
			<td>${busi.password}</td>
			<td>${busi.realname}</td>
			<td>${busi.phone}</td>
			<td>${busi.address}</td>
			<td>${busi.qq}</td>
			<td>${busi.weixin}</td>
			<td>
				<button class="btn btn-success" title="修改" onclick="busi.modal(${busi.id})"><i class="fa fa-pencil"></i></button>
			    <button class="btn btn-danger" title="删除" onclick="busi.del(${busi.id}, this)"><i class="fa fa-trash-o"></i></button>
			</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="../page/page.jsp"%>
