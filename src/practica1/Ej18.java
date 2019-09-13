package practica1;

import java.util.Arrays;

public class Ej18 {

    private static int[] eliminarPosición(int[] vector, int posicion) {

        if (posicion >= vector.length || posicion < 0)
            return vector;

        int[] nuevoVector = new int[vector.length - 1];

        int i = 0, j = 0;
        while (i < vector.length) {
            if (i != posicion) {
                nuevoVector[j] = vector[i];
                i++;
                j++;
            }
            else i++;
        }

        return nuevoVector;
    }


    private static void prueba(int[] vector, int posicion, int[] esperado) {
        System.out.format("Prueba con %s y %d: ", Arrays.toString(vector), posicion);
        System.out.println(Arrays.equals(eliminarPosición(vector, posicion), esperado) ? "OK" : "ERROR");
    }


    public static void main(String[] args) {
        int[] v1 = {0, 1, 2, 3, 4};
        int[] e1 = {0, 1, 2, 4};

        int[] v2 = {0, 1, 2, 3, 4};
        int[] e2 = {0, 1, 2, 3};

        int[] v3 = {0, 1, 2, 3, 4};
        int[] e3 = {1, 2, 3, 4};

        prueba(v1, 3, e1);
        prueba(v2, 4, e2);
        prueba(v3, 0, e3);
    }
}
