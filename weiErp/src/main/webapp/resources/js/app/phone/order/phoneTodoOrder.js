var phoneTodoOrder = {
	
	// 查询详情
	detail : function(id) {
		location = "phone/product/detail/" + id;
	},
	
	// 查询全部
	queryAll : function() {
		
		myUtil.showLoading();
		$.get("phone/order/queryAll/", {status : 1}, function(result) {
			myUtil.hideLoading();
			
			$("#orderList").append(result);
			
			// 监听查看详情事件
			phoneTodoOrder.listenDetail();
			
		}, "html");
	},
	
	// 监听查询详情事件
	listenDetail : function() {
		$("div.my_products").contents().find("li").click(function() {
			product.detail($(this).attr("pid"));
		});
	}

};

$(document).ready(function(){
	
	// 执行查询
	phoneTodoOrder.queryAll();
});
