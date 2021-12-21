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

    public void buyEssentialPackagesByID(Float newDebt, String mpID) {
        EssentialPackage temp = null;
        Date date;

        try {
            sql = "UPDATE mp_infor SET Debt = ? WHERE CCCD = ?";
            psm = conn.prepareStatement(sql);
            psm.setFloat(1, newDebt);
            psm.setString(2, mpID);
            rs = psm.executeQuery();
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
