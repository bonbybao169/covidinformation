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
    public List<String[]> ListPayment(){
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select P.MPID, P.Content, P.Cash, P.Time, I.Name from payment_history as P join mp_infor as I where P.MPID = I.CCCD ;";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("Time"),rs.getString("Name"), rs.getString("MPID"), rs.getString("Cash"),rs.getString("Content")}; 
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    } 
    public List<String[]> FindPayment(String CCCD){
        List<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select P.MPID, P.Content, P.Cash, P.Time, I.Name from payment_history as P join mp_infor as I where P.MPID = I.CCCD and P.MPID = ?;";
            psm = conn.prepareStatement(sql);
            psm.setString(1,CCCD);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("Time"),rs.getString("Name"), rs.getString("MPID"), rs.getString("Cash"),rs.getString("Content")}; 
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    } 
}
