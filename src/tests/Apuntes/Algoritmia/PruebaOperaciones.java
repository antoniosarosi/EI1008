package tests.Apuntes.Algoritmia;

import Apuntes.Algoritmia.OperationAlgorithms.*;

public class PruebaOperaciones {

    public static void main(String[] args) {
        long inicio, fin;
        double tiempo;
        long n, resultado;

        System.out.println("Prueba para sumatorio:");

        n = 100;
        for (int i = 0; i < 3; i++) {
            inicio = System.nanoTime();
            resultado = Sumatorio.constant(n);
            fin = System.nanoTime();
            tiempo = (((double) (fin - inicio)) / 1000000000);
            System.out.println("\tSumatorio constant para n = " + n + " ha tardado " + tiempo + " segundos " +
                    "con resultado: " + resultado);
            n *= 10;
        }
        System.out.println();

        n = 100;
        for (int i = 0; i < 3; i++) {
            inicio = System.nanoTime();
            resultado = Sumatorio.iterative(n);
            fin = System.nanoTime();
            tiempo = (((double) (fin - inicio)) / 1000000000);
            System.out.println("\tSumatorio iterative para n = " + n + " ha tardado " + tiempo + " segundos " +
                    "con resultado: " + resultado);
            n *= 10;
        }
        System.out.println();

        n = 100;
        for (int i = 0; i < 3; i++) {
            inicio = System.nanoTime();
            resultado = Sumatorio.recursive(n);
            fin = System.nanoTime();
            tiempo = (((double) (fin - inicio)) / 1000000000);
            System.out.println("\tSumatorio recursive para n = " + n + " ha tardado " + tiempo + " segundos " +
                    "con resultado: " + resultado);
            n *= 10;
        }
        System.out.println();

        System.out.println("Pruebas para factorial: ");
        n = 5;
        for (int i = 0; i < 3; i++) {
            inicio = System.nanoTime();
            resultado = Factorial.iterative((int) n);
            fin = System.nanoTime();
            tiempo = (((double) (fin - inicio)) / 1000000000);
            System.out.println("\tFactorial iterative para n = " + n + " ha tardado " + tiempo + " segundos " +
                    "con resultado: " + resultado);
            n += 5;
        }
        System.out.println();

        n = 5;
        for (int i = 0; i < 3; i++) {
            inicio = System.nanoTime();
            resultado = Factorial.recursive((int) n);
            fin = System.nanoTime();
            tiempo = (((double) (fin - inicio)) / 1000000000);
            System.out.println("\tFactorial recursive para n = " + n + " ha tardado " + tiempo + " segundos " +
                    "con resultado: " + resultado);
            n += 5;
        }
        System.out.println();

        System.out.println("Pruebas para fibonacci: ");
        n = 10;
        for (int i = 0; i < 3; i++) {
            inicio = System.nanoTime();
            resultado = Fibonnacci.iterative((int) n);
            fin = System.nanoTime();
            tiempo = (((double) (fin - inicio)) / 1000000000);
            System.out.println("\tFibonnaci iterative para n = " + n + " ha tardado " + tiempo + " segundos " +
                    "con resultado: " + resultado);
            n += 16;
        }
        System.out.println();

        n = 10;
        for (int i = 0; i < 3; i++) {
            inicio = System.nanoTime();
            resultado = Fibonnacci.recursive((int) n);
            fin = System.nanoTime();
            tiempo = (((double) (fin - inicio)) / 1000000000);
            System.out.println("\tFibonacci recursive para n = " + n + " ha tardado " + tiempo + " segundos " +
                    "con resultado: " + resultado);
            n += 16;
        }

        System.out.println("\nPruebas Hanoi: ");
        inicio = System.nanoTime();
        Hanoi.hanoi(3);
        fin = System.nanoTime();
        tiempo = (((double) (fin - inicio)) / 1000000000);
        System.out.println("Hanoi ha tardado " + tiempo + " segundos para 3 discos");
    }

}
