package cn.itcast.jdbc;

import java.sql.*;

public class DqlPractise {
    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.定义sql
            String sql = "select * from user";
            // 3.创建连接对象
            connection = DriverManager.getConnection("jdbc:mysql:///basic", "root", "123456");
            // 4.获取执行对象
            statement = connection.createStatement();
            // 5.执行sql
            resultSet = statement.executeQuery(sql);
            // 6.输出结果
            // 6.1让光标向下移动一行
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println(id);
                String name = resultSet.getString("name");
                System.out.println(name);
                int age = resultSet.getInt("age");
                System.out.println(age);
                boolean gender = resultSet.getBoolean("gender");
                System.out.println(gender);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
