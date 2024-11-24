/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles.ArbolPaciente;
 
import Modelo.Paciente;

/**
 *
 * @author LOZADA
 */
 

import Modelo.Paciente;

public class NodoPaciente {
    private Paciente dato;
    private NodoPaciente izquierdo;
    private NodoPaciente derecho;

    public NodoPaciente(Paciente dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    public Paciente getDato() {
        return dato;
    }

    public void setDato(Paciente dato) {
        this.dato = dato;
    }

    public NodoPaciente getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoPaciente izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoPaciente getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoPaciente derecho) {
        this.derecho = derecho;
    }
}
