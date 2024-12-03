package Modelo;

public class modeloGestionProductos {
    private String nombre;
    private double precio;
    private String descripcion;
    private String codigo;

    // Constructor completo
    public modeloGestionProductos(String nombre, double precio, String descripcion, String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    // Constructor vacío (opcional, útil para ciertas operaciones)
    public modeloGestionProductos() {
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Método toString para representar el producto como texto
    @Override
    public String toString() {
        return "Producto: " + nombre +
               ", Precio: $" + precio +
               ", Descripción: " + descripcion +
               ", Código: " + codigo;
    }

    // Método para comparar dos productos por su código
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        modeloGestionProductos that = (modeloGestionProductos) obj;
        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
