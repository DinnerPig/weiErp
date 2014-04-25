var product = {
	
	// 查询详情
	detail : function(id) {
		location = "phone/product/detail/" + id;
	},
	
	// 分页查询
	queryList : function(params) {
		
		myUtil.showLoading();
		$.get("phone/product/query/" + $("#typeId").val(), params, function(result) {
			myUtil.hideLoading();
			
			$("#productList").append(result);
			
			// 监听查看更多事件
			product.listenMore();
			
			// 监听查看产品详情事件
			product.listenDetail();
			
		}, "html");
	},
	
	// 监听查看更多事件
	listenMore : function() {
		
		// 当按钮存在时监听
		if($("#moreBtn").length > 0) {
			$("#moreBtn").click(function() {
				var page = $(this).attr("page");
				
				// 查询参数
				var params = {
					size : 10,
					page : page
				};
				
				// 删掉“查看更多”按钮
				$("#moreBtn").closest("li").remove();
				
				// 执行查询
				product.queryList(params);
				
			});
		}
	},
	
	// 监听搜索产品关键字事件
	listenQueryByKey : function() {
		var keyword = $("#keyword").val().trim();
		
		// 组装分页查询参数
		var params = {
			size : 10,
			page : 0,
			keyword : keyword
		};
		
		// 先清空列表
		$("#productList").html("");
		
		// 查询
		product.queryList(params);
	},
	
	// 监听查询产品详情事件
	listenDetail : function() {
		$("div.my_products").contents().find("li").click(function() {
			product.detail($(this).attr("pid"));
		});
	}

};

$(document).ready(function(){
	
	// 执行分页查询
	var params = {
		size : 10,
		page : 0
	};
	product.queryList(params);
	
	// 监听关键字查询
	$("#queryBtn").click(function() {
	    product.listenQueryByKey();
	});
});
