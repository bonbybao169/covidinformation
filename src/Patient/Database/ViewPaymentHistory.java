package Patient.Database;

import static DatabaseConnector.connect_db.createConnection;
import Patient.Model.PaymentHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewPaymentHistory {

    String sql;
    ResultSet rs;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public ArrayList<PaymentHistory> getPaymentHistory(String username) {
        PaymentHistory temp = null;
        ArrayList<PaymentHistory> list = new ArrayList<PaymentHistory>();

        try {
            sql = "select ph.MPID, ph.Content, ph.Cash, ph.Time, mp.Debt from payment_history ph join mp_infor mp on ph.MPID = mp.CCCD where MPID = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();

            while (rs.next()) {
                temp = new PaymentHistory(rs.getString("Content"), rs.getInt("Cash"), rs.getDate("Time"), rs.getFloat("Debt"));
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
