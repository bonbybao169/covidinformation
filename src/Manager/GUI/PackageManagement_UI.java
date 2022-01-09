/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Manager.GUI;

import Auth.GUI.Login_UI;
import Manager.Controller.ManagerController;
import Patient.Controller.patient_controller;
import Manager.GUI.FilterEP_UI;
import Patient.Model.EssentialPackage;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HOME
 */
public class PackageManagement_UI extends javax.swing.JFrame {

    /**
     * Creates new form PackageManagement
     */
    ManagerController manager = new ManagerController();
    static String MNID = "";
    static DefaultTableModel model;
    ArrayList<EssentialPackage> list = null;
    patient_controller control = new patient_controller();
    
    public PackageManagement_UI(String mnid) {
        initComponents();
        this.setLocationRelativeTo(null);
        MNID = mnid;
        sortType.add("Tăng dần theo ID");
        sortType.add("Giảm dần theo ID");
        sortType.add("Tăng dần theo Tên gói");
        sortType.add("Giảm dần theo Tên gói");
        sortType.add("Tăng dần theo Mức giới hạn");
        sortType.add("Giảm dần theo Mức giới hạn");
        sortType.add("Tăng dần theo Thời hạn");
        sortType.add("Giảm dần theo Thời hạn");
        sortType.add("Tăng dần theo Gía");
        sortType.add("Giảm dần theo Gía");
        if (FilterEP_UI.filtered == false) {
            list = control.view_essential_package();
            
            model = (DefaultTableModel) jTable1.getModel();
            for (EssentialPackage e : list) {
                model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
            }
        } else {
            list = control.view_filtered_EP();
            
            model = (DefaultTableModel) jTable1.getModel();
            for (EssentialPackage e : list) {
                model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        limitTime = new javax.swing.JTextField();
        limitPeople = new javax.swing.JTextField();
        EPID = new javax.swing.JTextField();
        EPName = new javax.swing.JTextField();
        searchButon = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        sortType = new java.awt.Choice();
        sortButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid Info Management - Manager");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ GÓI NHU YẾU PHẨM");

        jButton1.setText("Đăng xuất");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên gói", "Mức giới hạn/ người", "Thời hạn", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("ID");

        jLabel3.setText("Tên gói");

        jLabel4.setText("Mức giới hạn");

        jLabel5.setText("Đơn giá");

        jLabel6.setText("Thời gian giới hạn");

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });

        limitPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limitPeopleActionPerformed(evt);
            }
        });

        searchButon.setText("Tìm kiếm");
        searchButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButonActionPerformed(evt);
            }
        });

        delButton.setText("Xóa");
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Sửa");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(limitTime)
                            .addComponent(price, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EPID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EPName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(limitPeople, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchButon)
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(editButton)
                        .addGap(18, 18, 18)
                        .addComponent(delButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EPID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EPName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limitPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limitTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButon)
                    .addComponent(delButton)
                    .addComponent(addButton)
                    .addComponent(editButton))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Tiêu chí");

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
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortType, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(sortButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(sortType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(sortButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Lọc");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(2, 2, 2)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed
    
    private void limitPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limitPeopleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_limitPeopleActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        super.dispose();
        Login_UI.main(null);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        super.dispose();
        ManagerMain_UI.main(null, MNID);
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        super.dispose();
        FilterEP_UI.main(null, MNID);
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void searchButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButonActionPerformed
        // TODO add your handling code here:
        String searchID = EPID.getText();
        searchID = searchID.trim();
        String searchName = EPName.getText();
        searchName = searchName.trim();
        if (!searchID.equals("")) {
            EssentialPackage e = control.view_essential_package_by_id(searchID);
            
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
            
        } else if (!searchName.equals("")) {
            list = control.view_essential_package_by_name(searchName);
            
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (EssentialPackage e : list) {
                model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
            }
        } else {
            list = control.view_essential_package();
            
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (EssentialPackage e : list) {
                model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
            }
        }
    }//GEN-LAST:event_searchButonActionPerformed
    
    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
        // TODO add your handling code here:
        String type = sortType.getSelectedItem().toString();
        
        switch (type) {
            case "Tăng dần theo ID" -> {
                list = control.view_essential_package_id_asc();
                
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Giảm dần theo ID" -> {
                list = control.view_essential_package_id_desc();
                
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Tăng dần theo Tên gói" -> {
                list = control.view_essential_package_name_asc();
                
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Giảm dần theo Tên gói" -> {
                list = control.view_essential_package_name_desc();
                
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Tăng dần theo Mức giới hạn" -> {
                list = control.view_essential_package_limit_people_asc();
                
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Giảm dần theo Mức giới hạn" -> {
                list = control.view_essential_package_limit_people_desc();
                
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Tăng dần theo Thời hạn" -> {
                list = control.view_essential_package_limit_time_asc();
                
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Giảm dần theo Thời hạn" -> {
                list = control.view_essential_package_limit_time_desc();
                
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Tăng dần theo Gía" -> {
                list = control.view_essential_package_price_asc();
                
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Giảm dần theo Gía" -> {
                list = control.view_essential_package_price_desc();
                
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            default -> {
            }
        }
    }//GEN-LAST:event_sortButtonActionPerformed
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        manager.add_NewEssentialPackage(MNID, EPID.getText(), EPName.getText(),
                Integer.parseInt(limitPeople.getText()),
                java.sql.Date.valueOf(limitTime.getText()), Float.parseFloat(price.getText()));
        list = control.view_essential_package();
        model.setRowCount(0);
        model = (DefaultTableModel) jTable1.getModel();
        for (EssentialPackage e : list) {
            model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
        }
    }//GEN-LAST:event_addButtonActionPerformed
    
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        manager.UpdateEssentialPackage(MNID, EPID.getText(), EPName.getText(),
                Integer.parseInt(limitPeople.getText()),
                java.sql.Date.valueOf(limitTime.getText()), Float.parseFloat(price.getText()));
        list = control.view_essential_package();
        model.setRowCount(0);
        model = (DefaultTableModel) jTable1.getModel();
        for (EssentialPackage e : list) {
            model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
        }
    }//GEN-LAST:event_editButtonActionPerformed
    
    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        // TODO add your handling code here:
        manager.DelEssentialPackage(MNID, EPID.getText());
        list = control.view_essential_package();
        model.setRowCount(0);
        model = (DefaultTableModel) jTable1.getModel();
        for (EssentialPackage e : list) {
            model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
        }
    }//GEN-LAST:event_delButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[], String mnID) {
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
            java.util.logging.Logger.getLogger(PackageManagement_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PackageManagement_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PackageManagement_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PackageManagement_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PackageManagement_UI(mnID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EPID;
    private javax.swing.JTextField EPName;
    private javax.swing.JButton addButton;
    private javax.swing.JButton delButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField limitPeople;
    private javax.swing.JTextField limitTime;
    private javax.swing.JTextField price;
    private javax.swing.JButton searchButon;
    private javax.swing.JButton sortButton;
    private java.awt.Choice sortType;
    // End of variables declaration//GEN-END:variables

}
