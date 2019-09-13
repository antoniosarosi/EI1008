package tests.Apuntes.Algoritmia;

import java.util.Arrays;
import java.util.Random;
import Apuntes.Algoritmia.SortingAlgorithms;

public class PruebaSorting {

    public static void main(String[] args) {

        int dim = 100000;
        Random random = new Random();

        int[] worstCase1 = new int[dim];
        int[] randomCase1 = new int[dim];

        int j = dim;
        for (int i = 0; i < worstCase1.length; i++) {
            worstCase1[i] = j;
            j--;
        }

        for (int i = 0; i < randomCase1.length; i++)
            randomCase1[i] = random.nextInt(dim + 1);

        int[] worstCase2 = Arrays.copyOf(worstCase1, worstCase1.length);
        int[] worstCase3 = Arrays.copyOf(worstCase1, worstCase1.length);
        int[] randomCase2 = Arrays.copyOf(randomCase1, randomCase1.length);
        int[] randomCase3 = Arrays.copyOf(randomCase1, randomCase1.length);

        long inicio, fin, tiempo;

        System.out.println("Caso aleatorio:");
//        inicio = System.nanoTime();
//        SortingAlgorithms.selectionSort(randomCase1);
//        fin = System.nanoTime();
//        tiempo = fin - inicio;
//        System.out.println("\tselection sort ha tardado: " + ((double) tiempo) / 1000000000 + " seg");

        inicio = System.nanoTime();
        SortingAlgorithms.insertionSort(randomCase2);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("\tinsertion sort ha tardado: " + ((double) tiempo) / 1000000000 + " seg");

        inicio = System.nanoTime();
        SortingAlgorithms.mergeSort(randomCase3);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("\tmerge sort ha tardado: " + ((double) tiempo) / 1000000000 + " seg");

        System.out.println("\nCaso orden invertido:");
//        inicio = System.nanoTime();
//        SortingAlgorithms.selectionSort(worstCase1);
//        fin = System.nanoTime();
//        tiempo = fin - inicio;
//        System.out.println("\tselection sort ha tardado: " + ((double) tiempo) / 1000000000 + " seg");

        inicio = System.nanoTime();
        SortingAlgorithms.insertionSort(worstCase2);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("\tinsertion sort ha tardado: " + ((double) tiempo) / 1000000000 + " seg");


        inicio = System.nanoTime();
        SortingAlgorithms.mergeSort(worstCase3);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        System.out.println("\tmerge sort ha tardado: " + ((double) tiempo) / 1000000000 + " seg");
    }


}
