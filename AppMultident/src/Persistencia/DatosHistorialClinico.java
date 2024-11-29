/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class DatosHistorialClinico {

    private static final String ID_PACIENTE = "C:\\Users\\USER\\Documents\\GitHub\\GestionMultident\\AppMultident\\src\\Contenedores\\Pacientes.txt";

    public static List<String> leerPrimerElementoDeArchivo() {
        List<String> primerosElementos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ID_PACIENTE))) {
            String linea;
            while ((linea = reader.readLine()) != null) { 
                if (!linea.trim().isEmpty()) {
                    
                    String[] elementos = linea.split(",");
                    if (elementos.length > 0) {
                        primerosElementos.add(elementos[0].trim());
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        }

        return primerosElementos;
    }
}
