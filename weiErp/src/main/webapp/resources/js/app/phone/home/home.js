var home = {
		
	// 进入相应菜单
	query : function(type) {
		
		// 经销商入口
		if(type == "busi") {
			location = "phone/busi";
		}
	},
	
	// 点击导航菜单
	menu : function(type) {
	    
	    $.get("", function() {
	        
	    });
	    // 个人中心
	    if(type === "center") {
	        
	    }
	    
	    // 购物车
	    else if(type === "shopCar") {
	        location = "";
	    }
	    
	    // 礼品
	    else if(type === "product") {
	        
	    }
	    
	    // 注销
	    else if(type === "logout") {
	        
	    }
	}
};

$(document).ready(function(){
	
	// 注册菜单点击事件
	$("div[name^=menu]").click(function() {
		var type = $(this).attr("name").substring(5);
		home.query(type);
	});
});
