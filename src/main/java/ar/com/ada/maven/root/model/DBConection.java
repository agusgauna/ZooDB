package ar.com.ada.maven.root.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {
    private static Connection connection;
    private static String user = "root";
    private static String host = "jdbc:mysql://localhost:3306/";
    private static String password = "36216403";
    private static String db = "ZooDB";
    private static String drive = "com.mysql.cj.jdbc.Driver";

    private DBConection() {}

    public static Connection getConnection () throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (connection == null || connection.isClosed()) {
            Class.forName(drive).newInstance();
            String url = host + db + "?serverTimezone=UTC";
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
