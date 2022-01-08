package Patient.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDebtByID {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public int getDebtByID(String CCCD) {
        int temp = 0;

        try {
            sql = "SELECT Debt FROM mp_infor where CCCD = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, CCCD);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = rs.getInt("Debt");
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }
}
