package Patient.Database;

import static DatabaseConnector.connect_db.createConnection;
import Patient.Model.EssentialPackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class UpdateConsumptionHistory {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public void updateConsumptionHistory(String mpID, String epID, int quantity) {
        EssentialPackage temp = null;
        Date date;

        try {
            sql = "insert into consumption_history(MPID, EPID, Quantity, Time) values (?,?,?,?)";
            psm = conn.prepareStatement(sql);
            psm.setString(1, mpID);
            psm.setString(2, epID);
            psm.setInt(3, quantity);
            date = Date.valueOf(java.time.LocalDate.now());
            psm.setDate(4, date);
            rs = psm.executeQuery();
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
