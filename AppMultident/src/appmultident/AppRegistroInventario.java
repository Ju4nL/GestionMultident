package appmultident;

/**
 *
 * @author JUNIOR
 */
import Controlador.ControladorRegistroInventario;
import Modelo.RegistroInventario;
import Vista.VistaRegistroInventario;

public class AppRegistroInventario {
    public static void main(String[] args) {
        RegistroInventario registro = new RegistroInventario();
        VistaRegistroInventario vista = new VistaRegistroInventario();
        ControladorRegistroInventario controlador = new ControladorRegistroInventario(registro, vista);

        controlador.iniciar();
        vista.setVisible(true);
    }
}
