package Patient.Database;

import Patient.Model.*;
import static DatabaseConnector.connect_db.createConnection;
import java.sql.*;

public class ViewPatientInfo {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public Patient getPatientInfo(String username) {
        Patient temp = null;

        try {
            sql = "Select * from mp_infor where CCCD = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = new Patient(rs.getString("Name"), rs.getString("CCCD"), rs.getString("Address"), rs.getString("State"), rs.getString("At_IsolationArea"), rs.getString("Related"), rs.getDate("Birthday"), rs.getFloat("Debt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

}
