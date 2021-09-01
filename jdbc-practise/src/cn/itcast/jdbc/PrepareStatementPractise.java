package cn.itcast.jdbc;

import java.sql.*;

/**
 * PrepareStatement练习
 */
public class PrepareStatementPractise {
    public static void main(String[] args) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.定义sql
            String sql = "select * from user where id=?";
            // 3.创建连接对象
            connection = DriverManager.getConnection("jdbc:mysql:///basic", "root", "123456");
            // 4.获取执行对象
            preparedStatement = connection.prepareStatement(sql);
            // 6.给?赋值
            preparedStatement.setInt(1, 1);
            // 5.执行sql
            resultSet = preparedStatement.executeQuery();
            // 7.输出结果
            // 7.1让光标向下移动一行
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
            // 8.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
