package Patient.Database;

import static DatabaseConnector.connect_db.createConnection;
import Patient.Model.EssentialPackage;
import java.util.ArrayList;
import java.sql.*;

public class FilterEssentialPackage {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public ArrayList<EssentialPackage> filterEP(int limitPeopleFrom, int limitPeopleTo, Date limitTimeFrom, Date limitTimeTo, float priceFrom, float priceTo) {
        EssentialPackage temp = null;
        ArrayList<EssentialPackage> list = new ArrayList<EssentialPackage>();

        try {
            sql = "SELECT * FROM essentials_package WHERE Price BETWEEN ? AND ? AND LimitPerPeople BETWEEN ? AND ? AND ExpiredDate BETWEEN ? AND ?";
            psm = conn.prepareStatement(sql);
            psm.setFloat(1, priceFrom);
            psm.setFloat(2, priceTo);
            psm.setInt(3, limitPeopleFrom);
            psm.setInt(4, limitPeopleTo);
            psm.setDate(5, limitTimeFrom);
            psm.setDate(6, limitTimeTo);

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
