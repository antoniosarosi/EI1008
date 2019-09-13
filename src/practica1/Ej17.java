package practica1;

import java.util.Arrays;

public class Ej17 {

    private static boolean hayRepetidos(int[] vector) {

       for (int elemento : vector) {
           int repetidos = 0;

           for (int buscar : vector)
               if (buscar == elemento)
                   repetidos++;

           if (repetidos > 1) return true;
       }

       return false;
    }


    private static void prueba(int[] vector, boolean esperado) {
        System.out.format("Prueba con %s: ", Arrays.toString(vector));
        System.out.println(hayRepetidos(vector) == esperado ? "OK" : "ERROR");
    }


    public static void main(String[] args) {
        int[] v1 = {1, 2, 3, 4};
        int[] v2 = {1, 2, 3, 4, 2};
        int[] v3 = {1, 2, 3, 4, 2, 3, 4};

        prueba(v1, false);
        prueba(v2, true);
        prueba(v3, true);
    }
}
