/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ListasEnlazadas.ListasEnlazadasOdontologo.ListaEnlazadaOdontologos;
import ListasEnlazadas.ListasEnlazadasOdontologo.NodoOdontologo;
import Modelo.Odontologo;
import Persistencia.DatosOdontologos;
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
        this.listaOdontologos = DatosOdontologos.recuperarDeArchivo();
        initComponents();
    }

    private void initComponents() {
        // Asociar botones de la vista principal
        vistaGestionOdontologos.getBtnOpcionAñadir().addActionListener(this);
        vistaGestionOdontologos.getBtnOpcionEliminar().addActionListener(this);
        vistaGestionOdontologos.getBtnBuscar().addActionListener(this);
        vistaGestionOdontologos.getBtnOpcionActualizar().addActionListener(this);

        // Inicializar la vista principal mostrando los datos actuales
        cargarTablaOdontologos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

        if (e.getSource() == vistaGestionOdontologos.getBtnOpcionAñadir()) {
            abrirVistaAñadirOdontologo();
        } else if (e.getSource() == vistaGestionOdontologos.getBtnOpcionEliminar()) {
            eliminarOdontologo();
        } else if (e.getSource() == vistaGestionOdontologos.getBtnOpcionActualizar()) {
            actualizarOdontologo();
        } else if (e.getSource() == vistaGestionOdontologos.getBtnBuscar()) {
//            buscarOdontologo();
        }
    }

    private void abrirVistaAñadirOdontologo() {
        vistaAñadirOdontologs = new VistaAñadirOdontologo(); // Crear instancia del JFrame de añadir
        vistaAñadirOdontologs.setVisible(true); // Mostrar la ventana
        vistaAñadirOdontologs.getBtnGuardar().addActionListener(e -> guardarNuevoOdontologo()); // Asociar el evento al botón "Guardar"
    }

    private void guardarNuevoOdontologo() {
        try {
            int id = listaOdontologos.obtenerMaximoId() + 1;
            String nombre = vistaAñadirOdontologs.getTextoNombre().getText();
            String especialidad = vistaAñadirOdontologs.getTextoEspecialidad().getText();
            String telefono = vistaAñadirOdontologs.getTextoTelefono().getText();
            String email = vistaAñadirOdontologs.getTextoEmail().getText();
            String numeroColegiatura = vistaAñadirOdontologs.getTextoNumeroColegiatura().getText();

            Odontologo nuevoOdontologo = new Odontologo(id, nombre, especialidad, telefono, email, numeroColegiatura);
            listaOdontologos.agregar(nuevoOdontologo);

            guardarLista(); // Guardar la lista en el archivo
            vistaGestionOdontologos.displaySucessMessage("Odontólogo añadido correctamente.");
            cargarTablaOdontologos(); // Actualizar la tabla
            vistaAñadirOdontologs.dispose();
        } catch (Exception e) {
            vistaAñadirOdontologs.displayErrorMessage("Error: Verifica los datos ingresados.");
        }
    }

    private void guardarLista() {
        DatosOdontologos.guardarEnArchivo(listaOdontologos);
    }

    private void cargarTablaOdontologos() {
        // Limpia la tabla actual
        vistaGestionOdontologos.limpiarTabla();

        // Recorrer la lista enlazada y agregar cada odontólogo a la tabla
        NodoOdontologo temp = listaOdontologos.getCabeza();
        while (temp != null) {
            Odontologo odontologo = temp.getDato();
            vistaGestionOdontologos.agregarFilaTabla(new Object[]{
                odontologo.getIdOdontologo(),
                odontologo.getNombre(),
                odontologo.getEspecialidad(),
                odontologo.getTelefono(),
                odontologo.getEmail(),
                odontologo.getNumeroColegiatura()
            });
            temp = temp.getSiguiente();
        }
    }

    private void actualizarOdontologo() {
        try {
            // Obtener la fila seleccionada en la tabla
            int filaSeleccionada = vistaGestionOdontologos.getTablaGestionCitas().getSelectedRow();
            if (filaSeleccionada == -1) {
                vistaGestionOdontologos.displayErrorMessage("Por favor, selecciona un odontólogo para actualizar.");
                return;
            }

            // Obtener el ID del odontólogo desde la tabla
            int id = (int) vistaGestionOdontologos.getTablaGestionCitas().getValueAt(filaSeleccionada, 0);

            // Buscar el odontólogo en la lista enlazada
            Odontologo odontologo = listaOdontologos.buscarPorId(id);
            if (odontologo == null) {
                vistaGestionOdontologos.displayErrorMessage("No se encontró el odontólogo seleccionado.");
                return;
            }

            // Mostrar la vista de actualizar con los datos actuales del odontólogo
            vistaAñadirOdontologs = new VistaAñadirOdontologo();
            vistaAñadirOdontologs.getTextoNombre().setText(odontologo.getNombre());
            vistaAñadirOdontologs.getTextoEspecialidad().setText(odontologo.getEspecialidad());
            vistaAñadirOdontologs.getTextoTelefono().setText(odontologo.getTelefono());
            vistaAñadirOdontologs.getTextoEmail().setText(odontologo.getEmail());
            vistaAñadirOdontologs.getTextoNumeroColegiatura().setText(odontologo.getNumeroColegiatura());
            vistaAñadirOdontologs.setVisible(true);

            // Asociar el botón "Guardar" para guardar los cambios
            vistaAñadirOdontologs.getBtnGuardar().addActionListener(e -> {
                try {
                    // Actualizar los datos del odontólogo
                    odontologo.setNombre(vistaAñadirOdontologs.getTextoNombre().getText());
                    odontologo.setEspecialidad(vistaAñadirOdontologs.getTextoEspecialidad().getText());
                    odontologo.setTelefono(vistaAñadirOdontologs.getTextoTelefono().getText());
                    odontologo.setEmail(vistaAñadirOdontologs.getTextoEmail().getText());
                    odontologo.setNumeroColegiatura(vistaAñadirOdontologs.getTextoNumeroColegiatura().getText());

                    // Guardar la lista actualizada en el archivo
                    guardarLista();

                    // Actualizar la tabla
                    cargarTablaOdontologos();

                    vistaGestionOdontologos.displaySucessMessage("Odontólogo actualizado correctamente.");
                    vistaAñadirOdontologs.dispose();
                } catch (Exception ex) {
                    vistaAñadirOdontologs.displayErrorMessage("Error al actualizar el odontólogo.");
                }
            });
        } catch (Exception e) {
            vistaGestionOdontologos.displayErrorMessage("Error al intentar actualizar el odontólogo.");
        }
    }

    private void eliminarOdontologo() {
        try {
            // Obtener la fila seleccionada en la tabla
            int filaSeleccionada = vistaGestionOdontologos.getTablaGestionCitas().getSelectedRow();
            if (filaSeleccionada == -1) {
                vistaGestionOdontologos.displayErrorMessage("Por favor, selecciona un odontólogo para eliminar.");
                return;
            }

            // Obtener el ID del odontólogo desde la tabla
            int id = (int) vistaGestionOdontologos.getTablaGestionCitas().getValueAt(filaSeleccionada, 0);

            // Eliminar el odontólogo de la lista enlazada
            listaOdontologos.eliminarPorId(id);

            // Guardar la lista actualizada en el archivo
            guardarLista();

            // Actualizar la tabla
            cargarTablaOdontologos();

            vistaGestionOdontologos.displaySucessMessage("Odontólogo eliminado correctamente.");
        } catch (Exception e) {
            vistaGestionOdontologos.displayErrorMessage("Error al eliminar el odontólogo.");
        }
    }

}
