package cn.itcast.mybatis.test;


import cn.itcast.mybatis.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class MybatisPrimer01 {
    /**
     * 基于statementID去执行sql
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        String resource = "mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User user = (User) session.selectOne("cn.itcast.mybatis.bean.UserMapper.selectUser", 1);
            log.info(user.toString());
        }

    }

    /**
     * 基于接口绑定的方式
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        String resource = "mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User user = (User) session.selectOne("cn.itcast.mybatis.bean.UserMapper.selectUser", 1);
            log.info(user.toString());
        }


    }
}
