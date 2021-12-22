package Auth.Database;

import static DatabaseConnector.connect_db.createConnection;
import Auth.Model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAccountByID {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public Account getAccountByID(String username) {
        Account temp = null;

        try {
            sql = "SELECT * FROM account where Username = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = new Account(rs.getString("Username"), rs.getString("Password"), rs.getString("State"), rs.getInt("Type"));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }
}
