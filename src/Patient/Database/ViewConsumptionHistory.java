package Patient.Database;

import static DatabaseConnector.connect_db.createConnection;
import Patient.Model.ConsumptionHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewConsumptionHistory {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public ArrayList<ConsumptionHistory> getConsumptionHistory(String username) {
        ConsumptionHistory temp = null;
        ArrayList<ConsumptionHistory> list = new ArrayList<ConsumptionHistory>();

        try {
            sql = "SELECT ch.MPID, ch.epid, ep.name, ch.Quantity, ch.Time from consumption_history ch join essentials_package ep on ch.epid = ep.id where MPID = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = new ConsumptionHistory(rs.getString("MPID"), rs.getString("epid"), rs.getString("name"), rs.getString("Quantity"), rs.getDate("Time"));
                list.add(temp);
            }
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
