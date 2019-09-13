package Apuntes.EstructuraDatos.Colas;

import java.util.NoSuchElementException;

public class ColaNodoDoble implements ColaIntegerDoble {

    private static class Node {
        int data;
        Node next, prev;

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node first, last;

    public ColaNodoDoble() { first = last = null; }

    public ColaNodoDoble(int e) { first = last = new Node(e, null, null); }

    public ColaNodoDoble(int[] v) {
        if (v.length == 0) first = last = null;
        else {
            first = last = new Node(v[0], null, null);
            for (int i = 1; i < v.length; i++) addL(v[i]);
        }
    }

    public void addL(int e) {
        Node n = new Node(e, null, last);
        if (isEmpty()) first = last = n;
        else {
            last.next = n;
            last = n;
        }
    }

    public void  addF(int e) {
        Node n = new Node(e, first, null);
        if (isEmpty()) first = last = n;
        else {
            first.prev = n;
            first = n;
        }
    }

    public int peekL() {
        if (isEmpty()) throw new NoSuchElementException();
        return last.data;
    }

    public int peekF() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.data;
    }

    public int pollL() {
        if (isEmpty()) throw new NoSuchElementException();
        int e = last.data;
        if (first == last) first = last = null;
        else {
            last = last.prev;
            last.next = null;
        }
        return e;
    }

    public int pollF() {
        if (isEmpty()) throw new NoSuchElementException();
        int e = first.data;
        if (first == last) first = last = null;
        else {
            first = first.next;
            first.prev = null;
        }
        return e;
    }

    public boolean isEmpty() { return first == null; }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        String str = "[" + first.data;
        Node current = first.next;
        while (current != null) {
            str += ", " + current.data;
            current = current.next;
        }
        return str + "]";
    }

}
