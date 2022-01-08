/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager.Service;

import static DatabaseConnector.connect_db.createConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HOME
 */
public class StatisticService {

    public ArrayList<String[]> showConsumption() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select ID,Name,LimitPerPeople,ExpiredDate,Price,sum(c.Quantity) as Quantity,c.Time\n"
                    + "from essentials_package ep join consumption_history c on ep.ID = c.EPID\n"
                    + "group by ep.ID ,c.Time";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {
                String[] temp = {rs.getDate("Time").toString(), rs.getString("ID"), rs.getString("Name"),
                    Integer.toString(rs.getInt("LimitPerPeople")), rs.getDate("ExpiredDate").toString(),
                    Float.toString(rs.getFloat("Price")), Integer.toString(rs.getInt("Quantity"))};
                list.add(temp);
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<String[]> showStateStatistic() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select m.State,count(*) as SL from mp_infor m group by m.State";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {
                String[] temp = {"F" + rs.getString("State"),
                    Integer.toString(rs.getInt("SL"))};
                list.add(temp);
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<String[]> showCuredStatistic() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select m.Name, m.CCCD,m.Birthday,c.Cured from mp_infor m join cured_person c on m.CCCD=c.F0";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                String[] temp = {rs.getString("Name"),
                    rs.getString("CCCD"), rs.getDate("Birthday").toString(), (rs.getBoolean("Cured")) ? "Đã Chữa Khỏi" : "Chưa khỏi"};
                list.add(temp);
            }
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public int calTotalConsumption() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        int total = 0;
        try {
            sql = "select sum(c.Quantity) as TOTAL from consumption_history c";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {
                total = rs.getInt("TOTAL");
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }

    public float calTotalDebt() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        float total = 0;
        try {
            sql = "select sum(m.Debt) as TOTAL from mp_infor m";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {
                total = rs.getInt("TOTAL");
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }

    public int calTotalCured() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        int total = 0;
        try {
            sql = "select sum(c.Cured) as TOTAL from cured_person c where c.Cured = 1";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                total = rs.getInt("TOTAL");
            }
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }

    public int calTotalPatient() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        int total = 0;
        try {
            sql = "select count(*) as TOTAL from mp_infor";
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                total = rs.getInt("TOTAL");
            }
            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }

    public int addStatistictHistoryForManager(String MNID, String type) {

        String sql;
        Date date;
        String content = "Thực hiện thông kê thông tin " + type;
        Connection conn = null;
        PreparedStatement psm = null;
        int row = 0;
        try {
            sql = "insert into management_history (AccountID,Content,Time) values (?,?,?)";
            conn = createConnection();
            psm = conn.prepareStatement(sql);

            psm.setString(1, MNID);
            psm.setString(2, content);
            date = Date.valueOf(java.time.LocalDate.now());
            psm.setDate(3, date);
            row = psm.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (psm != null) {
                    psm.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        }

        return row;
    }
}
