function show(path){
	$.ajax({
		type : "get",
		url : "/MyBlog/show/"+path,
		/* dataType:"json", */
		success : function(data) {
			$("#right_Content").html(data);
			$("#"+path).siblings().removeClass("active");
			$("#"+path).addClass("active");
		}
	});
}

function show2(path,page){
	$.ajax({
		type : "get",
		url : "/MyBlog/show/"+path+"/"+page,
		/* dataType:"json", */
		success : function(data) {
			$("#right_Content").html(data);
		}
	});
}

