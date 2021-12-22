/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager.Service;

/**
 *
 * @author HOME
 */
import static DatabaseConnector.connect_db.createConnection;
import Patient.Model.Patient;

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
public class CovidManagementService {

    int status;

    public ArrayList<Patient> showList() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt from mp_infor";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("At_IsolationArea"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Patient findByCCCD(String CCCD) {
        Patient p = null;
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        try {
            sql = "select * from mp_infor where CCCD = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, CCCD);
            rs = psm.executeQuery();

            if (rs.next()) {

                p = new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("At_IsolationArea"), rs.getFloat("Debt"));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    public int addNewMP_Info(Patient newp) {
        Patient p = null;
        String sql;

        Connection conn = null;
        PreparedStatement psm = null;
        int row = 0;
        try {
            sql = "insert into mp_infor (Name,CCCD,Birthday,Address,State,At_IsolationArea,Related,Debt) values (?,?,?,?,?,?,?,?)";
            conn = createConnection();
            psm = conn.prepareStatement(sql);
            psm.setString(1, newp.getName());
            psm.setString(2, newp.getCCCD());
            psm.setDate(3, newp.getDOB());
            psm.setString(4, newp.getAddress());
            psm.setString(5, newp.getState());
            psm.setString(6, newp.getIsolation());
            psm.setString(7, newp.getRelated());
            psm.setFloat(8, 0);
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

    public int addNewMPAccount(String CCCD) {
        Patient p = null;
        String sql;

        Connection conn = null;
        PreparedStatement psm = null;
        int row = 0;
        try {
            sql = "insert into Account (Username,Password,Type,state) values (?,?,?,?)";
            conn = createConnection();
            psm = conn.prepareStatement(sql);
            psm.setString(1, CCCD);
            psm.setString(2, null);
            psm.setInt(3, 3);
            psm.setString(4, "OPEN");

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

    public ArrayList<String> findIsolationArea() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<String> list = new ArrayList<String>();
        try {
            sql = "select Name from isolation_area where PresentCapicity < MaxCapicity";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new String(rs.getString("Name")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public int transferStatus(String CCCD, String newstatus) {
        Patient p = null;
        String sql;

        Connection conn = null;
        PreparedStatement psm = null;
        int row = 0;
        try {
            sql = "update mp_infor set At_IsolationArea = ? where CCCD = ?";
            conn = createConnection();
            psm = conn.prepareStatement(sql);
            psm.setString(1, newstatus);
            psm.setString(2, CCCD);

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

    public int transferIsolationArea(String CCCD, String newplace) {
        Patient p = null;
        String sql;

        Connection conn = null;
        PreparedStatement psm = null;
        int row = 0;
        try {
            sql = "update mp_infor set State = ? where CCCD = ?";
            conn = createConnection();
            psm = conn.prepareStatement(sql);
            psm.setString(1, newplace);
            psm.setString(2, CCCD);

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

    public ArrayList<Patient> sortACSByName() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt from mp_infor order by Name ACS";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("At_IsolationArea"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortACSByState() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt from mp_infor order by Status ACS";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("At_IsolationArea"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortDECSByState() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt from mp_infor order by State DESC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("At_IsolationArea"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortACSByDebt() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt from mp_infor order by Debt ACS";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("At_IsolationArea"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortDECSByDebt() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt from mp_infor order by Debt DESC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("At_IsolationArea"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortACSByDOB() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt from mp_infor order by Birthday ACS";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("At_IsolationArea"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public int addTransferStatusHistoryForManager(String MNID, String MPID, String oldState, String newState) {
        Patient p = null;
        String sql;
        Date date;
        String content = "Người được quản lý với CCCD= " + MPID + " được chuyển trạng thái từ "
                + oldState + " sang trạng thái mới " + newState;
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
            psm.setString(1, MPID);
            row += psm.executeUpdate();
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

    public int addTransferIsolationAreaHistoryForManager(String MNID, String MPID, String oldPlace, String newPlace) {
        Patient p = null;
        String sql;
        Date date;
        String content = "Người được quản lý với CCCD= " + MPID + " được chuyển trạng thái từ "
                + oldPlace + " sang trạng thái mới " + newPlace;
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
            psm.setString(1, MPID);
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

    public static void main(String[] args) {
        Patient p = null;
        String sql;
        Date date;
        String MNID = "MN12345";
        String MPID = "111111111111";
        String oldState = "F1";
        String newState = "F0";
        String content = "Người được quản lý với CCCD= " + MPID + " được chuyển trạng thái từ "
                + oldState + " sang trạng thái mới " + newState;
        Connection conn = null;
        PreparedStatement psm = null;
        int row = 0;
        try {
            sql = "insert into management_history (STT,AccountID,Content,Time) values (?,?,?,?)";
            conn = createConnection();
            psm = conn.prepareStatement(sql);
            psm.setInt(1, 6);
            psm.setString(2, MNID);
            psm.setString(3, content);
            date = Date.valueOf(java.time.LocalDate.now());
            psm.setDate(4, date);
            row = psm.executeUpdate();
            psm.setInt(1, 7);
            psm.setString(2, MPID);
            row += psm.executeUpdate();
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
        System.out.println(row + " inserted.");
    }
}