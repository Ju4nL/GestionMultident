/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasSimples;

import java.util.ArrayList;
import 
/**
 *
 * @author USER
 */
public class ListaHistorialDatos {
    
    private ArrayList<String> elementos;

    // Constructor
    public ListaHistorialDatos() {
        this.elementos = new ArrayList<>();
    }

    // Método para agregar un elemento a la lista
    public void agregar(String elemento) {
        elementos.add(elemento);
        System.out.println("Elemento agregado: " + elemento);
    }
    
    // Método para eliminar un elemento de la lista
    public boolean eliminar(String elemento) {
        if (elementos.contains(elemento)) {
            elementos.remove(elemento);
            System.out.println("Elemento eliminado: " + elemento);
            return true;
        } else {
            System.out.println("El elemento no existe en la lista.");
            return false;
        }
    }

    // Método para imprimir todos los elementos de la lista
    public void imprimir() {
        if (elementos.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("Elementos en la lista:");
            for (T elemento : elementos) {
                System.out.println("- " + elemento);
            }
        }
    }

    // Método para obtener el tamaño de la lista
    public int tamaño() {
        return elementos.size();
    }

    // Método para obtener un elemento por índice
    public T obtener(int indice) {
        if (indice >= 0 && indice < elementos.size()) {
            return elementos.get(indice);
        } else {
            System.out.println("Índice fuera de rango.");
            return null;
        }
    }
}

