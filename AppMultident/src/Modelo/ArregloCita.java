/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.SimpleDateFormat;

/**
 *
 * @author USER
 */
public class ArregloCita {

    SimpleDateFormat formato_fecha = new SimpleDateFormat("dd/mm/yyyy");
    SimpleDateFormat formato_hora = new SimpleDateFormat("hh:mm");
    public String[] arregloCita = new String[7];

    public ArregloCita(Cita arc1) {
        arregloCita[0] = arc1.getIdcita();
        arregloCita[1] = arc1.getDni_cliente();
        arregloCita[2] = arc1.getNombre_cliente();
        arregloCita[3] = arc1.getApellido_cliente();
        arregloCita[4] = arc1.getTelefono_cliente();
        arregloCita[5] = formato_fecha.format(arc1.getFecha());
        arregloCita[6] = formato_hora.format(arc1.getHora());
    }
}
