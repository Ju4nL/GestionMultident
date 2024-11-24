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
        arregloCita[0] = String.valueOf(arc1.getIdCita());
        arregloCita[1] = String.valueOf(arc1.getPaciente().getNombre());
        arregloCita[2] = String.valueOf(arc1.getOdontologo().getNombre());
        arregloCita[3] = arc1.getEstado();
        arregloCita[4] = String.valueOf(formato_fecha.format(arc1.getFecha()));
        arregloCita[5] = String.valueOf(formato_fecha.format(arc1.getHora()));
    }
}
