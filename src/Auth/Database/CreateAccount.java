package Auth.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccount {

    String sql;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public void createPatientAccount(String username, String password) {

        try {
            sql = "insert into account(Username, Password, Type, State) values (?,?,?,?)";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            psm.setString(2, password);
            psm.setInt(3, 3);
            psm.setString(4, "OPEN");
            int executeUpdate = psm.executeUpdate();
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
