package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    Boolean insertUser(User user);

    User selectOneByIdAndName(@Param("id") Integer id, @Param("name") String name);
    User selectOneByIdAndName(Map<String, Object> map);
}
