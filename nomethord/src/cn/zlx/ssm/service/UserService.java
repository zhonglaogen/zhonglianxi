package cn.zlx.ssm.service;

import cn.zlx.ssm.entity.User;

public interface UserService {
    public boolean findUser(User user);
    public boolean addUser(User user);
    public boolean checkRepeat(User user);
}
