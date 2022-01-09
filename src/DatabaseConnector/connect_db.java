package DatabaseConnector;

import java.sql.*;

public class connect_db {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://b1bb22a80f4007:2d081ad0@us-cdbr-east-05.cleardb.net/heroku_1b8798dece88215";
    static String user = "b1bb22a80f4007"; // add username của connection trong mysql vào đây
    static String pass = "2d081ad0"; // add password của connection trong mysql vào đây

    public static Connection createConnection() {
        Connection conn = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, user, pass);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
