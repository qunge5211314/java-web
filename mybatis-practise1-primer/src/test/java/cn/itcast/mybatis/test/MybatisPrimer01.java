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

@Slf4j
public class MybatisPrimer01 {
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

    /**
     * 基于statementID去执行sql
     */
    @Test
    public void test01() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User user = (User) session.selectOne("cn.itcast.mybatis.bean.UserMapper.selectUser", 1);
            log.info(user.toString());
        }

    }

    /**
     * 基于接口绑定的方式
     */
    @Test
    public  void test02() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(2);
            log.info(user.toString());
        }
    }

    /**
     * 基于注解的方式
     */
    @Test
    public void test03(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(2);
            log.info(user.toString());
        }
    }
}
