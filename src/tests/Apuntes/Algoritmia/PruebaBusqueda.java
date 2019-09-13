package tests.Apuntes.Algoritmia;

import Apuntes.Algoritmia.SearchAlgorithms;

public class PruebaBusqueda {

    public static void main(String[] args) {
        int dim = 510000000;
        int[] array = new int[dim];
        int buscado;

        long inicio, fin, tiempo;

        for (int i = 1; i <= array.length; i++)
            array[i - 1] = 2 * i;

        System.out.println("Caso fácil, primer elemento y vector ordenado");

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.sequentialSearch(array, true, array[0]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda secuencial ha tardado " + ((double) tiempo) / 1000000000);

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.busquedaBinaria(array, array[0]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda binaria ha tardado " + ((double) tiempo) / 1000000000);

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.recursiveBinarySearch(array, array[0]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda binaria recursiva ha tardado " + ((double) tiempo) / 1000000000);

        System.out.println("\nCaso dificil, ultimo elemento y vector ordenado");

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.sequentialSearch(array, true, array[dim - 1]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda secuencial ha tardado " + ((double) tiempo) / 1000000000);

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.busquedaBinaria(array, array[dim - 1]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda binaria ha tardado " + ((double) tiempo) / 1000000000);

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.recursiveBinarySearch(array, array[dim - 1]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda binaria recursiva ha tardado " + ((double) tiempo) / 1000000000);

        System.out.println("\nCaso intermedio, elemento en la mitad y vector ordenado");

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.sequentialSearch(array, true, array[(dim - 1) / 2]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda secuencial ha tardado " + ((double) tiempo) / 1000000000);

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.busquedaBinaria(array, array[(dim - 1) / 2]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda binaria ha tardado " + ((double) tiempo) / 1000000000);

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.recursiveBinarySearch(array, array[(dim - 1) / 2]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda binaria recursiva ha tardado " + ((double) tiempo) / 1000000000);

        System.out.println("\nCaso mitad derecha");

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.sequentialSearch(array, true, array[(dim - 1) / 2 + (dim - 1) / 4]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda secuencial ha tardado " + ((double) tiempo) / 1000000000);

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.busquedaBinaria(array, array[(dim - 1) / 2 + (dim - 1) / 4]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda binaria ha tardado " + ((double) tiempo) / 1000000000);

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.recursiveBinarySearch(array, array[(dim - 1) / 2 + (dim - 1) / 4]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda binaria recursiva ha tardado " + ((double) tiempo) / 1000000000);


        System.out.println("\nCaso mitad izquierda");

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.sequentialSearch(array, true, array[(dim - 1) / 4]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda secuencial ha tardado " + ((double) tiempo) / 1000000000);

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.busquedaBinaria(array, array[(dim - 1) / 4]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda binaria ha tardado " + ((double) tiempo) / 1000000000);

        inicio = System.nanoTime();
        buscado = SearchAlgorithms.recursiveBinarySearch(array, array[(dim - 1) / 4]);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("Busqueda binaria recursiva ha tardado " + ((double) tiempo) / 1000000000);
    }
}
