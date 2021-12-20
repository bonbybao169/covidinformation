package Patient.Database;

import Patient.Model.ConsumptionHistory;
import static DatabaseConnector.connect_db.createConnection;
import java.sql.*;
import java.util.ArrayList;

public class ViewManagementHistory {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public ArrayList<ConsumptionHistory> getManagementHistory(String username) {
        ConsumptionHistory temp = null;
        ArrayList<ConsumptionHistory> list = new ArrayList<ConsumptionHistory>();

        try {
            sql = "Select * from management_history where AccountID = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = new ConsumptionHistory(rs.getString("AccountID"), rs.getString("Content"), rs.getDate("Time"));
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
