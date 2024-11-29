/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.HistorialClinico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class DatosHistorialClinico {

    private static final String FILE_PATH = "src/Contenedores/HistorialClinicoPaciente.txt";
    private static final String PACIENTES_ID = "src/Contenedores/Pacientes.txt";

    public List<String> leerPrimerElementoDeArchivo() {
        List<String> primerosElementos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(PACIENTES_ID))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Dividir la línea en partes usando la coma como separador
                String[] partes = linea.split(",");

                // Agregar el primer elemento si existe
                if (partes.length > 0) {
                    primerosElementos.add(partes[0].trim()); // `trim` elimina espacios innecesarios
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return primerosElementos;
    }

    public void guardarHistorialEnArchivo(HistorialClinico hc) {
        // Ruta del archivo
        String rutaArchivo = FILE_PATH;

        // Asegurarse de que los campos no sean nulos
        String antecedentes = hc.getAntecedentes() != null ? hc.getAntecedentes() : "Sin datos";
        String alergias = hc.getAlergias() != null ? hc.getAlergias() : "Sin datos";
        String notasAdicionales = hc.getNotasAdicionales() != null ? hc.getNotasAdicionales() : "Sin datos";
        String nombrePaciente = hc.getPaciente() != null ? hc.getPaciente().getNombre() : "Desconocido";

        // Construir la nueva línea
        String nuevaLinea = hc.getPaciente().getIdPaciente() + ","
                + antecedentes + ","
                + alergias + ","
                + notasAdicionales;

        List<String> lineas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");

                // Excluir la línea con el mismo ID
                if (datos.length > 0 && !datos[0].equals(String.valueOf(hc.getPaciente().getIdPaciente()))) {
                    lineas.add(linea); // Mantener líneas que no coincidan
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
        }

        // Agregar la nueva línea al final de la lista
        lineas.add(nuevaLinea);

        // Sobrescribir el archivo con las líneas actualizadas
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, false))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Historial actualizado exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el historial en el archivo: " + e.getMessage());
        }
    }

    public String[] convertirStringAArreglo(String nuevaLinea) {
        // Dividir el string por la coma (",") y almacenar en un arreglo
        String[] datos = nuevaLinea.split(",");

        // Mostrar los datos para verificar el resultado
        System.out.println("Datos convertidos: ");
        for (String dato : datos) {
            System.out.println(dato);
        }

        return datos;
    }

    public String[] buscarPorIdEnArchivo(int idBuscado) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Dividir la línea en partes usando la coma como separador
                String[] partes = linea.split(",");

                // Intentar convertir el primer elemento en un entero (ID)
                if (partes.length > 0) {
                    try {
                        int idActual = Integer.parseInt(partes[0].trim());
                        if (idActual == idBuscado) {
                            return partes; // Retorna toda la línea como un arreglo
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error al convertir el ID a número: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            String nuevaLinea = idBuscado + ",Desconocido,Desconocido,Desconocido,Sin información";
            writer.write(nuevaLinea);
            writer.newLine();
            return convertirStringAArreglo(nuevaLinea);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        return null; // Manejo de errores
    }
    
    public void agregarHistorial(int idPaciente, String textoAntecedente, String textoAlergias, String textoNotas) {
        File archivo = new File(FILE_PATH);
        List<String> lineas = new ArrayList<>();
        boolean existe = false;

        try {
            // Leer todas las líneas del archivo si ya existe
            if (archivo.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        String[] datos = linea.split(",");
                        if (Integer.parseInt(datos[0]) == idPaciente) {
                            existe = true;
                            // Modificar la línea existente con los nuevos datos
                            linea = idPaciente + "," + textoAntecedente + "," + textoAlergias + "," + textoNotas;
                        }
                        lineas.add(linea); // Guardar las líneas en la lista
                    }
                }
            }

            if (!existe) {
                // Crear una nueva línea para el paciente si no existe
                String nuevaLinea = idPaciente + "," + textoAntecedente + "," + textoAlergias + "," + textoNotas;
                lineas.add(nuevaLinea);
            }

            // Escribir las líneas nuevamente en el archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, false))) {
                for (String linea : lineas) {
                    writer.write(linea);
                    writer.newLine();
                }
            }

            System.out.println("Datos guardados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el historial clínico: " + e.getMessage());
        }
    }
}
