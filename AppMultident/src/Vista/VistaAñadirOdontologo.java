package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import Colas.ColaOdontologo;
import Modelo.Odontologo;

public class VistaAñadirOdontologo extends javax.swing.JFrame {

    private ColaOdontologo Co; // Declaramos la cola para almacenar odontólogos
    private void limpiarCampos() {
    textoNombre.setText("");
    textoEspecialidad.setText("");
    textoTelefono.setText("");
    textoEmail.setText("");
    textoNumeroColegiatura.setText("");
}
    public VistaAñadirOdontologo() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Co = new ColaOdontologo();
    }

    public JTextField getTextoEmail() {
        return textoEmail;
    }

    public JTextField getTextoEspecialidad() {
        return textoEspecialidad;
    }

    public JTextField getTextoNumeroColegiatura() {
        return textoNumeroColegiatura;
    }

    public JTextField getTextoNombre() {
        return textoNombre;
    }

    public JTextField getTextoTelefono() {
        return textoTelefono;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        textoEspecialidad = new javax.swing.JTextField();
        textoTelefono = new javax.swing.JTextField();
        textoEmail = new javax.swing.JTextField();
        textoNumeroColegiatura = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jTextField3.setText("jTextField1");

        jTextField6.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre");

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Especialidad");

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Teléfono");

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Email");

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("NumeroColegiatura");

        textoNombre.setBackground(new java.awt.Color(153, 153, 153));
        textoNombre.setForeground(new java.awt.Color(51, 51, 51));
        textoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNombreActionPerformed(evt);
            }
        });

        textoEspecialidad.setBackground(new java.awt.Color(153, 153, 153));
        textoEspecialidad.setForeground(new java.awt.Color(51, 51, 51));

        textoTelefono.setBackground(new java.awt.Color(153, 153, 153));
        textoTelefono.setForeground(new java.awt.Color(51, 51, 51));
        textoTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoTelefonoActionPerformed(evt);
            }
        });

        textoEmail.setBackground(new java.awt.Color(153, 153, 153));
        textoEmail.setForeground(new java.awt.Color(51, 51, 51));

        textoNumeroColegiatura.setBackground(new java.awt.Color(153, 153, 153));
        textoNumeroColegiatura.setForeground(new java.awt.Color(51, 51, 51));

        btnCancelar.setBackground(new java.awt.Color(0, 204, 204));
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(0, 204, 204));
        btnGuardar.setForeground(new java.awt.Color(51, 51, 51));
        btnGuardar.setText("Añadir");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Añadir Odontologo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(99, 99, 99))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoNumeroColegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(53, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(textoEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(textoNumeroColegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
     textoNombre.setText("");
        textoEspecialidad.setText("");
        textoTelefono.setText("");
        textoEmail.setText("");
        textoNumeroColegiatura.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
String nombre = textoNombre.getText().trim();
    String especialidad = textoEspecialidad.getText().trim();
    String telefono = textoTelefono.getText().trim();
    String email = textoEmail.getText().trim();
    String numeroColegiatura = textoNumeroColegiatura.getText().trim();

    if (nombre.isEmpty() || especialidad.isEmpty() || telefono.isEmpty() || email.isEmpty() || numeroColegiatura.isEmpty()) {
        displayErrorMessage("Por favor, complete todos los campos.");
        return;
    }

    try {
        // Crear una instancia de Odontologo con los datos de los campos de texto
        Odontologo Od = new Odontologo(7282, nombre, especialidad, telefono, email, numeroColegiatura);

        // Agregar el odontólogo a la cola
        Co.encolar(Od);  // Aquí debería funcionar si 'Co' es una instancia de ColaOdontologo

        displaySucessMessage("Odontólogo añadido correctamente a la cola.");
        limpiarCampos();
    } catch (Exception e) {
        displayErrorMessage("Error al añadir el odontólogo: " + e.getMessage());
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void textoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNombreActionPerformed

    private void textoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoTelefonoActionPerformed
    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error Login", JOptionPane.ERROR_MESSAGE);
    }

    public void displaySucessMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaAñadirCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAñadirCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAñadirCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAñadirCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAñadirOdontologo().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    public javax.swing.JTextField textoEmail;
    public javax.swing.JTextField textoEspecialidad;
    public javax.swing.JTextField textoNombre;
    public javax.swing.JTextField textoNumeroColegiatura;
    public javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables
}
