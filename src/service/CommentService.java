package service;

import pojo.Comment;
import pojo.PageBean;

public interface CommentService {
	/**
	 * ��ȡ����
	 * @param id
	 * @param page
	 * @return
	 */
	PageBean<Comment> showComment(Integer id,Integer page);
	
	/**
	 * �����۵���
	 * @param id
	 */
	void dissComment(Integer id);
	
	/**
	 * �����۲���
	 * @param id
	 */
	void loveComment(Integer id);
	
	/**
	 * ��������
	 * @param comment
	 */
	void addComment(Comment comment);
}
