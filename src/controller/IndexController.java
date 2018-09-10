package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Article;
import pojo.Index;
import pojo.PageBean;
import pojo.Tags;
import service.IndexService;

@Controller
public class IndexController {
	@Autowired
	IndexService service;
	/**
	 * ��ת���ض���ҳ��
	 * @param path
	 * @param request
	 * @return
	 */
	@RequestMapping("/index/{path}")
	public String showIndex(@PathVariable String path,HttpServletRequest request){
		System.out.println("·��������ҳ");
		Index indexInfo = service.showIndex();
		request.setAttribute("indexInfo", indexInfo);
		request.setAttribute("type", path);
		return "index";
	}
	/**
	 * ��ת���ض���ҳ��
	 * @param path
	 * @param request
	 * @return
	 */
	@RequestMapping("/index/tag/{path}")
	public String showIndexByTag(@PathVariable String path,HttpServletRequest request){
		System.out.println("��ǩ������ҳ");
		Index indexInfo = service.showIndex();
		request.setAttribute("indexInfo", indexInfo);
		request.setAttribute("type","tag");
		request.setAttribute("value", path);
		System.out.println(path);
		return "index";
	}
	@RequestMapping("/index/sort/{path}")
	public String showIndexBySort(@PathVariable String path,HttpServletRequest request){
		System.out.println("��ǩ������ҳ");
		Index indexInfo = service.showIndex();
		request.setAttribute("indexInfo", indexInfo);
		request.setAttribute("type","sort");
		request.setAttribute("value", path);
		System.out.println(path);
		return "index";
	}
	/**
	 * Ĭ����ҳ
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String show(HttpServletRequest request){
		System.out.println("Ĭ�ϼ�����ҳ");
		Index indexInfo = service.showIndex();
		request.setAttribute("indexInfo", indexInfo);
		request.setAttribute("type", "articleList");
		return "index";
	}
	/**
	 * ��ת����һҳ
	 * @param request
	 * @return
	 */
	@RequestMapping("/show/articleList")
	public String showArticle(HttpServletRequest request){
		PageBean<Article> articleList = service.showArticle(1);
		request.setAttribute("articleList", articleList);
		return "page/articleList";
	}
	/**
	 * ��ת����Nҳ
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/show/articleList/{page}")
	public String showArticles(@PathVariable int page,HttpServletRequest request){
		PageBean<Article> articleList = service.showArticle(page);
		request.setAttribute("articleList", articleList);
		return "page/articleList";
	}

	@RequestMapping("/show/tagList")
	public String showTags(HttpServletRequest request){
		List<Tags> tagsList = service.showTags();
		request.setAttribute("tagsList", tagsList);
		return "page/tagList";
	}
	
	@RequestMapping("/show/sortList")
	public String showSorts(HttpServletRequest request){
		request.setAttribute("sortList", service.showSorts());
		return "page/sortList";  
	}
	
	@RequestMapping("/show/timeList")
	public String showTimes(HttpServletRequest request){
		request.setAttribute("YearList", service.showTimes());
		return "page/timeList";
	}
	
	@RequestMapping("/show/tag/{tag}")
	public String showTag(@PathVariable String tag,HttpServletRequest request){
		request.setAttribute("tagsList", service.showTagByName(tag));
		return "page/tagList";
	}
	@RequestMapping("/show/sort/{sort}")
	public String showSort(@PathVariable String sort,HttpServletRequest request){
		request.setAttribute("sortList", service.showSortByName(sort));
		return "page/sortList";
	}
	@RequestMapping("/show/about")
	public String showAbout(){
		return "page/about";
	}
}
