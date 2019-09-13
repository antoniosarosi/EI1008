package Apuntes.EstructuraDatos.Listas.LinkedList;

import Apuntes.EstructuraDatos.Listas.ListaInt;

public class DoublyLinkedList  implements ListaInt {

    private static class Node {
        int data;
        Node next, prev;
        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // Atributos
    private Node head;
    private Node last;
    private int length;

    // Constructores

    public DoublyLinkedList() {
        head = last = null;
        length = 0;
    }

    public DoublyLinkedList(int data) {
        head = last = new Node(data, null, null);
        length = 1;
    }

    public DoublyLinkedList(int[] v) {
        if (v.length == 0) head = last = null;
        else for (int i : v) append(i);
    }

    // Métodos Públicos

    @Override
    public int length() { return length; }

    @Override
    public void append(int data) {
        if (length == 0) head = last = new Node(data, null, null);
        else {
            last.next = new Node(data, null, last);
            last = last.next;
        }
        length++;
    }

    @Override
    public void insert(int posicion, int data) {
        if (length == 0) throw new IndexOutOfBoundsException();
        if (posicion < 0 || posicion > length) throw new IndexOutOfBoundsException();
        // Insertar según la posición
        if (posicion == 0) {
            head = new Node(data, head, null);
            length++;
        }
        else if (posicion == length) append(data);
        else {
            Node node = optimizedNodeIterator(posicion);
            node.prev = new Node(data, node, node.prev);
            node.prev.prev.next = node.prev;
            length++;
        }
    }

    @Override
    public int get(int posicion) {
        checkPosition(posicion);
        Node node = optimizedNodeIterator(posicion);
        return node.data;
    }

    @Override
    public void set(int posicion, int data) {
        checkPosition(posicion);
        Node node = optimizedNodeIterator(posicion);
        node.data = data;
    }

    @Override
    public void deleteIndex(int posicion) {
        checkPosition(posicion);
        if (posicion == 0){
            head = head.next;
            head.prev = null;
        }
        else if (posicion == length - 1) {
            last = last.prev;
            last.next = null;
        }
        else {
            Node node = optimizedNodeIterator(posicion);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        length--;
    }

    @Override
    public void clearList() {
        head = last = null;
        length = 0;
    }

    @Override
    public void deleteLast() {
        last = last.prev;
        last.next = null;
    }

    @Override
    public boolean delElement(int elemento) {
        Node current = head;
        while(current.data != elemento) {
            current = current.next;
            if (current == null) return false;
        }

        if (current == head) {
            head = head.next;
            head.prev = null;
            length--;
            return true;
        }
        if (current == last) {
            last = last.prev;
            last.next = null;
            length--;
            return true;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        length--;
        return true;
    }

    @Override
    public boolean delAllElements(int elemento) {
        boolean deleted = false;
        Node current = head;
        while (current != null) {
            if (current.data == elemento) {
                deleted = true;
                if (current == head) {
                    head = head.next;
                    head.prev = null;
                }
                else if (current == last) {
                    last = last.prev;
                    last.next = null;
                }
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                length--;
            }
            current = current.next;
        }
        return deleted;
    }

    @Override
    public String toString() {
        if (length == 0) return "[]";
        StringBuilder cadena = new StringBuilder("[");
        cadena.append(head.data);
        for (Node current = head.next; current != null; current = current.next)
            cadena.append(", ").append(current.data);

        return cadena + "]";
    }

    // Métodos Privados

    private void checkPosition(int posicion) {
        if (length == 0) throw new IndexOutOfBoundsException();
        if (posicion < 0 || posicion >= length) throw new IndexOutOfBoundsException();
    }

    private Node optimizedNodeIterator(int posicion) {
        if (posicion <= length / 2) {
            Node prev = head;
            for (int i = 0; i < posicion; i++) prev = prev.next;
            return prev;
        }
        else {
            Node next = last;
            for (int i = 1; i < length - posicion; i++) next = next.prev;
            return next;
        }
    }

}
