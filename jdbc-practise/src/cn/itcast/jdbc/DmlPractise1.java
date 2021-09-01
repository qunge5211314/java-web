package cn.itcast.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class DmlPractise1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        // 1.导入驱动jar包
        // 2.注册驱动(可以省略)
        // Class.forName("com.mysql.jdbc.Driver");
        // 3.获取数据库连接对象
        // Connection connection = DriverManager.getConnection("jdbc:mysql//root:123456@localhost:3306/basic");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/basic", "root", "123456");
        // 4.待执行的sql
        String sql1 = "update user set name='zhangsan' where id=1";
        // 5.获取执行sql的对象 Statement对象
        Statement statement = connection.createStatement();
        // 6.执行sql
        int i = statement.executeUpdate(sql1);
        // 7.查看处理结果
        System.out.println(i);
        // 8.释放资源
        statement.close();
        connection.close();

    }
}
