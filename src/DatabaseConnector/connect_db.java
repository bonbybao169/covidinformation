package DatabaseConnector;

import java.sql.*;

public class connect_db {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/covid_management";
    static String user = "root"; // add username của connection trong mysql vào đây
    static String pass = "Bao160901"; // add password của connection trong mysql vào đây

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
