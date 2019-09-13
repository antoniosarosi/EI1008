package practica3;

public class Diccionario {

    private static class Node {
        String cadena;
        int cantidad;
        Node next;
        Node prev;

        Node(String s, int c, Node next, Node prev) {
            this.cadena = s;
            this.cantidad = c;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return cadena + "-->" + cantidad;
        }
    }

    private Node head;
    private Node last;
    private int size;

    // Constructor por defecto

    public void añadir(String unaCadena, int unaCantidad) {
        if (size == 0) {
            head = last = new Node(unaCadena, unaCantidad, null, null);
            size++;
            return;
        }

        // Buscar si existe
        Node current = head;
        while (current != null) {
            if (current.cadena.equals(unaCadena)) {
                current.cantidad += unaCantidad;
                return;
            }
            current = current.next;
        }

        // No existe
        if (head.cadena.compareTo(unaCadena) > 0) {
            head.prev = new Node(unaCadena, unaCantidad, head, null);
            head = head.prev;
        }
        else if (last.cadena.compareTo(unaCadena) <= 0) {
            last.next = new Node(unaCadena, unaCantidad, null, last);
            last = last.next;
        }
        else {
            Node nuevo = getPosicion(unaCadena);
            nuevo.prev = new Node(unaCadena, unaCantidad, nuevo, nuevo.prev);
            nuevo.prev.prev.next = nuevo.prev;
        }
        size++;
    }

    public String cadenaConMayorCantidad() {
        if (size == 0) return null;
        int max = 0;
        String str = "";
        Node current = head;
        while (current != null) {
            if (current.cantidad >= max) {
                max = current.cantidad;
                str = current.cadena;
            }
            current = current.next;
        }
        return str;
    }

    public int cantidad(String unaCadena) {
        Node n = getNode(unaCadena);
        if (n == null) return 0;
        return n.cantidad;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        if (size == 0) return str.append("}").toString();
        str.append(head.toString());
        Node current = head.next;
        while (current != null) {
            str.append(", ").append(current.toString());
            current = current.next;
        }
        return str.append("}").toString();
    }

    // Metodos privados

    private Node getPosicion(String s) {
        /* Devuelve el nodo que debería contener la cadena dada según el orden lexicográfico.
         * No cubre el caso en el que va primero (antes de head), ni el caso en el que va último
         * (después de last) */
        Node current = head;
        while (current != last && current.cadena.compareTo(s) <= 0)
            current = current.next;
        return current;
    }

    private Node getNode(String s) {
        // Devuelve el nodo que contiene la cadena dada, y null si no existe
        Node current = head;
        while (current != null && ! current.cadena.equals(s))
            current = current.next;
        return current;
    }

}
