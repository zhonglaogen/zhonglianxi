package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserQueryVo;

import java.util.List;

public interface UserMapper {
    public User FindUserById(int id)throws Exception;
    public List<User> FindUserList(UserQueryVo userQueryVo)throws Exception;
    public void insertUser (User user)throws Exception;


}
