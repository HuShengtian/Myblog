package service;

import pojo.ArticleInfo;

public interface ArticleService {

	
	/**
	 * 查看单个文章信息
	 * @param id
	 * @return
	 */
	ArticleInfo showArticle(Integer id);
	
	/**
	 * 点赞
	 * @param id
	 */
	void addStar(Integer id);
	
	int ArticleCount();
}
