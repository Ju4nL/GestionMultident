package Controlador;

/**
 *
 * @author JUNIOR
 */
import Modelo.MovimientoInventario;
import Modelo.RegistroInventario;
import Vista.VistaRegistroInventario;

import java.util.Scanner;

public class ControladorRegistroInventario {
    private RegistroInventario registro;
    private VistaRegistroInventario vista;
    private Scanner scanner;

    public ControladorRegistroInventario(RegistroInventario registro, VistaRegistroInventario vista) {
        this.registro = registro;
        this.vista = vista;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        String continuar;
        do {
            vista.mostrarMensaje("Ingrese el nombre del producto: ");
            String producto = scanner.nextLine();

            vista.mostrarMensaje("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            vista.mostrarMensaje("Ingrese el tipo de movimiento (entrada/salida): ");
            String tipoMovimiento = scanner.nextLine();

            MovimientoInventario movimiento = new MovimientoInventario(producto, cantidad, tipoMovimiento);
            registro.agregarMovimiento(movimiento);

            vista.mostrarMensaje("¿Desea agregar otro movimiento? (si/no): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("si"));

        vista.mostrarMovimientos(registro.getMovimientos());
    }
}