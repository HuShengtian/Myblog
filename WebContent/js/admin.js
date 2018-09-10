function upSort(e){
	var old=$(e).parent().prev().val();
	var newName=window.prompt("请输入新的名字",old);
	if(newName!=null&&newName!=""){
		$.ajax({
			type : "get",
			url : "/MyBlog/upSort/" +old+ "/" + newName,
			/* dataType:"json", */
			success : function(data) {
				$(e).parent().prev().val(newName);
				$(e).attr({"onclick":"upSort(this,"+newName+")"});
			}
		});
	}	
}

function upTag(e){
	var old=$(e).parent().prev().val();
	var newName=window.prompt("请输入新的名字",old);
	if(newName!=null&&newName!=""){
		$.ajax({
			type : "get",
			url : "/MyBlog/upTag/" +old+ "/" + newName,
			/* dataType:"json", */
			success : function(data) {
				$(e).parent().prev().val(newName);
				$(e).attr({"onclick":"upSort(this,"+newName+")"});
			}
		});
	}	
}