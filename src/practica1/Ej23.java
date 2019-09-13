package practica1;

import java.util.Arrays;

public class Ej23 {

    private static boolean estáEnTodasLasColumnas(int[][] matriz, int num) {

        int vecesQueDebeAparecer = matriz[0].length;
        int aparece = 0;

        for (int col = 0; col < matriz[0].length; col++) {
            for (int fil = 0; fil < matriz.length; fil++) {
                if (matriz[fil][col] == num) {
                    aparece++;
                    break;
                }
            }
        }

        return aparece == vecesQueDebeAparecer;
    }


    private static void prueba(int[][] matriz, int num, boolean esperado) {
        System.out.println("Prueba con la matriz: ");

        for (int[] fila : matriz)
            System.out.println("\t" + Arrays.toString(fila));

        System.out.println("Y numero " + num);

        System.out.println(estáEnTodasLasColumnas(matriz, num) == esperado ? "OK\n" : "ERROR\n");
    }


    public static void main(String[] args) {
         int[][] m1 = {
                 {1, 2, 3, 4},
                 {3, 7, 8, 9},
                 {4, 5, 6, 1},
                 {9, 3, 8, 6},
                 {6, 4, 1, 3}
         };

        int[][] m2 = {
                {1, 2, 3, 4},
                {3, 7, 8, 9},
                {4, 5, 6, 1},
                {9, 3, 8, 6},
                {6, 4, 1, 0}
        };

        int[][] m3 = {
                {7, 4, 1, 2, 0},
                {0, 3, 1, 3, 8},
                {1, 2, 3, 4, 7},
                {1, 5, 7, 5, 7},
                {1, 1, 9, 6, 1},
                {1, 1, 4, 7, 1},
                {1, 0, 2, 1, 1}
        };

        int[][] m4 = {
                {7, 4, 1, 2, 0},
                {0, 3, 1, 3, 8},
                {1, 2, 3, 4, 7},
                {1, 5, 7, 5, 7},
                {1, 1, 9, 6, 2},
                {1, 1, 4, 7, 7},
                {1, 0, 2, 1, 9}
        };

        prueba(m1, 3, true);
        prueba(m2, 3, false);
        prueba(m3, 1, true);
        prueba(m4, 1, false);
    }
}
