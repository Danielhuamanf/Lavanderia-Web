
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/lavanderiaweb3";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
