package appmultident;
/**
 *
 * @author JUNIOR
 */
import Modelo.Tratamiento;
import Controlador.ControladorTratamiento;
import Vista.vistaTratamiento;

public class AppMultidentTratamiento {
    public static void main(String[] args) {
    vistaTratamiento Vtrata = new vistaTratamiento();
    Tratamiento t = new Tratamiento();
    ControladorTratamiento ctrl = new ControladorTratamiento(Vtrata, t);
 
    Vtrata.setVisible(true);
    ctrl.iniciar();
    }
}