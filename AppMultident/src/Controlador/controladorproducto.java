package controlador;

import modelo.Modelo; // Asegúrate de que la clase Modelo esté en el paquete correcto
import java.util.ArrayList;
import java.util.List;
import vista.Vista;

public class ControladorProducto {
    private final List<Modelo> productos;

    public ControladorProducto(Vista view, Modelo mod) {
        this.productos = new ArrayList<>();
    }

    public static void main(String[] args) {
        // Crear instancias de Vista y Modelo
        Vista view = new Vista(); // Asegúrate de que la clase Vista esté correctamente definida
        Modelo mod = new Modelo(); // Asegúrate de que la clase Modelo tenga un constructor sin parámetros

        ControladorProducto controlador = new ControladorProducto(view, mod);

        // Crear productos
        Modelo producto1 = new Modelo("hilo dental", 15.00, "fibra de 3 metros", "HD001");
        Modelo producto2 = new Modelo("Cepillo electrico", 45.00, "bateria recargable", "CE002");

        // Agregar productos
        controlador.agregarProducto(producto1);
        controlador.agregarProducto(producto2);

        // Listar productos
        System.out.println("Lista de productos:");
        for (Modelo producto : controlador.listarProductos()) {
            System.out.println(producto);
        }

        // Buscar producto
        Modelo buscado = controlador.buscarProductoPorCodigo("HD001");
        if (buscado != null) {
            System.out.println("Producto encontrado: " + buscado);
        } else {
            System.out.println("Producto no encontrado.");
        }

        // Actualizar producto
        Modelo productoActualizado = new Modelo("HilO dental", 23.00, "fibra delgada de 5 metros", "HD001");
        controlador.actualizarProducto("HD001", productoActualizado); // Cambié "P001" a "HD001"

        // Eliminar producto
        controlador.eliminarProducto("CE002"); // Cambié "P002" a "CE002"

        // Listar productos después de modificaciones
        System.out.println("Lista de productos actualizada:");
        for (Modelo producto : controlador.listarProductos()) {
            System.out.println(producto);
        }
    }

    private void agregarProducto(Modelo producto) {
        productos.add(producto);
    }

    private List<Modelo> listarProductos() {
        return productos;
    }

    private void actualizarProducto(String codigo, Modelo productoActualizado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigo)) {
                productos.set(i, productoActualizado);
                return;
            }
        }
        System.out.println("Producto con código " + codigo + " no encontrado para actualizar.");
    }

    private Modelo buscarProductoPorCodigo(String codigo) {
        for (Modelo producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null; // Producto no encontrado
    }

    private void eliminarProducto(String codigo) {
        productos.removeIf(producto -> producto.getCodigo().equals(codigo));
    }

    public void iniciar() {
        // Implementar lógica de inicio si es necesario
    }
}
