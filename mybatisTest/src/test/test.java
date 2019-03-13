package test;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.dao.UserDaoImp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class test {
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
        UserDao dao=new UserDaoImp(sqlSessionFactory);
        User user=dao.findUserById(3);
        System.out.println(user);
    }
}
