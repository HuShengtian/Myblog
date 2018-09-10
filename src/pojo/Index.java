package pojo;

import java.util.List;

public class Index {
	private int articleCount; //文章数量
	private int sortCount;
	private int tagCount;
	private List<Sort> sortList;  //分类列表
	private List<Article> articles;
	private List<Tag> tags;	
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	public int getSortCount() {
		return sortCount;
	}
	public void setSortCount(int sortCount) {
		this.sortCount = sortCount;
	}
	public int getTagCount() {
		return tagCount;
	}
	public void setTagCount(int tagCount) {
		this.tagCount = tagCount;
	}
	public List<Sort> getSortList() {
		return sortList;
	}
	public void setSortList(List<Sort> sortList) {
		this.sortList = sortList;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
}
