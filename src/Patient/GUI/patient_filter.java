package Patient.GUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import Patient.Controller.patient_controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class patient_filter extends javax.swing.JFrame {

    patient_controller control = new patient_controller();
    public static boolean filtered = false;

    public patient_filter() {
        try {
            img = ImageIO.read(new File("src/Image/covid.jpg"));
            initComponents();
            Image dimg = img.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            jLabel2.setIcon(imageIcon);
            this.setLocationRelativeTo(null);
        } catch (IOException ex) {
            Logger.getLogger(patient_filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        priceToTextField = new javax.swing.JTextField();
        limitPeopleFromTextField = new javax.swing.JTextField();
        limitPeopleToTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        priceFromTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        limitTimeFromTextField = new javax.swing.JTextField();
        limitTimeToTextField = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jFormattedTextField2.setText("jFormattedTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lọc");
        setPreferredSize(new java.awt.Dimension(640, 360));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(379, 275));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Giá:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mức giới hạn:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Thời gian giới hạn:");

        confirmButton.setText("OK");
        confirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmButtonMouseClicked(evt);
            }
        });

        priceToTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceToTextField.setToolTipText("Allow only number");
        priceToTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priceToTextFieldKeyPressed(evt);
            }
        });

        limitPeopleFromTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        limitPeopleFromTextField.setToolTipText("Allow only number");
        limitPeopleFromTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                limitPeopleFromTextFieldKeyPressed(evt);
            }
        });

        limitPeopleToTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        limitPeopleToTextField.setToolTipText("Allow only number");
        limitPeopleToTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                limitPeopleToTextFieldKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel5.setText("-");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel6.setText("-");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel7.setText("-");

        priceFromTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceFromTextField.setToolTipText("Allow only number");
        priceFromTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priceFromTextFieldKeyPressed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        limitTimeFromTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        limitTimeFromTextField.setText("YYYY-MM-DD");
        limitTimeFromTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limitTimeFromTextFieldMouseClicked(evt);
            }
        });

        limitTimeToTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        limitTimeToTextField.setText("YYYY-MM-DD");
        limitTimeToTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limitTimeToTextFieldMouseClicked(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(132, 132, 132)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(priceFromTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(limitPeopleFromTextField)
                            .addComponent(limitTimeFromTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(priceToTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(limitPeopleToTextField)
                            .addComponent(limitTimeToTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirmButton)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(priceFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(limitPeopleFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limitPeopleToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limitTimeFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limitTimeToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_confirmButtonMouseClicked

        // TODO add your handling code here:
        if (!limitTimeFromTextField.getText().equals("YYYY-MM-DD") && !limitTimeToTextField.getText().equals("YYYY-MM-DD")) {
            if (priceFromTextField.getText().equals("") || priceToTextField.getText().equals("")) {
                if (limitPeopleFromTextField.getText().equals("") || limitPeopleToTextField.getText().equals("")) {
                    if (limitTimeFromTextField.getText().equals("") || limitTimeToTextField.getText().equals("")) {
                        control.filter_essential_package(limitPeopleFromTextField.getText(), limitPeopleToTextField.getText(),
                                limitTimeFromTextField.getText(), limitTimeToTextField.getText(), priceFromTextField.getText(),
                                priceToTextField.getText());
                        filtered = true;

                        super.dispose();
                        patient_purchase.main(null);
                    } else {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            Date dateFrom = sdf.parse(limitTimeFromTextField.getText());
                            Date dateTo = sdf.parse(limitTimeToTextField.getText());

                            if (dateFrom.before(dateTo) || dateFrom.equals(dateTo)) {
                                control.filter_essential_package(limitPeopleFromTextField.getText(), limitPeopleToTextField.getText(),
                                        limitTimeFromTextField.getText(), limitTimeToTextField.getText(), priceFromTextField.getText(),
                                        priceToTextField.getText());
                                filtered = true;

                                super.dispose();
                                patient_purchase.main(null);
                            } else {
                                errorLabel.setText("Input date wrong.");
                            }
                        } catch (ParseException ex) {
                            Logger.getLogger(patient_filter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    if (Integer.valueOf(limitPeopleFromTextField.getText()) <= Integer.valueOf(limitPeopleToTextField.getText())) {
                        control.filter_essential_package(limitPeopleFromTextField.getText(), limitPeopleToTextField.getText(),
                                limitTimeFromTextField.getText(), limitTimeToTextField.getText(), priceFromTextField.getText(),
                                priceToTextField.getText());
                        filtered = true;

                        super.dispose();
                        patient_purchase.main(null);
                    } else {
                        errorLabel.setText("Input limit per people wrong.");
                    }
                }
            } else {
                if (Float.valueOf(priceFromTextField.getText()) <= Float.valueOf(priceToTextField.getText())) {
                    control.filter_essential_package(limitPeopleFromTextField.getText(), limitPeopleToTextField.getText(),
                            limitTimeFromTextField.getText(), limitTimeToTextField.getText(), priceFromTextField.getText(),
                            priceToTextField.getText());
                    filtered = true;

                    super.dispose();
                    patient_purchase.main(null);
                } else {
                    errorLabel.setText("Input price wrong.");
                }
            }

        } else {
            errorLabel.setText("Delete YYYY-MM-DD");
        }

    }// GEN-LAST:event_confirmButtonMouseClicked

    private void priceFromTextFieldKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_priceFromTextFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            priceFromTextField.setEditable(false);
        } else {
            priceFromTextField.setEditable(true);
        }
    }// GEN-LAST:event_priceFromTextFieldKeyPressed

    private void priceToTextFieldKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_priceToTextFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            priceToTextField.setEditable(false);
        } else {
            priceToTextField.setEditable(true);
        }
    }// GEN-LAST:event_priceToTextFieldKeyPressed

    private void limitPeopleFromTextFieldKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_limitPeopleFromTextFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            limitPeopleFromTextField.setEditable(false);
        } else {
            limitPeopleFromTextField.setEditable(true);
        }
    }// GEN-LAST:event_limitPeopleFromTextFieldKeyPressed

    private void limitPeopleToTextFieldKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_limitPeopleToTextFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            limitPeopleToTextField.setEditable(false);
        } else {
            limitPeopleToTextField.setEditable(true);
        }
    }// GEN-LAST:event_limitPeopleToTextFieldKeyPressed

    private void limitTimeFromTextFieldMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_limitTimeFromTextFieldMouseClicked
        // TODO add your handling code here:
        limitTimeFromTextField.setText("");
    }// GEN-LAST:event_limitTimeFromTextFieldMouseClicked

    private void limitTimeToTextFieldMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_limitTimeToTextFieldMouseClicked
        // TODO add your handling code here:
        limitTimeToTextField.setText("");
    }// GEN-LAST:event_limitTimeToTextFieldMouseClicked

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
            java.util.logging.Logger.getLogger(patient_filter.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patient_filter.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patient_filter.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patient_filter.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patient_filter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField limitPeopleFromTextField;
    private javax.swing.JTextField limitPeopleToTextField;
    private javax.swing.JTextField limitTimeFromTextField;
    private javax.swing.JTextField limitTimeToTextField;
    private javax.swing.JTextField priceFromTextField;
    private javax.swing.JTextField priceToTextField;
    // End of variables declaration//GEN-END:variables
    BufferedImage img = null;
}
