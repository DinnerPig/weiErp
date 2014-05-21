var consumer = {
    
    //=============================注册登陆================================
        
    // 进入注册页面
    registerPage : function() {
        myUtil.showLoading();
        $.get("phone/consumer/registerPage", function(result) {
            myUtil.hideLoading();
            $("#loginDiv").html(result);
        }, "html");
    },
    
    // 准备注册
    preRegister : function() {
        
        var model = {
            shareSerial : $("#shareSerial").val().trim(),
            username : $("#username").val().trim(),
            password : $("#password").val().trim(),
            "detail.phone" : $("#phone").val().trim(),
            "detail.trueName" : $("#trueName").val().trim(),
            "detail.address" : $("#address").val().trim()
        };
        
        // 注册
        if(consumer.checkRegister(model)) {
            consumer.save(model, function(result) {
                if(result.status == 1) {
                    alert("注册成功");
                    
                    // 跳转到登陆页面
                    location = "phone/busi";
                }
                else if(result.status == 1004) {
                    alert("分享人编号不存在");
                }
                else if(result.status == 1007) {
                    alert("用户名重复");
                }
                else {
                    alert("注册失败");
                }
            });
        }
    },
    
    // 注册校验
    checkRegister : function(model) {
        if(model.shareSerial === "") {
            alert("分享编号不能为空");
            return false;
        }
        if(model.username === "") {
            alert("账号不能为空");
            return false;
        }
        if(model.password === "") {
            alert("密码不能为空");
            return false;
        }
        if(model["detail.phone"] === "") {
            alert("手机不能为空");
            return false;
        }
        if(model["detail.trueName"] === "") {
            alert("真实姓名不能为空");
            return false;
        }
        if(model["detail.address"] === "") {
            alert("收货地址不能为空");
            return false;
        }
        return true;
    },
    
    // 保存
    save : function(model, callback) {
        myUtil.showLoading();
        $.post("phone/consumer/save", model, function(result) {
            myUtil.hideLoading();
            
            if(callback) {
                callback(result);
            }
            
        }, "json");
    },
    
    // 准备修改
    preModify : function(id) {
        var model = {
            id : id,
            "detail.trueName" : $("#trueName").val().trim(),
            "detail.phone" : $("#phone").val().trim(),
            "detail.qq" : $("#qq").val().trim(),
            "detail.email" : $("#email").val().trim(),
            "detail.address" : $("#address").val().trim()
        };
        
        // 保存
        if(consumer.checkModify(model)) {
            consumer.save(model, function(result) {
                if(result.status == 1) {
                    alert("修改个人信息成功");
                }
                else {
                    alert("修改个人信息失败");
                }
            });
        }
    },
    
    // 修改校验
    checkModify : function(model) {
        if(model["detail.phone"] === "") {
            alert("手机不能为空");
            return false;
        }
        if(model["detail.trueName"] === "") {
            alert("真实姓名不能为空");
            return false;
        }
        if(model["detail.address"] === "") {
            alert("收货地址不能为空");
            return false;
        }
        return true;
    },
    
    //=============================分享会员================================
    
    // 升级成分享会员页面
    riseSharePage : function() {
        myUtil.showLoading();
        $.get("phone/consumer/riseSharePage", function(result) {
            myUtil.hideLoading();
            
            $("#mainContents").html(result);
        }, "html");
    },
    
    // 准备升级
    preRiseShare : function() {
        var model = {
            payAccount : $("#payAccount").val().trim(),
            bank : $("#bank").val().trim(),
            bankAccount : $("#bankAccount").val().trim(),
            bankUser : $("#bankUser").val().trim()
        };
        
        // 执行升级
        if(consumer.checkRiseShare(model)) {
            consumer.riseShare(model, function(result) {
                if(result.status == 1) {
                    alert("提交成功，24小时内通过审核即可升级成功");
                }
                else {
                    alert("提交失败");
                }
            });
        }
    },
    
    // 升级检查
    checkRiseShare : function(model) {
        if(model.payAccount === "") {
            alert("支付宝账号不能为空");
            return false;
        }
        if(model.bank === "") {
            alert("开户银行不能为空");
            return false;
        }
        if(model.bankAccount === "") {
            alert("银行账户不能为空");
            return false;
        }
        if(model.bankUser === "") {
            alert("开户人不能为空");
            return false;
        }
        return true;
    },
    
    // 执行升级提交
    riseShare : function(model, callback) {
        myUtil.showLoading();
        $.post("phone/consumer/applyRise", model, function(result) {
            myUtil.hideLoading();
            
            if(callback) {
                callback(result);
            }
        }, "json");
    },
    
    //=============================后台管理之会员升级================================
    
    // 查询会员信息
    queryById : function(id, callback) {
        $("#pcLoading").show();
        $.get("pc/consumer/query/" + id, function(result) {
            $("#pcLoading").hide();
            
            if(callback) {
                callback(result);
            }
            
        }, "html");
    },
    
    // 执行升级
    rise : function(id, callback) {
        $("#pcLoading").show();
        $.post("pc/consumer/rise/" + id, function(result) {
            $("#pcLoading").hide();
            
            if(callback) {
                callback(result);
            }
        }, "json");
    },
    
    //=============================后台管理之会员列表================================
    
    // 分页查询
    queryList : function(params) {
        
        $("#pcLoading").show();
        $.get("pc/consumer/list", params, function(result) {
            $("#pcLoading").hide();
            
            $("#mainContext").html(result);
            
            // 监听翻页事件
            myUtil.listenChangePage(function(page) {
                consumer.queryList({page:page});
            });

        }, "html");
    },
    
};
