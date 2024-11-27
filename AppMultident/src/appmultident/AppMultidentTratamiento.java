package appmultident;
import modelo.Tratamiento;
import controlador.ControladorTratamiento;
import Vista.VistaTratamiento;

public class AppMultidentTratamiento {
    public static void main(String[] args) {
    Tratamiento Trata = new Tratamiento();
    VistaTratamiento Vtrata = new VistaTratamiento();
    ControladorTratamiento crtl = new ControladorTratamiento(Trata, Vtrata);
    
    }
}