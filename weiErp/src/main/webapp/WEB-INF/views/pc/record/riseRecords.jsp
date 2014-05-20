<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<table class="table table-striped">
	<tr>
		<th>#</th>
		<th>申请账号</th>
		<th>申请时间</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${records}" var="record" varStatus="idx">
		<tr>
			<td>${idx.count}</td>
			<td>
				<a href="javascript:void(0)" onclick="riseRecord.queryConsumer(${record.consumer.id})">${record.consumer.username}</a>
			</td>
			<td><fmt:formatDate value="${record.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>
			    <button class="btn btn-danger" title="删除" onclick="riseRecord.remove(${record.id})"><i class="fa fa-trash-o"></i></button>
			</td>
		</tr>
	</c:forEach>
</table>
