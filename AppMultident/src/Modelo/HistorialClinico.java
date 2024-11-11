/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.List;

/**
 *
 * @author USER
 */
public class HistorialClinico {
    int idHistorial;
    int idPaciente;
    String nombrePaciente;
    String apellidoPaciente;
    String telefonoPaciente;
    String emailPaciente;
    String direccionPaciente;
    Paciente paciente;
    String antecedentes;
    String alergias;
    List tratamientos;
    String notasAdicionales;

    public HistorialClinico(String idPaciente, String nombrePaciente, String apellidoPaciente, String telefonoPaciente, String emailPaciente, String antecedentes, String alergias, String notasAdicionales) {
        this.idPaciente = Integer.parseInt(idPaciente);
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.emailPaciente = emailPaciente;
        this.antecedentes = antecedentes;
        this.alergias = alergias;
        this.notasAdicionales = notasAdicionales;
    }
    
    

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getNotasAdicionales() {
        return notasAdicionales;
    }

    public void setNotasAdicionales(String notasAdicionales) {
        this.notasAdicionales = notasAdicionales;
    }
    
    
}
