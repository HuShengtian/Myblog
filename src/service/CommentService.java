package service;

import pojo.Comment;
import pojo.PageBean;

public interface CommentService {
	/**
	 * 获取评论
	 * @param id
	 * @param page
	 * @return
	 */
	PageBean<Comment> showComment(Integer id,Integer page);
	
	/**
	 * 给评论点赞
	 * @param id
	 */
	void dissComment(Integer id);
	
	/**
	 * 给评论差评
	 * @param id
	 */
	void loveComment(Integer id);
	
	/**
	 * 增加评论
	 * @param comment
	 */
	void addComment(Comment comment);
}
