package cn.itcast.mybatis.test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mybatis配置文件相关测试
 */
@Slf4j
public class MapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() {
        String resource = "mybatis.xml";
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    /**
     * mysql获取自增主键的值
     */
    @Test
    public void mapperTest01() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setName("zhangsan");
            user.setLastName("zhang");
            Boolean result = userMapper.insertUser(user);
            log.info(user.getId().toString());
            log.info(result.toString());
            sqlSession.commit();
        }
    }

    /**
     * 多个参数测试1
     */
    @Test
    public void mapperTest02() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectOneByIdAndName(3, "wangwu");
            log.info(user.toString());
        }
    }

    /**
     * 多个参数测试2
     */
    @Test
    public void mapperTest03() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Map map = new HashMap<>();
            map.put("id", 3);
            map.put("name", "wangwu");
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectOneByIdAndName(map);
            log.info(user.toString());
        }
    }

    /**
     * 返回查询结果列表
     */
    @Test
    public void mapperTest04() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            String name = "%l%";
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.selectUsersByNameLike(name);
            for (User user : userList) {
                log.info(user.toString());
            }
        }
    }

    /**
     * 返回查询结果为Map的方式
     */
    @Test
    public void mapperTest05() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> userMap = userMapper.selectOneByIdMapResult(2);
            log.info(userMap.toString());

        }
    }

    /**
     * 返回查询结果为Map的方式
     */
    @Test
    public void mapperTest06() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<Integer, User> userMap = userMapper.selectUsersByNameLikeMapResult("%l%");
            for (Map.Entry<Integer, User> userEntry : userMap.entrySet()) {
                log.info(userEntry.toString());
            }
        }
    }

}
