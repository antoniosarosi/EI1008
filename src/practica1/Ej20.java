package practica1;

import java.util.Arrays;

public class Ej20 {

    private static boolean contiene(int[] vector, int numero) {
        for (int e : vector)
            if (e == numero) return true;

        return false;
    }


    private static boolean contiene(int[] v1, int[] v2) {
        for (int e : v2)
            if (! contiene(v1, e)) return false;

        return true;
    }


    private static void prueba(int[] vector, int n, boolean esperado) {
        System.out.format("Prueba con %s y %d: ", Arrays.toString(vector), n);
        System.out.println(contiene(vector, n) == esperado ? "OK" : "ERROR");
    }


    private static void prueba(int[] v1, int[] v2, boolean esperado) {
        System.out.format("Prueba con %s y %s: ", Arrays.toString(v1), Arrays.toString(v2));
        System.out.println(contiene(v1, v2) == esperado ? "OK" : "ERROR");
    }


    public static void main(String[] args) {
        int[] v1 = {0, 2, 4, 6};
        int[] v2 = {1, -5, 12, 4, 6, 7, 8};
        int[] v3 = {6, 7, 8};

        prueba(v1, 2, true);
        prueba(v1, -1, false);

        prueba(v2, v3, true);
        prueba(v1, v3, false);
    }
}
