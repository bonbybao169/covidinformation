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
import Manager.Controller.ManagerController;
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
            sql = "select m.Name,CCCD,Birthday,Address,State,Debt, a.Name  as Hopital from mp_infor m join isolation_area a on m.At_IsolationArea=a.ID";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        Integer.toString(rs.getInt("State")), rs.getString("Hopital"), rs.getFloat("Debt")));
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
            sql = "select m.Name,CCCD,Birthday,Address,State,Debt, a.Name  as Hopital from mp_infor m join isolation_area a on m.At_IsolationArea=a.ID where m.CCCD = ?";
            psm = conn.prepareStatement(sql);
            psm.setString(1, CCCD);
            rs = psm.executeQuery();

            if (rs.next()) {

                p = new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        Integer.toString(rs.getInt("State")), rs.getString("Hopital"), rs.getFloat("Debt"));
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
            psm.setInt(5, Integer.parseInt(newp.getState()));
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

    public ArrayList<String[]> findIsolationArea() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            sql = "select ID,Name from isolation_area where PresentCapicity < MaxCapicity";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                String[] temp = {rs.getString("ID"), rs.getString("Name")};
                list.add(temp);
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<String[]> findRelatedPeopleList(String CCCD) {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            sql = "CALL findRelatedPeople(?);";
            psm = conn.prepareStatement(sql);
            psm.setString(1, CCCD);
            rs = psm.executeQuery();

            while (rs.next()) {
                String[] temp = {rs.getString("CCCD"), rs.getString("Name")};
                list.add(temp);
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public int transferStatus(String CCCD, int newstatus) {

        String sql;

        Connection conn = null;
        PreparedStatement psm = null;
        int row = 0;
        try {
            sql = "call transferState(?,?)";
            conn = createConnection();
            psm = conn.prepareStatement(sql);
            psm.setInt(2, newstatus);
            psm.setString(1, CCCD);

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

        String sql;

        Connection conn = null;
        PreparedStatement psm = null;
        int row = 0;
        try {
            sql = "update mp_infor set At_IsolationArea = ? where CCCD = ?";
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

    public ArrayList<Patient> sortASCByName() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select m.Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt ,a.Name  as Hopital from mp_infor m join isolation_area a  on m.At_IsolationArea=a.ID order by m.Name ASC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("Hopital"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortDESCByName() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select m.Name,CCCD,Birthday,Address,State,Debt, a.Name  as Hopital from mp_infor m join isolation_area a  on m.At_IsolationArea=a.ID order by m.Name DESC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("Hopital"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortASCByState() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select m.Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt, a.Name  as Hopital from mp_infor m join isolation_area a  on m.At_IsolationArea=a.ID order by Status ASC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("Hopital"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortDESCByState() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select m.Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt, a.Name  as Hopital from mp_infor m join isolation_area a  on m.At_IsolationArea=a.ID order by State DESC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("Hopital"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortASCByDebt() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select m.Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt, a.Name  as Hopital from mp_infor m join isolation_area a  on m.At_IsolationArea=a.ID order by Debt ASC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("Hopital"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortDESCByDebt() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select m.Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt ,a.Name  as Hopital from mp_infor m join isolation_area a  on m.At_IsolationArea=a.ID order by Debt DESC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("Hopital"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortASCByDOB() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select m.Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt, a.Name  as Hopital from mp_infor m join isolation_area a  on m.At_IsolationArea=a.ID order by Birthday ASC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("Hopital"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortDESCByDOB() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select m.Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt, a.Name  as Hopital from mp_infor m join isolation_area a  on m.At_IsolationArea=a.ID order by Birthday DESC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("Hopital"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortASCByHopital() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select m.Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt, a.Name  as Hopital from mp_infor m join isolation_area a  on m.At_IsolationArea=a.ID order by a.Name ASC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("Hopital"), rs.getFloat("Debt")));
            }

            conn.close();
            psm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Patient> sortDESCByHopital() {
        String sql;
        ResultSet rs;
        Connection conn = createConnection();
        PreparedStatement psm = null;
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            sql = "select m.Name,CCCD,Birthday,Address,State,At_IsolationArea,Debt, a.Name  as Hopital from mp_infor m join isolation_area a  on m.At_IsolationArea=a.ID order by a.Name DESC";
            psm = conn.prepareStatement(sql);

            rs = psm.executeQuery();

            while (rs.next()) {

                list.add(new Patient(rs.getString("Name"), rs.getString("CCCD"),
                        rs.getDate("Birthday"), rs.getString("Address"),
                        rs.getString("State"), rs.getString("Hopital"), rs.getFloat("Debt")));
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

    public int addNewMPInforHistoryForManager(String MNID, String MPID) {
        Patient p = null;
        String sql;
        Date date;
        String content = "Thêm thông tin người được quản lý mới với CCCD= " + MPID;
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

    public int addNewMPAccountHistoryForManager(String MNID, String MPID) {
        Patient p = null;
        String sql;
        Date date;
        String content = "Thêm tài khoản mới cho người được quản lý mới với CCCD= " + MPID;
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

}
