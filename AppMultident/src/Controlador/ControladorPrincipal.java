/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Vista.VistaHome; 
import Vista.VistaGestionOdontologo;
import Vista.VistaGestionPacientes; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LOZADA
 */ 

 
public class ControladorPrincipal implements ActionListener {
    private VistaHome vistaHome;

    public ControladorPrincipal() {
        // Instanciar la vista principal
        this.vistaHome = new VistaHome();
 
        initComponents();
    }

    private void initComponents() {
        // Asociar botones a los ActionListeners
        vistaHome.getBtnPacientes().addActionListener(this);
        vistaHome.getBtnOdontologos().addActionListener(this);
        vistaHome.getBtnCitas().addActionListener(this);
        vistaHome.getBtnInventario().addActionListener(this);

        // Hacer visible la vista principal
        
        vistaHome.setLocationRelativeTo(null);
        vistaHome.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaHome.getBtnPacientes()) {
            abrirVistaPacientes();
        } else if (e.getSource() == vistaHome.getBtnOdontologos()) {
            abrirVistaOdontologos();
        } else if (e.getSource() == vistaHome.getBtnCitas()) {
            abrirVistaCitas();
        } else if (e.getSource() == vistaHome.getBtnInventario()) {
            abrirVistaInventario();
        }
    }

    // Métodos para abrir las diferentes vistas
    private void abrirVistaPacientes() {
        VistaGestionPacientes vistaPacientes = new VistaGestionPacientes();
        new ControladorPacientes(vistaPacientes);
        vistaPacientes.setVisible(true);
    }

    private void abrirVistaOdontologos() {
        VistaGestionOdontologo vistaOdontologos = new VistaGestionOdontologo();
        new ControladorOdontologos(vistaOdontologos);
        vistaOdontologos.setVisible(true);
    }

    private void abrirVistaCitas() {
        //VistaCitas vistaCitas = new VistaCitas();
        //new ControladorCitas(vistaCitas);
        //vistaCitas.setVisible(true);
    }

    private void abrirVistaInventario() {
        //VistaInventario vistaInventario = new VistaInventario();
        //new ControladorInventario(vistaInventario);
        //vistaInventario.setVisible(true);
    }
}
