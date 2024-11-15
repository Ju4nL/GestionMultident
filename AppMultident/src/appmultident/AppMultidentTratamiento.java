package appmultident;

import controlador.ControladorTratamiento;
import vista.VistaTratamiento;

public class AppMultidentControlador {
    public static void main(String[] args) {
        ControladorTratamiento controlador = new ControladorTratamiento();
        VistaTratamiento vista = new VistaTratamiento(controlador);
        
        vista.setVisible(true);
    }
}