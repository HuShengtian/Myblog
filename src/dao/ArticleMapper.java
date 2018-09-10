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
     * ��������
     * @param record
     * @return
     */
    int insert(Article record);
    
    /**
     * ���ҵ�ƪ����
     * @param id
     * @return
     */
    Article selectByPrimaryKey(Integer id);
    
    /**
     * ����ȫ������
     * @return
     */
    List<Article> selectAll();
    
    /**
     * ��������
     * @param record
     * @return
     */
    int updateByPrimaryKey(Article record);
    
    /**
     * ���ӷÿ�
     * @param id
     * @return
     */
    int updateVisit(Integer id);
    
    
    /**
     * ����
     * @param id
     * @return
     */
    int updateStar(Integer id);
    
    /**
     * ������һƪ����
     * @param article
     * @return
     */
    Article selectPrevious(Article article);
    /**
     * ������һƪ����
     * @param article
     * @return
     */
    Article selectNext(Article article);
    
    /**
     * ��������
     */
    int addComment(Integer id);
    /**
     * ��������
     */
    int lessenComment(Integer id);
    
    /**
     * ��ȡ���µ�����
     * @return
     */
    int articleCount();
    
    /**
     * ��ȡ�����б�
     * @return
     */
    List<Sort> sortList();
    /**
     * ������������
     * @return
     */
    List<Article> selectHotArticle();
    /**
     * ��ҳ����
     * @param page  �ڼ�ҳ
     * @param count ÿҳ��ʾ�ĸ���
     * @return
     */
    List<Article> selectArticle(@Param("page")Integer page,@Param("count")Integer count);
    /**
     * ��ȡ��������
     * @return
     */
    int selectArticleCount();
    
    /**
     * ���ݱ�ǩ��ȡ����
     * @param tag
     * @return
     */
    List<Article> selectArticleByTag(String tag);
    
    /**
     * ���ݷ����ȡ����
     * @param sort
     * @return
     */
    List<Article> selectArticleBySort(String sort);
    /**
     * ��ȡ���
     * @return
     */
    List<YearLine> selectAllYear();
    
    /**
     * ��ȡ�·�
     * @param year
     * @return
     */
    List<MonthLine> SelectAllMonth(String year);
    /**
     * ��ȡʱ��ε�����
     * @param year
     * @param month
     * @return
     */
    List<Article> SelectArticleByTime(@Param("year") String year,@Param("month") String month);
}