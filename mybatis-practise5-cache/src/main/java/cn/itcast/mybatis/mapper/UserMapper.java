package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.model.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    Boolean insertUser(User user);

    User selectOneByIdAndName(@Param("id") Integer id, @Param("name") String name);

    User selectOneByIdAndName(Map<String, Object> map);

    List<User> selectUsersByNameLike(String name);

    // 返回一条记录的map：key就是列名，值就是对应的值
    Map<String, Object> selectOneByIdMapResult(Integer id);

    // 多条记录封装一个map：Map<String, User> 键是这条记录的主键，值是记录封装后的JavaBean
    @MapKey("id")
    Map<Integer, User> selectUsersByNameLikeMapResult(String name);

    User selectOneById(Integer id);

}
