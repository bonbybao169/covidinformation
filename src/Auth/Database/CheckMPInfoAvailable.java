package Auth.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CheckMPInfoAvailable {

    String sql;
    Connection conn = createConnection();
    PreparedStatement psm = null;
    ResultSet rs;

    public boolean checkMPInfoAvailable(String username) {
        boolean available = false;
        String temp = "";

        try {
            sql = "SELECT CCCD FROM mp_infor where CCCD = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = rs.getString("CCCD");
            }

            if (temp.equals("")) {
                available = false;
            } else {
                available = true;
            }

            System.out.println(available);
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return available;
    }
}
