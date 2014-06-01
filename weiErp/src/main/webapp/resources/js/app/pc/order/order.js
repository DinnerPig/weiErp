var order = {
    
    // 固定参数：订单状态
    status : 0,
        
    // 分页查询
    queryList : function(params) {
        
        $("#pcLoading").show();
        
        // 设置固定参数status
        if(params === undefined) {
            params = {};
        }
        params.status = order.status;
        
        $.get("pc/order/query/list", params, function(result) {
            $("#pcLoading").hide();
            
            $("#orderList").html(result);
            
            // 监听翻页事件
            order.listenChangePage();
            
        }, "html");
    },
    
    // 监听搜索订单号事件
    listenQueryByKey : function() {
        var keyword = $("#keyword").val().trim();
        
        // 组装分页查询参数
        var params = {
            page : 0,
            keyword : keyword,
        };
        
        var consumerId = $("#consumerId").val();
        if(consumerId !== "") {
            params.consumerId = consumerId;
        }
        
        // 查询
        order.queryList(params);
    },
    
    // 监听翻页事件
    listenChangePage : function() {
        
        $("#nextPage").click(function() {

            var params = {
                page : $(this).attr("page"),
                keyword : $("#keyword").val() 
            };
            
            var busiId = $("#busiId").val();
            if(busiId !== "") {
                params.busiId = busiId;
            }
            
            // 查询
            order.queryList(params);
        });
        
        $("#prevPage").click(function() {
            
            var params = {
                page : parseInt($(this).attr("page")) - 2,
                keyword : $("#keyword").val()
            };
            
            var busiId = $("#busiId").val();
            if(busiId !== "") {
                params.busiId = busiId;
            }
            
            // 查询
            order.queryList(params);
        });
    },
    
    // 改为发货状态
    done : function(id) {
        var expressSerial = prompt("请输入快递单号");
        
        if(expressSerial !== null) {
            $("#pcLoading").show();
            $.get("pc/order/done/" + id, {expressSerial:expressSerial}, function(result) {
                $("#pcLoading").hide();
                
                if(result.status == 1) {
                    myUtil.bsAlert("发货成功", 1);
                    order.queryList();
                }
                else {
                    myUtil.bsAlert("发货失败", 2);
                }
            }, "json");
        }
    },
    
    // 删除
    remove : function(id) {
        if(confirm("确定要删除吗？")) {
            $.get("pc/order/remove/" + id, function(result) {
                if(result.status == 1) {
                    alert("删除成功");
                    order.queryList();
                }
                else {
                    alert("删除失败");
                }
            }, "json");
        }
    },
    
    // 打印
    print : function(obj) {
        var attr = [];
        attr.push("class");
        attr.push("id");
        attr.push("style");
        attr.push("on");
        $(obj).parent().prev().printArea({mode:"popup", popClose:true, retainAttr:attr});
    }
    
};