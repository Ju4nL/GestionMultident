/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class HistorialClinico {
    int idHistorial;
    Paciente paciente;
    String antecedentes;
    String alergias;
    List tratamientos;
    String notasAdicionales;

    public HistorialClinico(){}
    
    public HistorialClinico(int idHistorial, Paciente paciente, String antecedentes, String alergias, List tratamientos, String notasAdicionales) {
        this.idHistorial = idHistorial;
        this.paciente = paciente;
        this.antecedentes = antecedentes;
        this.alergias = alergias;
        this.tratamientos = tratamientos;
        this.notasAdicionales = notasAdicionales;
    }
    
    public Object[] convertirAArreglo(int idHistorial, Paciente paciente, String antecedentes, 
                                  String alergias, List tratamientos, String notasAdicionales) {
    return new Object[] {
        idHistorial,                            // ID del historial
        paciente != null ? paciente.getNombre() : "Sin asignar", // Nombre del paciente (o nulo)
        antecedentes != null ? antecedentes : "",  // Antecedentes
        alergias != null ? alergias : "",          // Alergias
        tratamientos != null ? tratamientos : new ArrayList<>(), // Lista de tratamientos
        notasAdicionales != null ? notasAdicionales : "" // Notas adicionales
    };
}

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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

    public List getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List tratamientos) {
        this.tratamientos = tratamientos;
    }

    public String getNotasAdicionales() {
        return notasAdicionales;
    }

    public void setNotasAdicionales(String notasAdicionales) {
        this.notasAdicionales = notasAdicionales;
    }

    
    
    

    
    
}
