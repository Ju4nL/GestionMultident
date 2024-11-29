/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ColaGestionCitas {

    private Queue<List<Object>> colaCitas;

    // Constructor
    public ColaGestionCitas() {
        this.colaCitas = new LinkedList<>();
    }

    // Método para agregar una cita a la cola
    public void agregarCita(int idCita, int idPaciente, int idOdontologo, String estado, LocalDate fecha, LocalTime hora) {
        List<Object> cita = List.of(idCita, idPaciente, idOdontologo, estado, fecha, hora);
        colaCitas.add(cita);
    }

    // Método para obtener y remover la próxima cita (FIFO)
    public List<Object> atenderCita() {
        return colaCitas.poll(); // Devuelve y elimina la cita al frente de la cola
    }

    // Método para obtener la próxima cita sin removerla
    public List<Object> verProximaCita() {
        return colaCitas.peek(); // Devuelve la cita al frente de la cola sin eliminarla
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return colaCitas.isEmpty();
    }

    // Método para obtener el tamaño de la cola
    public int obtenerTamaño() {
        return colaCitas.size();
    }

    // Método para imprimir todas las citas en la cola
    public void imprimirCitas() {
        for (List<Object> cita : colaCitas) {
            System.out.println("Cita: " + cita);
        }
    }

    public void agregarUltimaCitaATabla(JTable tabla) {
        if (colaCitas.isEmpty()) {
            System.out.println("No hay citas en la cola para agregar a la tabla.");
            return;
        }

        List<Object> ultimaCita = ((LinkedList<List<Object>>) colaCitas).getLast();

        Object[] datosFila = {
            ultimaCita.get(0), // ID Cita
            ultimaCita.get(1), // ID Paciente
            ultimaCita.get(2), // ID Odontologo
            ultimaCita.get(3), // Estado
            ultimaCita.get(4), // Fecha
            ultimaCita.get(5) // Hora
        };

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addRow(datosFila);

        System.out.println("Última cita agregada a la tabla: " + ultimaCita);
    }

    public Object[] convertirListaEnArreglo(List<Object> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("La lista está vacía o es nula.");
            return new Object[0];
        }
        return lista.toArray();
    }

    public Object[] convertirUltimaListaEnArreglo() {
        if (colaCitas.isEmpty()) {
            System.out.println("No hay citas en la cola.");
            return new Object[0]; // Retorna un arreglo vacío si la cola está vacía
        }

        List<Object> ultimaCita = ((LinkedList<List<Object>>) colaCitas).getLast();

        return ultimaCita.toArray();
    }

    public void guardarUltimaCitaEnArchivo(String nombreArchivo) {
        if (colaCitas.isEmpty()) {
            System.out.println("No hay citas en la cola para guardar.");
            return;
        }
        
        List<Object> ultimaCita = ((LinkedList<List<Object>>) colaCitas).getLast();

        StringBuilder contenido = new StringBuilder();
        for (Object dato : ultimaCita) {
            contenido.append(dato).append(" | "); 
        }
        contenido.setLength(contenido.length() - 3);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(contenido.toString());
            writer.newLine(); 
            System.out.println("Última cita guardada en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar la cita en el archivo: " + e.getMessage());
        }
    }
}
