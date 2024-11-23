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
public class ListaEnlazadaOdontologos {
    private NodoOdontologo cabeza;

    public ListaEnlazadaOdontologos() {
        this.cabeza = null;
    }

    // Método para agregar un odontólogo
    public void agregar(Odontologo odontologo) {
        NodoOdontologo nuevoNodo = new NodoOdontologo(odontologo);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoOdontologo temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
        }
    }

    // Método para mostrar todos los odontólogos
    public void mostrar() {
        NodoOdontologo temp = cabeza;
        while (temp != null) {
            System.out.println(temp.getDato());
            temp = temp.getSiguiente();
        }
    }

    // Método para buscar un odontólogo por ID
    public Odontologo buscarPorId(int id) {
        NodoOdontologo temp = cabeza;
        while (temp != null) {
            if (temp.getDato().getIdOdontologo() == id) {
                return temp.getDato();
            }
            temp = temp.getSiguiente();
        }
        return null; // No encontrado
    }

    // Método para eliminar un odontólogo por ID
    public void eliminarPorId(int id) {
        if (cabeza == null) return;

        if (cabeza.getDato().getIdOdontologo() == id) {
            cabeza = cabeza.getSiguiente();
            return;
        }

        NodoOdontologo temp = cabeza;
        while (temp.getSiguiente() != null) {
            if (temp.getSiguiente().getDato().getIdOdontologo() == id) {
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                return;
            }
            temp = temp.getSiguiente();
        }
    }
}

