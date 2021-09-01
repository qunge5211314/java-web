package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * user表添加一条记录，insert语句
 */
public class DmlPractise2 {
    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.定义sql
            String sql = "insert into user (name, age, gender) values ('xuyingzi', 21, 0)";
            // 3.创建连接对象
            connection = DriverManager.getConnection("jdbc:mysql:///basic", "root", "123456");
            // 4.获取执行对象
            statement = connection.createStatement();
            // 5.执行sql
            int i = statement.executeUpdate(sql);
            // 6.输出结果
            System.out.println(i);
            if (i > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7.释放资源
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
