package Apuntes.EstructuraDatos.Stacks;

import java.util.EmptyStackException;

public class StackNodes implements IntegerStack {

    private static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;

    public StackNodes() {
        top = null;
    }

    public StackNodes(int data) {
        top = new Node(data, null);
    }

    public StackNodes(int[] v) {
        top = null;
        for (int i : v) push(i);
    }

    public void push(int elemento) { top = new Node(elemento, top); }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        int elemento = top.data;
        top = top.next;
        return elemento;
    }

    public int top() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() { return top == null; }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (isEmpty()) return str + "]";
        str.append(top.data);
        Node i = top.next;
        while (i != null) {
            str.append(", ").append(i.data);
            i = i.next;
        }
        return str + "]";
    }

}
