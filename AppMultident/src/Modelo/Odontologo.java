package Modelo;

public class Odontologo {
    private int idOdontologo;
    private String nombre;
    private String especialidad;
    private String telefono;
    private String email;
    private String numeroColegiatura;
    public static final String FILE_PATH = "src/Contenedores/Odontologos.txt";
    // Constructor
    public Odontologo(){}
    
    public Odontologo(int idOdontologo, String nombre, String especialidad, String telefono, String email, String numeroColegiatura) {
        this.idOdontologo = idOdontologo;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
        this.numeroColegiatura = numeroColegiatura;
    }

    // Getters y Setters
    public int getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(int idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public void setNumeroColegiatura(String numeroColegiatura) {
        this.numeroColegiatura = numeroColegiatura;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "idOdontologo=" + idOdontologo +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", numeroColegiatura='" + numeroColegiatura + '\'' +
                '}';
    }
}