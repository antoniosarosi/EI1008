package practica3;

import practica2.ExcepcionFechaInvalida;
import practica2.Fecha;
import practica2.Tarea;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

public class Agenda {

    private List<Tarea> tareas = new ArrayList<>();

    // Constructor por defecto

    public void añadir(Tarea tarea) {
        if (tareas.size() == 0)
            tareas.add(tarea);
        else {
            if (tarea.getFecha().compareTo(tareas.get(tareas.size() - 1).getFecha()) >= 0)
                tareas.add(tarea);
            else {
                int posicion = 0;
                for (Tarea t : tareas) {
                    if (t.getFecha().compareTo(tarea.getFecha()) > 0) {
                        tareas.add(posicion, tarea);
                        return;
                    }
                    posicion++;
                }
            }
        }

    }

    public int cantidad() { return tareas.size(); }

    public Tarea[] consultar(Fecha fecha) {
        int toIndex = 0, tamaño = 0, posicion = 0;
        for (Tarea t : tareas) {
            if (t.getFecha().compareTo(fecha) == 0) {
                toIndex = posicion + 1;
                tamaño++;
            }
            else if (t.getFecha().compareTo(fecha) > 0)
                break;

            posicion++;
        }
        return tareas.subList(toIndex - tamaño, toIndex).toArray(new Tarea[tamaño]);
    }

    public void borrarPasadas(Fecha fecha) {

        // Hay que borrar todas
        if (tareas.get(tareas.size() - 1).getFecha().compareTo(fecha) < 0) {
            tareas.clear();
            return;
        }

        // Otro caso
        int posicion = 0;
        for (Tarea t : tareas) {
            if (t.getFecha().compareTo(fecha) >= 0) {
                tareas = tareas.subList(posicion, tareas.size());
                return;
            }
            posicion++;
        }
    }

    public void borrar() throws ExcepcionFechaInvalida {
        borrarPasadas(Fecha.hoy());
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        for (Tarea t : tareas)
            cadena.append(t.toString()).append("\n");

        return cadena.toString();
    }
}
