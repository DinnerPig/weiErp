var detail = {
        
    // 进入订单
	toOrder : function(callback) {
	    myUtil.showLoading();
	    $.get("phone/order/page", function(result) {
	        myUtil.hideLoading();
	        $("#orderDiv").html(result);
	        
	        if(callback) {
	            callback();
	        }
	    }, "html");
	},
	
	// 添加到购物车
	addShopCar : function(productId, amount) {
	    $.post("phone/order/shopCar", {productId:productId, amount:amount}, function(result) {
	        if(result.status == 1) {
	            alert("添加到购物车成功", 1);
	        } 
	        else {
	            alert("添加到购物车失败", 2);
	        }
	    }, "json");
	}
};

$(document).ready(function(){
	
	//注册开始下单事件
	$("#orderBtn").click(function() {
	    detail.toOrder(function() {
	        
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
	
	// 监听添加到购物车事件
    $("#shopCarBtn").click(function() {
        var id = $(this).attr("pid");
        
        // 添加到购物车
        var amount = window.prompt("请输入产品数量");
        if(/^[0-9]+$/.test(amount)) {
            detail.addShopCar(id, amount);
        }
        else {
            alert("数量必须为数字");
        }
    });
});
