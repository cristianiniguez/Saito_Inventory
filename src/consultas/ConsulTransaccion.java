package consultas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.Transaccion;

public class ConsulTransaccion {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar, Date fecha_inicio, Date fecha_final) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "ID producto", "Producto", "Tipo", "Cantidad", "Tarifa", "Monto", "Fecha"};
        String[] registro = new String[8];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select t.id_transaccion, t.id_producto, p.nombre, t.tipo, t.cantidad, t.fecha "
                + "from transaccion as t, producto as p "
                + "where t.id_producto = p.id_producto "
                + "and t.tipo like '%" + buscar + "%' "
                + "and t.fecha between '" + fecha_inicio + "' and '" + fecha_final + "' "
                + "order by id_transaccion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id_transaccion");
                registro[1] = rs.getString("id_producto");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("tipo");
                registro[4] = rs.getString("cantidad");
                
                String tarifa = new ConsulProducto().tarifa(rs.getInt("id_producto"), rs.getString("tipo"));
                registro[5] = tarifa;
                registro[6] = Double.toString(rs.getInt("cantidad") * Double.parseDouble(tarifa));
                
                registro[7] = rs.getString("fecha");

                totalRegistros++;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar registros de transacciones");
            System.err.println("Error al mostrar registros de transacciones: " + e);
            return null;
        }
    }

    public boolean insertar(Transaccion dts) {
        sSQL = "insert into transaccion (id_producto, tipo, cantidad, fecha) "
                + "values (?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId_producto());
            pst.setString(2, dts.getTipo());
            pst.setInt(3, dts.getCantidad());
            pst.setDate(4, dts.getFecha());
            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar registro de transacción");
            System.err.println("Error al insertar registro de transacción: " + e);
            return false;
        }
    }

    public boolean editar(Transaccion dts) {
        sSQL = "update transaccion set id_producto=?, tipo=?, cantidad=?, fecha=? "
                + "where id_transaccion=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId_producto());
            pst.setString(2, dts.getTipo());
            pst.setInt(3, dts.getCantidad());
            pst.setDate(4, dts.getFecha());
            pst.setInt(5, dts.getId_transaccion());
            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar registro de transacción");
            System.err.println("Error al editar registro de transacción: " + e);
            return false;
        }
    }
}
