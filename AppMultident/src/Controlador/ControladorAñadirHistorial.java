/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.HistorialClinico;
import Persistencia.DatosHistorialClinico;
import Vista.VistaAñadirHistorial;
import Vista.VistaHistorialClinicoPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 *
 * @author USER
 */
public class ControladorAñadirHistorial implements ActionListener{
    VistaAñadirHistorial vista_añadir;
    VistaHistorialClinicoPaciente vista_historial;
    
    public ControladorAñadirHistorial (VistaAñadirHistorial vah, VistaHistorialClinicoPaciente vcp){
        this.vista_añadir=vah;
        this.vista_historial=vcp;
        this.vista_añadir.btnGuardar.addActionListener(this);
        this.vista_añadir.btnCancelar.addActionListener(this);
        
        
    }
    public void iniciar() {
        vista_añadir.setTitle("Añadir Datos");
        vista_añadir.setLocationRelativeTo(null);
        vista_añadir.setVisible(true);
        this.vista_añadir.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista_añadir.btnGuardar){
            int idPaciente = Integer.parseInt(this.vista_historial.jComboBox1.getEditor().getItem().toString());
            String textoAntecedente = this.vista_añadir.textoAntecedentes.getText();
            String textoAlergias = this.vista_añadir.textoAlergias.getText();
            String textoNotas = this.vista_añadir.textoNotas.getText();
            DatosHistorialClinico dhc = new DatosHistorialClinico();
            dhc.agregarHistorial(idPaciente, textoAntecedente, textoAlergias, textoNotas);
            JOptionPane.showMessageDialog(vista_añadir,"Se ha guardado correctamente");
            
        
        }else if (e.getSource()==this.vista_añadir.btnCancelar){
            this.vista_añadir.setVisible(false);
        }
    
    
    }
    
}
