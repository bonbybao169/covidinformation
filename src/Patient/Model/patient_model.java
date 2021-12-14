package Patient.Model;

import Patient.GUI.*;
import Patient.Controller.*;
import static DatabaseConnector.connect_db.createConnection;
import java.sql.*;

public class patient_model {

    public String name, CCCD, address, state, isolationarea, related;
    public Date DOB;
    public float debt;

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public patient_model getPatientInfo(String username) {
        patient_model temp = new patient_model();
        try {
            sql = "Select * from mp_infor where CCCD = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp.name = rs.getString("Name");
                temp.CCCD = rs.getString("CCCD");
                temp.address = rs.getString("Address");
                temp.state = rs.getString("State");
                temp.DOB = rs.getDate("Birthday");
                temp.isolationarea = rs.getString("At_IsolationArea");
                temp.debt = rs.getFloat("Debt");
                temp.related = rs.getString("Related");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

}
