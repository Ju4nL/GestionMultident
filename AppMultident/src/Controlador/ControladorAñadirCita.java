/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Colas.ColaGestionCitas;
import Modelo.Cita;
import Vista.VistaAñadirCita;
import Controlador.ControladorCitas;
import Modelo.ArregloCita;
import Vista.VistaGestionCitas;
import appmultident.AppMultident;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.random;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ControladorAñadirCita implements ActionListener {

    VistaAñadirCita vista_añadir;
    VistaGestionCitas vista_gestion;
    ColaGestionCitas cola_citas;
    Cita cita;

    public ControladorAñadirCita(VistaAñadirCita va, VistaGestionCitas vg, Cita ct, ColaGestionCitas cgc) {
        this.vista_gestion = vg;
        this.vista_añadir = va;
        this.cita = ct;
        this.cola_citas = cgc;

        vista_añadir.jButton1.addActionListener(this);
        vista_añadir.jButton2.addActionListener(this);
        vista_añadir.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Solo cierra esta ventana en lugar de cerrar toda la aplicación
                vista_añadir.dispose();
            }
        });
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
        int idrandom = (int) (Math.random() * 1000) + 1;
        cita.setIdCita(idrandom);
        cita.getPaciente().setIdPaciente(Integer.parseInt(vista_añadir.textoIdPaciente.getText()));
        cita.getOdontologo().setIdOdontologo(Integer.parseInt(vista_añadir.textoIdOdontologo.getText()));
        cita.setEstado(vista_añadir.textoEstado.getText());
        cita.setFecha(LocalDate.parse(vista_añadir.textoFecha.getText()));
        cita.setHora(LocalTime.parse(vista_añadir.textoHora.getText()));

        if (e.getSource() == vista_añadir.jButton2) {
            
            int idPaciente = this.cita.getPaciente().getIdPaciente();
            int idOdontologo = this.cita.getOdontologo().getIdOdontologo();
            String estado = this.cita.getEstado();
            LocalDate fecha = this.cita.getFecha();
            LocalTime hora = this.cita.getHora();
            
            this.cola_citas.agregarCita(idrandom, idPaciente, idOdontologo, estado, fecha, hora);

            

            this.cola_citas.agregarUltimaCitaATabla(this.vista_gestion.getTablaCitas());
            String ruta = "C:\\Users\\USER\\Documents\\GitHub\\GestionMultident\\AppMultident\\src\\Contenedores\\CitasTablas.txt";
            this.cola_citas.guardarUltimaCitaEnArchivo(ruta);

            JOptionPane.showMessageDialog(vista_gestion, "Fila Agregada");
            vista_añadir.setVisible(false);

        } else if (e.getSource() == vista_añadir.jButton1) {
            vista_añadir.setVisible(false);
        }

    }

}
