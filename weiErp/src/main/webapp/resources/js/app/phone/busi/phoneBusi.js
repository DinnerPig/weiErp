var busi = {
	
    // 保存信息前
    preSave : function() {
        var model = {
            id : $("#hiddenBusiId").val(),
            phone : $("#busiPhone").val().trim(),
            qq : $("#busiQq").val().trim(),
            weixin : $("#busiWeixin").val().trim(),
            address : $("#busiAddress").val().trim()
        };
        busi.save(model);
    },
      
    // 保存
	save : function(model) {
	    if(busi.check(model)) {
	        myUtil.showLoading();
	        $.post("phone/busi/modify", model, function(result) {
	            myUtil.hideLoading();
	            if(result.status == 1) {
	                alert("修改个人信息成功");
	            }
	            else {
	                alert("修改个人信息失败");
	            }
	        }, "json");
	    }
	},
	
	// 表单校验
	check : function(model) {
	    if(model.phone === "") {
	        alert("手机号不能为空");
	        return false;
	    }
	    if(model.address === "") {
            alert("送货地址不能为空");
            return false;
        }
	    return true;
	}
};
