package tarea_10y11;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class QualityProducts extends javax.swing.JFrame {

    
    public QualityProducts() {
        initComponents();
        productos();
    }
    
    public void productos(){
        try{
            conexion cn = new conexion();

            Statement statement = cn.conectar().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Product");
            
            DefaultTableModel model = (DefaultTableModel)tblProduct.getModel();
            model.setColumnCount(0);
            model.setRowCount(0);
            String [] columns = {"productId", "productName", "supplierId", "categoryId", "quantityPerUnit", "unitPrice", "unitsInStock", "unitsOnOrder", "reorderLevel", "discontinued"};
            
            for (String column:columns){
                model.addColumn((column));
            }

            while(resultSet.next()){
                String[] row = {
                    String.valueOf(resultSet.getInt("productId")),
                    resultSet.getString("productName"),
                    String.valueOf(resultSet.getInt("supplierId")),
                    String.valueOf(resultSet.getInt("categoryId")),
                    resultSet.getString("quantityPerUnit"),
                    String.valueOf(resultSet.getDouble("unitPrice")),
                    resultSet.getString("unitsInStock"),
                    resultSet.getString("unitsOnOrder"),
                    resultSet.getString("reorderLevel"),
                    String.valueOf(resultSet.getInt("discontinued")),
                };
                model.addRow(row);
            }
            tblProduct.setModel(model);
    }catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
    public void EliminarProducto(){
        try{
            int proid;
            proid = Integer.parseInt(txtproname.getText());
            conexion cn = new conexion();
            PreparedStatement preparedStatement = cn.conectar().prepareStatement("DELETE FROM Product WHERE productName=?");
            preparedStatement.setInt(1, proid );
            
            int rows = preparedStatement.executeUpdate();
            if (rows>0) {
                JOptionPane.showMessageDialog(null, "Se borro ");
                productos();
                }else {
                JOptionPane.showMessageDialog(null, "No se borro");
                }
            
        }catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void AgregarProducto(){
        try{
            int proid = Integer.parseInt(txtproID.getText());
            String proname = txtproname.getText();
            int supId = Integer.parseInt(txtsupplierID.getText());
            int catId = Integer.parseInt(txtcatID.getText());
            String quantity = txtQPU.getText();
            double unitP = Integer.parseInt(txtunitP.getText());
            int unitS = Integer.parseInt(txtUIS.getText());
            int unitO = Integer.parseInt(txtUIO.getText());
            int reorder = Integer.parseInt(txtreorderL.getText());
            String disc = txtDis.getText();
            
            conexion cn = new conexion();
            
            PreparedStatement ps =
                    cn.conectar().prepareStatement("INSERT INTO Product VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, proid);
            ps.setString(2, proname);
            ps.setInt(3, supId);
            ps.setInt(4, catId);
            ps.setString(5, quantity);
            ps.setDouble(6, unitP);
            ps.setInt(7, unitS);
            ps.setInt(8, unitO);
            ps.setInt(9, reorder);
            ps.setString(10, disc);           
            
            int rows = ps.executeUpdate();
            if (rows > 0 ) {
                JOptionPane.showMessageDialog(null, "inserto correctamente");
            }else {
                JOptionPane.showMessageDialog(null, "error garrafal");
                }
                    
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtproID = new javax.swing.JTextField();
        txtproname = new javax.swing.JTextField();
        txtsupplierID = new javax.swing.JTextField();
        txtcatID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQPU = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtunitP = new javax.swing.JTextField();
        txtUIS = new javax.swing.JTextField();
        txtUIO = new javax.swing.JTextField();
        txtreorderL = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDis = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        btnin = new javax.swing.JButton();
        btnel = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("PRODUCT");

        jLabel2.setText("productID");

        jLabel3.setText("productName");

        jLabel4.setText("supplierID");

        jLabel5.setText("categoryID");

        jLabel6.setText("QuantityPerUnit");

        jLabel7.setText("Unitprice");

        jLabel8.setText("UnitinStock");

        jLabel9.setText("UnitInOrder");

        jLabel10.setText("ReorderLevel");

        jLabel11.setText("Discontinued");

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        btnin.setText("Insertar Producto");
        btnin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninActionPerformed(evt);
            }
        });

        btnel.setText("Eliminar Producto");
        btnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(521, 521, 521))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addComponent(txtDis))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(txtreorderL))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(txtUIO))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(txtUIS))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(txtunitP))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txtQPU))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtproname))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtproID, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txtsupplierID))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtcatID)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnin)
                        .addGap(26, 26, 26)
                        .addComponent(btnel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtproID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtproname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtsupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtcatID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtQPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtunitP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtUIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtUIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtreorderL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtDis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnin)
                    .addComponent(btnel)
                    .addComponent(btnActualizar))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninActionPerformed
        AgregarProducto();
    }//GEN-LAST:event_btninActionPerformed

    private void btnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelActionPerformed
        EliminarProducto();
    }//GEN-LAST:event_btnelActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        int row = tblProduct.getSelectedRow();
        System.out.println(row);
        
        txtproID.setText(String.valueOf(tblProduct.getModel().getValueAt(row,0)));
        txtproname.setText(String.valueOf(tblProduct.getModel().getValueAt(row,1)));
        txtsupplierID.setText(String.valueOf(tblProduct.getModel().getValueAt(row,2)));
        txtcatID.setText(String.valueOf(tblProduct.getModel().getValueAt(row,3)));
        txtQPU.setText(String.valueOf(tblProduct.getModel().getValueAt(row,4)));
        txtunitP.setText(String.valueOf(tblProduct.getModel().getValueAt(row,5)));
        txtUIS.setText(String.valueOf(tblProduct.getModel().getValueAt(row,6)));
        txtUIO.setText(String.valueOf(tblProduct.getModel().getValueAt(row,7)));
        txtreorderL.setText(String.valueOf(tblProduct.getModel().getValueAt(row,8)));
        txtDis.setText(String.valueOf(tblProduct.getModel().getValueAt(row,9)));
        
    }//GEN-LAST:event_tblProductMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        AgregarProducto();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(QualityProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QualityProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QualityProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QualityProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QualityProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnel;
    private javax.swing.JButton btnin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtDis;
    private javax.swing.JTextField txtQPU;
    private javax.swing.JTextField txtUIO;
    private javax.swing.JTextField txtUIS;
    private javax.swing.JTextField txtcatID;
    private javax.swing.JTextField txtproID;
    private javax.swing.JTextField txtproname;
    private javax.swing.JTextField txtreorderL;
    private javax.swing.JTextField txtsupplierID;
    private javax.swing.JTextField txtunitP;
    // End of variables declaration//GEN-END:variables
}
