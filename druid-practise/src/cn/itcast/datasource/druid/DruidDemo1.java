package cn.itcast.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid演示
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        // 1.加载配置文件
        Properties properties = new Properties();
        InputStream resourceAsStream = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        // 2.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        for (int i = 1; i <= 10; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i + ":" + connection);
        }

    }
}
