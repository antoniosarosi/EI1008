package Examenes.Junio2017.Ejercicio2;

import practica2.ExcepcionFechaInvalida;
import practica2.Fecha;

import java.util.NoSuchElementException;

public class Almacén {

    private static class Nodo {
        Producto producto;
        Nodo siguiente;
        Nodo(Producto producto, Nodo siguiente) {
            this.producto = producto;
            this.siguiente = siguiente;
        }
    }

    private Nodo primero;

    // Constructor (por defecto)

    public boolean añadirProducto(String código, int cantidad) throws ExcepcionFechaInvalida {

        // Si la lista está vacía hay que iniciar el primer Nodo
        if (primero == null) {
            primero = new Nodo(new Producto(código, cantidad, Fecha.hoy()), null);
            return true;
        }
        // Si no está vacía actualizamos el Nodo correspondiente o añadimos el nuevo al final de la lista
        Nodo anterior = primero;
        Nodo actual = primero;
        while (actual != null) {
            if (actual.producto.getCódigo().equals(código)) {
                actual.producto.setCantidad(actual.producto.getCantidad() + cantidad);
                actual.producto.setÚltimaFecha(Fecha.hoy());
                return false;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        anterior.siguiente = new Nodo(new Producto(código, cantidad, Fecha.hoy()), null);
        return true;
    }

    public int venderProducto(String código, int cantidad) throws ExcepcionFechaInvalida {
        Nodo anterior = primero;
        Nodo actual = primero;
        while (actual != null) {
            if (actual.producto.getCódigo().equals(código)) {
                if (actual.producto.getCantidad() - cantidad > 0) {
                    actual.producto.setCantidad(actual.producto.getCantidad() - cantidad);
                    actual.producto.setÚltimaFecha(Fecha.hoy());
                    return cantidad;
                }
                else {
                    if (actual == primero)
                        primero = primero.siguiente;
                    else
                        anterior.siguiente = actual.siguiente;
                    return actual.producto.getCantidad();
                }
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        throw new NoSuchElementException();
    }

    public int eliminarObsoletos(Fecha fecha) {
        // Recorre solo una vez la lista, O(n)

        int borrados = 0; // cantidad de nodos eliminados

        // Por si al principio tenemos que borrar uno o varios
        while (primero != null && primero.producto.getÚltimaFecha().compareTo(fecha) < 0) {
            primero = primero.siguiente;
            borrados++;
        }
        // Por si acaso se han borrado todos
        if (primero == null)
            return borrados;

        Nodo anterior = primero;
        Nodo actual = primero.siguiente;
        while (actual != null) {
            if (actual.producto.getÚltimaFecha().compareTo(fecha) < 0) {
                do {
                    actual = actual.siguiente;
                    borrados++;
                    // Esto es otra vez por si hay que borrar más de uno seguido
                } while (actual != null && actual.producto.getÚltimaFecha().compareTo(fecha) < 0);
                anterior.siguiente = actual;
                // Y esto otra vez por si se han borrado todos
                if (actual == null)
                    return borrados;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return borrados;
    }
}
