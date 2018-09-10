package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Comment;

public interface CommentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);
    /**
     * 分页查询评论
     * @param aricleId
     * @param page
     * @param count
     * @return
     */
    List<Comment> selectByAricleId(@Param("articleId")Integer articleId,@Param("page")Integer page,@Param("count")Integer count);
    /**
     * 查询评论数
     * @param aricleId
     * @return
     */
    int selectCount(Integer articleId);
    
    /**
     * 赞
     * @param id
     * @return
     */
    int addLove(Integer id);
    
    /**
     * 踩
     * @param id
     * @return
     */
    int addDiss(Integer id);
}