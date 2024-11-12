package Modelo;

import Security.PasswordUtils;

import java.io.*;
import java.util.UUID;

public class LoginModel {

    private static final String FILE_PATH = "src/Contenedores/Usuarios.txt";

    public String[] authenticate(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(";");
                if (userData[1].equalsIgnoreCase(username)) {
                    return new String[]{userData[0], userData[2], userData[3]};
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
        return null;
    }

    public boolean createUser(String email, String plainPassword, String role) {
        if (email == null || email.isEmpty() || plainPassword == null || plainPassword.isEmpty() || role == null || role.isEmpty()) {
            throw new IllegalArgumentException("El correo, la contraseña y el rol no pueden estar vacíos");
        }

        String userId = generateNextId();  // Obtener el próximo ID secuencial
        String hashedPassword = PasswordUtils.hashPassword(plainPassword);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String userRecord = userId + ";" + email + ";" + hashedPassword + ";" + role;
            writer.write(userRecord);
            writer.newLine();
            System.out.println("Usuario creado con éxito: " + email);
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de usuarios: " + e.getMessage());
            return false;
        }
    }

    // Método para generar el próximo ID secuencial
    private String generateNextId() {
        int lastId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(";");
                int currentId = Integer.parseInt(userData[0]);
                if (currentId > lastId) {
                    lastId = currentId;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el último ID de usuarios: " + e.getMessage());
        }
        return String.valueOf(lastId + 1);  // Incrementar en 1 el último ID encontrado
    }

    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        if (!hashedPassword.contains(":")) {
            System.err.println("Formato de hash incorrecto. Debe ser 'salt:hash'.");
            return false;
        }
        return PasswordUtils.verifyPassword(plainPassword, hashedPassword);
    }

}
