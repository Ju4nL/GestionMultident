/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenamientos;

import ListasEnlazadas.ListasEnlazadasOdontologo.ListaEnlazadaOdontologos;
import ListasEnlazadas.ListasEnlazadasOdontologo.NodoOdontologo;
import Modelo.Odontologo;

/**
 *
 * @author LOZADA
 */

public class OrdenamientoOdontologos {

    // **1. Ordenar por ID - Burbuja**
    public static void ordenarPorIdBurbuja(ListaEnlazadaOdontologos lista) {
        if (lista.getCabeza() == null) {
            return;
        }

        boolean cambiado;
        do {
            cambiado = false;
            NodoOdontologo actual = lista.getCabeza();
            while (actual.getSiguiente() != null) {
                if (actual.getDato().getIdOdontologo() > actual.getSiguiente().getDato().getIdOdontologo()) {
                    // Intercambiar
                    Odontologo temp = actual.getDato();
                    actual.setDato(actual.getSiguiente().getDato());
                    actual.getSiguiente().setDato(temp);
                    cambiado = true;
                }
                actual = actual.getSiguiente();
            }
        } while (cambiado);
    }

    // **2. Ordenar por Nombre - Inserción**
    public static void ordenarPorNombreInsercion(ListaEnlazadaOdontologos lista) {
        if (lista.getCabeza() == null || lista.getCabeza().getSiguiente() == null) {
            return;
        }

        NodoOdontologo nodoActual = lista.getCabeza().getSiguiente();
        NodoOdontologo nodoAnteriorOrdenado = lista.getCabeza();

        while (nodoActual != null) {
            NodoOdontologo nodoOrdenado = lista.getCabeza();
            NodoOdontologo nodoAnterior = null;

            while (nodoOrdenado != nodoActual
                    && nodoOrdenado.getDato().getNombre().compareToIgnoreCase(nodoActual.getDato().getNombre()) < 0) {
                nodoAnterior = nodoOrdenado;
                nodoOrdenado = nodoOrdenado.getSiguiente();
            }

            if (nodoOrdenado != nodoActual) {
                nodoAnteriorOrdenado.setSiguiente(nodoActual.getSiguiente());

                if (nodoAnterior == null) {
                    nodoActual.setSiguiente(lista.getCabeza());
                    lista.setCabeza(nodoActual);
                } else {
                    nodoAnterior.setSiguiente(nodoActual);
                    nodoActual.setSiguiente(nodoOrdenado);
                }
                nodoActual = nodoAnteriorOrdenado.getSiguiente();
            } else {
                nodoAnteriorOrdenado = nodoActual;
                nodoActual = nodoActual.getSiguiente();
            }
        }
    }

    // **3. Ordenar por Especialidad - Selección**
    public static void ordenarPorEspecialidadSeleccion(ListaEnlazadaOdontologos lista) {
        NodoOdontologo actual = lista.getCabeza();
        while (actual != null) {
            NodoOdontologo menor = actual;
            NodoOdontologo temp = actual.getSiguiente();

            while (temp != null) {
                if (temp.getDato().getEspecialidad().compareToIgnoreCase(menor.getDato().getEspecialidad()) < 0) {
                    menor = temp;
                }
                temp = temp.getSiguiente();
            }

            // Intercambiar
            Odontologo aux = actual.getDato();
            actual.setDato(menor.getDato());
            menor.setDato(aux);

            actual = actual.getSiguiente();
        }
    }
}
