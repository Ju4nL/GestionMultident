package modelo;

public class Tratamiento {
    private String nombre;
    private double costo;
    private String descripcion;
    

    public Tratamiento(String nombre, double costo, String descripcion) {
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
