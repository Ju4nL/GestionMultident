/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles.ArbolPaciente;

/**
 *
 * @author LOZADA
 */
import Modelo.Paciente;
import java.util.ArrayList;
import java.util.List;

public class ArbolPaciente {

    private NodoPaciente raiz;

    public ArbolPaciente() {
        this.raiz = null;
    }

    public NodoPaciente getRaiz() {
        return raiz;
    }

    // Insertar un paciente en el árbol
    public void insertar(Paciente paciente) {
        raiz = insertarRecursivo(raiz, paciente);
    }

    private NodoPaciente insertarRecursivo(NodoPaciente nodo, Paciente paciente) {
        if (nodo == null) {
            return new NodoPaciente(paciente);
        }

        if (paciente.getIdPaciente() < nodo.getDato().getIdPaciente()) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), paciente));
        } else if (paciente.getIdPaciente() > nodo.getDato().getIdPaciente()) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), paciente));
        }

        return nodo;
    }

    // Buscar un paciente por ID
    public Paciente buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Paciente buscarRecursivo(NodoPaciente nodo, int id) {
        if (nodo == null) {
            return null; // No encontrado
        }

        if (id == nodo.getDato().getIdPaciente()) {
            return nodo.getDato();
        }

        if (id < nodo.getDato().getIdPaciente()) {
            return buscarRecursivo(nodo.getIzquierdo(), id);
        } else {
            return buscarRecursivo(nodo.getDerecho(), id);
        }
    }

    // Eliminar un paciente
    public void eliminar(int id) {
        raiz = eliminarRecursivo(raiz, id);
    }

    private NodoPaciente eliminarRecursivo(NodoPaciente nodo, int id) {
        if (nodo == null) {
            return null;
        }

        if (id < nodo.getDato().getIdPaciente()) {
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), id));
        } else if (id > nodo.getDato().getIdPaciente()) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), id));
        } else {
            // Nodo encontrado
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            NodoPaciente sucesor = obtenerMinimo(nodo.getDerecho());
            nodo.setDato(sucesor.getDato());
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesor.getDato().getIdPaciente()));
        }

        return nodo;
    }

    private NodoPaciente obtenerMinimo(NodoPaciente nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    // Recorrido InOrder (para listar los pacientes)
    public List<Paciente> recorrerInOrder() {
        List<Paciente> lista = new ArrayList<>();
        recorrerInOrderRecursivo(raiz, lista);
        return lista;
    }

    private void recorrerInOrderRecursivo(NodoPaciente nodo, List<Paciente> lista) {
        if (nodo != null) {
            recorrerInOrderRecursivo(nodo.getIzquierdo(), lista);
            lista.add(nodo.getDato());
            recorrerInOrderRecursivo(nodo.getDerecho(), lista);
        }
    }

    public int obtenerMaximoId() {
        NodoPaciente actual = raiz;
        if (actual == null) {
            return 0; // Si el árbol está vacío, retornar 0 como valor inicial
        }
        while (actual.getDerecho() != null) {
            actual = actual.getDerecho(); // Seguir al nodo más a la derecha
        }
        return actual.getDato().getIdPaciente(); // Retornar el ID del nodo más grande
    }
}


