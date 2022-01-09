package Auth.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePassword {

    String sql;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public void updatePasswordAccount(String username, String password) {

        try {
            sql = "update account set Password = ? where username = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, password);
            psm.setString(2, username);
            int executeUpdate = psm.executeUpdate();
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
