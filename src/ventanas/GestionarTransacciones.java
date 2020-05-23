/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Auxiliar;
import consultas.ConsulProducto;
import consultas.ConsulTransaccion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import objetos.Transaccion;

/**
 *
 * @author FELIX
 */
public class GestionarTransacciones extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    public static int IDproducto = 0;
    String producto, precioCompraSt, precioVentaSt;
    Double precioCompra = 0d, precioVenta = 0d;

    /**
     * Creates new form GestionarProductos
     */
    public GestionarTransacciones() {
        initComponents();

        setSize(1280, 670);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Rellenando el combo tipo de transacción
        cmb_tipo_mostrar.addItem("");
        cmb_tipo_mostrar.addItem("Compra");
        cmb_tipo_mostrar.addItem("Venta");

        //Poniendo fechas actuales
        dtc_fechaInicial.setDate(new java.util.Date());
        dtc_fechaFinal.setDate(new java.util.Date());

        //Mostrando tabla e inhabilitando campos
        Mostrar(cmb_tipo_mostrar.getSelectedItem().toString(), Auxiliar.SQLDate(dtc_fechaInicial.getCalendar()), Auxiliar.SQLDate(dtc_fechaFinal.getCalendar()));
        Inhabilitar();
    }

    private String accion = "guardar";

    private void OcultarColumnas() {
        tab_transacciones.getColumnModel().getColumn(0).setMaxWidth(0);
        tab_transacciones.getColumnModel().getColumn(0).setMinWidth(0);
        tab_transacciones.getColumnModel().getColumn(0).setPreferredWidth(0);

        tab_transacciones.getColumnModel().getColumn(1).setMaxWidth(0);
        tab_transacciones.getColumnModel().getColumn(1).setMinWidth(0);
        tab_transacciones.getColumnModel().getColumn(1).setPreferredWidth(0);

    }

    private void Inhabilitar() {
        cmb_tipo.setEnabled(false);
        txt_cantidad.setEnabled(false);
        dtc_fecha.setEnabled(false);

        btn_buscar_producto.setEnabled(false);
        btn_guardar.setEnabled(false);

        txt_id_transaccion.setText("");
        txt_id_producto.setText("");
        txt_producto.setText("");
        txt_tarifa.setText("");
        txt_cantidad.setText("");
    }

    private void Habilitar() {
        cmb_tipo.setEnabled(true);
        txt_cantidad.setEnabled(true);
        dtc_fecha.setEnabled(true);

        btn_buscar_producto.setEnabled(true);
        btn_guardar.setEnabled(true);

        txt_id_transaccion.setText("");
        txt_id_producto.setText("");
        txt_producto.setText("");
        txt_tarifa.setText("");
        txt_cantidad.setText("");
        dtc_fecha.setDate(new java.util.Date());
    }

    private void Mostrar(String tipo, Date fecha_inicio, Date fecha_final) {
        try {
            DefaultTableModel modelo;
            ConsulTransaccion func = new ConsulTransaccion();
            modelo = func.mostrar(tipo, fecha_inicio, fecha_final);
            tab_transacciones.setModel(modelo);
            OcultarColumnas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al mostrar transacciones");
            System.err.println("Error al mostrar transacciones: " + e);
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
        txt_producto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        txt_id_transaccion = new javax.swing.JTextField();
        btn_nuevo = new javax.swing.JButton();
        lbl_nuevo = new javax.swing.JLabel();
        lbl_guardar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_exportar = new javax.swing.JButton();
        lbl_exportar = new javax.swing.JLabel();
        txt_id_producto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtc_fecha = new com.toedter.calendar.JDateChooser();
        cmb_tipo = new javax.swing.JComboBox<>();
        btn_buscar_producto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_tarifa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane_productos = new javax.swing.JScrollPane();
        tab_transacciones = new javax.swing.JTable();
        cmb_tipo_mostrar = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dtc_fechaInicial = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        dtc_fechaFinal = new com.toedter.calendar.JDateChooser();
        btn_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar Transacciones");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true), "Registro de Transacciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Transacción:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 20));

        txt_producto.setEnabled(false);
        jPanel2.add(txt_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 110, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tipo:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 20));
        jPanel2.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 110, -1));

        btn_guardar.setBackground(new java.awt.Color(255, 255, 255));
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 80, 80));

        txt_id_transaccion.setEnabled(false);
        jPanel2.add(txt_id_transaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 110, -1));

        btn_nuevo.setBackground(new java.awt.Color(255, 255, 255));
        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 80, 80));

        lbl_nuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_nuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nuevo.setText("Nuevo");
        jPanel2.add(lbl_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 80, 20));

        lbl_guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_guardar.setText("Guardar");
        jPanel2.add(lbl_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 80, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Producto:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        btn_exportar.setBackground(new java.awt.Color(255, 255, 255));
        btn_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        btn_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_exportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 80, 80));

        lbl_exportar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_exportar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_exportar.setText("Exportar");
        jPanel2.add(lbl_exportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 80, 20));

        txt_id_producto.setEnabled(false);
        jPanel2.add(txt_id_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 40, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Fecha:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, 20));
        jPanel2.add(dtc_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 110, -1));

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compra", "Venta" }));
        cmb_tipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_tipoItemStateChanged(evt);
            }
        });
        cmb_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipoActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 110, -1));

        btn_buscar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btn_buscar_producto.setOpaque(false);
        btn_buscar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_productoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_buscar_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 40, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tarifa:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 20));

        txt_tarifa.setEnabled(false);
        jPanel2.add(txt_tarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 110, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 620, 540));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true), "Lista de Transacciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_transacciones.setModel(new javax.swing.table.DefaultTableModel(
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
        tab_transacciones.setEnabled(false);
        tab_transacciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_transaccionesMouseClicked(evt);
            }
        });
        jScrollPane_productos.setViewportView(tab_transacciones);

        jPanel3.add(jScrollPane_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 580, 410));

        cmb_tipo_mostrar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_tipo_mostrarItemStateChanged(evt);
            }
        });
        jPanel3.add(cmb_tipo_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Mostrar:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Fecha Inicial:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, 20));

        dtc_fechaInicial.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(dtc_fechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 140, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Fecha Final:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, 20));

        dtc_fechaFinal.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(dtc_fechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 140, -1));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 620, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        //Validación de los datos
        if (txt_id_producto.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un producto");
            btn_buscar_producto.requestFocus();
            return;
        }
        if (!Auxiliar.IsNumeric(txt_cantidad.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar una cantidad numérica");
            txt_cantidad.setText("");
            txt_cantidad.requestFocus();
            return;
        }

        //Creación del objeto Transaccion
        Transaccion dts = new Transaccion();
        dts.setId_producto(Integer.parseInt(txt_id_producto.getText()));
        dts.setTipo(cmb_tipo.getSelectedItem().toString());
        dts.setCantidad(Integer.parseInt(txt_cantidad.getText()));
        dts.setFecha(Auxiliar.SQLDate(dtc_fecha.getCalendar()));

        //Guardado o edición en la base de datos
        ConsulTransaccion func = new ConsulTransaccion();
        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "La transacción fue registrada satisfactoriamente");
                Mostrar(cmb_tipo_mostrar.getSelectedItem().toString(), Auxiliar.SQLDate(dtc_fechaInicial.getCalendar()), Auxiliar.SQLDate(dtc_fechaFinal.getCalendar()));
                Inhabilitar();
            }
        } else if (accion.equals("editar")) {
            dts.setId_transaccion(Integer.parseInt(txt_id_transaccion.getText()));
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "La transacción fue editada satisfactoriamente");
                Mostrar(cmb_tipo_mostrar.getSelectedItem().toString(), Auxiliar.SQLDate(dtc_fechaInicial.getCalendar()), Auxiliar.SQLDate(dtc_fechaFinal.getCalendar()));
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

    private void tab_transaccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_transaccionesMouseClicked

        Habilitar();
        lbl_guardar.setText("Editar");
        accion = "editar";

        int fila = tab_transacciones.rowAtPoint(evt.getPoint());
        txt_id_transaccion.setText(tab_transacciones.getValueAt(fila, 0).toString());
        txt_id_producto.setText(tab_transacciones.getValueAt(fila, 1).toString());
        txt_producto.setText(tab_transacciones.getValueAt(fila, 2).toString());
        cmb_tipo.setSelectedItem(tab_transacciones.getValueAt(fila, 3).toString());
        txt_cantidad.setText(tab_transacciones.getValueAt(fila, 4).toString());
        dtc_fecha.setDate(Date.valueOf(tab_transacciones.getValueAt(fila, 7).toString()));

    }//GEN-LAST:event_tab_transaccionesMouseClicked

    private void btn_buscar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_productoActionPerformed
        // TODO add your handling code here:
        BuscarProducto.tipo_transaccion = cmb_tipo.getSelectedItem().toString();
        BuscarProducto form = new BuscarProducto();
        form.setVisible(true);
    }//GEN-LAST:event_btn_buscar_productoActionPerformed

    private void cmb_tipo_mostrarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_tipo_mostrarItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_tipo_mostrarItemStateChanged

    private void cmb_tipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_tipoItemStateChanged
        // TODO add your handling code here:
        if (!txt_id_producto.getText().equals("")) {
            int id = Integer.parseInt(txt_id_producto.getText());
            String tipo = cmb_tipo.getSelectedItem().toString();
            ConsulProducto func = new ConsulProducto();
            txt_tarifa.setText(func.tarifa(id, tipo));
        }
    }//GEN-LAST:event_cmb_tipoItemStateChanged

    private void cmb_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_tipoActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        Mostrar(cmb_tipo_mostrar.getSelectedItem().toString(), Auxiliar.SQLDate(dtc_fechaInicial.getCalendar()),Auxiliar.SQLDate(dtc_fechaFinal.getCalendar()));
    }//GEN-LAST:event_btn_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarTransacciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_buscar_producto;
    private javax.swing.JButton btn_exportar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JComboBox<String> cmb_tipo_mostrar;
    private com.toedter.calendar.JDateChooser dtc_fecha;
    private com.toedter.calendar.JDateChooser dtc_fechaFinal;
    private com.toedter.calendar.JDateChooser dtc_fechaInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane_productos;
    private javax.swing.JLabel lbl_exportar;
    private javax.swing.JLabel lbl_guardar;
    private javax.swing.JLabel lbl_nuevo;
    private javax.swing.JTable tab_transacciones;
    private javax.swing.JTextField txt_cantidad;
    public static javax.swing.JTextField txt_id_producto;
    private javax.swing.JTextField txt_id_transaccion;
    public static javax.swing.JTextField txt_producto;
    public static javax.swing.JTextField txt_tarifa;
    // End of variables declaration//GEN-END:variables

}
