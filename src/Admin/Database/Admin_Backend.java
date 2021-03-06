/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Database;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.*;
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

    public List<String[]> ListManager() {
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select Username,State from account where Type=2;";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("Username"), rs.getString("State")};
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void CreateManager(String username, String password) {
        try {
            sql = "insert account values(?,?,2,'OPEN');";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            psm.setString(2, password);
            psm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LockOrOpen(String username, String state) {
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

    public void DeleteHospital(String ID) {
        try {
            sql = "delete from isolation_area where ID = ?;";
            psm = conn.prepareStatement(sql);
            psm.setString(1, ID);
            psm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> HistoryManager(String username) {
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select Content,Time from management_history where AccountID=?;";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("Time"), rs.getString("Content")};
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String[]> FindManager(String username) {
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select Username,state from covid_management.account where type=2 and username = ?;";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("Username"), rs.getString("state")};
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String[]> ListHospital() {
        List<String[]> list = new ArrayList<String[]>();
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

    public void AddHospital(String ID, String Name, int MaxCapicity, int PresentCapicity) {
        try {
            sql = "insert isolation_area values (?,?,?,?);";
            psm = conn.prepareStatement(sql);
            psm.setString(1, ID);
            psm.setString(2, Name);
            psm.setInt(3, MaxCapicity);
            psm.setInt(4, PresentCapicity);
            psm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateHospital(String ID, String Name, int MaxCapicity, int PresentCapicity) {
        try {
            sql = "update isolation_area set Name=?, MaxCapicity=?, PresentCapicity=? where ID=?;";
            psm = conn.prepareStatement(sql);
            psm.setString(1, Name);
            psm.setInt(2, MaxCapicity);
            psm.setInt(3, PresentCapicity);
            psm.setString(4, ID);
            psm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> FindHospital(String ID) {
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select * from isolation_area where ID=?;";
            psm = conn.prepareStatement(sql);
            psm.setString(1, ID);
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
}
