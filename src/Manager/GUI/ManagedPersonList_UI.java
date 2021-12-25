/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Manager.GUI;

import Manager.Controller.ManagerController;
import static Manager.GUI.PackageManagement_UI.model;
import Patient.Model.Patient;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HOME
 */
public class ManagedPersonList_UI extends javax.swing.JFrame {

    /**
     * Creates new form ManagedPersonList
     */
    ManagerController manager = new ManagerController();
    static String MNID = "MN12345";
    static DefaultTableModel model;

    public ManagedPersonList_UI() {
        initComponents();
        ArrayList<Patient> list = manager.view_patient_list();
        model = (DefaultTableModel) jTable1.getModel();
        for (Patient p : list) {
            String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
            model.addRow(temp);
        }
        sortType.add("Tăng dần theo Tên người được quản lý");
        sortType.add("Giảm dần theo Tên người được quản lý");
        sortType.add("Tăng dần theo Tên nơi điều trị");
        sortType.add("Giảm dần theo Tên nơi điều trị");
        sortType.add("Tăng dần theo Ngày sinh");
        sortType.add("Giảm dần theo Ngày sinh");
        sortType.add("Tăng dần theo Trạng thái");
        sortType.add("Giảm dần theo Trạng thái");
        sortType.add("Tăng dần theo Dư nợ");
        sortType.add("Giảm dần theo Dư nợ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchID = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        sortType = new java.awt.Choice();
        sortButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid Info Management - Manager");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "CCCD", "Ngày sinh", "Địa chỉ", "Trạng thái", "Nơi điều trị", "Dư nợ"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("HIỂN THỊ DANH SÁCH NGƯỜI LIÊN QUAN ĐẾN COVID");

        jButton2.setText("Đăng xuất");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        jLabel3.setText("CCCD:");

        searchButton.setText("Tìm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchID, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(searchButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchButton)
                    .addComponent(searchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Sắp xếp");

        sortButton.setText("Sắp xếp");
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortType, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sortButton)
                    .addComponent(sortType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        super.dispose();
        CovidManagement_UI.main(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String mpID = searchID.getText();
        mpID = mpID.trim();
        Patient p = null;
        p = manager.searchPatient(mpID);
        if (p != null) {
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
            model.addRow(temp);
        }

    }//GEN-LAST:event_searchButtonActionPerformed

    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
        // TODO add your handling code here:
        String type = sortType.getSelectedItem().toString();

        switch (type) {

            case "Tăng dần theo Tên người được quản lý" -> {
                ArrayList<Patient> list = manager.sort_ASC_byName();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Patient p : list) {
                    String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
                    model.addRow(temp);
                }
            }
            case "Giảm dần theo Tên người được quản lý" -> {
                ArrayList<Patient> list = manager.sort_DESC_byName();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Patient p : list) {
                    String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
                    model.addRow(temp);
                }
            }
            case "Tăng dần theo Tên nơi điều trị" -> {
                ArrayList<Patient> list = manager.sort_ASC_byName();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Patient p : list) {
                    String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
                    model.addRow(temp);
                }
            }
            case "Giảm dần theo Tên nơi điều trị" -> {
                ArrayList<Patient> list = manager.sort_DESC_byName();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Patient p : list) {
                    String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
                    model.addRow(temp);
                }
            }
            case "Tăng dần theo Ngày sinh" -> {
                ArrayList<Patient> list = manager.sort_ASC_byDOB();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Patient p : list) {
                    String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
                    model.addRow(temp);
                }
            }
            case "Giảm dần theo Ngày sinh" -> {
                ArrayList<Patient> list = manager.sort_DESC_byDOB();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Patient p : list) {
                    String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
                    model.addRow(temp);
                }
            }
            case "Tăng dần theo Trạng thái" -> {
                ArrayList<Patient> list = manager.sort_ASC_byState();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Patient p : list) {
                    String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
                    model.addRow(temp);
                }
            }
            case "Giảm dần theo Trạng thái" -> {
                ArrayList<Patient> list = manager.sort_DESC_byState();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Patient p : list) {
                    String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
                    model.addRow(temp);
                }
            }
            case "Tăng dần theo Dư nợ" -> {
                ArrayList<Patient> list = manager.sort_ASC_byDebt();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Patient p : list) {
                    String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
                    model.addRow(temp);
                }
            }
            case "Giảm dần theo Dư nợ" -> {
                ArrayList<Patient> list = manager.sort_DESC_byDebt();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Patient p : list) {
                    String[] temp = {p.getName(), p.getCCCD(), p.getDOB().toString(), p.getAddress(), "F" + p.getState(), p.getIsolation(), Float.toString(p.getDebt())};
                    model.addRow(temp);
                }
            }
            default -> {
            }
        }
    }//GEN-LAST:event_sortButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagedPersonList_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagedPersonList_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagedPersonList_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagedPersonList_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagedPersonList_UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchID;
    private javax.swing.JButton sortButton;
    private java.awt.Choice sortType;
    // End of variables declaration//GEN-END:variables
}
