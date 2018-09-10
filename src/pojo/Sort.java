package pojo;

import java.util.List;

public class Sort {
	private String sortName;
	private Integer sortCount;
	private List<Article> articles;
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public Integer getSortCount() {
		return sortCount;
	}
	public void setSortCount(Integer sortCount) {
		this.sortCount = sortCount;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
