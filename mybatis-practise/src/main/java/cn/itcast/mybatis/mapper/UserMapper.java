package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.bean.User;

public interface UserMapper {
    User selectUser(Integer id);
}
