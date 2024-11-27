/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Arboles.ArbolPaciente.ArbolPaciente;
import Arboles.ArbolPaciente.NodoPaciente;
import Modelo.Paciente;
import java.io.*;

/**
 *
 * @author LOZADA
 */

public class DatosPacientes {

    private static final String FILE_PATH = "src/Contenedores/Pacientes.txt";

    // Método para guardar el árbol en un archivo de texto
    public static void guardarEnArchivo(ArbolPaciente arbol) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            guardarRecursivo(writer, arbol.getRaiz());
        } catch (IOException e) {
            System.out.println("Error: No se puede guardar la lista de pacientes. " + e);
        }
    }

    private static void guardarRecursivo(BufferedWriter writer, NodoPaciente nodo) throws IOException {
        if (nodo != null) {
            Paciente paciente = nodo.getDato();
            writer.write(paciente.getIdPaciente() + ","
                    + paciente.getNombre() + ","
                    + paciente.getApellido() + ","
                    + paciente.getTelefono() + ","
                    + paciente.getEmail() + ","
                    + paciente.getDireccion());
            writer.newLine();

            guardarRecursivo(writer, nodo.getIzquierdo());
            guardarRecursivo(writer, nodo.getDerecho());
        }
    }

    // Método para cargar el árbol desde un archivo de texto
    public static ArbolPaciente recuperarDeArchivo() {
        ArbolPaciente arbol = new ArbolPaciente();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(","); // Dividir por comas

                // Rellenar campos faltantes con valores predeterminados
                int id = datos.length > 0 ? Integer.parseInt(datos[0]) : 0;
                String nombre = datos.length > 1 ? datos[1] : "Desconocido";
                String apellido = datos.length > 2 ? datos[2] : "Desconocido";
                String telefono = datos.length > 3 ? datos[3] : "Sin teléfono";
                String email = datos.length > 4 ? datos[4] : "Sin email";
                String direccion = datos.length > 5 ? datos[5] : "Sin dirección";

                // Crear un nuevo objeto Paciente
                Paciente paciente = new Paciente(id, nombre, apellido, telefono, email, direccion);

                // Insertar en el árbol
                arbol.insertar(paciente);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará un nuevo archivo al guardar.");
        } catch (IOException e) {
            System.out.println("Error: No se puede leer la lista de pacientes. " + e);
        }
        return arbol;
    }

}
