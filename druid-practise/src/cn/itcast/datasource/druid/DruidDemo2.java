package cn.itcast.datasource.druid;


import cn.itcast.datasource.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用DruidUtil工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) throws SQLException {
        /**
         * 完成添加操作，给user表添加一条记录
         */
        // 1.获取连接对象
        Connection connection = DruidUtil.getConnection();
        // 2.定义sql
        String sql = "insert into user (name, age, gender) values (?, ?, ?)";
        // 3.获取sql执行对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 4.占位符赋值
        preparedStatement.setString(1, "dukun");
        preparedStatement.setInt(2, 32);
        preparedStatement.setBoolean(3, true);
        // 5.执行sql
        preparedStatement.executeUpdate();
        // 6.释放资源
        DruidUtil.close(preparedStatement, connection);

    }
}
