package Patient.Database;

import static DatabaseConnector.connect_db.createConnection;
import Patient.Model.EssentialPackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewEPLimitPeopleASC {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public ArrayList<EssentialPackage> getEssentialPackageLimitPeopleASC() {
        EssentialPackage temp = null;
        ArrayList<EssentialPackage> list = new ArrayList<EssentialPackage>();

        try {
            sql = "SELECT * FROM essentials_package ORDER BY LimitPerPeople ASC";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = new EssentialPackage(rs.getString("ID"), rs.getString("Name"), rs.getInt("LimitPerPeople"), rs.getDate("ExpiredDate"), rs.getFloat("Price"));
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
