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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruzbihan
 */
public class ReportPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReportPanel2
     */
    public ReportPanel() {
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

        jXDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrders = new org.jdesktop.swingx.JXTable();
        btnGetReport = new org.jdesktop.swingx.JXButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 4));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jXDatePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 30));

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "User Name", "Amount"
            }
        ));
        jScrollPane1.setViewportView(tblOrders);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 550, 290));

        btnGetReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        btnGetReport.setForeground(new java.awt.Color(51, 0, 0));
        btnGetReport.setText("Get Report");
        btnGetReport.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGetReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGetReportMouseClicked(evt);
            }
        });
        add(btnGetReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 150, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGetReportMouseClicked
        try {
            Date date = jXDatePicker.getDate();
            DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
            String strDate = df.format(date);
            System.out.println(strDate);

            String SQL = "select * from orders where date = '" + strDate + "';";
            Connection conn = DBConnection.getInstance().getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            DefaultTableModel dtm = (DefaultTableModel) tblOrders.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                String orderID = rs.getString("orderID");
                String userName = rs.getString("userName");
                String amount = rs.getString("orderAmount");
                Object[] row = {orderID, userName, amount};
                dtm.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGetReportMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnGetReport;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker;
    private org.jdesktop.swingx.JXTable tblOrders;
    // End of variables declaration//GEN-END:variables
}
