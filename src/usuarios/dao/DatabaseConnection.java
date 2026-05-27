package usuarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Sustituye con la IP de tu Ubuntu Server que configuramos antes
    private static final String URL = "jdbc:mysql://192.168.56.101:3306/levelup_arcade";
    private static final String USER = "admin_arcade";
    private static final String PASS = "campusfp";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}