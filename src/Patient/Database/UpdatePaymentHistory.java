/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patient.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HOME
 */
public class UpdatePaymentHistory {

    String sql;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public void updatePaymentHistory(String MPID, int money) {
        Date date;

        try {
            sql = "insert into consumption_history(MPID,Content,Cash,Time) values (?,?,?,?)";
            psm = conn.prepareStatement(sql);
            psm.setString(1, MPID);
            psm.setString(2, "Thanh toán ngày" + java.time.LocalDate.now().toString());
            psm.setInt(3, money);
            date = Date.valueOf(java.time.LocalDate.now());
            psm.setDate(4, date);
            int executeUpdate = psm.executeUpdate();
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
