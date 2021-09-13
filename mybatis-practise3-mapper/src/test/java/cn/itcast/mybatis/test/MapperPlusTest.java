package cn.itcast.mybatis.test;

import cn.itcast.mybatis.mapper.EnterpriseMapper;
import cn.itcast.mybatis.mapper.UserMapperPlus;
import cn.itcast.mybatis.model.Enterprise;
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
public class MapperPlusTest {
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

    @Test
    public void mapperPlusTest01() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapperPlus userMapperPlus = sqlSession.getMapper(UserMapperPlus.class);
            User user = userMapperPlus.selectOneById(2);
            log.info(user.toString());
        }
    }

    @Test
    public void mapperPlusTest02() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapperPlus userMapperPlus = sqlSession.getMapper(UserMapperPlus.class);
            User user = userMapperPlus.selectUserAndEnterpriseById(2);
            log.info(user.toString());
            log.info(user.getEnterprise().toString());
        }
    }

    @Test
    public void mapperPlusTest03() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapperPlus userMapperPlus = sqlSession.getMapper(UserMapperPlus.class);
            User user = userMapperPlus.selectUserAndEnterpriseByIdStep(4);
            log.info(user.toString());
            log.info(user.getEnterprise().toString());
        }
    }

    @Test
    public void mapperPlusTest04() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EnterpriseMapper enterpriseMapper = sqlSession.getMapper(EnterpriseMapper.class);
            Enterprise enterprise = enterpriseMapper.selectEnterpriseAndUsersById(1);
            log.info(enterprise.toString());

        }
    }

    @Test
    public void mapperPlusTest05() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EnterpriseMapper enterpriseMapper = sqlSession.getMapper(EnterpriseMapper.class);
            Enterprise enterprise = enterpriseMapper.selectEnterpriseAndUsersByIdStep(2);
            log.info(enterprise.getName());
            log.info(enterprise.getUserList().toString());
        }
    }
}
