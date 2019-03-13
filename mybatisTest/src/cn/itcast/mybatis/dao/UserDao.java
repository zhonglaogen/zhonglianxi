package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;

public interface UserDao {
    //根据id查询用户id
    public User findUserById(int id)throws  Exception;
    //添加用户信息
    public void insertUser(User user)throws Exception;
    //删除用户信息
    public void deleteUser(int id)throws  Exception;

}
