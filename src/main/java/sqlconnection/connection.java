package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather_report?characterEncoding=UTF-8","root", "fh789524560");
            System.out.println("数据库连接成功!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序配置未配置成功!!!");
        }catch (SQLException e) {
            System.out.println("数据库连接失败!!!");
        }
        return conn;
    }

}
