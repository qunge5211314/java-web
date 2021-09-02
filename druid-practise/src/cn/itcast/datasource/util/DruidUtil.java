package cn.itcast.datasource.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.ConnectionFeatureNotAvailableException;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池的工具类
 */
public class DruidUtil {
    // 1.定义成员变量DataSouce
    private static DataSource dataSource = null;

    static {
        // 1.加载配置文件
        Properties properties = new Properties();
        InputStream inputStream = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        // 2.获取DataSource
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * 获取连接对象
     *
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(Statement statement, Connection connection) throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
