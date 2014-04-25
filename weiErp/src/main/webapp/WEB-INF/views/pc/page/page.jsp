<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<!-- 分页 - begin -->
<ul class="pager" style="margin:50px;">
   	<c:choose>
		<c:when test="${page <= 1}">
			<li class="previous disabled"><a href="javascript:void(0)"><i class="fa fa-chevron-left"></i>&nbsp;上一页</a></li>
		</c:when>
		<c:otherwise>
			<li class="previous"><a href="javascript:void(0)" id="prevPage" page="${page}"><i class="fa fa-chevron-left"></i>&nbsp;上一页</a></li>
		</c:otherwise>
	</c:choose>
    <li style="line-height:30px;">共&nbsp;<label>${totalPage}</label>&nbsp;页，第&nbsp;<label>${page}</label>&nbsp;页</li>
    <c:choose>
		<c:when test="${page eq totalPage}">
			<li class="next disabled"><a href="javascript:void(0)">下一页&nbsp;<i class="fa fa-chevron-right"></i></a></li>
		</c:when>
		<c:otherwise>
			<li class="next"><a href="javascript:void(0)" id="nextPage" page="${page}">下一页&nbsp;<i class="fa fa-chevron-right"></i></a></li>
		</c:otherwise>
	</c:choose>
</ul>
<!-- 分页 - end -->