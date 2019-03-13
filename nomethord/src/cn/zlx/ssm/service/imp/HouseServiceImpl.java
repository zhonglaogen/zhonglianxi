package cn.zlx.ssm.service.imp;

import cn.zlx.ssm.entity.Allhouse;
import cn.zlx.ssm.entity.AllhouseExample;
import cn.zlx.ssm.mapper.AllhouseMapper;
import cn.zlx.ssm.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HouseServiceImpl implements HouseService {



    @Autowired
    private AllhouseMapper allhouseMapper;

    @Override
    public List<Allhouse> findHouse() {

        AllhouseExample allhouseExample = new AllhouseExample();
        //通过criteria构造查询条件
        AllhouseExample.Criteria criteria = allhouseExample.createCriteria();
        criteria.getAllCriteria();
        //可能返回多条记录
        List<Allhouse> list = allhouseMapper.selectByExample(allhouseExample);
        return list;
    }

    @Override
    public void insertHouse(Allhouse allhouse) {
        allhouseMapper.insert(allhouse);
    }

    @Override
    public void updateHouse(Integer id, Allhouse allhouse) {
        allhouse.setHouseid(id);
        allhouseMapper.updateByPrimaryKeySelective(allhouse);
    }
}
