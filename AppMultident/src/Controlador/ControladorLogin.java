package Controlador;

import Modelo.LoginModel;
import Vista.VistaLogin;
import Vista.VistaHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin {

    private VistaLogin vistaLogin;
    private LoginModel loginModel;

    public ControladorLogin(VistaLogin vistaLogin, LoginModel loginModel) {
        this.vistaLogin = vistaLogin;
        this.loginModel = loginModel;

        // Configurar la acción del botón de login
        this.vistaLogin.setLoginAction(new LoginAction());
    }

    // Clase interna para manejar la acción del botón de login
    private class LoginAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = vistaLogin.getTxtUsername().getText();
            char[] passwordArray = vistaLogin.getPswPassword().getPassword();
            String password = new String(passwordArray);

            // Llamar al método de autenticación
            String[] user = loginModel.authenticate(username);

            // Mensajes de depuración
            if (user == null) {
                System.out.println("Usuario no encontrado.");
                vistaLogin.displayErrorMessage("Usuario o contraseña incorrectos.");
                return;
            }

            if (user != null) {
                System.out.println("Usuario encontrado: " + user[0]);
            }

            if (loginModel.verifyPassword(password, user[1])) {
                String role = user[2];
                if ("ADMIN".equalsIgnoreCase(role.trim())) {
                    System.out.println("Login exitoso como administrador.");

                    // Mostrar la vista de inicio
                    VistaHome vistaHome = new VistaHome();
                    vistaHome.setVisible(true);

                    vistaLogin.dispose();  // Cierra la ventana de login
                } else {
                    vistaLogin.displayErrorMessage("Acceso denegado. Solo los administradores pueden acceder.");
                }

            } else {
                vistaLogin.displayErrorMessage("Usuario o contraseña incorrectos.");
            }

            // Limpiar la contraseña
            java.util.Arrays.fill(passwordArray, '0');
        }
    }
}
