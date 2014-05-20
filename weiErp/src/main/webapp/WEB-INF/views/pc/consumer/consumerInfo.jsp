<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>

<div class="modal-dialog">
    <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">会员信息</h4>
         </div>
         <div class="modal-body">
         	<table class="table">
         		<tr>
         			<td>会员账号</td>
         			<td>${consumer.username}</td>
         		</tr>
         		<tr>
         			<td>会员等级</td>
         			<td>
         				<c:choose>
         					<c:when test="${consumer.degree == 1}">
         						普通会员
         					</c:when>
         					<c:otherwise>
         						分享会员
         					</c:otherwise>
         				</c:choose>
         			</td>
         		</tr>
         		<tr>
         			<td>真实姓名</td>
         			<td>${consumer.detail.trueName}</td>
         		</tr>
         		<tr>
         			<td>支付宝账号</td>
         			<td>${consumer.bank.payAccount}</td>
         		</tr>
         		<tr>
         			<td>开户银行</td>
         			<td>${consumer.bank.bank}</td>
         		</tr>
         		<tr>
         			<td>银行账号</td>
         			<td>${consumer.bank.bankAccount}</td>
         		</tr>
         		<tr>
         			<td>开户人</td>
         			<td>${consumer.bank.bankUser}</td>
         		</tr>
         	</table>
         </div>
         <div class="modal-footer">
         	<button type="button" class="btn btn-warning" onclick="riseRecord.riseConsumer(${consumer.id})">升级为分享会员</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
         </div>
    </div>
</div>