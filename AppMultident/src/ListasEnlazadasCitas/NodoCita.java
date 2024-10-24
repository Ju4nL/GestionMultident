/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasEnlazadasCitas;

import Modelo.ArregloCita;
import Modelo.Cita;

/**
 *
 * @author USER
 */
public class NodoCita {
    public ArregloCita c1;
    public NodoCita siguiente;
    public NodoCita (ArregloCita e){
        this.c1 = e;
        this.siguiente = null;
        
    }
    
    
}
