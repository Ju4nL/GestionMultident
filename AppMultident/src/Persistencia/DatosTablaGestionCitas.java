/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class DatosTablaGestionCitas {

    private static final String FILE_PATH = "src/Contenedores/CitasTablas.txt";

    public static void cargarCitasDesdeArchivo(DefaultTableModel modeloTabla) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] datosCita = linea.split("\\|");
                    modeloTabla.addRow(datosCita);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar las citas desde el archivo.");
        }
    }
}
