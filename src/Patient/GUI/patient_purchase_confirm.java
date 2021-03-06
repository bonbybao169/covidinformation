package Patient.GUI;

import Patient.Controller.patient_controller;
import Patient.Model.EssentialPackage;
import Patient.Model.Patient;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class patient_purchase_confirm extends javax.swing.JFrame {

    patient_controller control = new patient_controller();
    DefaultTableModel model;
    static EssentialPackage ep = null;
    static Patient pa;

    public patient_purchase_confirm() {

        try {
            img = ImageIO.read(new File("src/Image/covid.jpg"));
            initComponents();
            Image dimg = img.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            jLabel2.setIcon(imageIcon);
            this.setLocationRelativeTo(null);

            ep = control.view_essential_package_by_id(patient_purchase.IDToConfirm);
            nameEPLabel.setText(ep.getEPName());

            int total = control.getTotalUse(patient_purchase.IDToConfirm);
            int quantityLeft = ep.getLimitPeople() - total;
            quantityLeftLabel.setText(String.valueOf(quantityLeft));

            quantityEPSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, quantityLeft, 1));

        } catch (IOException ex) {
            Logger.getLogger(patient_purchase_confirm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameEPLabel = new javax.swing.JLabel();
        quantityLeftLabel = new javax.swing.JLabel();
        totalPriceLabel = new javax.swing.JLabel();
        buyConfirmButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        quantityEPSpinner = new javax.swing.JSpinner();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("X??c nh???n mua nhu y???u ph???m");
        setPreferredSize(new java.awt.Dimension(640, 360));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("T??n g??i:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("S??? l?????ng mua:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("S??? l?????ng c??n l???i:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("T???ng c???ng:");

        nameEPLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameEPLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameEPLabel.setText("L????ng kh??");
        nameEPLabel.setToolTipText("");
        nameEPLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        quantityLeftLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quantityLeftLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        quantityLeftLabel.setText("8");
        quantityLeftLabel.setToolTipText("");
        quantityLeftLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        totalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalPriceLabel.setText("0");
        totalPriceLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        buyConfirmButton.setText("Mua");
        buyConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buyConfirmButtonMouseClicked(evt);
            }
        });

        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });

        quantityEPSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        quantityEPSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                quantityEPSpinnerStateChanged(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backButton)
                        .addGap(15, 15, 15)
                        .addComponent(buyConfirmButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(quantityLeftLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nameEPLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(totalPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(quantityEPSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameEPLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(quantityEPSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(quantityLeftLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(totalPriceLabel))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buyConfirmButton)
                        .addComponent(backButton))
                    .addComponent(errorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        super.dispose();
        patient_purchase.main(null);
    }//GEN-LAST:event_backButtonMouseClicked

    private void quantityEPSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_quantityEPSpinnerStateChanged
        // TODO add your handling code here:
        float totalPrice = (int) quantityEPSpinner.getValue() * ep.getPrice();
        totalPriceLabel.setText(String.valueOf(totalPrice));
    }//GEN-LAST:event_quantityEPSpinnerStateChanged

    private void buyConfirmButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyConfirmButtonMouseClicked
        // TODO add your handling code here:
        if ((int) quantityEPSpinner.getValue() == 0) {
            errorLabel.setText("Please choose quantity or Press Back!");
        } else {
            control.addConsumptionHistory(ep.getEPID(), (int) quantityEPSpinner.getValue());
            pa = control.view_basic_info();
            float newDebt = pa.getDebt() + Float.valueOf(totalPriceLabel.getText());
            control.buyEssentialPackage(newDebt);

            super.dispose();
            patient_purchase.main(null);
        }

    }//GEN-LAST:event_buyConfirmButtonMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(patient_purchase_confirm.class
                    .getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patient_purchase_confirm.class
                    .getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patient_purchase_confirm.class
                    .getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patient_purchase_confirm.class
                    .getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patient_purchase_confirm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton buyConfirmButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameEPLabel;
    private javax.swing.JSpinner quantityEPSpinner;
    private javax.swing.JLabel quantityLeftLabel;
    private javax.swing.JLabel totalPriceLabel;
    // End of variables declaration//GEN-END:variables
    BufferedImage img = null;
}
