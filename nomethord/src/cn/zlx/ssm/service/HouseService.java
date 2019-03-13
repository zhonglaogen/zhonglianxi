package cn.zlx.ssm.service;

import cn.zlx.ssm.entity.Allhouse;

import java.util.List;

public interface HouseService {
    public List<Allhouse> findHouse();
    public void insertHouse(Allhouse allhouse);
    public void updateHouse(Integer id,Allhouse allhouse);
}
