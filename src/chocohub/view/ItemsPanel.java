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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruzbihan
 */
public class ItemsPanel extends javax.swing.JPanel {

    /**
     * Creates new form ItemsPanel2
     */
    public ItemsPanel() {
        initComponents();
        loadAllItems();
        loadComboBox();
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
        tblItem = new org.jdesktop.swingx.JXTable();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtItemName = new org.jdesktop.swingx.JXTextField();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        txtUnitPrice = new org.jdesktop.swingx.JXTextField();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        cmbItemCode = new javax.swing.JComboBox<>();
        btnEdit = new org.jdesktop.swingx.JXButton();
        btnRemove = new org.jdesktop.swingx.JXButton();
        btnAddItem = new org.jdesktop.swingx.JXButton();
        comboAvlbl1 = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Unit Price", "Availability"
            }
        ));
        tblItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblItem);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 200));

        jXPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 4));

        jXLabel3.setForeground(new java.awt.Color(51, 0, 0));
        jXLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel3.setText("Item Code");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jXLabel4.setForeground(new java.awt.Color(51, 0, 0));
        jXLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel4.setText("Item Name");
        jXLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtItemName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        txtItemName.setForeground(new java.awt.Color(51, 0, 0));
        txtItemName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtItemName.setSelectionColor(new java.awt.Color(51, 0, 0));

        jXLabel5.setForeground(new java.awt.Color(51, 0, 0));
        jXLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel5.setText("Unit Price");
        jXLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtUnitPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        txtUnitPrice.setForeground(new java.awt.Color(51, 0, 0));
        txtUnitPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUnitPrice.setSelectionColor(new java.awt.Color(51, 0, 0));

        jXLabel6.setForeground(new java.awt.Color(51, 0, 0));
        jXLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel6.setText("Availability");
        jXLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cmbItemCode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbItemCode.setForeground(new java.awt.Color(51, 0, 0));
        cmbItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbItemCodeActionPerformed(evt);
            }
        });

        btnEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chocohub/images/edit.png"))); // NOI18N
        btnEdit.setText("Update");
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        btnRemove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chocohub/images/remove.png"))); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAddItem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        btnAddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chocohub/images/plus (2).png"))); // NOI18N
        btnAddItem.setText("Add");
        btnAddItem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        comboAvlbl1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        comboAvlbl1.setForeground(new java.awt.Color(51, 0, 0));
        comboAvlbl1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboAvlbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboAvlbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        add(jXPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, 170));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            String SQL = "delete from choc where chocCode='" + cmbItemCode.getSelectedItem().toString() + "';";
            Connection conn = DBConnection.getInstance().getConnection();
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(SQL);

            if (rs > 0) {
                JOptionPane.showMessageDialog(this, "Item Deleted Successfully!");
                loadAllItems();
                loadComboBox();
            } else {
                JOptionPane.showMessageDialog(this, "Delete Fail!");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        AddItem addChoc = new AddItem(MainFrame.mainFrame, true);
        addChoc.setVisible(true);
        loadAllItems();
        loadComboBox();

    }//GEN-LAST:event_btnAddItemActionPerformed

    private void cmbItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbItemCodeActionPerformed
        if (cmbItemCode.getSelectedIndex() != -1) {
            searchItemByCode(cmbItemCode.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cmbItemCodeActionPerformed

    private void tblItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemMouseClicked
        if (tblItem.getRowCount() == -1) {
            return;
        }

        String itemCode = (String) tblItem.getValueAt(tblItem.getSelectedRow(), 0);
        searchItemByCode(itemCode);
    }//GEN-LAST:event_tblItemMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        try {
            String itemCode = cmbItemCode.getSelectedItem().toString();
            String itemName = txtItemName.getText();
            double unitPrice = Double.parseDouble(txtUnitPrice.getText());
            String availability = comboAvlbl1.getSelectedItem().toString();

            String SQL = "update choc set chocName='" + itemName + "',"
                    + " unitPrice='" + unitPrice + "', availability='" + availability + "' where chocCode='" + itemCode + "';";

            Connection conn = DBConnection.getInstance().getConnection();
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(SQL);

            if (rs > 0) {
                JOptionPane.showMessageDialog(this, "Item Updated!");
                loadAllItems();
                loadComboBox();
            } else {
                JOptionPane.showMessageDialog(this, "Update Failed!");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAddItem;
    private org.jdesktop.swingx.JXButton btnEdit;
    private org.jdesktop.swingx.JXButton btnRemove;
    private javax.swing.JComboBox<String> cmbItemCode;
    private javax.swing.JComboBox<String> comboAvlbl1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTable tblItem;
    private org.jdesktop.swingx.JXTextField txtItemName;
    private org.jdesktop.swingx.JXTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables

    private void loadAllItems() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) tblItem.getModel();
            dtm.setRowCount(0);

            String SQL = "select * from choc";
            Connection conn = DBConnection.getInstance().getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                String itemCode = rs.getString("chocCode");
                String itemName = rs.getString("chocName");
                double unitPrice = rs.getDouble("unitPrice");
                String availability = rs.getString("availability");

                Object[] rowData = {itemCode, itemName, unitPrice, availability};
                dtm.addRow(rowData);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadComboBox() {
        cmbItemCode.removeAllItems();
        try {

            String SQL = "select * from choc";
            Connection conn = DBConnection.getInstance().getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs == null) {
                return;
            }

            while (rs.next()) {
                cmbItemCode.addItem(rs.getString("chocCode"));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchItemByCode(String chocCode) {
        try {
            String SQL = "select * from choc where chocCode='" + chocCode + "';";
            Connection conn = DBConnection.getInstance().getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                cmbItemCode.setSelectedItem(chocCode);
                txtItemName.setText(rs.getString("chocName"));
                txtUnitPrice.setText(rs.getString("unitPrice"));
                comboAvlbl1.setSelectedItem(rs.getString("availability"));
            } else {
                JOptionPane.showMessageDialog(this, "Item not available! ");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
