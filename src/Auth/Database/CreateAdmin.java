/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auth.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.*;
public class CreateAdmin {
    String sql;
    Connection conn = createConnection();
    PreparedStatement psm = null;
    ResultSet rs;
    public boolean CheckAdmin(){
        try {
            sql = "SELECT count(*) as total FROM account where Type=1;";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            rs.next();
            int total = rs.getInt(1);
            conn.close();
            psm.close();
            if(total==1)
                return true;
            else 
                return false;

               
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void CreateAdmin(String username,String password){
        try {
            sql = "insert account values(?,?,1,'OPEN');";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            psm.setString(2, password);
            psm.executeUpdate();
            conn.close();
            psm.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
