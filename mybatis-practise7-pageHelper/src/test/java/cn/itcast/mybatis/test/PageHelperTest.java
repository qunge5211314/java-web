package cn.itcast.mybatis.test;

import cn.itcast.mybatis.bean.User;
import cn.itcast.mybatis.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class PageHelperTest {
    SqlSessionFactory sqlSessionFactory;

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
    public void pageHelperTest01() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Page<User> page = PageHelper.startPage(1, 5);
            List<User> users = userMapper.selectUsers();
            // navigatePages：传入要连续显示多少页
            PageInfo<User> pageInfo = new PageInfo<>(users, 5);
            for (User user : users) {
                log.info(user.toString());
            }
            log.info("总记录数:" + page.getTotal());
            log.info("当前页码:" + page.getPageNum());
            log.info("每页的记录数:" + page.getPageSize());
            log.info("总页码:" + page.getPages());
            log.info("-------------------------------------------");
            log.info("总记录数:" + pageInfo.getTotal());
            log.info("当前页码:" + pageInfo.getPageNum());
            log.info("每页的记录数:" + pageInfo.getPageSize());
            log.info("总页码:" + pageInfo.getPages());
            log.info("是否第一页:" + pageInfo.isIsFirstPage());
            log.info("是否最后一页:" + pageInfo.isIsLastPage());
            int[] navigatepageNums = pageInfo.getNavigatepageNums();
            for (int navigatepageNum : navigatepageNums) {
                log.info(""+navigatepageNum);
            }
        }
    }
}
