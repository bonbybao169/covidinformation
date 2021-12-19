/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.*;
import Manager.Model.*;
import java.util.*;
/**
 *
 * @author ACER
 */
public class Admin_Backend {
    static String sql;
    static ResultSet rs;
    static Connection conn = createConnection();
    static PreparedStatement psm = null;
    public List<Manager> ListManager(){
        List<Manager> list= new ArrayList<Manager>();
        try {
            sql = "select username,state from covid_management.account where type=2;";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                list.add(new Manager(rs.getString("username"), rs.getString("state")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void CreateManager(String username,String password){
        try {
            sql = "insert account values(?,?,2,OPEN);";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            psm.setString(2, password);
            psm.executeUpdate();
     
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void LockOrOpen(String username,String state){
    
        try {
            sql = "update account set state= ? where username = ?;";
            psm = conn.prepareStatement(sql);
            psm.setString(1, state);
            psm.setString(2, username);
            psm.executeUpdate();
     
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
