package Patient.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewTotalUseByMpIDAndEpID {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public int viewTotalUse(String mpID, String epID) {
        int total = 0;

        try {
            sql = "select sum(quantity) from consumption_history ch join essentials_package ep on ch.EPID = ep.ID where ch.Time BETWEEN ep.Startingdate AND ep.ExpiredDate AND ch.mpid = ? and ch.epid = ? group by mpid";
            psm = conn.prepareStatement(sql);
            psm.setString(1, mpID);
            psm.setString(2, epID);
            rs = psm.executeQuery();

            while (rs.next()) {
                total = rs.getInt(1);
            }
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
