<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>

<c:forEach items="${products}" var="product">
	<li ontouchstart="" pid="${product.id}">
		<img src="${product.mainImage}">
		<div class="my-productBrief">
			<h4>${product.name}</h4>
			<p>原价：<span style="color:red">${product.price}</span>&nbsp;元</p>
			<p>
				优惠价：
				<span style="color:red">
					<c:choose>
						<c:when test="${sessionScope.prefer}">
							${product.preferPrice}
						</c:when>
						<c:otherwise>
							不可见
						</c:otherwise>
					</c:choose>
				</span>
				&nbsp;元
			</p>
			<p>
				分享金：
				<span style="color:red">
					<c:choose>
						<c:when test="${sessionScope.share}">
							${product.shareCash}
						</c:when>
						<c:otherwise>
							不可见
						</c:otherwise>
					</c:choose>
				</span>
				&nbsp;元
			</p>
		</div>
	</li>
</c:forEach>
<c:if test="${totalPage > page}">
	<li style="height:auto">
		<button class="btn btn-success my_blockBtn" id="moreBtn" page="${page}">查看更多</button>
	</li>
</c:if>
