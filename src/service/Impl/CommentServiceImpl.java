package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ArticleMapper;
import dao.CommentMapper;
import pojo.Comment;
import pojo.PageBean;
import service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public PageBean<Comment> showComment(Integer id,Integer page) {
		PageBean<Comment> comments = new PageBean<Comment>();
		int count = commentMapper.selectCount(id);   //ÆÀÂÛ×ÜÊý
		List<Comment> com = commentMapper.selectByAricleId(id, (page-1)*5, 5);
		comments.setCurrentCount(5);
		comments.setCurrentPage(page);
		comments.setTotalCount(count);
		comments.setList(com);
		int totalPage=(int) Math.ceil((double)count/5);
		comments.setTotalPage(totalPage);
		return comments;
	}

	@Override
	public void dissComment(Integer id) {
		commentMapper.addDiss(id);
		
	}

	@Override
	public void loveComment(Integer id) {
		commentMapper.addLove(id);
	}

	@Override
	public void addComment(Comment comment) {
		commentMapper.insert(comment);
		articleMapper.addComment(comment.getArticleId());
	}

}
