<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<input type="hidden" id="hiddenId" value="${busi.id}">
<div class="modal-dialog">
    <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">
            	<c:choose>
	            	<c:when test="${busi.id eq null}">
	            		新增经销商
	            	</c:when>
            		<c:otherwise>
            			修改经销商
            		</c:otherwise>
            	</c:choose>
            </h4>
         </div>
         <div class="modal-body">
         	<table class="my_table">
         		<tr>
         			<td>编号</td>
         			<td><input type="text" class="form-control" id="editSerial" value="${busi.serial}"></td>
         		</tr>
         		<tr>
         			<td>账号</td>
         			<td><input type="text" class="form-control" id="editUsername" value="${busi.username}"></td>
         		</tr>
         		<tr>
         			<td>密码</td>
         			<td><input type="text" class="form-control" id="editPassword" value="${busi.password}"></td>
         		</tr>
         		<tr>
         			<td>真实姓名</td>
         			<td><input type="text" class="form-control" id="editRealname" value="${busi.realname}"></td>
         		</tr>
         		<tr>
         			<td>手机号</td>
         			<td><input type="text" class="form-control" id="editPhone" value="${busi.phone}"></td>
         		</tr>
         		<tr>
         			<td>收货地址</td>
         			<td><input type="text" class="form-control" id="editAddress" value="${busi.address}"></td>
         		</tr>
         		<tr>
         			<td>QQ</td>
         			<td><input type="text" class="form-control" id="editQq" value="${busi.qq}"></td>
         		</tr>
         		<tr>
         			<td>微信号</td>
         			<td><input type="text" class="form-control" id="editWeixin" value="${busi.weixin}"></td>
         		</tr>
         	</table>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-info" onclick="busi.modalEdit()">保存</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
         </div>
    </div>
</div>