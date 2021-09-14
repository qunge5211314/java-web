package cn.itcast.mybatis.test;

import cn.itcast.mybatis.mapper.UserMapperDynamicSql;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class DynamicSqlTest {
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
     * 测试where/if
     */
    @Test
    public void dynamicSqlTest01() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapperDynamicSql dynamicSqlMapper = sqlSession.getMapper(UserMapperDynamicSql.class);
            User user = new User();
//            user.setId(3);
            user.setName("%liu%");
            List<User> users = dynamicSqlMapper.selectUsersByConditionIf(user);
            String result = users.isEmpty() ? "empty" : "exists";
            log.info(result);
            for (User user1 : users) {
                log.info(user1 != null ? user1.toString() : "null");
            }

            //我们发现，查询的时候如果某些条件没带可能sql拼装会有问题。(例如本例中注释掉了user.setId(3);)
            //1、给where后边加上1=1，以后的条件都and ***
            //2、mybatis使用where标签来将所有的查询条件包括在内,mybatis就会将where标签中拼装的sql，多出来的and或者or去掉
            //where只会去掉第一个多出来的and或者or
        }
    }

    /**
     * 测试trim
     */
    @Test
    public void dynamicSqlTest02() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapperDynamicSql userMapperDynamicSql = sqlSession.getMapper(UserMapperDynamicSql.class);
            User user = new User();
//            user.setId(3);
            user.setName("%liu%");
            List<User> users = userMapperDynamicSql.selectUsersByConditionTrim(user);
            String result = users.isEmpty() ? "empty" : "exists";
            log.info(result);
            for (User user1 : users) {
                log.info(user1 != null ? user1.toString() : "null");
            }
        }
    }

    /**
     * 测试choose
     */
    @Test
    public void dynamicSqlTest03() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapperDynamicSql userMapperDynamicSql = sqlSession.getMapper(UserMapperDynamicSql.class);
            User user = new User();
            user.setId(3);
            user.setName("%liu%");
            List<User> users = userMapperDynamicSql.selectUsersByConditionChoose(user);
            String result = users.isEmpty() ? "empty" : "exists";
            log.info(result);
            for (User user1 : users) {
                log.info(user1 != null ? user1.toString() : "null");
            }
        }
    }

    /**
     * 测试set
     */
    @Test
    public void dynamicSqlTest04() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapperDynamicSql userMapperDynamicSql = sqlSession.getMapper(UserMapperDynamicSql.class);
            User user = new User();
            user.setId(7);
            user.setName("qiqi");
//            user.setLastName("qi");
            Boolean result = userMapperDynamicSql.updateUser(user);
            log.info(result.toString());
            sqlSession.commit();
        }
    }

    /**
     * 测试foreach
     */
    @Test
    public void dynamicSqlTest05() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapperDynamicSql userMapperDynamicSql = sqlSession.getMapper(UserMapperDynamicSql.class);
            List<Integer> ids = new ArrayList<>();
            ids.add(2);
            ids.add(3);
            ids.add(7);
            List<User> users = userMapperDynamicSql.selectUsersByConditionForeach(ids);
            for (User user : users) {
                log.info(user.toString());
            }
        }
    }

    /**
     * 测试批量保存
     */
    @Test
    public void dynamicSqlTest06() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapperDynamicSql mapper = sqlSession.getMapper(UserMapperDynamicSql.class);
            User user1 = new User("baba", "ba");
            User user2 = new User("jiujiu", "jiu");
            User user3 = new User("shishi", "shi");
            List<User> users = Arrays.asList(user1, user2, user3);
            Integer result = mapper.insertUsersByConditionForeach(users);
            log.info(result.toString());
            sqlSession.commit();
        }
    }

    /**
     * 测试内置参数_databaseId
     */
    @Test
    public void dynamicSqlTest07() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapperDynamicSql mapper = sqlSession.getMapper(UserMapperDynamicSql.class);
            User user1 = new User();
            user1.setName("li");
            List<User> userList = mapper.selectUsersTestInnerParam(user1);
            for (User user : userList) {
                log.info(user.toString());
            }
        }
    }
}
