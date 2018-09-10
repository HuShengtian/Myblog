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
 * ������صĿ�����
 * @date 2018��8��16��
 * @author yamoo
 *
 */
@Controller
public class ArticleController {
	@Autowired
	private ArticleService service;
	
	
	

	
	/**
	 * չʾ������������
	 * @param id
	 */
	@RequestMapping("/showArticle/{id}")
	public String showArticle(@PathVariable Integer id,HttpServletRequest request){
		ArticleInfo articleInfo = service.showArticle(id);
		request.setAttribute("articleInfo", articleInfo);
		return "article";
	}
	
	
	/**
	 * ����
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
