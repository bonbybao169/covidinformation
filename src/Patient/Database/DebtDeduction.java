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
public class DebtDeduction {

    String sql;
    Connection conn = createConnection();
    PreparedStatement psm = null;

    public void updateDebt(String MPID, int money) {
        Date date;

        try {
            GetDebtByID model = new GetDebtByID();
            int paymoney = model.getDebtByID(MPID);
            int debt = paymoney - money;
            sql = "update mp_infor set Debt = ?  where CCCD = ?";
            psm = conn.prepareStatement(sql);
            psm.setInt(1, debt);
            psm.setString(2, MPID);
            int executeUpdate = psm.executeUpdate();
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
