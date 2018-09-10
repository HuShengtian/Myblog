package controller;



import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pojo.Article;
import pojo.Sort;
import pojo.Tags;
import pojo.Users;
import service.AdminService;
import service.IndexService;

/**
 * 用户相关的控制器
 * @date 2018年8月16日
 * @author yamoo
 *
 */
@Controller
public class AdminController {
	@Autowired
	AdminService service;
	@Autowired
	IndexService service2;
	
	@RequestMapping("/delTag/{name}")
	public String DelTag(@PathVariable String name){
		service.delTag(name);
		return "redirect:/admin";
	}
	
	@RequestMapping("/delSort/{name}")
	public String DelSort(@PathVariable String name){
		service.delSrot(name);
		return "redirect:/admin";
	}
	
	@RequestMapping("/upTag/{old}/{newName}")
	@ResponseBody
	public String upTag(@PathVariable String old,@PathVariable String newName){
		service.upTag(old, newName);
		return "";
	};
	
	@RequestMapping("/upSort/{old}/{newName}")
	@ResponseBody
	public String upSort(@PathVariable String old,@PathVariable String newName){
		service.upSort(old, newName);
		return "";
	};
	
	@RequestMapping("/delArticle/{id}")
	public String DelArticle(@PathVariable Integer id){
		service.delArticle(id);
		return "redirect:/admin";
	}
	
	@RequestMapping("/updateArticle")
	public String updateArticle(Article article){
		service.updateArticle(article);
		return "redirect:/admin";
	}
	
	@RequestMapping("/showUpdateArticle/{id}")
	public String showUpdateArticle(@PathVariable Integer id,HttpServletRequest request){
		List<Sort> sorts = service2.showSorts();
		request.setAttribute("sorts", sorts);
		request.setAttribute("article", service.showArticle(id));
		return "admin/updateArticle";
	}
	@RequestMapping("/delComment/{id}/{aid}")
	@ResponseBody
	public String delComment(@PathVariable Integer id,@PathVariable Integer aid){
		service.delComment(id,aid);
		return "";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(HttpServletRequest request){
		request.setAttribute("articleList", service.selectAllArticle());
		request.setAttribute("sortList", service.selectAllSort());
		request.setAttribute("tagList", service.selectAllTag());
		return "admin/admin";
	}
	/**
	 * 登录
	 * @param user
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Users user,ModelMap model,HttpSession session,HttpServletRequest request){
		Users login = service.login(user);
		if(login!=null){
			//model.
			session.setAttribute("user", login);
			return "redirect:/index";
		}else {
			request.setAttribute("msg", "<font color='red'>账号密码错误</font>");
			return "login";
		}
		
	}
	/**
	 * 提交文章
	 * 提交标签
	 * @param article
	 * @param response
	 * @param tags
	 */
	@RequestMapping("addArticle")
	public void addArticle(Article article,HttpServletResponse response,String tags){
		//装载标签的内容
		Set<String> set=new HashSet<String>();
		tags=tags.trim();
		String[] split = tags.split(" ");
		for (String string : split) {
			if(!string.equals(" ")&&!string.equals("")){
				set.add(string);
			}
		}
		service.addArticle(article,set);
		response.setHeader("Refresh", "3;url="+"/MyBlog/index");
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write("文章创建成功,三秒后返回主页..");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 进入新增文章界面
	 * @return
	 */
	@RequestMapping("newArticle")
	public String newArticle(HttpSession session,HttpServletRequest request){
		List<Sort> sorts = service2.showSorts();
		List<Tags> tags = service2.showTags();
		request.setAttribute("sorts", sorts);
		request.setAttribute("tags", tags);
		Users user = (Users)session.getAttribute("user");
		if(user==null){
			return "redirect:/login.jsp";
		}
		return "admin/newArticle";
	}
	
	/**
	 * 上传图片
	 * @param request
	 * @param response
	 * @param pictureFile
	 */
	@RequestMapping("/uploadPic")
	public void uploadPic(HttpServletRequest request,HttpServletResponse response,@RequestParam("editormd-image-file") MultipartFile pictureFile){
		 System.out.println("图片上传");
		try {
			 //获取上传过来的图片的全名
			  String filename = pictureFile.getOriginalFilename();
			  //获取图片的后缀名
			  String lastname = filename.substring(filename.lastIndexOf("."));
			  //新的文件名
			  String newName=UUID.randomUUID().toString().replaceAll("-", "")+lastname;
			  pictureFile.transferTo(new File(request.getServletContext().getRealPath("/upload")+"/"+newName));
			  System.out.println(request.getServletContext().getRealPath("/upload"));
	          //下面response返回的json格式是editor.md所限制的，规范输出就OK
	          response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/MyBlog/upload/" + newName + "\"}" );
	      } catch (Exception e) {
	          try {
	              response.getWriter().write( "{\"success\":0}" );
	          } catch (Exception e1) {
	              e1.printStackTrace();
	          }
	      }
	}
}
