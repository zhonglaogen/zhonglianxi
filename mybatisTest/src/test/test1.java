package test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class test1 {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws IOException {
        //mybatis配置文件
        String resource="config/SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置信息
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

    }
    @Test
    public void testFindUserById() throws Exception {
        SqlSession  sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo=new UserQueryVo();
        User user=new User();
        userQueryVo.setUser(user);
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);
        ids.add(7);
        userQueryVo.setIds(ids);
       List<User> users= userMapper.FindUserList(userQueryVo);
        System.out.println(users);
        sqlSession.close();
    }
    @Test
    public void insertUsertest() throws Exception {
        SqlSession  sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user1=new User();
        user1.setName("baonana");
        user1.setSex("women");
        user1.setAge(23);
        userMapper.insertUser(user1);
        sqlSession.commit();
        sqlSession.close();
    }
}
