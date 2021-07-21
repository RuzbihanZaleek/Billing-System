/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chocohub.view;

import chocohub.common.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruzbihan
 */
public class SettingsPanel extends javax.swing.JPanel {

    /**
     * Creates new form SettingsPanel2
     */
    public SettingsPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        txtUserName = new org.jdesktop.swingx.JXTextField();
        pwdConfirm = new javax.swing.JPasswordField();
        pwdCurrent1 = new javax.swing.JPasswordField();
        pwdNew1 = new javax.swing.JPasswordField();
        btnSave = new org.jdesktop.swingx.JXButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXLabel2.setForeground(new java.awt.Color(51, 0, 0));
        jXLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel2.setText("Confirm Password");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(jXLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 130, 30));

        jXLabel3.setForeground(new java.awt.Color(51, 0, 0));
        jXLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel3.setText("User Name            ");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(jXLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 130, 30));

        jXLabel4.setForeground(new java.awt.Color(51, 0, 0));
        jXLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel4.setText("Current Password");
        jXLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(jXLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 130, 30));

        jXLabel5.setForeground(new java.awt.Color(51, 0, 0));
        jXLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel5.setText("New Password     ");
        jXLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(jXLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 130, 30));

        txtUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        txtUserName.setForeground(new java.awt.Color(51, 0, 0));
        txtUserName.setText("Chocohub");
        txtUserName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUserName.setSelectionColor(new java.awt.Color(51, 0, 0));
        add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 220, 30));

        pwdConfirm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pwdConfirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        add(pwdConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 220, 30));

        pwdCurrent1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pwdCurrent1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        add(pwdCurrent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 220, 30));

        pwdNew1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pwdNew1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        add(pwdNew1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 220, 30));

        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        btnSave.setText("Save");
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 150, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String userName = txtUserName.getText();
            String currentPassword = String.valueOf(pwdCurrent1.getPassword());
            String newPassword = String.valueOf(pwdNew1.getPassword());
            String confirmPassword = String.valueOf(pwdConfirm.getPassword());

            String SQL = "select * from user where userName='" + userName + "' and password='" + currentPassword + "';";
            Connection conn = DBConnection.getInstance().getConnection();
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(SQL);

            if (rst.next() && newPassword.equals(confirmPassword)) {
                String SQL2 = "Update user set password='" + newPassword + "' where userName='Chocohub'";
                int res = stm.executeUpdate(SQL2);
                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "User Updated");
                    pwdCurrent1.setText(null);
                    pwdNew1.setText(null);
                    pwdConfirm.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Check input values again");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SettingsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SettingsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnSave;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private javax.swing.JPasswordField pwdConfirm;
    private javax.swing.JPasswordField pwdCurrent1;
    private javax.swing.JPasswordField pwdNew1;
    private org.jdesktop.swingx.JXTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}