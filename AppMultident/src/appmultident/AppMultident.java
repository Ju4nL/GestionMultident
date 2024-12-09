package appmultident;

import Controlador.ControladorLogin;
import Modelo.LoginModel;
import Vista.VistaLogin;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

public class AppMultident {

    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        UIManager.put("Button.arc", 20); 
        LoginModel loginModel = new LoginModel();
        VistaLogin vistaLogin = new VistaLogin();

        // Crear el controlador para manejar la vista y el modelo
        ControladorLogin loginController = new ControladorLogin(vistaLogin, loginModel);
        
        // Configurar la vista de inicio de sesión
        vistaLogin.setLocationRelativeTo(null);
        vistaLogin.setVisible(true);
    }
}


  