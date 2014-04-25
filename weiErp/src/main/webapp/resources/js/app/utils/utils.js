//工具类方法（通过dom对象调用的）都写成zepto的拓展方法，调用时就方便了，其他的还是要定义一个全局变量myUtil

var myUtil = {

	//显示loading
	showLoading : function() {
		$("#loadingDiv").show();
		startAnimation();
	},
	
	//隐藏loading
	hideLoading : function() {
		stopAnimation();
		$("#loadingDiv").hide();
	},
	
	// bootstrap弹出框
    bsAlert : function(content, type) {
        if (type == 1) {
            content = "<i class='fa fa-check-circle-o' style='color:green;font-size:20px'></i>&emsp;"
                    + content;
        } 
        else if (type == 2) {
            content = "<i class='fa fa-times-circle-o' style='color:#e74c3c;font-size:20px'></i>&emsp;"
                    + content;
        } 
        else if (type == 3) {
            content = "<i class='fa fa-info-circle' style='color:#d35400;font-size:20px'></i>&emsp;"
                    + content;
        }
        $("#alertContent").html(content);
        $('#alertDiv').modal('show');
    },
    
    // 检查session是否过期，过期则返回登陆界面
    checkSession : function(status) {
        if(status == -2) {
            location = "pc";
        }
    }
};

