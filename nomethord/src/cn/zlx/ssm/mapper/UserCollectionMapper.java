package cn.zlx.ssm.mapper;

import cn.zlx.ssm.entity.UserCollection;
import cn.zlx.ssm.entity.UserCollectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCollectionMapper {
    int countByExample(UserCollectionExample example);

    int deleteByExample(UserCollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    List<UserCollection> selectByExample(UserCollectionExample example);

    UserCollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCollection record, @Param("example") UserCollectionExample example);

    int updateByExample(@Param("record") UserCollection record, @Param("example") UserCollectionExample example);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);
}