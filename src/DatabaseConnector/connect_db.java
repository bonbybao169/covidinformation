package DatabaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connect_db {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/covid_management";
    static final String user = ""; // add username của connection trong mysql vào đây
    static final String pass = ""; // add password của connection trong mysql vào đây
    static Connection conn = null;

    public static void main(String[] args) {
        try {

            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to DB...");

            conn = DriverManager.getConnection(DB_URL, user, pass);

        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(connect_db.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Logger.getLogger(connect_db.class.getName()).log(Level.SEVERE, null, e);
                }
            }

        }

    }
}
