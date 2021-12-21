package Patient.Database;

import static DatabaseConnector.connect_db.createConnection;
import Patient.Model.EssentialPackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class BuyEssentialPackage {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public void buyEssentialPackagesByID(String mpID, String epID, int quantity) {
        EssentialPackage temp = null;
        Date date;

        try {
            UpdateConsumptionHistory ush = new UpdateConsumptionHistory();
            ush.updateConsumptionHistory(mpID, epID, quantity);

            sql = "insert into consumption_history(MPID, EPID, Quantity, Time) values (?,?,?,?)";
            psm = conn.prepareStatement(sql);
            psm.setString(1, "111111111111");
            psm.setString(2, epID);
            psm.setInt(3, quantity);
            date = Date.valueOf(java.time.LocalDate.now());
            psm.setDate(4, date);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = new EssentialPackage(rs.getString("ID"), rs.getString("Name"), rs.getInt("LimitPerPeople"), rs.getDate("ExpiredDate"), rs.getFloat("Price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
