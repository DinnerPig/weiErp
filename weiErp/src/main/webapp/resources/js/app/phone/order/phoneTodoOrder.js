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
			
		}, "html");
	},
};
