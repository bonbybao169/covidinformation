/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.*;

/**
 *
 * @author ACER
 */
public class Admin_Backend {
    static String sql;
    static ResultSet rs;
    static Connection conn = createConnection();
    static PreparedStatement psm = null;
    public void CreateManager(String username,String password){
        try {
            sql = "insert account values(?,?,2);";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            psm.setString(2, password);
            psm.executeUpdate();
     
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
