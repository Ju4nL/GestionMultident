package Modelo;

/**
 *
 * @author JUNIOR
 */
public class MovimientoInventario {
    private String producto;
    private int cantidad;
    private String tipoMovimiento; // "entrada" o "salida"

    public MovimientoInventario(String producto, int cantidad, String tipoMovimiento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                ", tipoMovimiento='" + tipoMovimiento + '\'' +
                '}';
    }
}    

