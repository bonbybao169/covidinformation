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
    public List<String[]> HistoryManager(String username){
        List<String[]> list= new ArrayList<String[]>();
        try {
            sql = "select AccountID,Time from management_history where AccountID=?;";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("AccountID"), rs.getString("Time")};
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<String[]> ListHospital(){
        List<String[]> list= new ArrayList<String[]>();
        try {
            sql = "select * from isolation_area;";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("ID"), rs.getString("Name"), rs.getString("MaxCapicity"), rs.getString("PresentCapicity")}; 
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void AddHospital(String ID, String Name, int MaxCapicity, int PresentCapicity){
        try {
            sql = "insert isolation_area values (?,?,?,?);";
            psm = conn.prepareStatement(sql);
            psm.setString(1, ID);
            psm.setString(2, Name);
            psm.setInt(3,MaxCapicity);
            psm.setInt(4,PresentCapicity);
            psm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
