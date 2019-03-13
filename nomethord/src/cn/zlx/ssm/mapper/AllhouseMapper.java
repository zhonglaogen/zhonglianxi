package cn.zlx.ssm.mapper;

import cn.zlx.ssm.entity.Allhouse;
import cn.zlx.ssm.entity.AllhouseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AllhouseMapper {
    int countByExample(AllhouseExample example);

    int deleteByExample(AllhouseExample example);

    int deleteByPrimaryKey(Integer houseid);

    int insert(Allhouse record);

    int insertSelective(Allhouse record);

    List<Allhouse> selectByExampleWithBLOBs(AllhouseExample example);

    List<Allhouse> selectByExample(AllhouseExample example);

    Allhouse selectByPrimaryKey(Integer houseid);

    int updateByExampleSelective(@Param("record") Allhouse record, @Param("example") AllhouseExample example);

    int updateByExampleWithBLOBs(@Param("record") Allhouse record, @Param("example") AllhouseExample example);

    int updateByExample(@Param("record") Allhouse record, @Param("example") AllhouseExample example);

    int updateByPrimaryKeySelective(Allhouse record);

    int updateByPrimaryKeyWithBLOBs(Allhouse record);

    int updateByPrimaryKey(Allhouse record);
}