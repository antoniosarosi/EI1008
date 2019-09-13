package Apuntes.EstructuraDatos.Colas;

import java.util.NoSuchElementException;

public class ColaNodoSimple implements ColaIntegerSimple {

    private static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node first, last;

    // Constructores

    // Cola vacía
    public ColaNodoSimple() { first = last = null; }
    // Cola a partir de un elemento
    public ColaNodoSimple(int e) {first = last = new Node(e, null); }
    // Cola a partir de un array
    public ColaNodoSimple(int[] v) { for (int e : v) add(e); }

    // Metodos

    public void add(int e) {
        // Añade un elemento a la cola
        Node n = new Node(e, null);
        if (isEmpty()) first = last = n;
        else {
            last.next = n;
            last = n;
        }
    }

    public int peek() {
        // Devuelve pero no saca de la cola al primer elemento
        if (isEmpty()) throw new NoSuchElementException();
        return first.data;
    }

    public int poll() {
        // Devuelve y saca de la cola al primer elemento
        if (isEmpty()) throw new NoSuchElementException();
        int e = first.data;
        first = first.next;
        if (first == null) last = null;
        return e;
    }

    public boolean isEmpty() { return first == null; }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder str = new StringBuilder("[" + first.data);
        Node current = first.next;
        while (current != null) {
            str.append(", ").append(current.data);
            current = current.next;
        }
        return str + "]";
    }

}
