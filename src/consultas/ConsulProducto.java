package consultas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.Producto;

public class ConsulProducto {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalRegistros;
    
    public DefaultTableModel mostrar(){
        DefaultTableModel modelo;
        
        String[] titulos = {"ID", "Nombre", "Precio de compra", "Precio de venta"};
        String[] registro = new String[4];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * from producto order by id_producto";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[0] = rs.getString("id_producto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("precio_compra");
                registro[3] = rs.getString("precio_venta");
                
                totalRegistros++;
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar registros de productos");
            System.err.println("Error al mostrar registros de productos: " + e);
            return null;
        }
    }
    
    public boolean insertar(Producto dts) {
        sSQL = "insert into producto (nombre, precio_compra, precio_venta) "
                + "values (?,?,?)";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setDouble(2, dts.getPrecio_compra());
            pst.setDouble(3, dts.getPrecio_venta());
            int n = pst.executeUpdate();
            
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar registro de producto");
            System.err.println("Error al insertar registro de producto: " + e);
            return false;
        }
    }
    
    public boolean editar(Producto dts) {
        sSQL = "update producto set nombre=?, precio_compra=?, precio_venta=? "
                + "where id_producto=?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setDouble(2, dts.getPrecio_compra());
            pst.setDouble(3, dts.getPrecio_venta());
            pst.setInt(4, dts.getId_producto());
            int n = pst.executeUpdate();
            
            if (n != 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar registro de producto");
            System.err.println("Error al editar registro de producto: " + e);
            return false;
        }
    }
    
    public String tarifa(int id, String str){
        
        String tarifa = "";
        
        if (str.equals("Compra")) {
            sSQL = "select precio_compra as tarifa from producto where id_producto=?";
        }else if (str.equals("Venta")) {
            sSQL = "select precio_venta as tarifa from producto where id_producto=?";
        }
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                tarifa = rs.getString("tarifa");
            }
            return tarifa;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener tarifa de producto");
            System.err.println("Error al obtener tarifa de producto: " + e);
            return tarifa;
        }
        
    }
    
}
