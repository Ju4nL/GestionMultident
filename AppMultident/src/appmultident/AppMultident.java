/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appmultident;

import Controlador.ControladorCitas;
import Controlador.ControladorHistorialClinico;
import Vista.VistaGestionCitas;
import Vista.VistaHistorialClinicoPaciente;
//import com.formdev.flatlaf.themes.FlatMacLightLaf;
//import javax.swing.UIManager;

/**
 
 * @author LOZADA
 */
public class AppMultident {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //FlatMacLightLaf.setup();
        //UIManager.put("Button.arc", 25); 
        /*
        VistaGestionCitas vg1 = new VistaGestionCitas();
        ControladorCitas c1 = new ControladorCitas(vg1);
        */
        
      
        
        VistaHistorialClinicoPaciente vhc1 = new VistaHistorialClinicoPaciente();
        ControladorHistorialClinico chc1= new ControladorHistorialClinico(vhc1);
        
    }
    
}
