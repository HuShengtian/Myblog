package pojo;

import java.util.List;

public class ArticleInfo {
	private Article previous;
	private Article next;
	private Article article;
	private List<Tag> tags;
	
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public Article getPrevious() {
		return previous;
	}
	public void setPrevious(Article previous) {
		this.previous = previous;
	}
	public Article getNext() {
		return next;
	}
	public void setNext(Article next) {
		this.next = next;
	}

}
