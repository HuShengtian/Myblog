package dao;

import java.util.List;
import pojo.Visiter;

public interface VisiterMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Visiter record);

    Visiter selectByPrimaryKey(Integer id);

    List<Visiter> selectAll();

    int updateByPrimaryKey(Visiter record);
}