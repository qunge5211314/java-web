package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.model.User;

public interface UserMapper {
    User selectOneById(Integer id);
}
