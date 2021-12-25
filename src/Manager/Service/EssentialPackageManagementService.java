/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager.Service;

import static DatabaseConnector.connect_db.createConnection;
import Patient.Model.Patient;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HOME
 */
public class EssentialPackageManagementService {

    public int addNewEssentialPackage(String epID, String name, int limitPeople, Date limitDate, float price) {

        String sql;

        Connection conn = null;
        PreparedStatement psm = null;
        int row = 0;
        try {
            sql = "insert into essentials_package (ID,Name,LimitPerPeople,ExpiredDate,Price) values (?,?,?,?,?)";
            conn = createConnection();
            psm = conn.prepareStatement(sql);
            psm.setString(1, epID);
            psm.setString(2, name);
            psm.setInt(3, limitPeople);
            psm.setDate(4, limitDate);
            psm.setFloat(5, price);

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

    public int updateEssentialPackage(String epID, String name, int limitPeople, Date limitDate, float price) {

        String sql;

        Connection conn = null;
        PreparedStatement psm = null;
        int row = 0;
        try {
            sql = "update essentials_package set Name = ?,LimitPerPeople = ?,ExpiredDate = ?, Price = ? where ID = ?";
            conn = createConnection();
            psm = conn.prepareStatement(sql);

            psm.setString(1, name);
            psm.setInt(2, limitPeople);
            psm.setDate(3, limitDate);
            psm.setFloat(4, price);
            psm.setString(5, epID);
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

    public int deleteEssentialPackage(String EPID) {

        String sql;

        Connection conn = null;
        PreparedStatement psm = null;
        int row = 0;
        try {
            sql = "delete from essentials_package where ID =?";
            conn = createConnection();
            psm = conn.prepareStatement(sql);

            psm.setString(1, EPID);
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

    public int addNewEPHistoryForManager(String MNID, String EPID) {

        String sql;
        Date date;
        String content = "Thêm thông tin quản lý cho gói nhu yếu phẩm mới với ID= " + EPID;
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

    public int addDelEPHistoryForManager(String MNID, String EPID) {

        String sql;
        Date date;
        String content = "Xóa thông tin quản lý của gói nhu yếu phẩm có ID= " + EPID;
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

    public int addUpdateEPHistoryForManager(String MNID, String EPID) {
        Patient p = null;
        String sql;
        Date date;
        String content = "Chỉnh sửa thông tin quản lý cho gói nhu yếu phẩm với ID= " + EPID;
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
