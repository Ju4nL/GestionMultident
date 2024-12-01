package Controlador;

import Modelo.modeloGestionProductos;
import java.util.ArrayList;
import java.util.List;

public class controladorGestionProductos {
    private final List<modeloGestionProductos> productos;

    // Constructor del controlador
    public controladorGestionProductos() {
        this.productos = new ArrayList<>();
    }

    // Método para agregar un producto
    public void agregarProducto(modeloGestionProductos producto) {
        if (buscarProductoPorCodigo(producto.getCodigo()) == null) {
            productos.add(producto);
            System.out.println("Producto agregado exitosamente: " + producto.getNombre());
        } else {
            System.out.println("Ya existe un producto con el código: " + producto.getCodigo());
        }
    }

    // Método para listar todos los productos
    public List<modeloGestionProductos> listarProductos() {
        return new ArrayList<>(productos); // Devuelve una copia de la lista
    }

    // Método para buscar un producto por su código
    public modeloGestionProductos buscarProductoPorCodigo(String codigo) {
        for (modeloGestionProductos producto : productos) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                return producto;
            }
        }
        return null; // Producto no encontrado
    }

    // Método para actualizar un producto existente
    public void actualizarProducto(String codigo, modeloGestionProductos productoActualizado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                productos.set(i, productoActualizado);
                System.out.println("Producto actualizado: " + productoActualizado.getNombre());
                return;
            }
        }
        System.out.println("Producto con código " + codigo + " no encontrado para actualizar.");
    }

    // Método para eliminar un producto por su código
    public void eliminarProducto(String codigo) {
        if (productos.removeIf(producto -> producto.getCodigo().equalsIgnoreCase(codigo))) {
            System.out.println("Producto con código " + codigo + " eliminado.");
        } else {
            System.out.println("Producto con código " + codigo + " no encontrado para eliminar.");
        }
    }
}

