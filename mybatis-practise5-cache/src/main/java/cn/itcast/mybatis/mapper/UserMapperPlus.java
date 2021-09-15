package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.model.User;

import java.util.List;

public interface UserMapperPlus {

    User selectOneById(Integer id);

    User selectUserAndEnterpriseById(Integer id);

    User selectUserAndEnterpriseByIdStep(Integer id);

    List<User> selectUsersByEnterpriseId(Integer enterpriseId);
}
