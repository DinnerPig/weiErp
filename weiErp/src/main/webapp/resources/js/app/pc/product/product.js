var product = {
    
    // 分页查询
    queryList : function(params) {
        
        $("#pcLoading").show();
        $.get("pc/product/query/list", params, function(result) {
            $("#pcLoading").hide();
            
            $("#productList").html(result);
            
            // 监听翻页事件
            product.listenChangePage();
            
        }, "html");
    },
    
    // 监听搜索产品关键字事件
    listenQueryByKey : function() {
        var keyword = $("#keyword").val().trim();
        
        // 组装分页查询参数
        var params = {
            size : 10,
            page : 0,
            keyword : keyword
        };
        
        var type = $("#productType").val();
        if(type !== "") {
            params.typeId = type;
        }
        
        // 查询
        product.queryList(params);
    },
    
    // 监听新增礼品事件
    listenAdd : function() {
        $("#addBtn").click(function() {
            product.modal();
        });
    },
    
    // 打开礼品编辑页面
    modal : function(id) {
        $.get("pc/product/modal", {id:id}, function(result) {
            $("#productModal").html(result).modal("show");
            
            // 监听鼠标悬浮显示删除按钮事件
            product.listenImgDelBtn();
            
        }, "html");
    },
    
    // 保存
    save : function(model) {
        if(product.check(model)) {
            $("#pcLoading").show();
            $.ajax({
                type: "POST",
                url: "pc/product/save",
                data: JSON.stringify(model),
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success: function(result){
                    $("#pcLoading").hide();
                    if(result.status == 1) {
                        $("#productModal").modal("hide");
                        myUtil.bsAlert("保存成功", 1);
                        product.queryList();
                    }
                    else {
                        myUtil.bsAlert("保存失败", 2);
                    }
            
                }
            });
        }
    },
    
    // 校验
    check : function(model) {
        
        if(model.serial === "") {
            myUtil.bsAlert("编号不能为空", 3);
            return false;
        }
        
        if(model.name === "") {
            myUtil.bsAlert("名称不能为空", 3);
            return false;
        }
        
        if(model.price == "" || !isFinite(model.price)) {
            myUtil.bsAlert("单价不能为空，且必须为数字", 3);
            return false;
        }
        
        return true;
    },
    
    // 编辑礼品
    modalEdit : function() {
        var model = {
            type : {
                id : $("#editType").val()
            },
            serial : $("#editSerial").val(),
            description : $("#editDescription").val(),
            name : $("#editName").val(),
            standard : $("#editStandard").val(),
            price : $("#editPrice").val(),
        };
        
        var mainImage = $("#mainImgTd").children("img").attr("src");
        model.mainImage = mainImage.substring(0, mainImage.indexOf("?"));;
        
        var id = $("#hiddenId").val();
        if(id !== "") {
            model.id = id;
        } 
        
        // 礼品图片
        var images = [];
        $("#imgTd").contents().find("img").each(function() {
            var url = $(this).attr("src");
            url = url.substring(0, url.indexOf("?"));
            images.push({url : url});
        });
        model.images = images;
        
        product.save(model);
    },
    
    // 监听翻页事件
    listenChangePage : function() {
        
        var params = {
            size : 10,
        };
        
        $("#nextPage").click(function() {
           
            params.page = $(this).attr("page");
            params.keyword = $("#keyword").val();
            
            var type = $("#productType").val();
            if(type !== "") {
                params.typeId = type;
            }
            
            // 查询
            product.queryList(params);
        });
        
        $("#prevPage").click(function() {
            
            params.page = parseInt($(this).attr("page")) - 2;
            params.keyword = $("#keyword").val();
            
            var type = $("#productType").val();
            if(type !== "") {
                params.typeId = type;
            }
            
            // 查询
            product.queryList(params);
        });
    },
    
    // 删除
    del : function(id) {
        if(confirm("确定要删除吗")) {
            $("#pcLoading").show();
            $.get("pc/product/del/" + id, function(result) {
                $("#pcLoading").hide();
                
                if(result.status == 1) {
                    myUtil.bsAlert("删除成功", 1);
                    product.queryList();
                }
                else {
                    myUtil.bsAlert("删除失败", 2);
                }
            }, "json");
        }
    },
    
    // 监听鼠标悬浮显示删除按钮事件
    listenImgDelBtn : function() {
        $("#imgTd").children("div").mouseenter(function() {
            product.showDelBtn($(this));
        })
        .mouseleave(function() {
            product.hideDelBtn($(this));
        });
    },
    
    // 显示删除按钮
    showDelBtn : function(obj) {
        obj.children("button").show();
    },
    
    // 隐藏删除按钮
    hideDelBtn : function(obj) {
        obj.children("button").hide();
    },
    
    // 删除图片
    delImg : function(obj) {
        $(obj).closest("div.my_imgList").remove();
    },
    
    // 显示礼品大图
    showBigImg : function(obj) {
        var src = $(obj).attr("src");
        $("#productImgModal").load("resources/model/pc/product/productImgModal.jsp", function() {
            $("#productImgModal").modal("show");
            $("#productBigImg").attr("src", src.substring(0, src.indexOf("?")));
        });
    },
    
    // 上传图片
    upload : function(obj, type) {
        
        // 1.获取上传文件路径
        var path = $(obj).val();
        
        if(path == "") {
            return;
        }

        var token = qiniu.config.UPLOAD_TOKEN;
        var files = $(obj)[0].files;
        if (files.length > 0) {
            
            //开始上传
            $(obj).prev().show(); //loading....
            
            //配置上传参数
            var config = {file : files[0], token : token};
            qiniu.upload(config, function(xhr) {
                
                //上传成功
                if(xhr.readyState == 4 && xhr.status == 200 && xhr.responseText != "") {
                    
                    //隐藏loading...
                    $(obj).prev().hide(); 
                    
                    var blkRet = JSON.parse(xhr.responseText);
                    var key = blkRet.key;
                    
                    //赋值
                    if(type === "main") {
                        $("#mainImgTd").html("<img class='my_smImg' src='" + qiniu.config.DOMAIN_NAME + key + "?imageView/1/w/50/h/50'>");
                    }
                    else {
                        $("#imgTd").append("<div class='my_imgList'>" +
                                "<img class='my_smImg' src='" + qiniu.config.DOMAIN_NAME + key + "?imageView/1/w/50/h/50'>" +
                                "<button class='btn btn-info my_hoverDelBtn' onclick='product.delImg(this)'><i class='fa fa-trash-o'></i></button>" +
                                "</div>");
                    }
                }
                
                //上传失败
                else if (xhr.status != 200 && xhr.responseText) {
                    
                    //隐藏loading...
                    $(obj).prev().hide(); 
                    
                    //文件格式错误
                    if(xhr.status == 403) {
                        myUtil.bsAlert("上传文件格式错误，只能上传图片类型", 3);
                    } 
                    
                    //其他错误
                    else {
                        myUtil.bsAlert("上传失败", 2);
                    }
                }
                
            });
        } else {
            myUtil.bsAlert("请选择要上传的文件", 3);
        }
    }
    
};
