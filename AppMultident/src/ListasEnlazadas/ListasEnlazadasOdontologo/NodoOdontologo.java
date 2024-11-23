/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasEnlazadas.ListasEnlazadasOdontologo;

import Modelo.Odontologo;

/**
 *
 * @author LOZADA
 */
public class NodoOdontologo {
    private Odontologo dato;
    private NodoOdontologo siguiente;

    public NodoOdontologo(Odontologo dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Odontologo getDato() {
        return dato;
    }

    public void setDato(Odontologo dato) {
        this.dato = dato;
    }

    public NodoOdontologo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoOdontologo siguiente) {
        this.siguiente = siguiente;
    }
}

