package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperDynamicSql {
    // 携带了哪个字段查询条件就带上这个字段的值
    List<User> selectUsersByConditionIf(User user);

    // trim自定义字符串截取
    List<User> selectUsersByConditionTrim(@Param("user") User user);

    // choose (when, otherwise)：分支选择：带了break的switch-case
    //        如果带了id就用id查，如果带了lastName就用lastName查；只会进入其中一个
    List<User> selectUsersByConditionChoose(User user);


    // trim+set更新表中的数据
    Boolean updateUser(User user);

    // foreach遍历
    List<User> selectUsersByConditionForeach(@Param("ids") List<Integer> ids);

    // 批量保存
    Integer insertUsersByConditionForeach(@Param("users") List<User> users);

    // 测试内置的参数
    List<User> selectUsersTestInnerParam(User user);

}
