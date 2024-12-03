package Modelo;

public class modeloProductos {
private final String nombre;
    private final double precio;
    private final String descripcion;
    private final String codigo;

    // Constructor
    public modeloProductos(String nombre, double precio, String descripcion, String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public modeloProductos() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    // Método toString para representar el producto como una cadena
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }    
}
