/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import ListasEnlazadas.ListasEnlazadasOdontologo.ListaEnlazadaOdontologos;
import ListasEnlazadas.ListasEnlazadasOdontologo.NodoOdontologo;
import Modelo.Odontologo;
import java.io.*; 
/**
 *
 * @author LOZADA
 */ 


public class DatosOdontologos {

    private static final String FILE_PATH = "src/Contenedores/Odontologos.txt";

    // Método para guardar la lista de odontólogos en un archivo de texto
    public static void guardarEnArchivo(ListaEnlazadaOdontologos lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            NodoOdontologo temp = lista.getCabeza(); // Obtener la cabeza de la lista enlazada
            while (temp != null) {
                Odontologo odontologo = temp.getDato();
                writer.write(odontologo.getIdOdontologo() + ","
                        + odontologo.getNombre() + ","
                        + odontologo.getEspecialidad() + ","
                        + odontologo.getTelefono() + ","
                        + odontologo.getEmail() + ","
                        + odontologo.getNumeroColegiatura());
                writer.newLine();
                temp = temp.getSiguiente();
            }
        } catch (IOException e) {
            System.out.println("Error: No se puede guardar la lista de odontólogos. " + e);
        }
    }

    // Método para cargar la lista de odontólogos desde un archivo de texto
    public static ListaEnlazadaOdontologos recuperarDeArchivo() {
        ListaEnlazadaOdontologos lista = new ListaEnlazadaOdontologos();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(","); // Dividir por comas
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String especialidad = datos[2];
                String telefono = datos[3];
                String email = datos[4];
                String numeroColegiatura = datos[5];

                // Crear un nuevo objeto Odontologo
                Odontologo odontologo = new Odontologo(id, nombre, especialidad, telefono, email, numeroColegiatura);

                // Agregarlo a la lista enlazada
                lista.agregar(odontologo);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará un nuevo archivo al guardar.");
        } catch (IOException e) {
            System.out.println("Error: No se puede leer la lista de odontólogos. " + e);
        }
        return lista;
    }
}
