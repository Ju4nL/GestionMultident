package Modelo;
/**
 *
 * @author JUNIOR
 */
public class Tratamiento {
    private String nombreDoc;
    private String telefonoDoc;
    private String correoDoc;
    private String nombreP;
    private String direccionP;
    private String nombre;
    private double costo;
    private String observaciones;
    

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getTelefonoDoc() {
        return telefonoDoc;
    }

    public void setTelefonoDoc(String telefonoDoc) {
        this.telefonoDoc = telefonoDoc;
    }

    public String getCorreoDoc() {
        return correoDoc;
    }

    public void setCorreoDoc(String correoDoc) {
        this.correoDoc = correoDoc;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDireccionP() {
        return direccionP;
    }

    public void setDireccionP(String direccionP) {
        this.direccionP = direccionP;
    }

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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    
    @Override
    public String toString() {
        return "Tratamiento{" +
                "nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
