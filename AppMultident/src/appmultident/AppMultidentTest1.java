/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appmultident;

import Controlador.ControladorCitas;
import Controlador.ControladorLogin;
import Controlador.ControladorOdontologos;
import Modelo.LoginModel;
import Vista.VistaGestionCitas;
import Vista.VistaGestionOdontologo;
import Vista.VistaGestionPacientes;
import Vista.VistaHome;
import Vista.VistaLogin;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

/**
 *
 * @author LOZADA
 */
public class AppMultidentTest1 {

    /**
     * @param args the command line arguments
     */
 
     public static void main(String[] args) {
        FlatMacLightLaf.setup();
        UIManager.put("Button.arc", 20); 
        LoginModel loginModel = new LoginModel();
        VistaGestionOdontologo vistaLogin = new VistaGestionOdontologo();
        ControladorOdontologos co= new ControladorOdontologos(vistaLogin);
        vistaLogin.setVisible(true);  // Mostrar la vista de login
    }
    
}
