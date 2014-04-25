var detail = {
        
    // 进入订单
	toOrder : function(id, callback) {
	    myUtil.showLoading();
	    $.get("phone/product/order/" + id, function(result) {
	        myUtil.hideLoading();
	        $("#orderDiv").html(result);
	        
	        if(callback) {
	            callback();
	        }
	    }, "html");
	}
};

$(document).ready(function(){
	
	//注册开始下单事件
	$("#orderBtn").click(function() {
	    var id = $(this).attr("pid");
	    detail.toOrder(id, function() {
	        
	        // 隐藏产品详情
	        $("#detailBlock").hide();
	        $("#detailBlock").parent().css("height", $("#orderDiv").height());
	        
	        // 随即生成订单号：PD + 时间序列
	        $("#serial").html("PD" + new Date().getTime());
	        
	        setTimeout(function() {
	            $("#orderDiv").css("-webkit-transform", "translate3d(0px, 0px, 0px)");
	            $("#orderDiv").css("-moz-transform", "translate3d(0px, 0px, 0px)");
	        }(), 10);
	    });
	});
});
