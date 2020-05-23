package consultas;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    public String bd = "bd_saito_inventory";
    public String url = "jdbc:mysql://localhost/" + bd;
    public String user = "root";
    public String pass = "";
    
    public Connection conectar(){
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(this.url, this.user, this.pass);
            return cn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            System.err.println("Error al conectar con la base de datos: " + e);
        }
        return cn;
    }
}
