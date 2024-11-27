/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasEnlazadas.ListasEnlazadasOdontologo;

import Modelo.Odontologo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LOZADA
 */
public class ListaEnlazadaOdontologos {

    private NodoOdontologo cabeza;

    public ListaEnlazadaOdontologos() {
        this.cabeza = null;
    }

    public NodoOdontologo getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoOdontologo cabeza) {
        this.cabeza = cabeza;
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

    public Odontologo buscarPorNombre(String nombre) {
        NodoOdontologo temp = cabeza;
        while (temp != null) {
            if (temp.getDato().getNombre().equalsIgnoreCase(nombre)) {
                return temp.getDato();
            }
            temp = temp.getSiguiente();
        }
        return null; // No encontrado
    }

    public Odontologo buscarPorEspecialidad(String especialidad) {
        NodoOdontologo temp = cabeza;
        while (temp != null) {
            if (temp.getDato().getEspecialidad().equalsIgnoreCase(especialidad)) {
                return temp.getDato();
            }
            temp = temp.getSiguiente();
        }
        return null; // No encontrado
    }

    // Método para eliminar un odontólogo por ID
    public void eliminarPorId(int id) {
        if (cabeza == null) {
            return;
        }

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

    public int contar() {
        int contador = 0;
        NodoOdontologo temp = cabeza;
        while (temp != null) {
            contador++;
            temp = temp.getSiguiente();
        }
        return contador;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public List<Odontologo> obtenerTodos() {
        List<Odontologo> lista = new ArrayList<>();
        NodoOdontologo temp = cabeza;
        while (temp != null) {
            lista.add(temp.getDato());
            temp = temp.getSiguiente();
        }
        return lista;
    }

    public int obtenerMaximoId() {
        int maxId = 1; // Asumimos que el ID mínimo es 0
        NodoOdontologo temp = cabeza;

        while (temp != null) {
            if (temp.getDato().getIdOdontologo() > maxId) {
                maxId = temp.getDato().getIdOdontologo(); // Actualizar el máximo
            }
            temp = temp.getSiguiente(); // Avanzar al siguiente nodo
        }

        return maxId; // Retornar el mayor ID encontrado
    }

}
