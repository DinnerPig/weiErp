var qiniu = {
	
	config : {
		DOMAIN_NAME : "http://weierp.qiniudn.com/",
		UPLOAD_URL : "http://up.qiniu.com",
		//TODO 不应该暴露在js中，安全的做法是：每次上传时都从服务器端获取token，且过期时间很短
		UPLOAD_TOKEN : "2Q8XURjrvXltviwW7T77PZ-eJ7yikuLjs9h3jifo:-V7ITefTPkccTGXlGAgX5Jvs6QE=:eyJzY29wZSI6IndlaWVycCIsImRlYWRsaW5lIjoxNTg0MzI3OTIwLCJ0cmFuc2Zvcm0iOiJpbWFnZVZpZXcvMi93LzgwMC9xLzY1IiwiZm9wVGltZW91dCI6NSwibWltZUxpbWl0IjoiaW1hZ2UvKiJ9"
	},
	
	//上传 TODO 将参数改为js对象，防止因参数顺序导致的问题，callback除外
	upload : function(config, callback) {
		var xhr = new XMLHttpRequest();
        xhr.open('POST', qiniu.config.UPLOAD_URL, true);
        
        //html5特性
        var formData = new FormData();
        if(config.key) {
        	formData.append('key', config.key);
        }
        formData.append('token', config.token);
        formData.append('file', config.file);

        xhr.send(formData);
        
        xhr.onreadystatechange = function(response) {
        	
        	//回调处理
        	if(callback) {
        		callback(xhr);
        	}
        };
    
	}
	
};