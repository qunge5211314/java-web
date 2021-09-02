package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0参数演示
 */
public class C3p0Demo2 {
    public static void main(String[] args) throws SQLException {
        // 1.创建数据库连接池对象 什么参数都不传使用default默认的配置参数
        DataSource dataSource = new ComboPooledDataSource("otherc3p0");
        for (int i = 1; i <= 11; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i + ":" + connection);
            if (i==5){
                connection.close();
            }
        }
    }
}
