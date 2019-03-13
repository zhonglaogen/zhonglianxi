package cn.itcast.mybatis.po;

import java.util.List;

public class UserQueryVo {
    private List<Integer> ids;
    private User User;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public cn.itcast.mybatis.po.User getUser() {
        return User;
    }

    public void setUser(cn.itcast.mybatis.po.User user) {
        User = user;
    }
}
