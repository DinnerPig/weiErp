var phoneDoneOrder = {
    
    // 分页查询
    queryList : function(params) {
        
        if(params === undefined) {
            params = {};
        }
        params.status = 2;
        
        myUtil.showLoading();
        $.get("phone/order/query/list", params, function(result) {
            myUtil.hideLoading();
            
            $("#orderList").append(result);
            
            // 监听查看更多事件
            phoneDoneOrder.listenMore();
            
            // 监听查看产品详情事件
            phoneDoneOrder.listenDetail();
            
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
                    page : page
                };
                
                // 删掉“查看更多”按钮
                $("#moreBtn").closest("li").remove();
                
                // 执行查询
                phoneDoneOrder.queryList(params);
            });
        }
    },
    
    // 监听搜索产品关键字事件
    listenQueryByKey : function() {
        var keyword = $("#keyword").val().trim();
        
        // 组装分页查询参数
        var params = {
            page : 0,
            keyword : keyword
        };
        
        // 先清空列表
        $("#orderList").html("");
        
        // 查询
        phoneDoneOrder.queryList(params);
    },
    
    // 监听查询产品详情事件
    listenDetail : function() {
        $("#orderList").children("li").click(function() {
            location = "phone/order/detail/" + $(this).attr("orderid");
        });
    }
};

$(document).ready(function(){
    
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
