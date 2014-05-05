var detail = {
        
	// 添加到购物车
	addShopCar : function(productId, amount) {
	    $.post("phone/order/shopCar", {productId:productId, amount:amount}, function(result) {
	        if(result.status == 1) {
	            alert("添加到购物车成功", 1);
	        } 
	        else {
	            alert("添加到购物车失败", 2);
	        }
	    }, "json");
	}
};
