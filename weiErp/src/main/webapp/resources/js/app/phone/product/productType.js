$(document).ready(function(){
	$("div.my_bigType").contents().find("li").click(function() {
		location = "phone/product/show/" + $(this).attr("tid");
	});
});
