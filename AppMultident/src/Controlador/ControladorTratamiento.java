package controlador;

import modelo.Tratamiento;
import java.util.ArrayList;
import java.util.List;

public class ControladorTratamiento {
    private List<Tratamiento> tratamientos;

    public ControladorTratamiento() {
        tratamientos = new ArrayList<>();
    }

    public void agregarTratamiento(Tratamiento tratamiento) {
        tratamientos.add(tratamiento);
    }

    public List<Tratamiento> obtenerTratamientos() {
        return tratamientos;
    }

    public Tratamiento buscarTratamiento(String nombre) {
        for (Tratamiento t : tratamientos) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                return t;
            }
        }
        return null; // Si no se encuentra
    }

    public void eliminarTratamiento(String nombre) {
        tratamientos.removeIf(t -> t.getNombre().equalsIgnoreCase(nombre));
    }
}
