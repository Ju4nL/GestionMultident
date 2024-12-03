package Controlador;
/**
 *
 * @author JUNIOR
 */
import Modelo.Tratamiento;
import java.util.ArrayList;
import java.util.List;
import Vista.vistaTratamiento;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ControladorTratamiento {
    
    private vistaTratamiento Vtrata;
    private Tratamiento t;
    private List<Tratamiento> listaTratamientos;
    
    public ControladorTratamiento(vistaTratamiento Vtrata, Tratamiento t) {
        this.Vtrata = Vtrata;
        this.t = t;
    }

    public ControladorTratamiento() {
        this.listaTratamientos = new ArrayList<>();
    }
    public void iniciar(){
    Vtrata.setTitle("RESULTADO MEDICO");
    Vtrata.setLocationRelativeTo(null);
}
    // Método para agregar un tratamiento
    public void agregarTratamiento(String nombreDoc, String telefonoDoc, String correoDoc, String nombreP, String direccionP, String telefonoP, String observaciones, String tratamiento) {
        // Aquí puedes agregar la lógica para almacenar los datos (por ejemplo, en una base de datos o lista)
        
        // Solo como ejemplo, se puede imprimir en consola:
        System.out.println("Tratamiento agregado:");
        System.out.println("Doctor: " + nombreDoc + ", Teléfono: " + telefonoDoc + ", Correo: " + correoDoc);
        System.out.println("Paciente: " + nombreP + ", Dirección: " + direccionP + ", Teléfono: " + telefonoP);
        System.out.println("Observaciones: " + observaciones);
        System.out.println("Tratamiento: " + tratamiento);
    }
        public void guardarEnArchivo(String nombreDoc, String telefonoDoc, String correoDoc, String nombreP, String direccionP, String telefonoP, String observaciones, String tratamiento) {
    String rutaArchivo = "C:\\Users\\JUNIOR\\Documents\\GestionMultident\\AppMultident\\src\\Contenedores\\Tratamiento"; // Nombre del archivo
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
        writer.write("Doctor: " + nombreDoc + "\n");
        writer.write("Teléfono Doctor: " + telefonoDoc + "\n");
        writer.write("Correo Doctor: " + correoDoc + "\n");
        writer.write("Paciente: " + nombreP + "\n");
        writer.write("Dirección Paciente: " + direccionP + "\n");
        writer.write("Teléfono Paciente: " + telefonoP + "\n");
        writer.write("Observaciones: " + observaciones + "\n");
        writer.write("Tratamiento: " + tratamiento + "\n");
        writer.write("----------------------------------------\n");
    } catch (IOException e) {
        System.err.println("Error al guardar los datos en el archivo: " + e.getMessage());
    }    
    }   
    // Método para eliminar un tratamiento por nombre
    public void eliminarTratamiento(String nombre) {
        listaTratamientos.removeIf(t -> t.getNombre().equalsIgnoreCase(nombre));
    }

    // Método para obtener todos los tratamientos
    public List<Tratamiento> obtenerTratamientos() {
        return listaTratamientos;
    }

}
