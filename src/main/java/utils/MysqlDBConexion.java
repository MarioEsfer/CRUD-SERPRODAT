package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlDBConexion {

    public static Connection getConexion() {
        Connection cn = null;
        try {	
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/instituto?useSSL=false&serverTimezone=UTC",
                "root",
                "admin"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
}
