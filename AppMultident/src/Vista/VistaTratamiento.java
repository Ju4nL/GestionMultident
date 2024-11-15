
package Vista;

import controlador.ControladorTratamiento;
import javax.swing.GroupLayout;
import modelo.Tratamiento;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author JUNIOR
 */
public class VistaTratamiento extends javax.swing.JFrame {

    private ControladorTratamiento controlador;
    private JTextField nombreField;
    private JTextField costoField;
    private JTextField descripcionField;
    private JTextArea areaResultados;
    private JButton btnAgregar;
    private JButton btnListar;
    private JButton btnBuscar;
    private JButton btnEliminar;
    
    public VistaTratamiento(ControladorTratamiento controlador) {
        this.controlador = controlador;
        initComponents1();

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarTratamiento();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTratamientos();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarTratamiento();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTratamiento();
            }
        });
    }

        
     private void initComponents1() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //campos de texto
        nombreField = new JTextField(20);
        costoField = new JTextField(20);
        descripcionField = new JTextField(20);
        areaResultados = new JTextArea(10, 30);
        areaResultados.setEditable(false);
        
        //botones
        btnAgregar = new JButton("Agregar");
        btnListar = new JButton("Listar");
        btnBuscar = new JButton("Buscar");
        btnEliminar = new JButton("Eliminar");

        // Configurar el layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(new JLabel("Nombre:"))
                    .addComponent(nombreField)
                    .addComponent(new JLabel("Costo:"))
                    .addComponent(costoField)
                    .addComponent(new JLabel("Descripción:"))
                    .addComponent(descripcionField)
                    .addComponent(new JLabel("Resultados:"))
                    .addComponent(areaResultados)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addComponent(btnListar)
                        .addComponent(btnBuscar)
                        .addComponent(btnEliminar))
                )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(new JLabel("Nombre:"))
                .addComponent(nombreField)
                .addComponent(new JLabel("Costo:"))
                .addComponent(costoField)
                .addComponent(new JLabel("Descripción:"))
                .addComponent(descripcionField)
                .addComponent(new JLabel("Resultados:"))
                .addComponent(areaResultados)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnListar)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar))
        );

        pack();
    }                       

    private void agregarTratamiento() {
    
    }

    private void listarTratamientos() {
    
    }

    private void buscarTratamiento() {
    
    }

    private void eliminarTratamiento() {
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            ControladorTratamiento controlador = new ControladorTratamiento(); // Asegúrate de que el controlador tenga un constructor sin parámetros
                new VistaTratamiento(controlador).setVisible(true);    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
