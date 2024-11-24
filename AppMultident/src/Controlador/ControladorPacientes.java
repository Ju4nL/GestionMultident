package Controlador;

import Arboles.ArbolPaciente.ArbolPaciente;
import Modelo.Paciente;
import Persistencia.DatosPacientes;
import Vista.VistaAñadirPaciente;
import Vista.VistaGestionPacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class ControladorPacientes implements ActionListener {

    private ArbolPaciente arbolPacientes;
    private VistaGestionPacientes vistaGestionPacientes;
    private VistaAñadirPaciente vistaAñadirPacientes;

    public ControladorPacientes(VistaGestionPacientes vistaGestionPacientes) {
        this.vistaGestionPacientes = vistaGestionPacientes;
        this.arbolPacientes = DatosPacientes.recuperarDeArchivo();
        initComponents();
    }

    private void initComponents() {
        // Asociar botones de la vista principal
        vistaGestionPacientes.getBtnOpcionAñadir().addActionListener(this);
        vistaGestionPacientes.getBtnOpcionEliminar().addActionListener(this);
        vistaGestionPacientes.getBtnBuscar().addActionListener(this);
        vistaGestionPacientes.getBtnOpcionActualizar().addActionListener(this);
        vistaGestionPacientes.getBtnOrdenar().addActionListener(this);

        // Cargar pacientes en la tabla
        cargarTablaPacientes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaGestionPacientes.getBtnOpcionAñadir()) {
            abrirVistaAñadirPaciente();
        } else if (e.getSource() == vistaGestionPacientes.getBtnOpcionEliminar()) {
            eliminarPaciente();
        } else if (e.getSource() == vistaGestionPacientes.getBtnOpcionActualizar()) {
            actualizarPaciente();
        } else if (e.getSource() == vistaGestionPacientes.getBtnBuscar()) {
            buscarPaciente();
        } else if (e.getSource() == vistaGestionPacientes.getBtnOrdenar()) {
            ordenarPacientes();
        }
    }

    // Método para abrir la ventana de añadir paciente
    private void abrirVistaAñadirPaciente() {
        vistaAñadirPacientes = new VistaAñadirPaciente(); // Crear instancia del JFrame de añadir
        vistaAñadirPacientes.setVisible(true); // Mostrar la ventana
        vistaAñadirPacientes.getBtnGuardar().addActionListener(e -> guardarNuevoPaciente()); // Asociar el evento al botón "Guardar"
    }

    // Método para guardar un nuevo paciente
    private void guardarNuevoPaciente() {
        try {
            int id = arbolPacientes.obtenerMaximoId() + 1; // Generar un nuevo ID
            String nombre = vistaAñadirPacientes.getTextoNombre().getText();
            String apellido = vistaAñadirPacientes.getTextoApellido().getText();
            String telefono = vistaAñadirPacientes.getTextoTelefono().getText();
            String email = vistaAñadirPacientes.getTextoEmail().getText();
            String direccion = vistaAñadirPacientes.getTextoDireccion().getText();

            Paciente nuevoPaciente = new Paciente(id, nombre, apellido, telefono, email, direccion);
            arbolPacientes.insertar(nuevoPaciente); // Insertar en el árbol

            guardarLista(); // Guardar en archivo
            cargarTablaPacientes(); // Actualizar tabla
            vistaGestionPacientes.displaySucessMessage("Paciente añadido correctamente.");
            vistaAñadirPacientes.dispose(); // Cerrar la ventana de añadir
        } catch (Exception e) {
            vistaAñadirPacientes.displayErrorMessage("Error: Verifica los datos ingresados.");
        }
    }

    // Método para cargar los datos en la tabla
    private void cargarTablaPacientes() {
        vistaGestionPacientes.limpiarTabla(); // Limpiar la tabla
        arbolPacientes.recorrerInOrder().forEach(paciente -> {
            vistaGestionPacientes.agregarFilaTabla(new Object[]{
                paciente.getIdPaciente(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getTelefono(),
                paciente.getEmail(),
                paciente.getDireccion()
            });
        });
    }

    // Método para actualizar un paciente
    private void actualizarPaciente() {
        try {
            int filaSeleccionada = vistaGestionPacientes.getTablaPacientes().getSelectedRow();
            if (filaSeleccionada == -1) {
                vistaGestionPacientes.displayErrorMessage("Por favor, selecciona un paciente para actualizar.");
                return;
            }

            int id = (int) vistaGestionPacientes.getTablaPacientes().getValueAt(filaSeleccionada, 0);
            Paciente paciente = arbolPacientes.buscar(id);

            if (paciente == null) {
                vistaGestionPacientes.displayErrorMessage("No se encontró el paciente seleccionado.");
                return;
            }

            vistaAñadirPacientes = new VistaAñadirPaciente(); // Mostrar ventana con datos prellenados
            vistaAñadirPacientes.getTextoNombre().setText(paciente.getNombre());
            vistaAñadirPacientes.getTextoApellido().setText(paciente.getApellido());
            vistaAñadirPacientes.getTextoTelefono().setText(paciente.getTelefono());
            vistaAñadirPacientes.getTextoEmail().setText(paciente.getEmail());
            vistaAñadirPacientes.getTextoDireccion().setText(paciente.getDireccion());
            vistaAñadirPacientes.setVisible(true);

            vistaAñadirPacientes.getBtnGuardar().addActionListener(e -> {
                paciente.setNombre(vistaAñadirPacientes.getTextoNombre().getText());
                paciente.setApellido(vistaAñadirPacientes.getTextoApellido().getText());
                paciente.setTelefono(vistaAñadirPacientes.getTextoTelefono().getText());
                paciente.setEmail(vistaAñadirPacientes.getTextoEmail().getText());
                paciente.setDireccion(vistaAñadirPacientes.getTextoDireccion().getText());

                guardarLista(); // Guardar cambios
                cargarTablaPacientes(); // Actualizar la tabla
                vistaGestionPacientes.displaySucessMessage("Paciente actualizado correctamente.");
                vistaAñadirPacientes.dispose();
            });
        } catch (Exception e) {
            vistaGestionPacientes.displayErrorMessage("Error al actualizar el paciente.");
        }
    }

    // Método para eliminar un paciente
    private void eliminarPaciente() {
        try {
            int filaSeleccionada = vistaGestionPacientes.getTablaPacientes().getSelectedRow();
            if (filaSeleccionada == -1) {
                vistaGestionPacientes.displayErrorMessage("Por favor, selecciona un paciente para eliminar.");
                return;
            }

            // Obtener el ID y nombre del paciente seleccionado para mostrar en el mensaje de confirmación
            int id = (int) vistaGestionPacientes.getTablaPacientes().getValueAt(filaSeleccionada, 0);
            String nombre = (String) vistaGestionPacientes.getTablaPacientes().getValueAt(filaSeleccionada, 1);

            // Mostrar cuadro de diálogo de confirmación
            int confirmacion = JOptionPane.showConfirmDialog(
                    vistaGestionPacientes,
                    "¿Estás seguro de eliminar al paciente \"" + nombre + "\" con ID " + id + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            // Si el usuario selecciona "Sí", proceder con la eliminación
            if (confirmacion == JOptionPane.YES_OPTION) {
                arbolPacientes.eliminar(id); // Eliminar del árbol
                guardarLista(); // Guardar cambios
                cargarTablaPacientes(); // Actualizar la tabla
                vistaGestionPacientes.displaySucessMessage("Paciente eliminado correctamente.");
            }
        } catch (Exception e) {
            vistaGestionPacientes.displayErrorMessage("Error al eliminar el paciente.");
        }
    }

    // Método para guardar el árbol en un archivo
    private void guardarLista() {
        DatosPacientes.guardarEnArchivo(arbolPacientes);
    }

    private void buscarPaciente() {
        try {
            String criterioBusqueda = vistaGestionPacientes.getCbxCriterio().getSelectedItem().toString();
            String valorBusqueda = vistaGestionPacientes.getTextoBuscar().getText();

            List<Paciente> resultados = switch (criterioBusqueda) {
                case "ID" -> {
                    Paciente paciente = arbolPacientes.buscar(Integer.parseInt(valorBusqueda));
                    yield paciente != null ? List.of(paciente) : List.of();
                }
                case "Nombre" ->
                    arbolPacientes.recorrerInOrder()
                    .stream()
                    .filter(p -> p.getNombre().equalsIgnoreCase(valorBusqueda))
                    .collect(Collectors.toList());
                case "Apellido" ->
                    arbolPacientes.recorrerInOrder()
                    .stream()
                    .filter(p -> p.getApellido().equalsIgnoreCase(valorBusqueda))
                    .collect(Collectors.toList());
                default ->
                    List.of();
            };

            if (resultados.isEmpty()) {
                vistaGestionPacientes.displayErrorMessage("No se encontraron resultados para la búsqueda.");
            } else {
                mostrarResultadoBusqueda(resultados);
            }
        } catch (Exception e) {
            vistaGestionPacientes.displayErrorMessage("Escriba algo para buscar.");
        }
    }

    private void ordenarPacientes() {
        String criterioOrden = vistaGestionPacientes.getCbxCriterio().getSelectedItem().toString();

        List<Paciente> pacientesOrdenados = switch (criterioOrden) {
            case "ID" ->
                arbolPacientes.recorrerInOrder();
            case "Nombre" ->
                arbolPacientes.recorrerInOrder()
                .stream()
                .sorted((p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()))
                .collect(Collectors.toList());
            case "Apellido" ->
                arbolPacientes.recorrerInOrder()
                .stream()
                .sorted((p1, p2) -> p1.getApellido().compareToIgnoreCase(p2.getApellido()))
                .collect(Collectors.toList());
            default ->
                arbolPacientes.recorrerInOrder();
        };

        mostrarResultadoBusqueda(pacientesOrdenados);
    }

    private void mostrarResultadoBusqueda(List<Paciente> pacientes) {
        vistaGestionPacientes.limpiarTabla();
        pacientes.forEach(paciente -> vistaGestionPacientes.agregarFilaTabla(new Object[]{
            paciente.getIdPaciente(),
            paciente.getNombre(),
            paciente.getApellido(),
            paciente.getTelefono(),
            paciente.getEmail(),
            paciente.getDireccion()
        }));
    }
}
