/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Busquedas;
import ListasEnlazadas.ListasEnlazadasOdontologo.ListaEnlazadaOdontologos;
import ListasEnlazadas.ListasEnlazadasOdontologo.NodoOdontologo;
import Modelo.Odontologo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LOZADA
 */ 

public class BusquedaOdontologos {

    // **1. Búsqueda Lineal por Nombre**
    public static Odontologo buscarPorNombreLineal(ListaEnlazadaOdontologos lista, String nombre) {
        NodoOdontologo temp = lista.getCabeza();
        while (temp != null) {
            if (temp.getDato().getNombre().equalsIgnoreCase(nombre)) {
                return temp.getDato();
            }
            temp = temp.getSiguiente();
        }
        return null; // No encontrado
    }

    // **2. Búsqueda Binaria por ID (lista debe estar ordenada)**
    public static Odontologo buscarPorIdBinaria(ListaEnlazadaOdontologos lista, int id) {
        var listaArray = lista.obtenerTodos();
        int inicio = 0, fin = listaArray.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Odontologo odontologoMedio = listaArray.get(medio);

            if (odontologoMedio.getIdOdontologo() == id) {
                return odontologoMedio;
            } else if (odontologoMedio.getIdOdontologo() < id) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return null; // No encontrado
    }
    
    // **3. Búsqueda Lineal por Especialidad**
    public static List<Odontologo> buscarPorEspecialidad(ListaEnlazadaOdontologos lista, String especialidad) {
        List<Odontologo> resultados = new ArrayList<>();
        NodoOdontologo temp = lista.getCabeza();
        while (temp != null) {
            if (temp.getDato().getEspecialidad().equalsIgnoreCase(especialidad)) {
                resultados.add(temp.getDato());
            }
            temp = temp.getSiguiente();
        }
        return resultados; // Devuelve todos los odontólogos con la especialidad
    }
}

