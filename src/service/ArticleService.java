package service;

import pojo.ArticleInfo;

public interface ArticleService {

	
	/**
	 * �鿴����������Ϣ
	 * @param id
	 * @return
	 */
	ArticleInfo showArticle(Integer id);
	
	/**
	 * ����
	 * @param id
	 */
	void addStar(Integer id);
	
	int ArticleCount();
}
