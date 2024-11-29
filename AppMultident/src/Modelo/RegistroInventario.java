package Modelo;

/**
 *
 * @author JUNIOR
 */
import java.util.ArrayList;
import java.util.List;

public class RegistroInventario {
    private List<MovimientoInventario> movimientos;

    public RegistroInventario() {
        movimientos = new ArrayList<>();
    }

    public void agregarMovimiento(MovimientoInventario movimiento) {
        movimientos.add(movimiento);
    }

    public List<MovimientoInventario> getMovimientos() {
        return movimientos;
    }
}
