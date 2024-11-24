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

    // Método para guardar la lista de odontólogos en un archivo de texto
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


    // Método para cargar la lista de odontólogos desde un archivo de texto
    public static ArbolPaciente recuperarDeArchivo() {
        ArbolPaciente arbol = new ArbolPaciente();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(","); // Dividir por comas
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String apellido = datos[2];
                String telefono = datos[3];
                String email = datos[4];
                String direccion = datos[5];

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
