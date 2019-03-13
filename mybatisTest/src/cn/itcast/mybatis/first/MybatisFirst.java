package cn.itcast.mybatis.first;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisFirst {
    //根据id查询用户信息，得到一条记录结果
    @Test
    public void findUserByIdTest() throws IOException {
        //mybatis配置文件
        String resource="config/SqlMapConfig.xml";
        //得到配置文件流
       InputStream inputStream= Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置信息
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到sqlsession
        SqlSession sqlSession=sqlSessionFactory.openSession();
        /*通过sqlsession操作数据库
        * 第一个参数：映射文件中statement的id，等于=namesqpce+"."+statement的id
        * 第二个参数：制定和映射文件中匹配的parameterType的类型的参数
        * sqlSession.selectOne最终的结果于映射文件中匹配的resultType类型的对象*/
        User user= sqlSession.selectOne("test.FindUserById",1);
        System.out.println(user.toString());
        //释放资源
        sqlSession.close();

    }
    @Test
    public void findUserByNameTest() throws IOException {
        //mybatis配置文件
        String resource="config/SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置信息
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到sqlsession
        SqlSession sqlSession=sqlSessionFactory.openSession();
        /*通过sqlsession操作数据库
         * 第一个参数：映射文件中statement的id，等于=namesqpce+"."+statement的id
         * 第二个参数：制定和映射文件中匹配的parameterType的类型的参数
         * sqlSession.selectOne最终的结果于映射文件中匹配的resultType类型的对象*/
       List<User> list=sqlSession.selectList("test.FindUserByName","zh");//sql注入：'or 1=1 or
        System.out.println(list);
        //释放资源
        sqlSession.close();

    }
    @Test
    public void insertUser() throws IOException {
        //mybatis配置文件
        String resource="config/SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置信息
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到sqlsession
        SqlSession sqlSession=sqlSessionFactory.openSession();
        /*通过sqlsession操作数据库
         * 第一个参数：映射文件中statement的id，等于=namesqpce+"."+statement的id
         * 第二个参数：制定和映射文件中匹配的parameterType的类型的参数
         * sqlSession.selectOne最终的结果于映射文件中匹配的resultType类型的对象*/
        User user=new User();
        user.setName("小华");
        user.setAge(19);
        user.setSex("men");
       sqlSession.insert("test.insertUser",user);//sql注入：'or 1=1 or
        //提交事务
        sqlSession.commit();
        //释放资源
        System.out.println(user.getId());
        sqlSession.close();

    }
}
