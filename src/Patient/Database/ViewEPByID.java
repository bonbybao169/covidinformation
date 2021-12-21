package Patient.Database;

import static DatabaseConnector.connect_db.createConnection;
import Patient.Model.EssentialPackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewEPByID {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public EssentialPackage getEssentialPackageByID(String epID) {
        EssentialPackage temp = null;

        try {
            sql = "SELECT * FROM essentials_package where ID = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, epID);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = new EssentialPackage(rs.getString("ID"), rs.getString("Name"), rs.getInt("LimitPerPeople"), rs.getDate("ExpiredDate"), rs.getFloat("Price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }
}
