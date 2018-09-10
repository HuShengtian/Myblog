package service;


import java.util.List;

import pojo.Article;
import pojo.Index;
import pojo.PageBean;
import pojo.Sort;
import pojo.Tags;
import pojo.YearLine;

public interface IndexService {
	Index showIndex();
	
	PageBean<Article> showArticle(Integer page);
	
	List<Tags> showTags();
	
	List<Tags> showTagByName(String tag);
	
	List<Sort> showSorts();
	
	List<Sort> showSortByName(String sort);
	
	List<YearLine> showTimes();
}
