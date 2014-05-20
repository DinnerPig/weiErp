<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp" %>

<div class="container">
	<table class="table">
		<tr>
			<td>支付宝账号</td>
			<td><input type="text" value="${bank.payAccount}" class="form-control" id="payAccount"></td>
		</tr>
		<tr>
			<td>开户银行</td>
			<td><input type="text" value="${bank.bank}" class="form-control" id="bank"></td>
		</tr>
		<tr>
			<td>银行账户</td>
			<td><input type="text" value="${bank.bankAccount}" class="form-control" id="bankAccount"></td>
		</tr>
		<tr>
			<td>开户人</td>
			<td><input type="text" value="${bank.bankUser}" class="form-control" id="bankUser"></td>
		</tr>
	</table>
</div>

<c:choose>
	<c:when test="${degree == 1}">
		<a class="btn btn-success btn-block my_blockBtn" onclick="consumer.preRiseShare()">升级</a>
	</c:when>
	<c:otherwise>
		<a class="btn btn-success btn-block my_blockBtn" onclick="consumer.modifyBank(${bank.id})">银行账号信息</a>
	</c:otherwise>
</c:choose>
