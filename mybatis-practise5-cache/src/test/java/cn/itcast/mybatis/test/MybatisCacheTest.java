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

@Slf4j
public class MybatisCacheTest {
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
     * 体会一级缓存
     */
    @Test
    public void mybatisCacheTest01() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = userMapper.selectOneById(2);
            log.info(user1.toString());
            User user2 = userMapper.selectOneById(2);
            log.info(user2.toString());
            log.info("user1和user2对比结果为：" + (user1 == user2));
        }
    }

    /**
     * 一级缓存失效：不同的sqlSession
     */
    @Test
    public void mybatisCacheTest02() {
        try (SqlSession sqlSession1 = sqlSessionFactory.openSession();
             SqlSession sqlSession2 = sqlSessionFactory.openSession();) {

            UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
            UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
            User user1 = userMapper1.selectOneById(2);
            log.info(user1.toString());
            User user2 = userMapper2.selectOneById(2);
            log.info(user2.toString());
            log.info("user1和user2对比结果为：" + (user1 == user2));
        }
    }

    /**
     * 一级缓存失效：sqlSession相同，查询条件不同
     */
    @Test
    public void mybatisCacheTest03() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = userMapper.selectOneById(2);
            log.info(user1.toString());
            User user2 = userMapper.selectOneById(3);
            log.info(user2.toString());
            log.info("user1和user2对比结果为：" + (user1 == user2));
        }
    }

    /**
     * 一级缓存失效：sqlSession相同，两次查询之间执行了增删改操作
     */
    @Test
    public void mybatisCacheTest04() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = userMapper.selectOneById(2);
            log.info(user1.toString());
            userMapper.insertUser(new User("hanqun", "han"));
            User user2 = userMapper.selectOneById(2);
            log.info(user2.toString());
            log.info("user1和user2对比结果为：" + (user1 == user2));
        }
    }

    /**
     * 一级缓存失效：sqlSession相同，手动清除了一级缓存(缓存清空)
     */
    @Test
    public void mybatisCacheTest05() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = userMapper.selectOneById(2);
            log.info(user1.toString());
            sqlSession.clearCache();
            User user2 = userMapper.selectOneById(2);
            log.info(user2.toString());
            log.info("user1和user2对比结果为：" + (user1 == user2));
        }
    }

    /**
     * 体会二级缓存
     */
    @Test
    public void mybatisCacheTest06() {
        try (SqlSession sqlSession1 = sqlSessionFactory.openSession();
             SqlSession sqlSession2 = sqlSessionFactory.openSession();) {
            UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
            UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
            User user1 = userMapper1.selectOneById(2);
            log.info(user1.toString());
            sqlSession1.close();
            // 第二次查询是从二级缓存中拿到的数据，并没有发送新的sql
            User user2 = userMapper2.selectOneById(2);
            log.info(user2.toString());
            log.info("user1和user2对比结果为：" + (user1 == user2));
        }
    }

    /**
     * 测试增删改后对二级缓存是否有影响
     */
    @Test
    public void mybatisCacheTest07() {
        try (SqlSession sqlSession1 = sqlSessionFactory.openSession();
             SqlSession sqlSession2 = sqlSessionFactory.openSession();) {
            UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
            UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
            User user1 = userMapper1.selectOneById(2);
            log.info(user1.toString());
            sqlSession1.close();
            userMapper2.insertUser(new User("lizhiwei", "li"));
            // 第二次查询是从二级缓存中拿到的数据，并没有发送新的sql
            User user2 = userMapper2.selectOneById(2);
            log.info(user2.toString());
            log.info("user1和user2对比结果为：" + (user1 == user2));
        }
    }

    /**
     * sqlSession.clearCache();对二级缓存的影响
     */
    @Test
    public void mybatisCacheTest08() {
        try (SqlSession sqlSession1 = sqlSessionFactory.openSession();
             SqlSession sqlSession2 = sqlSessionFactory.openSession();) {
            UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
            UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
            User user1 = userMapper1.selectOneById(2);
            log.info(user1.toString());
            sqlSession1.close();
            sqlSession2.clearCache();
            // 第二次查询是从二级缓存中拿到的数据，并没有发送新的sql
            User user2 = userMapper2.selectOneById(2);
            log.info(user2.toString());
            log.info("user1和user2对比结果为：" + (user1 == user2));
        }
    }
}
