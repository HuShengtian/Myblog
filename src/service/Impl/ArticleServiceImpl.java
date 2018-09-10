package service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ArticleMapper;
import dao.CommentMapper;
import dao.TagMapper;
import pojo.Article;
import pojo.ArticleInfo;
import service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleMapper articleMapper;
	@Autowired
	TagMapper tagMapper;
	@Autowired
	CommentMapper commentMapper;
	
	@Override
	public ArticleInfo showArticle(Integer id) {
		articleMapper.updateVisit(id);
		ArticleInfo info = new ArticleInfo();
		Article article=articleMapper.selectByPrimaryKey(id);
		info.setArticle(article);
		info.setPrevious(articleMapper.selectPrevious(article));
		info.setNext(articleMapper.selectNext(article));
		info.setTags(tagMapper.selectTagById(id));
		return info;
	}

	@Override
	public void addStar(Integer id) {
		articleMapper.updateStar(id);
	}

	@Override
	public int ArticleCount() {
		return articleMapper.articleCount();
	}

}
