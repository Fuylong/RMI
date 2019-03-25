/**
 * 
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author f_756
 *
 */
public class Database {

    // 连接数据库的各个参数
    final static private String driver = "com.mysql.jdbc.Driver";
    final static private String user = "root";
    final static private String pwd = "321142";
    final static private String url = "jdbc:mysql://127.0.0.1:3306/phone";

    static Connection conn = null;

    static {
        // 加载驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 创建连接
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 返回连接
    public static Connection getConnection() {
        return conn;
    }

}
