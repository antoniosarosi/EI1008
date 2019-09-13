package practica2.Ej09;

import practica2.ExcepcionFechaInvalida;
import practica2.Fecha;
import practica2.Tarea;

public class Agenda {

    // Atributos
    private Tarea[] tareas;

    // Constructores
    public Agenda() { tareas = new Tarea[0]; }

    // Métodos
    public void añadir(Tarea tarea) {

        Tarea[] nuevo;

        // Si no hay tareas
        if (tareas.length == 0) {
            nuevo = new Tarea[1];
            nuevo[0] = tarea;
            tareas = nuevo;
        }

        // Si hay tareas
        else {
            int posicionDondeAñadir = 0;

            // Último elemento
            if (tareas[tareas.length - 1].getFecha().compareTo(tarea.getFecha()) <= 0)
                posicionDondeAñadir = tareas.length;

            // Primer elemento
            else if (tareas[0].getFecha().compareTo(tarea.getFecha()) > 0)
                posicionDondeAñadir = 0;

            // Comprobamos todos los elementos restantes
            else {
                for (int i = 0; i < tareas.length - 1; i++) {
                    int comparacionConAnterior = tareas[i].getFecha().compareTo(tarea.getFecha());
                    int comparacionConPosterior = tareas[i + 1].getFecha().compareTo(tarea.getFecha());

                    // Tiene que ser mayor que la fecha anterior y menor que la posterior
                    if (comparacionConAnterior <= 0 && comparacionConPosterior > 0) {
                        posicionDondeAñadir = i + 1;
                        break;
                    }
                }
            }

            nuevo = new Tarea[tareas.length + 1];
            // añadimos la tarea dada
            nuevo[posicionDondeAñadir] = tarea;

            // añadimos el resto de elementos
            int i = 0, j = 0;
            while (j < tareas.length) {
                if (i == posicionDondeAñadir) i++;
                else {
                    nuevo[i] = tareas[j];
                    i++; j++;
                }
            }

            // referenciamos el vector tareas al nuevo vector
            tareas = nuevo;
        }
    }

    public int cantidad() { return tareas.length; }

    public Tarea[] consultar(Fecha fecha) {

        int tamaño = 0;

        for (Tarea t : tareas)
            if (t.getFecha().compareTo(fecha) == 0)
                tamaño++;

        Tarea[] vectorTareas = new Tarea[tamaño];

        int i = 0;
        for (Tarea t : tareas)
            if (t.getFecha().compareTo(fecha) == 0) {
                vectorTareas[i] = t;
                i++;
            }

        return vectorTareas;
    }

    public void borrarPasadas(Fecha fecha) {

        int borrarHasta = 0;

        for (int i = 0; i < tareas.length; i++)
            if (tareas[i].getFecha().compareTo(fecha) >= 0) {
                borrarHasta = i;
                break;
            }

        Tarea[] nuevo = new Tarea[tareas.length - borrarHasta];

        for (int i = 0, j = borrarHasta; i < nuevo.length; i++, j++)
            nuevo[i] = tareas[j];

        tareas = nuevo;
    }

    public void borrar() throws ExcepcionFechaInvalida {
        borrarPasadas(Fecha.hoy());
    }

    public String toString() {
        String cadena = "";
        for (Tarea t : tareas)
            cadena += t.toString() + "\n";

        return cadena;
    }
}
