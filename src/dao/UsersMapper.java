package dao;

import java.util.List;
import pojo.Users;

public interface UsersMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    Users selectByPrimaryKey(Integer userId);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);
    
    Users selectByUsernameUserpassword(Users user);
}