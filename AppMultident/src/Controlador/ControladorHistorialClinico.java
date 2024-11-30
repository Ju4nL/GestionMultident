/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Arboles.ArbolPaciente.ArbolPaciente;
import Colas.ColaGestionHistorial;
import Modelo.HistorialClinico;
import Modelo.Paciente;
import Modelo.TablaHistorialClinico;
import Persistencia.DatosHistorialClinico;
import Persistencia.DatosPacientes;
import Vista.VistaAñadirHistorial;
import Vista.VistaHistorialClinicoPaciente;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

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
        this.vista_historial.btnBuscar.addActionListener(this);
        this.vista_historial.jButton3.addActionListener(this);
        this.vista_historial.btnModificar.addActionListener(this);
        this.vista_historial.btnAñadir.addActionListener(this);

        this.vista_historial.textoNombre.setEnabled(false);
        this.vista_historial.textoApellido.setEnabled(false);
        this.vista_historial.textoTelefono.setEnabled(false);
        this.vista_historial.textoEmail.setEnabled(false);
        this.vista_historial.textoAntecedentes.setEnabled(false);
        this.vista_historial.textoAlergias.setEnabled(false);
        this.vista_historial.textoNotas.setEnabled(false);

        this.arbolPacientes = DatosPacientes.recuperarDeArchivo();
        this.vista_historial.jComboBox1.setEditable(true);
        this.vista_historial.jComboBox1.addActionListener(this);

        this.vista_historial.jComboBox1.removeAllItems();
        this.vista_historial.jComboBox1.setSelectedItem("");

        DatosHistorialClinico dhc = new DatosHistorialClinico();
        // Leer elementos desde el archivo
        List<String> ids = dhc.leerPrimerElementoDeArchivo();

        // Agregar elementos al JComboBox
        for (String id : ids) {
            this.vista_historial.jComboBox1.addItem(id);
        }
        
        iniciar();
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
        this.vista_historial.setTitle("Gestión de Historial");
        this.vista_historial.setSize(1100, 700);
        this.vista_historial.setLocationRelativeTo(null);
        this.vista_historial.setVisible(true);
        this.vista_historial.setDefaultCloseOperation(HIDE_ON_CLOSE);

    }
    public JTable getTabla(){
        return this.vista_historial.tablaHistorial;
    }

    private void limpiarCampos() {
        this.vista_historial.textoNombre.setText("");
        this.vista_historial.textoApellido.setText("");
        this.vista_historial.textoTelefono.setText("");
        this.vista_historial.textoEmail.setText("");
        this.vista_historial.textoAntecedentes.setText("");
        this.vista_historial.textoAlergias.setText("");
        this.vista_historial.textoNotas.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vista_historial.btnBuscar) {
            limpiarCampos();
            int idPaciente = Integer.parseInt(this.vista_historial.jComboBox1.getEditor().getItem().toString());
            
            buscarPaciente(idPaciente);
            
            TablaHistorialClinico thc = new TablaHistorialClinico();
            ColaGestionHistorial cgh = new ColaGestionHistorial();
            
            thc.setIdTratamiento(idPaciente);
            
            //cgh.agregarCita(idPaciente, paciente, odontologo, descripcion, idPaciente, LocalDate.EPOCH);
            
            
            

        } else if (e.getSource() == this.vista_historial.jComboBox1) {
            if (this.vista_historial.jComboBox1.isPopupVisible()) {
                this.vista_historial.jComboBox1.hidePopup();
                this.vista_historial.jComboBox1.getParent().revalidate();
                this.vista_historial.jComboBox1.getParent().repaint();
            }

        } else if (e.getSource() == this.vista_historial.btnModificar) {
            VistaAñadirHistorial vah = new VistaAñadirHistorial();
            ControladorAñadirHistorial cah = new ControladorAñadirHistorial(vah, vista_historial);
            cah.iniciar();
            
        } 
    }

    private void buscarPaciente(int id) {
        HistorialClinico hc = new HistorialClinico();
        hc.setPaciente(arbolPacientes.buscar(id));

        if (hc.getPaciente() != null) {

            this.vista_historial.textoNombre.setText(hc.getPaciente().getNombre());
            this.vista_historial.textoApellido.setText(hc.getPaciente().getApellido());
            this.vista_historial.textoTelefono.setText(hc.getPaciente().getTelefono());
            this.vista_historial.textoEmail.setText(hc.getPaciente().getEmail());
            if (this.vista_historial.textoAntecedentes.getText().equals("") & this.vista_historial.textoAlergias.getText().equals("") & this.vista_historial.textoNotas.getText().equals("")) {
                agregarDatosExtras(id);
            }

        } else {
            JOptionPane.showMessageDialog(this.vista_historial, "Paciente no encontrado.");
        }
    }

    private void agregarDatosExtras(int id) {
        DatosHistorialClinico dhc = new DatosHistorialClinico();
        String[] datos = dhc.buscarPorIdEnArchivo(id);

        this.vista_historial.textoAntecedentes.setText(datos[1]);
        this.vista_historial.textoAlergias.setText(datos[2]);
        this.vista_historial.textoNotas.setText(datos[3]);
    }
}
