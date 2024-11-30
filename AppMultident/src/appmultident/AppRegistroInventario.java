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
    
    // Crear la vista sin pasar el controlador
    VistaRegistroInventario vista = new VistaRegistroInventario(null);
    
    // Ahora crear el controlador
    ControladorRegistroInventario controlador = new ControladorRegistroInventario(registro, vista);
    
    // Establecer el controlador en la vista
    vista.setControlador(controlador);
    
    // Iniciar el controlador
    controlador.iniciar();
    
    // Hacer visible la vista
    vista.setVisible(true);
    }
}
