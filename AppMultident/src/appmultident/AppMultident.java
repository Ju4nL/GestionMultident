/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appmultident;

import Controlador.ControladorCitas;
import Vista.VistaGestionCitas;

/**
 *
 * @author LOZADA
 */
public class AppMultident {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaGestionCitas v1 = new VistaGestionCitas();
        ControladorCitas c1 = new ControladorCitas(v1);
        
        c1.iniciar();
        v1.setVisible(true);
    }
    
}
