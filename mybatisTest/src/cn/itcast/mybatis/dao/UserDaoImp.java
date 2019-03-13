package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImp implements UserDao {
    //向dao实现类中注入sqlsessionFactory
    //通过构造方法注入
    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImp(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;

    }
    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
       User user=sqlSession.selectOne("test.FindUserBy  Id",id);
        sqlSession.close();
        return user;
    }

    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser",user);
        sqlSession.close();


    }

    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser",id);
        sqlSession.close();
    }
}
