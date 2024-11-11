/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ListaPacientes {
    private ArrayList<HistorialClinico> pacientes;

    public ListaPacientes() {
        pacientes = new ArrayList<>();
        cargarPacientesDesdeArchivo("C:\\Users\\USER\\Documents\\GitHub\\GestionMultident\\AppMultident\\src\\Contenedores\\Pacientes.txt");
    }

    private void cargarPacientesDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 8) {
                    HistorialClinico paciente = new HistorialClinico(
                            datos[0], datos[1], datos[2], datos[3],
                            datos[4], datos[5], datos[6], datos[7]);
                    pacientes.add(paciente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public HistorialClinico buscarPacientePorCodigo(String codigo) {
        for (HistorialClinico paciente : pacientes) {
            if (paciente.getIdPaciente()==Integer.parseInt(codigo)) {
                return paciente;
            }
        }
        return null; // Retorna null si no encuentra el paciente
    }
}
