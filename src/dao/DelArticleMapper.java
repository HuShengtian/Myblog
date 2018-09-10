package dao;

import java.util.List;
import pojo.DelArticle;

public interface DelArticleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DelArticle record);

    DelArticle selectByPrimaryKey(Integer id);

    List<DelArticle> selectAll();

    int updateByPrimaryKey(DelArticle record);
}