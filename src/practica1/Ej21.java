package practica1;

import java.util.Arrays;

public class Ej21 {

    private static int posiciónInserción(int[] vector, int valor) {

        // Caso 1: valor menor que el primer elemento del vector
        if (valor < vector[0]) return 0;

        // Caso 2: valor mayor que el ultimo elemento del vector
        if (valor > vector[vector.length - 1]) return vector.length;

        // Caso 3: valor comprendido entre el primer y último elemento del vector
        int posicion = 0;
        for (int i = 0; i < vector.length; i++)
            if (vector[i] >= valor) {
                posicion = i;
                break;
            }

        return posicion;
    }


    private static void prueba(int[] vector, int v, int esperado) {
        System.out.format("Prueba con %s y %d: ", Arrays.toString(vector), v);
        System.out.println(posiciónInserción(vector, v) == esperado ? "OK" : "ERROR");
    }


    public static void main(String[] args) {
        int[] v = {1, 2, 3, 4};
        int[] v2 = {0, 3, 6, 9};
        int[] v3 = {0, 1, 2, 2, 2, 3};

        prueba(v, 2, 1);
        prueba(v, 0, 0);
        prueba(v, 5, 4);
        prueba(v2, 2, 1);
        prueba(v2, 4, 2);
        prueba(v2, 7, 3);
        prueba(v3, 2, 2);
    }
}
