package Colas;

/**
 *
 * @author JUNIOR
 */
import java.util.LinkedList;
import java.util.Queue;
import Modelo.Odontologo;

public class ColaOdontologo {
    // Usamos una Queue para almacenar los odontólogos
    private Queue<Odontologo> cola;

    public ColaOdontologo() {
        cola = new LinkedList<>();
    }

    // Método para agregar un odontólogo a la cola
    public void encolar(Odontologo odontologo) {
        cola.add(odontologo);  // Añadimos el odontólogo al final de la cola
    }

    // Método para quitar un odontólogo de la cola
    public Odontologo desencolar() {
        return cola.poll();  // Retorna y elimina el primer odontólogo de la cola
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return cola.isEmpty();
    }

    // Método para obtener el tamaño de la cola
    public int tamaño() {
        return cola.size();
    }
}
