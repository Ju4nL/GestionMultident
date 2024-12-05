/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appmultident;

import Controlador.ControladorCitas;
import Controlador.ControladorHistorialClinico;
import Controlador.ControladorLogin;
import Modelo.LoginModel;
import Vista.VistaGestionCitas;
import Vista.VistaHistorialClinicoPaciente;
import Vista.VistaLogin;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager; 
/**
 
 * @author LOZADA
 */
public class AppMultident {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        UIManager.put("Button.arc", 20); 
        LoginModel loginModel = new LoginModel();
        VistaLogin vistaLogin = new VistaLogin();

        // Crear el controlador, el cual manejará la vista y el modelo
        ControladorLogin loginController = new ControladorLogin(vistaLogin, loginModel);
        
        vistaLogin.setLocationRelativeTo(null);
        vistaLogin.setVisible(true);  // Mostrar la vista de login
        
    }
    
}
  