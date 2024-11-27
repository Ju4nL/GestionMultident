
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

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("jTextField1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 248, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
