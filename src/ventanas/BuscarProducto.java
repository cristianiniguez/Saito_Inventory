/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import consultas.ConsulProducto;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FELIX
 */
public class BuscarProducto extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    public static int IDproducto = 0;
    public static String tipo_transaccion = "";

    /**
     * Creates new form GestionarProductos
     */
    public BuscarProducto() {
        initComponents();

        setSize(640, 590);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Mostrar();
    }

    private void Mostrar() {
        try {
            DefaultTableModel modelo;
            ConsulProducto func = new ConsulProducto();
            modelo = func.mostrar();
            tab_productos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al mostrar registros");
            System.err.println("Error al mostrar registros " + e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane_productos = new javax.swing.JScrollPane();
        tab_productos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar Productos");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true), "Lista de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tab_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_productosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tab_productosMousePressed(evt);
            }
        });
        jScrollPane_productos.setViewportView(tab_productos);

        jPanel3.add(jScrollPane_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 580, 480));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_productosMouseClicked


    }//GEN-LAST:event_tab_productosMouseClicked

    private void tab_productosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_productosMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {

            int fila = tab_productos.getSelectedRow();
            String id, nombre, tarifa = "";
            id = tab_productos.getValueAt(fila, 0).toString();
            nombre = tab_productos.getValueAt(fila, 1).toString();

            if (tipo_transaccion.equals("Compra")) {
                tarifa = tab_productos.getValueAt(fila, 2).toString();
                GestionarTransacciones.txt_id_producto.setText(id);
                GestionarTransacciones.txt_producto.setText(nombre);
                GestionarTransacciones.txt_tarifa.setText(tarifa);
            } else if (tipo_transaccion.equals("Venta")) {
                tarifa = tab_productos.getValueAt(fila, 3).toString();
                GestionarTransacciones.txt_id_producto.setText(id);
                GestionarTransacciones.txt_producto.setText(nombre);
                GestionarTransacciones.txt_tarifa.setText(tarifa);
            } else if (tipo_transaccion.equals("")) {
                GestionarStock.txt_id_producto.setText(id);
                GestionarStock.txt_producto.setText(nombre);
            }
            
            this.setVisible(false);
        }
    }//GEN-LAST:event_tab_productosMousePressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane_productos;
    private javax.swing.JTable tab_productos;
    // End of variables declaration//GEN-END:variables

}