package practica1;

import java.util.Arrays;

public class Ej14 {

    private static int últimaPosición(int[] vector, int numero) {

        int posicion = -1;

        for (int i = 0; i < vector.length; i++)
            if (vector[i] == numero) posicion = i;

        return posicion;
    }


    private static void prueba(int[] vector, int numero, int esperado) {

        int posicion = últimaPosición(vector, numero);

        System.out.format("prueba con %s y %d: ", Arrays.toString(vector), numero);

        if (posicion == esperado)
            System.out.println("OK");
        else
            System.out.println("ERROR");
    }


    public static void main(String[] args) {

        int[] v1 = {0, 1, 2, 3, 4, 5};
        int[] v2 = {4, 1, 9, 6, 1, 6, 0};
        int[] v3 = {2, 11, 35, 1, 198, 976, 2};

        prueba(v1, 3, 3);
        prueba(v1, 6, -1);
        prueba(v2, 1, 4);
        prueba(v3, 2, 6);
    }
}
