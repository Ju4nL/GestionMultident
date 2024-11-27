/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Arboles.ArbolPaciente.ArbolPaciente;
import Modelo.Paciente;
import Persistencia.DatosPacientes;
import Vista.VistaHistorialClinicoPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ControladorHistorialClinico implements ActionListener {

    VistaHistorialClinicoPaciente vista_historial;
    private ArbolPaciente arbolPacientes;

    public ControladorHistorialClinico(VistaHistorialClinicoPaciente vhcp) {
        this.vista_historial = vhcp;
        this.vista_historial.jButton1.addActionListener(this);
        this.vista_historial.jButton2.addActionListener(this);
        this.vista_historial.jButton3.addActionListener(this);
        this.vista_historial.jButton4.addActionListener(this);
        this.vista_historial.jButton5.addActionListener(this);
        this.arbolPacientes = DatosPacientes.recuperarDeArchivo();
        this.vista_historial.jComboBox1.setEditable(true);
        this.vista_historial.jComboBox1.addActionListener(this);
       
        this.vista_historial.jComboBox1.removeAllItems();
        // Leer elementos desde el archivo
        String archivo = "C:\\Users\\USER\\Documents\\GitHub\\GestionMultident\\AppMultident\\src\\Contenedores\\IdPacientes.txt";
        List<String> citas = leerArchivo(archivo);

        // Agregar elementos al JComboBox
        for (String cita : citas) {
            this.vista_historial.jComboBox1.addItem(cita);
        }
       
        
        //this.vista_historial.jComboBox1.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {});
    }
    
    
    public static List<String> leerArchivo(String archivo) {
        List<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea); // Agregar cada línea a la lista
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return lista;
    }
    
    public void iniciar() {
        this.vista_historial.setTitle("Gestión de citas");
        this.vista_historial.setSize(1100, 700);
        this.vista_historial.setLocationRelativeTo(null);

    }


    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista_historial.jButton2) {
            String idPaciente = String.valueOf(this.vista_historial.jComboBox1.getEditor().getItem().toString());
            
            List<String> ids = leerArchivo("C:\\Users\\USER\\Documents\\GitHub\\GestionMultident\\AppMultident\\src\\Contenedores\\IdPacientes.txt");
            for (String id: ids){
                if (idPaciente.equalsIgnoreCase(id)){
                    int idIntPaciente = Integer.parseInt(idPaciente);
                    buscarPaciente(idIntPaciente);
                }
            }
        
        }
    }
    private void buscarPaciente(int id) {
       
            
            Paciente paciente = arbolPacientes.buscar(id);

            if (paciente != null) {
     
                    this.vista_historial.textoNombre.setText(paciente.getNombre());
                    this.vista_historial.textoApellido.setText(paciente.getApellido());
                    this.vista_historial.textoTelefono.setText(paciente.getTelefono());
                    this.vista_historial.textoEmail.setText(paciente.getEmail());
                    this.vista_historial.textoNombre.setText(paciente.getNombre());
                    
                
            } else {
                JOptionPane.showMessageDialog(this.vista_historial,"Paciente no encontrado.");
            }
    }
}
