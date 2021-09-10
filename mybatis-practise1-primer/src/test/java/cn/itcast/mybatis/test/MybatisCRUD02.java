package cn.itcast.mybatis.test;

import cn.itcast.mybatis.bean.User;
import cn.itcast.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 基于mybatis的xml方式对数据库进行增删改查
 */
@Slf4j
public class MybatisCRUD02 {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void before(){
        String resource = "mybatis.xml";
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void insertUserTest(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setName("liuliu");
            Integer result = mapper.insertUser(user);
            log.info(result.toString());
            session.commit();
        }
    }

    @Test
    public void deleteUserTest(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(1);
            Integer result = mapper.deleteUser(user);
            log.info(result.toString());
            session.commit();
        }
    }

    @Test
    public void updateUserTest(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(1);
            user.setName("zhangsan update");
            Integer result = mapper.updateUser(user);
            log.info(result.toString());
            session.commit();
        }
    }

    @Test
    public void selectUserTest(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(3);
            log.info(user.toString());
        }
    }
}
