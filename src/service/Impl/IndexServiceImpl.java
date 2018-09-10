package service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ArticleMapper;
import dao.TagMapper;
import pojo.Article;
import pojo.Index;
import pojo.MonthLine;
import pojo.PageBean;
import pojo.Sort;
import pojo.Tag;
import pojo.Tags;
import pojo.YearLine;
import service.IndexService;
@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
	private ArticleMapper articlemapper;
	@Autowired
	private TagMapper tagMapper;
	@Override
	public Index showIndex() {
		Index index = new Index();
		index.setArticleCount(articlemapper.articleCount());
		index.setArticles(articlemapper.selectHotArticle());
		List<Sort> sort = articlemapper.sortList();
		index.setSortList(sort);
		index.setSortCount(sort.size());
		List<Tag> tags = tagMapper.selectAll();
		index.setTags(tags);
		index.setTagCount(tags.size());
		return index;
	}
	@Override
	public PageBean<Article> showArticle(Integer page) {
		PageBean<Article> articleList = new PageBean<Article>();
		List<Article> articles = articlemapper.selectArticle((page-1)*10, 10);
		for (Article article : articles) {
			String content=article.getContent();
			content=content.replaceAll("#","");
			content=content.replaceAll("\\*", "");
			content=content.replaceAll("~", "");
			content=content.replaceAll(">", "");
			if (content.length()>120) {
				content=content.substring(0, 120);
				content+="...";
			}
			article.setContent(content);
		}
		int count = articlemapper.articleCount();
		articleList.setCurrentCount(10);
		articleList.setCurrentPage(page);
		articleList.setTotalCount(count);
		int totalPage=(int) Math.ceil((double)count/10);
		articleList.setTotalPage(totalPage);
		articleList.setList(articles);
		return articleList;
	}
	@Override
	public List<Tags> showTags() {
		List<Tag> tags = tagMapper.selectAll();
		List<Tags> tagsList = new ArrayList<Tags>();
		for(Tag tag: tags){
			Tags t = new Tags();
			t.setTag(tag);
			t.setArticles(articlemapper.selectArticleByTag(tag.getTag()));
			tagsList.add(t);
		}
		return tagsList;
	}
	@Override
	public List<Sort> showSorts() {
		List<Sort> sortList = articlemapper.sortList();
		for (Sort sort : sortList) {
			sort.setArticles(articlemapper.selectArticleBySort(sort.getSortName()));
		}
		return sortList;
	}
	@Override
	public List<YearLine> showTimes() {
		List<YearLine> years = articlemapper.selectAllYear();
		for (YearLine yearLine : years) {
			List<MonthLine> months = articlemapper.SelectAllMonth(yearLine.getYear());
			yearLine.setMonths(months);
			for (MonthLine month : months) {
				List<Article> articles = articlemapper.SelectArticleByTime(yearLine.getYear(), month.getMonth());
				month.setArticles(articles);
			}
		}
		return years;
	}
	@Override
	public List<Tags> showTagByName(String tag) {
		Tag tag2=new Tag();
		tag2.setTag(tag);
		List<Article> articles = articlemapper.selectArticleByTag(tag);
		Tags tags = new Tags();
		tags.setArticles(articles);
		tags.setTag(tag2);
		List<Tags> tagsList=new ArrayList<Tags>();
		tagsList.add(tags);
		return tagsList;
	}
	@Override
	public List<Sort> showSortByName(String sort) {
		Sort sort2 = new Sort();
		sort2.setSortName(sort);
		List<Article> articles = articlemapper.selectArticleBySort(sort);
		sort2.setArticles(articles);
		List<Sort> sortList =new ArrayList<Sort>();
		sortList.add(sort2);
		return sortList;
	}
}
