var busi = {
    
    // 分页查询
    queryList : function(params) {
        
        $("#pcLoading").show();
        $.get("pc/busi/query/list", params, function(result) {
            $("#pcLoading").hide();
            
            $("#mainContext").html(result);
            
            // 监听翻页事件
            busi.listenChangePage();

            // 监听新增礼品事件
            busi.listenAdd();
            
        }, "html");
    },
    
    // 监听新增事件
    listenAdd : function() {
        $("#addBtn").click(function() {
            busi.modal();
        });
    },
    
    // 打开编辑页面
    modal : function(id) {
        $.get("pc/busi/modal", {id:id}, function(result) {
            $("#busiModal").html(result).modal("show");
        }, "html");
    },
    
    // 保存
    save : function(model) {
        if(busi.check(model)) {
            $("#pcLoading").show();
            $.post("pc/busi/save", model, function(result) {
                $("#pcLoading").hide();
                if(result.status == 1) {
                    $("#busiModal").modal("hide");
                    myUtil.bsAlert("保存成功", 1);
                    busi.queryList();
                }
                else if(result.status == 1007) {
                    myUtil.bsAlert("该用户名已存在", 3);
                }
                else {
                    myUtil.bsAlert("保存失败", 2);
                }
            }, "json");
        }
    },
    
    // 校验
    check : function(model) {
        
        if(model.serial === "") {
            myUtil.bsAlert("编号不能为空", 3);
            return false;
        }
        
        if(model.username === "") {
            myUtil.bsAlert("账号不能为空", 3);
            return false;
        }
        
        if(model.password === "") {
            myUtil.bsAlert("密码不能为空", 3);
            return false;
        }
        
        if(model.realname === "") {
            myUtil.bsAlert("真实姓名不能为空", 3);
            return false;
        }
        
        if(model.phone === "") {
            myUtil.bsAlert("手机号不能为空", 3);
            return false;
        }
        
        return true;
    },
    
    // 编辑经销商
    modalEdit : function() {
        var model = {
            username : $("#editUsername").val(),
            password : $("#editPassword").val(),
            realname : $("#editRealname").val(),
            phone : $("#editPhone").val(),
            serial : $("#editSerial").val(),
            address : $("#editAddress").val(),
            qq : $("#editQq").val(),
            weixin : $("#editWeixin").val()
        };
        
        var id = $("#hiddenId").val();
        if(id !== "") {
            model.id = id;
        } 
        
        busi.save(model);
    },
    
    // 监听翻页事件
    listenChangePage : function() {
        
        var params = {
            size : 10,
        };
        
        $("#nextPage").click(function() {
           
            params.page = $(this).attr("page");
            
            // 查询
            busi.queryList(params);
            
        });
        
        $("#prevPage").click(function() {
            
            params.page = parseInt($(this).attr("page")) - 2;
            
            // 查询
            busi.queryList(params);
            
        });
    },
    
    // 删除
    del : function(id) {
        if(confirm("确定要删除吗")) {
            $("#pcLoading").show();
            $.get("pc/busi/delete/" + id, function(result) {
                $("#pcLoading").hide();
                
                if(result.status == 1) {
                    myUtil.bsAlert("删除成功", 1);
                    busi.queryList();
                } 
                else if(result.status == -3) {
                    myUtil.bsAlert("该供应商已存在订单信息，不能删除", 3);
                    busi.queryList();
                }
                else {
                    myUtil.bsAlert("删除失败", 2);
                }
            }, "json");
        }
    }
    
};
