package Patient.GUI;

import Patient.Controller.patient_controller;
import Patient.Model.EssentialPackage;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class patient_purchase extends javax.swing.JFrame {

    patient_controller control = new patient_controller();
    ArrayList<EssentialPackage> list = null;
    DefaultTableModel model;
    public static String IDToConfirm;

    public patient_purchase() {
        initComponents();
        this.setLocationRelativeTo(null);

        if (patient_filter.filtered == false) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sortComboBox = new javax.swing.JComboBox<>();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        filterButton = new javax.swing.JButton();
        buyButton = new javax.swing.JButton();
        sortButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gói nhu yếu phẩm");
        setPreferredSize(new java.awt.Dimension(640, 360));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("Gói nhu yếu phẩm");

        sortComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID (a-z)", "ID (z-a)", "Tên gói (a-z)", "Tên gói (z-a)", "Mức giới hạn (a-z)", "Mức giới hạn (z-a)", "Thời gian giới hạn (a-z)", "Thời gian giới hạn (z-a)", "Đơn giá (a-z)", "Đơn giá (z-a)" }));

        searchTextField.setToolTipText("Nhập tên gói muốn tìm kiếm");

        searchButton.setText("Tìm kiếm");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên gói", "Mức giới hạn", "Thời gian giới hạn", "Đơn giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });

        filterButton.setText("Lọc");
        filterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterButtonMouseClicked(evt);
            }
        });

        buyButton.setText("Mua");
        buyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buyButtonMouseClicked(evt);
            }
        });

        sortButton.setText("Sắp xếp");
        sortButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sortButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filterButton)
                        .addGap(15, 15, 15)
                        .addComponent(buyButton)
                        .addGap(15, 15, 15)
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(searchButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(sortButton))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(filterButton)
                    .addComponent(buyButton))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyButtonMouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        IDToConfirm = jTable1.getModel().getValueAt(selectedRow, 0).toString();

        super.dispose();
        patient_purchase_confirm.main(null);
    }//GEN-LAST:event_buyButtonMouseClicked

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        super.dispose();
        patient_main.main(null);
    }//GEN-LAST:event_backButtonMouseClicked

    private void filterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterButtonMouseClicked
        // TODO add your handling code here:
        super.dispose();
        patient_filter.main(null);
    }//GEN-LAST:event_filterButtonMouseClicked

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        // TODO add your handling code here:
        String search = searchTextField.getText();
        search = search.trim();

        if (search.equals("") || search.equals(" ")) {
            list = control.view_essential_package();

            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (EssentialPackage e : list) {
                model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
            }
        } else {
            list = control.view_essential_package_by_name(search);

            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (EssentialPackage e : list) {
                model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
            }
        }
    }//GEN-LAST:event_searchButtonMouseClicked

    private void sortButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sortButtonMouseClicked
        // TODO add your handling code here:
        String filter = sortComboBox.getSelectedItem().toString();

        switch (filter) {
            case "ID (a-z)" -> {
                list = control.view_essential_package_id_asc();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "ID (z-a)" -> {
                list = control.view_essential_package_id_desc();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Tên gói (a-z)" -> {
                list = control.view_essential_package_name_asc();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Tên gói (z-a)" -> {
                list = control.view_essential_package_name_desc();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Mức giới hạn (a-z)" -> {
                list = control.view_essential_package_limit_people_asc();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Mức giới hạn (z-a)" -> {
                list = control.view_essential_package_limit_people_desc();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Thời gian giới hạn (a-z)" -> {
                list = control.view_essential_package_limit_time_asc();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Thời gian giới hạn (z-a)" -> {
                list = control.view_essential_package_limit_time_desc();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Đơn giá (a-z)" -> {
                list = control.view_essential_package_price_asc();

                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (EssentialPackage e : list) {
                    model.addRow(new Object[]{e.getEPID(), e.getEPName(), e.getLimitPeople(), e.getLimitDate(), e.getPrice()});
                }
            }
            case "Đơn giá (z-a)" -> {
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

    }//GEN-LAST:event_sortButtonMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(patient_purchase.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patient_purchase.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patient_purchase.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patient_purchase.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patient_purchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton buyButton;
    private javax.swing.JButton filterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton sortButton;
    private javax.swing.JComboBox<String> sortComboBox;
    // End of variables declaration//GEN-END:variables
}
