/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment.Database;

import static DatabaseConnector.connect_paymentsystem.createConnection;
import java.sql.*;
import java.util.*;

public class Payment_Backend {

    static String sql;
    static ResultSet rs;
    static Connection conn = createConnection();
    static PreparedStatement psm = null;

    public List<String[]> InfoAdmin() {
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

    public List<String[]> ListPayment() {
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select P.MPID, P.Content, P.Cash, P.Time from payment_history as P;";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("Time"), rs.getString("MPID"), rs.getString("Cash"), rs.getString("Content")};
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String[]> FindPayment(String CCCD) {
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select P.MPID, P.Content, P.Cash, P.Time from payment_history as P where P.MPID = ?;";
            psm = conn.prepareStatement(sql);
            psm.setString(1, CCCD);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("Time"), rs.getString("MPID"), rs.getString("Cash"), rs.getString("Content")};
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String[]> ListPatient() {
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select M.CCCD,M.Name from mp_infor as M where M.CCCD NOT IN (select A.CCCD from mp_infor as A join payaccount where A.CCCD=payaccount.ID);";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("CCCD"), rs.getString("Name")};

                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String[]> FindPatient(String CCCD) {
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select M.CCCD,M.Name from mp_infor as M where M.CCCD NOT IN (select A.CCCD from mp_infor as A join payaccount where A.CCCD=payaccount.ID) and M.CCCD = ?;";
            psm = conn.prepareStatement(sql);
            psm.setString(1, CCCD);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("CCCD"), rs.getString("Name")};
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void AddPayAccount(String CCCD, int balance) {
        try {
            sql = "insert payaccount values(?,NULL,?,2);";
            psm = conn.prepareStatement(sql);
            psm.setString(1, CCCD);
            psm.setInt(2, balance);
            psm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean CheckAdmin() {
        try {
            int temp = 0;
            sql = "select count(*) from payaccount where Type=1;";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            rs.next();
            temp = rs.getInt(1);
            if (temp == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void CreateAdmin(String username, String password) {
        try {
            sql = "insert payaccount values(?,?,0,1);";
            psm = conn.prepareStatement(sql);
            psm.setString(1, username);
            psm.setString(2, password);
            psm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> Login() {
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select ID,Password from payaccount where type=1 and Password is not NULL; ";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("ID"), rs.getString("Password")};
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
