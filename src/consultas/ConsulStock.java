package consultas;

import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsulStock {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL1 = "";
    private String sSQL2 = "";
    private String sSQL3 = "";

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID producto", "Producto", "Comprado", "Vendido", "Stock disponible", "Valor de Stock"};
        String[] registro = new String[6];
        modelo = new DefaultTableModel(null, titulos);

        sSQL1 = "select id_producto, nombre from producto where id_producto like '%" + buscar + "%'";
        sSQL2 = "select sum(cantidad) as comprado from transaccion where id_producto=? and tipo='Compra'";
        sSQL3 = "select sum(cantidad) as vendido from transaccion where id_producto=? and tipo='Venta'";
        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sSQL1);

            while (rs1.next()) {
                registro[0] = rs1.getString("id_producto");
                registro[1] = rs1.getString("nombre");
                registro[2] = "0";
                registro[3] = "0";
                registro[4] = "0";

                try {
                    //Obteniendo comprado
                    PreparedStatement pst2 = cn.prepareStatement(sSQL2);
                    pst2.setString(1, rs1.getString("id_producto"));
                    ResultSet rs2 = pst2.executeQuery();
                    if (rs2.next()) {
                        registro[2] = rs2.getString("comprado");
                    }
                    //Obteniendo vendido
                    PreparedStatement pst3 = cn.prepareStatement(sSQL3);
                    pst3.setString(1, rs1.getString("id_producto"));
                    ResultSet rs3 = pst3.executeQuery();
                    if (rs3.next()) {
                        registro[3] = rs3.getString("vendido");
                    }
                    //Obteniendo lo demás
                    int disponible = rs2.getInt("comprado") - rs3.getInt("vendido");
                    registro[4] = Integer.toString(disponible);
                    String tarifa_venta = new ConsulProducto().tarifa(rs1.getInt("id_producto"), "Venta");
                    registro[5] = Double.toString(disponible * Double.parseDouble(tarifa_venta));
                } catch (SQLException e) {
                    System.err.println("Error al obtener cantidades de " + rs1.getString("nombre") + ": " + e);
                }

                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al calcular stock");
            System.err.println("Error al calcular stock: " + e);
            return null;
        }
    }

    public HashMap info(String id) {

        HashMap<String, Double> info = new HashMap<String, Double>();
        info.put("Compras", 0.0);
        info.put("Ventas", 0.0);
        info.put("Utilidad", 0.0);

        sSQL1 = "select sum(p.precio_compra * t.cantidad) as compras "
                + "from transaccion as t left join producto as p "
                + "on t.id_producto = p.id_producto "
                + "where t.id_producto like '%" + id + "%' "
                + "and t.tipo = 'Compra'";

        sSQL2 = "select sum(p.precio_venta * t.cantidad) as ventas "
                + "from transaccion as t left join producto as p "
                + "on t.id_producto = p.id_producto "
                + "where t.id_producto like '%" + id + "%' "
                + "and t.tipo = 'Venta'";

        try {
            //Obteniendo compras
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sSQL1);
            if (rs1.next()) {
                info.replace("Compras", rs1.getDouble("compras"));
            }
            //Obteniendo ventas
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sSQL2);
            if (rs2.next()) {
                info.replace("Ventas", rs2.getDouble("ventas"));
            }
            info.replace("Utilidad", rs1.getDouble("compras") - rs2.getDouble("ventas"));
        } catch (SQLException e) {
            System.out.println("Error al obtener información del producto: " + e);
        }

        return info;
    }
}
