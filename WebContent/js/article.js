function submitForm() {
	var form = $("#submitForm");
	$.ajax({
		type : "post",
		url : form.attr("action"),
		data : form.serialize(),
		/* dataType:"json", */
		success : function() {
			alert("提交成功!");
			showComment(1);
			form[0].reset();
			$("#addComment").html(function(i, text) {
				var c = parseInt(text, 10);
				return c + 1;
			});
		}
	});
}

/**
 * 展示评论
 * 
 * @param articleId
 * @param page
 * @returns
 */
function showComment(page) {
	$.ajax({
		type : "get",
		url : "/MyBlog/showComment/" + $("#articleId").val() + "/" + page,
		/* dataType:"json", */
		success : function(data) {
			$("#showComment").html(data);
		}
	});
}

/**
 * 赞
 * 
 * @param cid
 * @returns
 */
function loveComment(cid) {
	$.ajax({
		type : "get",
		url : "/MyBlog/loveComment/" + cid,
		/* dataType:"json", */
		success : function() {
			$("#l_" + cid).html(function(i, text) {
				var c = parseInt(text, 10);
				return c + 1;
			});
			$("#love_" + cid).css({
				"color" : "red"
			});
			$("#love_" + cid).removeAttr("onclick");
			$("#diss_" + cid).removeAttr("onclick");

		}
	});
}

/**
 * 踩
 * 
 * @param cid
 * @returns
 */
function dissComment(cid) {
	$.ajax({
		type : "get",
		url : "/MyBlog/dissComment/" + cid,
		/* dataType:"json", */
		success : function() {
			$("#d_" + cid).html(function(i, text) {
				var c = parseInt(text, 10);
				return c + 1;
			});
			$("#diss_" + cid).css({
				"color" : "red"
			});
			$("#love_" + cid).removeAttr("onclick");
			$("#diss_" + cid).removeAttr("onclick");
		}
	});
}
/**
 * 已经点过赞了
 * 
 * @returns
 */
function loved() {
	alert("你已经赞过这个文章了");
}

/**
 * 文章点赞
 * 
 * @param articleId
 *            文章id
 * @returns
 */
function love_article(articleId) {
	$.ajax({
		type : "get",
		url : "/MyBlog/addStar/" + articleId,
		/* dataType:"json", */
		success : function() {
			$("#love").html(function(i, text) {
				var c = parseInt(text, 10);
				return c + 1;
			});
			$("#love1").css({
				"color" : "red"
			});
			$("#loveClick").html("已点赞");
			$("#loveClick").attr({
				"onclick" : "loved()"
			});
		}
	});
}

function deletecm(commentId){
	$.ajax({
		type : "get",
		url : "/MyBlog/delComment/" + commentId+"/"+$("#articleId").val(),
		/* dataType:"json", */
		success : function() {
			showComment(1);
			$("#addComment").html(function(i, text) {
				var c = parseInt(text, 10);
				return c - 1;
			});
		}
	});
}