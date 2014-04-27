var order = {
		
	submit : function(pid) {
		
	    if(confirm("确定要提交订单吗？")) {
	    
	        var json = {
                serial : $("#serial").html(),
                address : $("#address").val().trim(),
                note : $("#note").val()
	        };
	        
	        // 订单产品
	        var products = [];
	        $("tr[name=product]").each(function() {
	            var product = {
	                id : $(this).attr("pid"),
	                amount : $(this).contents().find("input[name=amount]").val()
	            };
	            products.push(product);
	        });
	        
	        json.products = products;
	        
	        if(order.check(json)) {
	            order.realSubmit(json);
	        }
	    }
	},
	
	// 校验参数
	check : function(json) {
	    
	    if(json.products.length <= 0) {
	        alert("您还没有选择礼品");
	        return;
	    }
	    
	    for(var i=0; i<json.products.length; i++) {
	        if(!/^[0-9]+$/.test(json.products[i].amount)) {
	            alert("产品数量必须为数字", 3);
	            return false;
	        }
	    }
	    
	    if(json.address === "") {
	        alert("送货地址不能为空", 3);
            return false;
	    }
	    
	    return true;
	},
	
	// 执行提交
	realSubmit : function(json) {
	    myUtil.showLoading();
	    
	    $.ajax({
	        url : "phone/order/create",
	        data : JSON.stringify(json),
	        type : "POST",
	        contentType : "application/json",
	        dataType : "json",
	        success : function(result) {
	            myUtil.hideLoading();
	            if(result.status == 1) {
	                order.back();
	                alert("订单提交成功");
	            }
	            else {
	                alert("订单提交失败");
	            }
	        }
	    });
	},
	
	// 返回详情
	back : function() {
	    
	    // 隐藏产品详情
        $("#detailBlock").show();
        $("#detailBlock").parent().css("height", "auto");
        $("#orderDiv").css("-webkit-transform", "translate3d(500px, 0px, 0px)");
        $("#orderDiv").css("-moz-transform", "translate3d(500px, 0px, 0px)");
	},
	
	// 更新卖出数量
	updateOutAmount : function(id) {
	    var outAmount = $("#outAmount").val().trim();
	    $.post("phone/order/update/" + id, {outAmount : outAmount}, function(result) {
	        if(result.status == 1) {
	            alert("修改卖出数量成功");
	        }
	        else {
	            alert("修改卖出数量失败");
	        }
	    }, "json");
	}
};
