package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.bean.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
//    @Select("select * from user where id = #{id}")
    User selectUser(Integer id);

    Integer insertUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(User user);
}
