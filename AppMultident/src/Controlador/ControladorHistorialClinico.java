/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaHistorialClinicoPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author USER
 */
public class ControladorHistorialClinico implements ActionListener {
    
    VistaHistorialClinicoPaciente vista_historial;
    public ControladorHistorialClinico(VistaHistorialClinicoPaciente vhcp){
        this.vista_historial=vhcp;
        this.vista_historial.jButton1.addActionListener(this);
        this.vista_historial.jButton2.addActionListener(this);
        this.vista_historial.jButton3.addActionListener(this);
        this.vista_historial.jButton4.addActionListener(this);
        this.vista_historial.jButton5.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.vista_historial.jButton2){
            
        }
    }
    
}
