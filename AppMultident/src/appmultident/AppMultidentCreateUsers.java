/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appmultident;

 
import Modelo.LoginModel; 

/**
 *
 * @author LOZADA
 */
public class AppMultidentCreateUsers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginModel loginModel = new LoginModel();

        // Crear un usuario
        boolean success = loginModel.createUser("admin@multident.com", "12345", "ADMIN");

        if (success) {
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("Error al registrar el usuario.");
        }
    }
    
}
