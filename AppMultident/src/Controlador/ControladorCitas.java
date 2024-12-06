/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Colas.ColaGestionCitas;
import Modelo.Cita;
import Persistencia.DatosTablaGestionCitas;
import Vista.VistaGestionCitas;
import Vista.VistaAñadirCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ControladorCitas implements ActionListener {

    VistaGestionCitas vista_gestion;
    //ArregloCitas ListaCitas;
    String id;

    public void iniciar() {
        vista_gestion.setTitle("Gestión de citas");
        vista_gestion.setLocationRelativeTo(null);
        this.vista_gestion.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    



    public ControladorCitas(VistaGestionCitas c1) {
        vista_gestion = c1;

        vista_gestion.btnOpcionAñadir.addActionListener(this);
        vista_gestion.btnOpcionEliminar.addActionListener(this);
        vista_gestion.btnOpcionAtras.addActionListener(this);
        DatosTablaGestionCitas dtgc = new DatosTablaGestionCitas();
        dtgc.cargarCitasDesdeArchivo(vista_gestion.getModeloTabla());
        iniciar();
        vista_gestion.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista_gestion.btnOpcionAñadir) {
            Cita cita = new Cita();
            VistaAñadirCita va1 = new VistaAñadirCita();
            ColaGestionCitas cgc1 = new ColaGestionCitas();
            ControladorAñadirCita ca1 = new ControladorAñadirCita(va1, vista_gestion, cita, cgc1);
            ca1.iniciar();
            va1.setVisible(true);

        }
        if (e.getSource() == vista_gestion.btnOpcionEliminar) {
            JTable TablaCitas = vista_gestion.getTablaCitas();
            int filaSeleccionada = TablaCitas.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista_gestion, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                DefaultTableModel modelo = (DefaultTableModel) TablaCitas.getModel();

                modelo.removeRow(filaSeleccionada);
            }
        }
        if (e.getSource() == vista_gestion.btnOpcionAtras){
            this.vista_gestion.setVisible(false);
        }
    }

}
