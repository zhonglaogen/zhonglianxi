package cn.zlx.ssm.service.imp;

import cn.zlx.ssm.entity.User;
import cn.zlx.ssm.mapper.UserMapper;
import cn.zlx.ssm.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    /**
     * 登录判断
     */
    public boolean findUser(User user) {
        User user1 = userMapper.selectByPrimaryKey(user.getUserphone());
        if (user1 != null) {
            if (user.getPassword().equals(user1.getPassword())) {
                return true;
            }
        }

        return false;
    }

    @Override
    /**
     * 用户注册
     */
    public boolean addUser(User user) {
       User user1= userMapper.selectByPrimaryKey(user.getUserphone());
       if(user1==null){
           userMapper.insert(user);
           return true;
       }
        return false;

    }

    @Override
    public boolean checkRepeat(User user) {
        User user1 = userMapper.selectByPrimaryKey(user.getUserphone());
        if (user1 != null) {
                return true;
        }
        return false;
    }
//
//    @Test
//    public void test(){
//        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
//        User user1=(User) context.getBean("userMapper");
//        User user = userMapper.selectByPrimaryKey(1);
//    }
}
