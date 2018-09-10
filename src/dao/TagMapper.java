package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Tag;

public interface TagMapper {
	
	int delTagByName(String name);

    int insert(Tag record);

    List<Tag> selectAll();
    
    List<Tag> selectTagById(Integer id);
    
    int updateByTag(@Param("old")String old,@Param("newName")String newName);
    
}