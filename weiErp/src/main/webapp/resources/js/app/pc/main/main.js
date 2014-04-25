var main = {
    
    // 点击菜单
    clickMenu : function(url, obj) {
        $("#pcLoading").show();
        $.get(url, function(result) {
            $("#pcLoading").hide();
            $("#mainContext").html(result);
            
            // 礼品
            if(url === "pc/product/page") {
                var params = {
                    page : 0
                };
                product.queryList(params);
                
                // 监听搜索产品关键字事件
                $("#queryBtn").click(function() {
                    product.listenQueryByKey();
                });
                
                // 监听新增礼品事件
                product.listenAdd();
            }
            
            // 经销商
            if(url === "pc/busi/query/list") {
                var params = {
                    page : 0
                };
                busi.queryList(params);
            }
            
            // 订单
            if(url === "pc/order/page") {
                var params = {
                    page : 0
                };
                
                // 初始化订单全局状态
                order.status = obj.attr("status");
                
                order.queryList(params);
                
                // 监听搜索产品关键字事件
                $("#queryBtn").click(function() {
                    order.listenQueryByKey();
                });
            }
            
        }, "html");
    },
    
    // 监听菜单点击事件
    listenMenu : function() {
        $("div.panel-default").contents().find("div[name=submenu]").click(function() {
            var url = $(this).attr("url");
            main.clickMenu(url, $(this));
        });
    }
};

$(document).ready(function() {
   
    main.listenMenu();
});