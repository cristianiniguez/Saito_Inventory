/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Auxiliar;
import consultas.ConsulProducto;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import objetos.Producto;

/**
 *
 * @author FELIX
 */
public class GestionarProductos extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    public static int IDproducto = 0;
    String producto, precioCompraSt, precioVentaSt;
    Double precioCompra = 0d, precioVenta = 0d;

    /**
     * Creates new form GestionarProductos
     */
    public GestionarProductos() {
        initComponents();
        
        setSize(1280, 670);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        Mostrar();
        Inhabilitar();
    }
    
    private String accion = "guardar";
    
    private void Inhabilitar() {
        txt_nombre.setEnabled(false);
        txt_precio_compra.setEnabled(false);
        txt_precio_venta.setEnabled(false);
        
        btn_guardar.setEnabled(false);
        
        txt_id_producto.setText("");
        txt_nombre.setText("");
        txt_precio_compra.setText("");
        txt_precio_venta.setText("");
    }

    private void Habilitar() {
        txt_nombre.setEnabled(true);
        txt_precio_compra.setEnabled(true);
        txt_precio_venta.setEnabled(true);
        
        btn_guardar.setEnabled(true);
        
        txt_id_producto.setText("");
        txt_nombre.setText("");
        txt_precio_compra.setText("");
        txt_precio_venta.setText("");
    }
    
    private void Mostrar() {
        try {
            DefaultTableModel modelo;
            ConsulProducto func = new ConsulProducto();
            modelo = func.mostrar();
            tab_productos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al mostrar registros");
            System.err.println("Error al mostrar registros: " + e);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_precio_compra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_precio_venta = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        txt_id_producto = new javax.swing.JTextField();
        btn_nuevo = new javax.swing.JButton();
        lbl_nuevo = new javax.swing.JLabel();
        lbl_guardar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_exportar = new javax.swing.JButton();
        lbl_exportar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane_productos = new javax.swing.JScrollPane();
        tab_productos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar Productos");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTION DE INVENTARIO - SAITO INVENTORY");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 80));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true), "Registro de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Producto:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 20));
        jPanel2.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 110, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Precio de compra:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 20));
        jPanel2.add(txt_precio_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 110, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Precio de venta:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 20));
        jPanel2.add(txt_precio_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 110, -1));

        btn_guardar.setBackground(new java.awt.Color(255, 255, 255));
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 80, 80));

        txt_id_producto.setEnabled(false);
        jPanel2.add(txt_id_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 110, -1));

        btn_nuevo.setBackground(new java.awt.Color(255, 255, 255));
        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 80, 80));

        lbl_nuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_nuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nuevo.setText("Nuevo");
        jPanel2.add(lbl_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 80, 20));

        lbl_guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_guardar.setText("Guardar");
        jPanel2.add(lbl_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 80, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        btn_exportar.setBackground(new java.awt.Color(255, 255, 255));
        btn_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        btn_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_exportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 80, 80));

        lbl_exportar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_exportar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_exportar.setText("Exportar");
        jPanel2.add(lbl_exportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 80, 20));

        jLabel6.setText("Usar punto (.) para introducir decimales");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, 20));

        jLabel7.setText("Usar punto (.) para introducir decimales");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 620, 540));

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
        tab_productos.setEnabled(false);
        tab_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_productosMouseClicked(evt);
            }
        });
        jScrollPane_productos.setViewportView(tab_productos);

        jPanel3.add(jScrollPane_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 580, 480));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 620, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        //Validación de los datos
        if (txt_nombre.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un nombre de producto");
            txt_nombre.requestFocus();
            return;
        }
        if (!Auxiliar.IsNumeric(txt_precio_compra.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un precio de compra válido para el producto");
            txt_precio_compra.setText("");
            txt_precio_compra.requestFocus();
            return;
        }
        if (!Auxiliar.IsNumeric(txt_precio_venta.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un precio de venta válido para el producto");
            txt_precio_venta.setText("");
            txt_precio_venta.requestFocus();
            return;
        }
        
        //Creación del objeto Producto
        Producto dts = new Producto();
        dts.setNombre(txt_nombre.getText());
        dts.setPrecio_compra(Double.parseDouble(txt_precio_compra.getText()));
        dts.setPrecio_venta(Double.parseDouble(txt_precio_venta.getText()));
        
        //Guardado o edición en la base de datos
        ConsulProducto func = new ConsulProducto();
        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El producto fue registrado satisfactoriamente");
                Mostrar();
                Inhabilitar();
            }
        } else if (accion.equals("editar")) {
            dts.setId_producto(Integer.parseInt(txt_id_producto.getText()));
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El producto fue editado satisfactoriamente");
                Mostrar();
                Inhabilitar();
            }
        }
        
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportarActionPerformed
        
        JOptionPane.showMessageDialog(null, "Aún no está listo");
        
    }//GEN-LAST:event_btn_exportarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        
        Habilitar();
        lbl_guardar.setText("Guardar");
        accion = "guardar";
        
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void tab_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_productosMouseClicked
        
        Habilitar();
        lbl_guardar.setText("Editar");
        accion = "editar";

        int fila = tab_productos.rowAtPoint(evt.getPoint());
        txt_id_producto.setText(tab_productos.getValueAt(fila, 0).toString());
        txt_nombre.setText(tab_productos.getValueAt(fila, 1).toString());
        txt_precio_compra.setText(tab_productos.getValueAt(fila, 2).toString());
        txt_precio_venta.setText(tab_productos.getValueAt(fila, 3).toString());

    }//GEN-LAST:event_tab_productosMouseClicked

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
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exportar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane_productos;
    private javax.swing.JLabel lbl_exportar;
    private javax.swing.JLabel lbl_guardar;
    private javax.swing.JLabel lbl_nuevo;
    private javax.swing.JTable tab_productos;
    private javax.swing.JTextField txt_id_producto;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio_compra;
    private javax.swing.JTextField txt_precio_venta;
    // End of variables declaration//GEN-END:variables

}