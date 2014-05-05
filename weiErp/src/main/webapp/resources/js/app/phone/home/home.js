var home = {
		
	// 进入相应菜单
	query : function(type) {
		
		// 经销商入口
		if(type == "busi") {
			location = "phone/busi";
		}
	},
	
	// 点击导航菜单
	menu : function(obj, type) {
	    myUtil.showLoading();
	    $.get("phone/menu/" + type, function(result) {
	        myUtil.hideLoading();
	        
	        $(obj).siblings().removeClass("my-naviActive");
	        $(obj).addClass("my-naviActive");
	        
	        $("#mainContents").html(result);
	        
	        // 监听事件
	        if(type === "product") {
	            product.listenProductType();
	        }
	    });
	}
};

$(document).ready(function(){
	
	// 注册菜单点击事件
	$("div[name^=menu]").click(function() {
		var type = $(this).attr("name").substring(5);
		home.query(type);
	});
});
