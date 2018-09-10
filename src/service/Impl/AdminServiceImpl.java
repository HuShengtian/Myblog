package service.Impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.ArticleMapper;
import dao.CommentMapper;
import dao.TagMapper;
import dao.UsersMapper;
import pojo.Article;
import pojo.Sort;
import pojo.Tag;
import pojo.Users;
import service.AdminService;
@Component
public class AdminServiceImpl implements AdminService {

	@Autowired
	UsersMapper mapper;
	@Autowired
	ArticleMapper articleMapper;
	@Autowired
	TagMapper tagMapper;
	@Autowired
	CommentMapper comMapper;
	@Override
	public Users login(Users user) {
		Users users = mapper.selectByUsernameUserpassword(user);
		return users;
	}
	@Override
	public void addArticle(Article article,Set<String> set) {
		articleMapper.insert(article);
		for (String string : set) {
			Tag tag = new Tag();
			tag.setId(article.getId());
			tag.setTag(string);
			tagMapper.insert(tag);
		}
	}
	@Override
	public void delComment(Integer id,Integer aid) {
		articleMapper.lessenComment(aid);
		comMapper.deleteByPrimaryKey(id);
	}
	@Override
	public List<Article> selectAllArticle() {
		
		return articleMapper.selectAll();
	}
	@Override
	public List<Sort> selectAllSort() {
		
		return articleMapper.sortList();
	}
	@Override
	public List<Tag> selectAllTag() {
		// TODO Auto-generated method stub
		return tagMapper.selectAll();
	}
	@Override
	public Article showArticle(Integer id) {
		
		return articleMapper.selectByPrimaryKey(id);
	}
	@Override
	public void updateArticle(Article article) {
		articleMapper.updateByPrimaryKey(article);
		
	}
	@Override
	public void delArticle(Integer id) {
		articleMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public void upSort(String old, String newName) {
		articleMapper.updateBySort(old, newName);
		
	}
	@Override
	public void upTag(String old, String newName) {
		tagMapper.updateByTag(old, newName);
		
	}
	@Override
	public void delTag(String name) {
		tagMapper.delTagByName(name);	
	}
	@Override
	public void delSrot(String name) {
		articleMapper.deleteBySort(name);
		
	}

}
