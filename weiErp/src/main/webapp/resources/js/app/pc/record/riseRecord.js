var riseRecord = {
        
    // 进入记录页面
    recordPage : function() {
        $("#pcLoading").show();
        $.get("record/rise/recordPage", function(result) {
            $("#pcLoading").hide();
            $("#mainContext").html(result);
            
            // 执行查询
            riseRecord.queryList(null);
        }, "html");
    },
    
    // 执行查询
    queryList : function(params) {
        $("#pcLoading").show();
        $.get("record/rise/records", params, function(result) {
            $("#pcLoading").hide();
            $("#contentList").html(result);
        }, "html");
    },
    
    // 查询用户信息
    queryConsumer : function(id) {
        consumer.queryById(id, function(result) {
            $("#consumerModal").html(result).modal("show");
        });
    },
    
    // 升级用户
    riseConsumer : function(id) {
        if(confirm("确定要升级为分享会员吗？")) {
            consumer.rise(id, function(result) {
                $("#consumerModal").modal("hide");
                if(result.status == 1) {
                    myUtil.bsAlert("升级成功", 1);
                }
                else {
                    myUtil.bsAlert("升级失败", 1);
                }
            });
        }
    },
    
    // 删除记录
    remove : function(id) {
        if(confirm("确定要升级为分享会员吗？")) {
            $("#pcLoading").show();
            $.get("record/rise/remove/" + id, function(result) {
                $("#pcLoading").hide();
                
                if(result.status == 1) {
                    myUtil.bsAlert("删除成功", 1);
                    
                    // 刷新
                    riseRecord.queryList(null);
                }
                else {
                    myUtil.bsAlert("删除失败", 1);
                }
            }, "json");
        }
    }
};