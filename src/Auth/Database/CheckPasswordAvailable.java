package Auth.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CheckPasswordAvailable {

    String sql;
    Connection conn = createConnection();
    PreparedStatement psm = null;
    ResultSet rs;

    public boolean checkPasswordAvailable(String username) {
        boolean available = false;
        String temp = "";

        try {
            sql = "SELECT Password FROM account where Username = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = rs.getString("Password");
            }

            if (temp == null) {
                available = false;
            } else {
                available = true;
            }

            System.out.println("checkPass:" + available);
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return available;
    }
}
