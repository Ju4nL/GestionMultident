/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cita;
import Vista.VistaAñadirCita;
import Controlador.ControladorCitas;
import Modelo.ArregloCita;
import Vista.VistaGestionCitas;
import appmultident.AppMultident;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ControladorAñadirCita implements ActionListener {

    VistaAñadirCita vista_añadir;
    VistaGestionCitas vista_gestion;
    AppMultident app;
    Cita cita;

    public ControladorAñadirCita(VistaAñadirCita va, VistaGestionCitas vg, Cita ct) {
        this.vista_gestion = vg;
        this.vista_añadir = va;
        this.cita = ct;

        vista_añadir.jButton1.addActionListener(this);
        vista_añadir.jButton2.addActionListener(this);
    }

    public void iniciar() {
        vista_añadir.setTitle("Añadir Cita");
        vista_añadir.setLocationRelativeTo(null);
    }

    public void guardarCitaEnArchivo(ArregloCita arregloCita) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\USER\\Documents\\GitHub\\GestionMultident\\AppMultident\\src\\Contenedores\\CitasTablas.txt", true))) {
            // Convertimos el arreglo en una cadena de texto separada por comas
            StringBuilder sb = new StringBuilder();
            for (String dato : arregloCita.arregloCita) {
                sb.append(dato).append(",");
            }
            // Quitamos la última coma y añadimos una nueva línea
            sb.deleteCharAt(sb.length() - 1).append("\n");
            writer.write(sb.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la cita en el archivo.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cita.setIdcita(vista_añadir.textoID.getText());
        cita.setDni_cliente(vista_añadir.textoDni.getText());
        cita.setNombre_cliente(vista_añadir.textoNombre.getText());
        cita.setApellido_cliente(vista_añadir.textoApellido.getText());
        cita.setTelefono_cliente(vista_añadir.textoTelefono.getText());
        SimpleDateFormat formato_fecha = new SimpleDateFormat("dd/mm/yyyy");
        SimpleDateFormat formato_hora = new SimpleDateFormat("hh:mm");

        try {
            cita.setFecha(formato_fecha.parse(vista_añadir.textoFecha.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(ControladorAñadirCita.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cita.setHora(formato_hora.parse(vista_añadir.textoHora.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(ControladorAñadirCita.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (e.getSource() == vista_añadir.jButton2) {
            ArregloCita arreglo_gestionCitas = new ArregloCita(cita);

            vista_gestion.getModeloTabla().addRow(arreglo_gestionCitas.arregloCita);
            guardarCitaEnArchivo(arreglo_gestionCitas);
            JOptionPane.showMessageDialog(vista_gestion, "Fila Agregada");
            vista_añadir.setVisible(false);

        } else if (e.getSource() == vista_añadir.jButton1) {
            vista_añadir.setVisible(false);
        }

    }

}
