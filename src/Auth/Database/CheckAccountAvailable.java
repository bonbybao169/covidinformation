package Auth.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CheckAccountAvailable {

    String sql;
    Connection conn = createConnection();
    PreparedStatement psm = null;
    ResultSet rs;

    public boolean checkAccountAvailable(String username) {
        boolean available = false;
        String temp = "";

        try {
            sql = "SELECT Username FROM account where Username = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = rs.getString("Username");
            }

            if (temp.equals("")) {
                available = false;
            } else {
                available = true;
            }

            System.out.println("checkAccount:" + available);
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return available;
    }
}
