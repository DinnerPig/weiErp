var product = {
	
    // 监听点击礼品分类事件
    listenProductType : function() {
        $("div.my_bigType").contents().find("li").click(function() {
            product.showPage($(this).attr("tid"));
        });
    },
    
    // 监听关键字查询
    listenQueryByKey : function() {
        $("#queryBtn").click(function() {
            product.queryByKey();
        });
    },
    
    // 监听加入购物车事件
    listenAddShopCar : function() {
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
    },
    
    // 显示礼品列表主页面
    showPage : function(typeId) {
        $.get("phone/product/show/" + typeId, function(result) {
            $("#mainContents").html(result);
            
            // 执行分页查询
            product.queryList(null);
            
            // 监听关键字查询
            product.listenQueryByKey();
            
        }, "html");
    },
    
	// 查询详情
	detail : function(id) {
	    $.get("phone/product/detail/" + id, function(result) {
	        $("#mainContents").html(result);
	        
	        // 监听结算事件
	        product.listenToOrder();
	        
	        // 监听加入购物车事件
	        product.listenAddShopCar();
	        
	    }, "html");
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
	
	// 根据关键字搜索产品
	queryByKey : function() {
		var keyword = $("#keyword").val().trim();
		
		// 组装分页查询参数
		var params = {
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
	
});
