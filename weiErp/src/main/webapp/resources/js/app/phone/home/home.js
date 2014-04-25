var home = {
		
	// 进入相应菜单
	query : function(type) {
		
		// 经销商入口
		if(type == "busi") {
			location = "phone/busi";
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
