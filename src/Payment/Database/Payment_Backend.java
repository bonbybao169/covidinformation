/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.*;
import java.util.*;

public class Payment_Backend {
    static String sql;
    static ResultSet rs;
    static Connection conn = createConnection();
    static PreparedStatement psm = null;
    public List<String[]> InfoAdmin(){
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select ID,Balance from payaccount where Type=1;";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("ID"), rs.getString("Balance")}; 
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
