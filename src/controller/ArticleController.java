package controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ArticleInfo;
import service.ArticleService;
/**
 * 文章相关的控制器
 * @date 2018年8月16日
 * @author yamoo
 *
 */
@Controller
public class ArticleController {
	@Autowired
	private ArticleService service;
	
	
	

	
	/**
	 * 展示单个文章详情
	 * @param id
	 */
	@RequestMapping("/showArticle/{id}")
	public String showArticle(@PathVariable Integer id,HttpServletRequest request){
		ArticleInfo articleInfo = service.showArticle(id);
		request.setAttribute("articleInfo", articleInfo);
		return "article";
	}
	
	
	/**
	 * 点赞
	 * @param id
	 * @return
	 */
	@RequestMapping("/addStar/{id}")
	@ResponseBody
	public String addLove(@PathVariable Integer id){
		service.addStar(id);
		return "";
	}
}
