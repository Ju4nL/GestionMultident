package Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtils {

    // Método para hashear una contraseña
    public static String hashPassword(String plainTextPassword) {
        try {
            // Generar un salt aleatorio
            byte[] salt = generateSalt();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(plainTextPassword.getBytes());

            // Concatenar salt y hash y codificar en Base64
            return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error en hashing: " + e.getMessage());
        }
    }

    // Método para verificar la contraseña
    public static boolean verifyPassword(String plainTextPassword, String storedPassword) {
        String[] parts = storedPassword.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] storedHash = Base64.getDecoder().decode(parts[1]);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(plainTextPassword.getBytes());

            // Comprobar si el hash coincide
            return MessageDigest.isEqual(storedHash, hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error en verificación: " + e.getMessage());
        }
    }

    
    private static byte[] generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}
