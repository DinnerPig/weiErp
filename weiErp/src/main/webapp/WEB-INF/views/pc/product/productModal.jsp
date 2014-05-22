<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<input type="hidden" id="hiddenId" value="${product.id}">
<div class="modal-dialog">
    <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">
            	<c:choose>
	            	<c:when test="${product.id eq null}">
	            		新增礼品
	            	</c:when>
            		<c:otherwise>
            			修改礼品
            		</c:otherwise>
            	</c:choose>
            </h4>
         </div>
         <div class="modal-body">
         	<table class="my_table">
         		<tr>
         			<td>礼品分类</td>
         			<td>
         				<select id="editType" class="form-control">
         					<c:forEach items="${types}" var="type">
         						<c:choose>
         							<c:when test="${type.id eq product.type.id}">
		         						<option value="${type.id}" selected="selected">${type.name}</option>
         							</c:when>
         							<c:otherwise>
         								<option value="${type.id}">${type.name}</option>
         							</c:otherwise>
         						</c:choose>
         					</c:forEach>
         				</select>
         			</td>
         		</tr>
         		<tr>
                    <td>主图</td>
                    <td>
                        <span style="display:none;">上传中......<i class="fa fa-refresh fa-spin"></i></span>
                        <input type="file" onchange="product.upload(this,'main')" style="width:70px;">
                    </td>
                </tr>
                <tr>
                	<td colspan="2" id="mainImgTd">
                		<img src="${product.mainImage}?imageView/1/w/50/h/50">
                	</td>
                </tr>
         		<tr>
         			<td>编号</td>
         			<td><input type="text" class="form-control" id="editSerial" value="${product.serial}"></td>
         		</tr>
         		<tr>
         			<td>名称</td>
         			<td><input type="text" class="form-control" id="editName" value="${product.name}"></td>
         		</tr>
         		<tr>
         			<td>规格</td>
         			<td><input type="text" class="form-control" id="editStandard" value="${product.standard}"></td>
         		</tr>
         		<tr>
         			<td>单价</td>
         			<td><input type="text" class="form-control" id="editPrice" value="${product.price}"></td>
         		</tr>
         		<tr>
         			<td>分享金</td>
         			<td><input type="text" class="form-control" id="editShareCash" value="${product.shareCash}"></td>
         		</tr>
         		<tr>
                    <td>照片</td>
                    <td>
                        <span style="display:none;">上传中......<i class="fa fa-refresh fa-spin"></i></span>
                        <input type="file" onchange="product.upload(this)" style="width:70px;">
                    </td>
                </tr>
                <tr>
                	<td colspan="2" id="imgTd">
                		<c:forEach items="${product.images}" var="image">
                			<div class="my_imgList">
		                        <img src="${image.url}?imageView/1/w/50/h/50">
                				<button class="btn btn-info my_hoverDelBtn" onclick="product.delImg(this)"><i class="fa fa-trash-o"></i></button>
                			</div>
                    	</c:forEach>
                	</td>
                </tr>
         		<tr>
         			<td>描述</td>
         			<td><textarea id="editDescription" class="form-control">${product.description}</textarea></td>
         		</tr>
         	</table>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-info" onclick="product.modalEdit()">保存</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
         </div>
    </div>
</div>