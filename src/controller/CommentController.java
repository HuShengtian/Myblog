package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Comment;
import pojo.PageBean;
import service.CommentService;

@Controller
public class CommentController {
	@Autowired
	CommentService service;
	
	@RequestMapping("/showComment/{id}/{page}")
	public String showComment(@PathVariable Integer id,@PathVariable Integer page,HttpSession session){
		PageBean<Comment> commentList = service.showComment(id, page);
		session.setAttribute("commentList", commentList);
		return "page/comment";
	}
	
	@RequestMapping("/loveComment/{id}")
	@ResponseBody
	public String loveComment(@PathVariable Integer id){
		service.loveComment(id);
		return "";
	}
	
	@RequestMapping("/dissComment/{id}")
	@ResponseBody
	public String dissComment(@PathVariable Integer id){
		service.dissComment(id);
		return "";
	}
	
	@RequestMapping("/addComment")
	@ResponseBody
	public String addComment(Comment comment){
		service.addComment(comment);
		return "";
	}
}
