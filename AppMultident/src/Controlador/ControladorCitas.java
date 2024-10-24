/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cita;
import Vista.VistaGestionCitas;
import Vista.VistaAñadirCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ControladorCitas implements ActionListener{
    
    VistaGestionCitas vista_gestion;
    //ArregloCitas ListaCitas;
    String id;
    
    
    public void iniciar(){
        vista_gestion.setTitle("Gestión de citas");
        vista_gestion.setLocationRelativeTo(null);
    }
    
    public ControladorCitas (VistaGestionCitas c1){
        vista_gestion=c1;
        
        vista_gestion.btnOpcionAñadir.addActionListener(this);
        vista_gestion.btnOpcionEliminar.addActionListener(this);
        vista_gestion.btnOpcionAtras.addActionListener(this);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista_gestion.btnOpcionAñadir){
            Cita cita = new Cita();
            VistaAñadirCita va1= new VistaAñadirCita();
            ControladorAñadirCita ca1 = new ControladorAñadirCita(va1,vista_gestion,cita);
            ca1.iniciar();
            va1.setVisible(true);
            
        }
        if(e.getSource()==vista_gestion.btnOpcionEliminar){
            JTable TablaCitas = vista_gestion.getTablaCitas();
            int filaSeleccionada = TablaCitas.getSelectedRow();
            if(filaSeleccionada==-1){
                JOptionPane.showMessageDialog(vista_gestion, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                
            }else{
                DefaultTableModel modelo = (DefaultTableModel) TablaCitas.getModel();
                        
                modelo.removeRow(filaSeleccionada);
            }
        }
    }
    
}
