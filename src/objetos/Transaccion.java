package objetos;

import java.sql.Date;

public class Transaccion {

    private int id_transaccion;
    private int id_producto;
    private String tipo;
    private int cantidad;
    private Date fecha;

    public Transaccion() {
    }

    public Transaccion(int id_transaccion, int id_producto, String tipo, int cantidad, Date fecha) {
        this.id_transaccion = id_transaccion;
        this.id_producto = id_producto;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
