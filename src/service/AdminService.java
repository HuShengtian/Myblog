package service;


import java.util.List;
import java.util.Set;

import pojo.Article;
import pojo.Sort;
import pojo.Tag;
import pojo.Users;


public interface AdminService {
	
	void upTag(String old,String newName);
	
	void upSort(String old,String newName);
	
	void delTag(String name);
	
	void delSrot(String name);
	
	void delArticle(Integer id);
	
	void updateArticle(Article article);
	Article showArticle(Integer id);
	/**
	 * ɾ������
	 * @param id
	 */
	void delComment(Integer id,Integer aid);
	/**
	 * ��¼����
	 * @param user
	 * @return
	 */
	Users  login(Users user);
	/**
	 * �������·���
	 * @param article
	 * @param set
	 */
	void addArticle(Article article,Set<String> set);
	
	List<Article> selectAllArticle();
	
	List<Sort> selectAllSort();
	
	List<Tag> selectAllTag();
	
	
}
