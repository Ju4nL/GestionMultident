package Controlador;

/**
 *
 * @author JUNIOR
 */
import Modelo.MovimientoInventario;
import Modelo.RegistroInventario;
import Vista.VistaRegistroInventario;
import java.util.List;

public class ControladorRegistroInventario {
    private RegistroInventario registro;
    private VistaRegistroInventario vista;

    public ControladorRegistroInventario(RegistroInventario registro, VistaRegistroInventario vista) {
        this.registro = registro;
        this.vista = vista;
    }

    public void agregarMovimiento(String producto, int cantidad, String tipoMovimiento) {
        MovimientoInventario movimiento = new MovimientoInventario(producto, cantidad, tipoMovimiento);
        registro.agregarMovimiento(movimiento);
    }
        public void iniciar() {
        // Aquí puedes inicializar la vista, cargar datos, etc.
        vista.setVisible(true); // Muestra la ventana de la vista
    }
    public List<MovimientoInventario> getMovimientos() {
        return registro.getMovimientos();
    }
}