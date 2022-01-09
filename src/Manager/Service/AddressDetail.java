/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager.Service;

import static DatabaseConnector.connect_db.createConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HOME
 */
public class AddressDetail {

    public ArrayList<String> getCityList() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<String> list = new ArrayList<String>();
        try {
            sql = "select city.cityName from city";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                String temp = rs.getString("cityName");
                list.add(temp);
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<String> getDistrictByCityName(String city) {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<String> list = new ArrayList<String>();
        try {
            sql = "select d.districtName from district d join city c on c.cityID=d.cityID where c.cityName= ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, city);
            rs = psm.executeQuery();

            while (rs.next()) {

                String temp = rs.getString("districtName");
                list.add(temp);
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<String> getWardtByDistrictName(String district) {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<String> list = new ArrayList<String>();
        try {
            sql = "select w.wardName from ward w join district d on w.districtID=d.districtID where  d.districtName = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, district);
            rs = psm.executeQuery();

            while (rs.next()) {

                String temp = rs.getString("wardName");
                list.add(temp);
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
