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
	
	// 查询未发货订单
	queryOrder : function(type) {
	    if(type === "todo") {
	        $("#mainContents").load("resources/model/phone/order/phoneTodoOrder.jsp", function() {
	            
	            // 执行查询
	            phoneTodoOrder.queryAll();
	        });
	    }
	    else if(type === "done") {
	        $("#mainContents").load("resources/model/phone/order/phoneDoneOrder.jsp", function() {
	            
	            // 执行分页查询
	            var params = {
	                    page : 0
	            };
	            phoneDoneOrder.queryList(params);
	            
	            // 监听关键字查询
	            $("#queryBtn").click(function() {
	                phoneDoneOrder.listenQueryByKey();
	            });
	        });
	        
	    }
	}
};
