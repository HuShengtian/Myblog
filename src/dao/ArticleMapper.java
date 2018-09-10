package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Article;
import pojo.MonthLine;
import pojo.Sort;
import pojo.YearLine;

public interface ArticleMapper {
	
	int deleteBySort(String name);
	
	int updateBySort(@Param("old")String old,@Param("newName")String newName);

    int deleteByPrimaryKey(Integer id);
    
    /**
     * 新增文章
     * @param record
     * @return
     */
    int insert(Article record);
    
    /**
     * 查找单篇文章
     * @param id
     * @return
     */
    Article selectByPrimaryKey(Integer id);
    
    /**
     * 查找全部文章
     * @return
     */
    List<Article> selectAll();
    
    /**
     * 更新文章
     * @param record
     * @return
     */
    int updateByPrimaryKey(Article record);
    
    /**
     * 增加访客
     * @param id
     * @return
     */
    int updateVisit(Integer id);
    
    
    /**
     * 点赞
     * @param id
     * @return
     */
    int updateStar(Integer id);
    
    /**
     * 查找上一篇文章
     * @param article
     * @return
     */
    Article selectPrevious(Article article);
    /**
     * 查找下一篇文章
     * @param article
     * @return
     */
    Article selectNext(Article article);
    
    /**
     * 增加评论
     */
    int addComment(Integer id);
    /**
     * 减少评论
     */
    int lessenComment(Integer id);
    
    /**
     * 获取文章的数量
     * @return
     */
    int articleCount();
    
    /**
     * 获取分类列表
     * @return
     */
    List<Sort> sortList();
    /**
     * 查找热门文章
     * @return
     */
    List<Article> selectHotArticle();
    /**
     * 分页查找
     * @param page  第几页
     * @param count 每页显示的个数
     * @return
     */
    List<Article> selectArticle(@Param("page")Integer page,@Param("count")Integer count);
    /**
     * 获取文章数量
     * @return
     */
    int selectArticleCount();
    
    /**
     * 根据标签获取文章
     * @param tag
     * @return
     */
    List<Article> selectArticleByTag(String tag);
    
    /**
     * 根据分类获取文章
     * @param sort
     * @return
     */
    List<Article> selectArticleBySort(String sort);
    /**
     * 获取年份
     * @return
     */
    List<YearLine> selectAllYear();
    
    /**
     * 获取月份
     * @param year
     * @return
     */
    List<MonthLine> SelectAllMonth(String year);
    /**
     * 获取时间段的文章
     * @param year
     * @param month
     * @return
     */
    List<Article> SelectArticleByTime(@Param("year") String year,@Param("month") String month);
}