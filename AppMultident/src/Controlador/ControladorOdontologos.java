/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ListasEnlazadas.ListasEnlazadasOdontologo.ListaEnlazadaOdontologos;
import ListasEnlazadas.ListasEnlazadasOdontologo.NodoOdontologo;
import Modelo.Odontologo;
import Vista.VistaAñadirOdontologo;
import Vista.VistaGestionOdontologo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author LOZADA
 */
public class ControladorOdontologos implements ActionListener {

    private ListaEnlazadaOdontologos listaOdontologos;
    private VistaAñadirOdontologo vistaAñadirOdontologs;
    private VistaGestionOdontologo vistaGestionOdontologos;

    public ControladorOdontologos(VistaGestionOdontologo vistaGestionOdontologos) {
        this.vistaGestionOdontologos = vistaGestionOdontologos;
        this.listaOdontologos = new ListaEnlazadaOdontologos();
        initComponents();
    }

    private void initComponents() {
        // Asociar botones de la vista principal
        vistaGestionOdontologos.getBtnOpcionAñadir().addActionListener(this);
        vistaGestionOdontologos.getBtnOpcionEliminar().addActionListener(this);
        vistaGestionOdontologos.getBtnBuscar().addActionListener(this);
        vistaGestionOdontologos.getBtnOpcionActualizar().addActionListener(this);

        // Inicializar la vista principal mostrando los datos actuales
        //cargarTablaOdontologos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Aquí manejas los eventos de los botones
        if (e.getSource() == vistaGestionOdontologos.getBtnOpcionAñadir()) {
            abrirVistaAñadirOdontologo();
        } else if (e.getSource() == vistaGestionOdontologos.getBtnOpcionEliminar()) {
            //eliminarOdontologo();
        } else if (e.getSource() == vistaGestionOdontologos.getBtnBuscar()) {
            //consultarOdontologo();
        }
    }

    private void abrirVistaAñadirOdontologo() {
        vistaAñadirOdontologs = new VistaAñadirOdontologo(); // Crear instancia del JFrame de añadir
        vistaAñadirOdontologs.setVisible(true); // Mostrar la ventana
        vistaAñadirOdontologs.getBtnGuardar().addActionListener(e -> guardarNuevoOdontologo()); // Asociar el evento al botón "Guardar"
    }

    private void guardarNuevoOdontologo() {
        try {
            // Generar un nuevo ID
            int id = listaOdontologos.obtenerMaximoId() + 1;

            // Leer datos desde los campos de texto
            String nombre = vistaAñadirOdontologs.getTextoNombre().getText();
            String especialidad = vistaAñadirOdontologs.getTextoEspecialidad().getText();
            String telefono = vistaAñadirOdontologs.getTextoTelefono().getText();
            String email = vistaAñadirOdontologs.getTextoEmail().getText();
            String numeroColegiatura = vistaAñadirOdontologs.getTextoNumeroColegiatura().getText();

            // Crear y agregar el odontólogo
            Odontologo nuevoOdontologo = new Odontologo(id, nombre, especialidad, telefono, email, numeroColegiatura);
            listaOdontologos.agregar(nuevoOdontologo);

            // Guardar en el archivo y actualizar la vista
            guardarListaEnArchivo();
            vistaGestionOdontologos.displaySucessMessage("Odontólogo añadido correctamente.");

            // Cerrar la ventana de añadir
            vistaAñadirOdontologs.dispose();
        } catch (Exception e) {
            vistaAñadirOdontologs.displayErrorMessage("Error: Verifica los datos ingresados.");
        }
    }

    private void guardarListaEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Odontologo.FILE_PATH))) {
            NodoOdontologo temp = listaOdontologos.getCabeza(); // Obtener la cabeza de la lista
            while (temp != null) {
                // Escribir cada odontólogo como una línea en el archivo
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
            vistaGestionOdontologos.displayErrorMessage("Error al guardar los odontólogos en el archivo.");
        }
    }

}
