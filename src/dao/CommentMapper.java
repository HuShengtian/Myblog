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
     * ��ҳ��ѯ����
     * @param aricleId
     * @param page
     * @param count
     * @return
     */
    List<Comment> selectByAricleId(@Param("articleId")Integer articleId,@Param("page")Integer page,@Param("count")Integer count);
    /**
     * ��ѯ������
     * @param aricleId
     * @return
     */
    int selectCount(Integer articleId);
    
    /**
     * ��
     * @param id
     * @return
     */
    int addLove(Integer id);
    
    /**
     * ��
     * @param id
     * @return
     */
    int addDiss(Integer id);
}