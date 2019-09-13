package tests.practica3;

//
// Para que este programa de prueba funcione correctamente es importante que
// los métodos toString() de las clases ListaCadenasEnlaceSimple y ListaCadenasEnlaceDoble
// usen el formato indicado en el enunciado, es decir:
//   [] para una lista vacía y
//   [cadena, cadena, ..., cadena] para una lista no vacía
//

import practica3.ListaCadenas;
import practica3.ListaCadenasEnlaceSimple;

public class ListaCadenasPrueba {

    public static void main(String[] args) {
        ListaCadenas lista = new ListaCadenasEnlaceSimple();

        // Debes probar también:
        // ListaCadenas lista = new ListaCadenasEnlaceDoble();

        System.out.println("\nContenido de la lista: " + lista + " (" + lista.size() + " elementos).");
        System.out.println("--> Probamos add(String):");
        lista.add("A1");
        comprueba(lista, "[A1]");

        lista.add("B1");
        comprueba(lista, "[A1, B1]");

        lista.add("C3");
        comprueba(lista, "[A1, B1, C3]");

        System.out.println("--> Probamos add(int, String):");
        lista.add(1, "A2");
        comprueba(lista, "[A1, A2, B1, C3]");

        lista.add(0, "A0");
        comprueba(lista, "[A0, A1, A2, B1, C3]");

        lista.add(5, "D4");
        comprueba(lista, "[A0, A1, A2, B1, C3, D4]");

        System.out.println("\nContenido de la lista: " + lista + " (" + lista.size() + " elementos).");
        System.out.println("--> Probamos isEmpty() y remove(int):");
        while (!lista.isEmpty()) {
            String dato = lista.remove(0);
            System.out.println("Elemento borrado en la posición 0: " + dato);
        }
        comprueba(lista, "[]");

        lista.add("A1");
        lista.add("B1");
        lista.add("C3");
        lista.add(1, "A2");
        lista.add(0, "A0");
        lista.add(5, "D4");

        System.out.println("\nContenido de la lista: " + lista + " (" + lista.size() + " elementos).");
        System.out.println("--> Probamos set(int, String):");
        lista.set(1, "E1");
        comprueba(lista, "[A0, E1, A2, B1, C3, D4]");

        lista.set(5, "E2");
        comprueba(lista, "[A0, E1, A2, B1, C3, E2]");

        System.out.println("\nContenido de la lista: " + lista + " (" + lista.size() + " elementos).");
        System.out.println("--> Probamos indexOf(String) y get(int):");
        int índice = lista.indexOf("A0");
        System.out.println("Indice de A0: " + índice);
        System.out.println("Elemento en la posición " + índice + ": " + lista.get(índice));

        índice = lista.indexOf("A2");
        System.out.println("Indice de A2: " + índice);
        System.out.println("Elemento en la posición " + índice + ": " + lista.get(índice));

        índice = lista.indexOf("E2");
        System.out.println("Indice de E2: " + índice);
        System.out.println("Elemento en la posición " + índice + ": " + lista.get(índice));

        System.out.println("\nContenido de la lista: " + lista + " (" + lista.size() + " elementos).");
        System.out.println("--> Probamos remove(int):");
        String dato = lista.remove(5);
        comprueba(lista, "[A0, E1, A2, B1, C3]");
        System.out.println("Elemento borrado en la posición 5: " + dato + ". Nuevo contenido de la lista: " + lista);

        dato = lista.remove(3);
        comprueba(lista, "[A0, E1, A2, C3]");
        System.out.println("Elemento borrado en la posición 3: " + dato + ". Nuevo contenido de la lista: " + lista);

        dato = lista.remove(2);
        comprueba(lista, "[A0, E1, C3]");
        System.out.println("Elemento borrado en la posición 2: " + dato + ". Nuevo contenido de la lista: " + lista);

        System.out.println("\nContenido de la lista: " + lista + " (" + lista.size() + " elementos).");
        System.out.println("--> Probamos clear():");
        lista.clear();
        comprueba(lista, "[]");

        lista.add("A");
        lista.add("A");
        lista.add("A");
        lista.add("B");
        System.out.println("\nContenido de la lista: " + lista + " (" + lista.size() + " elementos).");
        System.out.println("--> Probamos lastIndexOf():");
        índice = lista.lastIndexOf("A");
        System.out.println("Último índice de A: " + índice);

    }


    public static void comprueba(ListaCadenas lista, String valorCorrecto) {
        if (!lista.toString().equals(valorCorrecto)) {
            System.out.println("*** Detectado error: Se esperaba " + valorCorrecto + " pero se ha obtenido " + lista);
        } else {
            System.out.println("    (ok)");
        }
    }
}
