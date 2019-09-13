package practica2.Ej10;

import practica2.ExcepcionFechaInvalida;
import practica2.Fecha;
import practica2.Tarea;

public class Agenda {

    // Atributos
    private Tarea[] tareas;  // array que contendrá las tareas
    private int cantidadTareas;  // número de tareas ocupando el array

    // Constructores
    public Agenda() {
        /* En los métodos usaremos frecuentemente cantidadTareas como length para recorrer el vector tareas,
           pero esto no es su length real (capacidad), aunque en ciertos momentos pueden coincidir */
        cantidadTareas = 0;
        tareas = new Tarea[10];  // Capacidad inicial de 10
    }

    // Métodos

    public void añadir(Tarea tarea) {

        switch (cantidadTareas) {

            // Si no hay tareas
            case 0: tareas[0] = tarea; break;

            // Si solo hay una tarea
            case 1:
                if (tarea.getFecha().compareTo(tareas[0].getFecha()) >= 0)
                    tareas[1] = tarea;
                else {
                    tareas[1] = tareas[0];
                    tareas[0] = tarea;
                }
                break;

            // Si hay varias tareas
            default:
                ajustarCapacidad(1);

                // La tarea va primera
                if (tarea.getFecha().compareTo(tareas[0].getFecha()) < 0) {
                    desplazarDerecha(0);
                    tareas[0] = tarea;
                }

                // La tarea va última
                else if (tarea.getFecha().compareTo(tareas[cantidadTareas - 1].getFecha()) >= 0)
                    tareas[cantidadTareas] = tarea;

                // La tarea está comprendida entre las existentes
                else {
                    int posicionDondeAñadir = 0;
                    for (int i = 0; i < cantidadTareas - 1; i++) {
                        int Anterior = tarea.getFecha().compareTo(tareas[i].getFecha());
                        int Posterior = tarea.getFecha().compareTo(tareas[i + 1].getFecha());

                        // Tiene que ser mayor o igual que la fecha anterior y menor que la posterior
                        if (Anterior >= 0 && Posterior < 0) {
                            posicionDondeAñadir = i + 1;
                            break;
                        }
                    } // for
                    desplazarDerecha(posicionDondeAñadir);
                    tareas[posicionDondeAñadir] = tarea;
                } // else
            } // switch

        cantidadTareas++;
    }

    public int cantidad() { return cantidadTareas; }

    public Tarea[] consultar(Fecha fecha) {
        int tamaño = 0;
        for (int i = 0; i < cantidadTareas; i++)
            if (tareas[i].getFecha().compareTo(fecha) == 0)
                tamaño++;

        Tarea[] vectorTareas = new Tarea[tamaño];
        for (int i = 0, j = 0; j < cantidadTareas; j++)
            if (tareas[j].getFecha().compareTo(fecha) == 0) {
                vectorTareas[i] = tareas[j];
                i++;
            }

        return vectorTareas;
    }

    public void borrarPasadas(Fecha fecha) {

        // Comprobamos si hay que borrar todas la tareas
        if (tareas[cantidadTareas - 1].getFecha().compareTo(fecha) < 0) {
            tareas = new Tarea[10];
            cantidadTareas = 0;
        }

        // Comprobar que no hay que borrar ninguna tarea
        else if (tareas[0].getFecha().compareTo(fecha) >= 0); // No hacer nada

        else {
            int cantidadBorrada = 0, borrarHasta = 0;
            for (int i = 0; i < cantidadTareas; i++) {
                if (tareas[i].getFecha().compareTo(fecha) >= 0) {
                    borrarHasta = i;
                    break;
                }
                cantidadBorrada--;
            } // for
            desplazarIzquierda(borrarHasta);
            ajustarCapacidad(cantidadBorrada);
            cantidadTareas += cantidadBorrada;
        } // else
    }

    public void borrar() throws ExcepcionFechaInvalida { borrarPasadas(Fecha.hoy()); }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < cantidadTareas; i++)
            cadena += tareas[i] + "\n";

        // Con esto podemos ver cómo va variando el length del vector según se añaden o eliminan tareas
//        cadena += "\n\t" + "El vector tareas tiene el siguiente length: " + tareas.length + "\n";
        return cadena;
    }

    // Metodos Auxiliares

    private void desplazarDerecha(int posicionDesdeDondeDesplazar) {
        // Lo usamos para poder añadir tareas
        for (int i = cantidadTareas -  1; i >= posicionDesdeDondeDesplazar; i--)
            tareas[i + 1] = tareas[i];
    }

    private void desplazarIzquierda(int posicionDesdeDondeDesplazar) {
        // Lo usamos para poder borrar tareas
        for (int i = 0, j = posicionDesdeDondeDesplazar; j < cantidadTareas; i++, j++)
            tareas[i] = tareas[j];

        int posicionDesdeDondePonerNulls = cantidadTareas - posicionDesdeDondeDesplazar;

        // Eliminamos explícitamente las tareas que han quedado como copias innecesarias
        for (int i = posicionDesdeDondePonerNulls; i < cantidadTareas; i++)
            tareas[i] = null;
    }

    private void ajustarCapacidad(int numElementos) {
        // Ajusta el length del vector tareas en funcion del número de elementos que entran o salen
        // Si los elementos salen (porque se borran) numElementos debe ser negativo

        Tarea[] nuevoTareas = new Tarea[0];

        // Duplicar capacidad
        if (cantidadTareas + numElementos > tareas.length)
            nuevoTareas = new Tarea[tareas.length * 2];

        /* Reducir a la mitad (tomamos en cuenta que de una sola vez se hayan borrado
           tantas tareas como para tener que reducirla aún más */
        else if (tareas.length / 2 >= 10)
            if (cantidadTareas + numElementos <= tareas.length / 4) {
                nuevoTareas = new Tarea[tareas.length];
                do nuevoTareas = new Tarea[nuevoTareas.length / 2];
                    while (cantidadTareas + numElementos <= nuevoTareas.length / 4 && nuevoTareas.length >= 20);
            }

        if (nuevoTareas.length != 0) {
            for (int i = 0; i < cantidadTareas && tareas[i] != null; i++)
                nuevoTareas[i] = tareas[i];

            tareas = nuevoTareas;
        }
    }

}
