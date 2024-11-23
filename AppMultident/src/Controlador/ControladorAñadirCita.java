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
import static java.lang.Math.random;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
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
        int idrandom = (int) (Math.random()*1000)+1;
        cita.setIdCita(idrandom);
        cita.getPaciente().setIdPaciente(Integer.parseInt(vista_añadir.textoIdPaciente.getText()));
        cita.getOdontologo().setIdOdontologo(Integer.parseInt(vista_añadir.textoIdOdontologo.getText()));
        cita.setEstado(vista_añadir.textoFecha.getText());
        cita.setFecha(LocalDate.parse(vista_añadir.textoFecha.getText()));
        cita.setHora(LocalTime.parse(vista_añadir.textoHora.getText()));
       
       

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
