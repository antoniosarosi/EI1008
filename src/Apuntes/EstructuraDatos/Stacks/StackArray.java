package Apuntes.EstructuraDatos.Stacks;

import Apuntes.EstructuraDatos.Listas.ArrayList.ListaArray;
import java.util.EmptyStackException;

public class StackArray implements IntegerStack {

    private ListaArray stack;  // simplemente usamos array list, que hace todo el trabajo

    // Constructores

    // Pila vacía
    public StackArray() { stack = new ListaArray(); }
    // Pila a partir de un elemento
    public StackArray(int data) { stack = new ListaArray(data); }
    // Pila a partir de array
    public StackArray(int[] v) { stack = new ListaArray(v); }

    // Metodos

    public void push(int data) { stack.append(data); }

    public int pop() {
        int e = stack.get(stack.length() - 1);
        stack.deleteLast();
        return e;
    }

    public int top() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.get(stack.length() - 1);
    }

    public boolean isEmpty() { return stack.length() == 0; }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder str = new StringBuilder("[" + stack.get(stack.length() - 1));
        for (int i = stack.length() - 2; i >= 0; i--) str.append(", ").append(stack.get(i));
        return str + "]";
    }

}
