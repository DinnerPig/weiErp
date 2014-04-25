<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8" />
<title>后台管理</title>
<link href="resources/js/plugin/bootstrap3/css/bootstrap.css" rel="stylesheet">
<link href="resources/style/plugin/font-awesome-4.0.1/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/style/app/pc/common/pc.css" rel="stylesheet">
<link href="resources/style/app/pc/main/main.css" rel="stylesheet">
<link href="resources/style/app/pc/product/pcProduct.css" rel="stylesheet">
</head>
<body>

	<nav role="navigation" class="navbar navbar-inverse zzl_header">
       <div class="container">
          <div class="row">
             <div class="col-md-12">
                <div class="navbar-header">
                  <a class="navbar-brand">后台管理 </a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                  <li><a href="pc"><i class="fa fa-power-off"></i>&nbsp;登出</a></li>
                </ul>
              </div>
            </div>
        </div>
    </nav>
    <div style="text-align: center;margin-top: 40px;">
        <div class="row">
            <div class="col-md-2">
                <div class="panel-group" id="accordion">
                  <div class="panel panel-default" style="border-top:none;">

                    <div class="panel-heading">
                    	<h4 class="panel-title">
				        	<a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne1">
				        		经销商管理
				        	</a>
				      	</h4>
                    </div>
                    <div id="collapseOne1" class="panel-collapse in">
                        <div class="panel-body" url="pc/busi/query/list" name="submenu" style="cursor: pointer;">
                                                                            经销商列表
                        </div>
                    </div>
                    <div class="panel-heading">
                    	<h4 class="panel-title">
				        	<a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne2">
				        		礼品管理
				        	</a>
				      	</h4>
                    </div>
                    <div id="collapseOne2" class="panel-collapse collapse">
                        <div class="panel-body" url="pc/product/page" name="submenu" style="cursor: pointer;">
                                                                            礼品列表
                        </div>
                    </div>
                    <div class="panel-heading">
                    	<h4 class="panel-title">
				        	<a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne3">
				        		订单管理
				        	</a>
				      	</h4>
                    </div>
                    <div id="collapseOne3" class="panel-collapse collapse">
                        <div class="panel-body" url="pc/order/page" status="1" name="submenu" style="cursor: pointer;">
                                                                            未发货订单
                        </div>
                        <div class="panel-body" url="pc/order/page" status="2" name="submenu" style="cursor: pointer;">
                                                                            已发货订单
                        </div>
                    </div>
                  </div>
                </div>
            </div>
            <div class="col-md-10">
                <div style="height:auto;width:auto;text-align:left;">
                    <div class="container-fluid" id="mainContext" style="position: relative;">
                        <div class="row">
                            <div class="col-md-12" style="color:gray;font-size: 30px;padding-top:200px;text-align: center;">欢迎来到后台管理系统</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>      
    </div>

	<!-- 礼品编辑 -->
	<div class="modal fade" id="productModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>
	
	<!-- 礼品图片放大 -->
	<div class="modal fade" id="productImgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>    
    
    <!-- 经销商编辑 -->
	<div class="modal fade" id="busiModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>
    
    <!-- 加载中 -->
    <div class="my_pcLoading" id="pcLoading">
        <img alt="加载中..." src="resources/images/pc/loadingUI1.GIF">
    </div>

    <!-- 公用提示框begin -->
    <div class="modal fade" id="alertDiv" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="z-index:2000">
        <div class="modal-dialog" style="width:400px;">
            <div class="modal-content">
                 <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">提示信息</h4>
                 </div>
                 <div class="modal-body" id="alertContent" style="text-align: center;"></div>
                 <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="common_alert_btn">关闭</button>
                 </div>
            </div>
        </div>
    </div>
    <!-- 公用提示框end -->
	
	<!-- 	js资源 -->
	<script type="text/javascript" src="resources/js/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/js/plugin/bootstrap3/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="resources/js/app/utils/qiniu/qiniu.js"></script>
	
	<script type="text/javascript" src="resources/js/app/pc/main/main.js"></script>
	
	<!-- 工具 -->
	<script type="text/javascript" src="resources/js/app/utils/utils.js"></script>
	
	<!-- 礼品 -->
	<script type="text/javascript" src="resources/js/app/pc/product/product.js"></script>
	
	<!-- 经销商 -->
	<script type="text/javascript" src="resources/js/app/pc/busi/pcBusi.js"></script>
	
	<!-- 订单 -->
	<script type="text/javascript" src="resources/js/app/pc/order/order.js"></script>
	
	<!-- 记得删掉 -->
	<script src="http://qtestbucket.qiniudn.com/demo/CryptoJS.js" type="text/javascript"></script>
	<script type="text/javascript" src="resources/js/app/utils/qiniu/token.js"></script>
	
</body>
</html>

