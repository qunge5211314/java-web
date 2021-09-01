package cn.itcast.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务操作
 */
public class TransactionPractise {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        // 1.获取连接
        try {
            connection = DriverManager.getConnection("jdbc:mysql:///basic", "root", "123456");
            // 2.开启事务
            connection.setAutoCommit(false);
            // 2.定义sql
            String sql1 = "update user set age = age + ? where id = ?";
            String sql2 = "update user set age = age - ? where id = ?";
            // 3.获取执行sql对象
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);
            // 4.设置参数
            preparedStatement1.setInt(1, 10);
            preparedStatement1.setInt(2, 1);
            preparedStatement2.setInt(1, 10);
            preparedStatement2.setInt(2, 2);
            // 5.执行sql
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
            // 6.提交事务
            connection.commit();
        } catch (Exception throwables) {
            // 事务回滚
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            // 8.释放资源
            if (preparedStatement1 != null) {
                try {
                    preparedStatement1.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (preparedStatement2 != null) {
                try {
                    preparedStatement2.close();
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
