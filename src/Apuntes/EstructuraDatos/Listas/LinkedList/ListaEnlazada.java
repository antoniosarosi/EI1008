package Apuntes.EstructuraDatos.Listas.LinkedList;

import Apuntes.EstructuraDatos.Listas.ListaInt;

public class ListaEnlazada implements ListaInt {

    private Node head;
    private Node last;
    private int size = 0;  // Tamaño o talla

    private static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // CONSTRUCTORES

    public ListaEnlazada() {
        // Crea una lista vacía
        head = null;
    }

    public ListaEnlazada(int data) {
        // Crea una lista de un solo elemento que recibe
        head = new Node(data, null);
        size++;
        last = head;
    }

    public ListaEnlazada(int[] array) {
        // Crea una lista enlazada a partir de un array que recibe
        if (array.length == 0) head = null;
        else for (int i : array) this.append(i);
    }

    // MÉTODOS

    public int length() { return size; }

    private void checkPosition(int posicion) {
    // Este método es auxiliar, solo lo usaremos aquí dentro
        if (size == 0) throw new IndexOutOfBoundsException();
        if (posicion < 0 || posicion >= size) throw new IndexOutOfBoundsException();
    }

    public void append(int data) {
        // Añade un elemento al final de la lista

        // Lista vacía
        if (size == 0) {
            // creamos el head
            head = new Node(data, null);
            // La variable last apunta al head (porque es el único que hay)
            last = head;
        }

        // Lista con elementos
        else {
            // Creamos un nuevo nodo, que irá después del último
            last.next = new Node(data, null);
            // Ahora el último nodo es el nuevo
            last = last.next;
        }
        // Finalmente, aumentamos el size
        size++;
    }

    public void insert(int posicion, int data) {
        // Añade en la posicion dada el elemento dado
        if (size == 0) throw new IndexOutOfBoundsException();
        if (posicion < 0 || posicion > size) throw new IndexOutOfBoundsException();

        if (posicion == 0) {
            head = new Node(data, head);
            size++;
        }
        else if (posicion == size) append(data);
        else {
            Node prev = head;
            for (int i = 0; i < posicion - 1; i++)
                prev = prev.next;

            prev.next = new Node(data, prev.next);
            size++;
        }
    }

    public int get(int posicion) {
        // Devuelve el elemento que hay en la posición que recibe
        checkPosition(posicion);

        if (posicion == 0) return head.data;
        if (posicion == size - 1) return last.data;

        Node current = head;
        for (int i = 0; i < posicion; i++)
            current = current.next;

        return current.data;
    }

    public void set(int posicion, int data) {
        // Actualiza el elemento que hay en la posicón que recibe con el dato que recibe
        checkPosition(posicion);

        if (posicion == 0) head.data = data;
        else if (posicion == size - 1) last.data = data;
        else {
           Node current = head;
           for (int i = 0; i < posicion; i++)
               current = current.next;

           current.data = data;
        }
    }

    public void deleteIndex(int posicion) {
        // Borra el elemento que hay en la posicion que recibe
        checkPosition(posicion);

        // Si la posición es 0 solo cambiamos el head al siguiente Nodo
        if (posicion == 0)
            head = head.next;

        else {
            Node current = head;  // Nodo actual, empezamos en head
            Node prev = null;  // Nodo anterior, el anterior al head no existe así que null

            for (int i = 0; i < posicion; i++) {
                prev = current;
                current = current.next;
            }

            // Si la posicion es la última quitamos el enlace a ella y cambiamos la variable last
           if (posicion == size - 1) {
               prev.next = null;
               last = prev;
           }

           // Si la posicion es una intermedia last se queda igual, pero eliminamos el puntero que había
           else prev.next = current.next;
        } // else

        // Decrementamos la talla
        size--;
    }

    public void clearList() {
        // Borra toda la lista entera
        head = null;
        size = 0;
        last = null;
    }

    public void deleteLast() {
        // Borra el último elemento
        Node current = head;
        while (current.next != last)
            current = current.next;

        last = current;
        current.next = null;
    }

    public boolean delElement(int elemento) {
        // Borra el primer nodo en el que aparece el elemento dado

        for (Node current = head, prev = null; current != null; prev = current, current = current.next) {
            // El bucle es un poco raro, pero actua como un "while nodo actual no sea null".
            // A cada pasada del bucle actualizamos el nodo actual y el nodo anterior.

            if (current.data == elemento) { // Encontrado
                // Elemento que no sea el primero
                if (prev != null) {
                    prev.next = current.next;

                    if (current.next == null) // Si borramos el ultimo hay que actualizar last
                        last = prev;
                }
                // Si el elemento es el primero
                else head = current.next;

                size--;
                return true;
            }
        } // for
        return false;  // Si nunca devolvemos true significa que no hemos encontrado el elemento
    }

    public boolean delAllElements(int elemento) {
        // Borra todas las apariciones de un elemento dado

        boolean deleted = false;
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data == elemento) {  // Encontrado

                // Elemento que no sea el primero
                if (prev != null) {

                    /* Este bucle sirve para ir saltandose elementos si son el mismo. Por ejemplo,
                    * si tenemos [1, 2, 3, 0, 0, 0, 0, 4], entonces este bucle se saltará todos los
                    * ceros y podremos poner el puntero del 3 hacía el 4 del final */
                    while (current.next != null && current.next.data == elemento) {
                        current = current.next;
                        size--;
                    }

                    prev.next = current.next;

                    if (prev.next == null) { // Si borramos el último actualizamos last
                        last = prev;
                        current = null;
                    }
                    else {  // Si borramos uno de en medio solo actualizamos el puntero de prev
                        prev = current.next;
                        current = prev.next;
                    }
                }

                // Si el elemento a borrar es el primero
                else  {
                    head = current.next;  // pasamos el head al siguiente
                    current = head;  // y el current al head
                }

                size--;  // Decremento de size
                deleted = true;
            }

            // No encontrado
            else {
                prev = current;
                current = current.next;
            }
        } // while
        return deleted;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder cadena = new StringBuilder("[");
        cadena.append(head.data);
        for (Node current = head.next; current != null; current = current.next)
            cadena.append(", ").append(current.data);

        return cadena + "]";
    }

}
