package practica1;

import java.util.Arrays;

public class Ej15 {

    private static boolean estáOrdenado(String[] vector) {

        for (int i = 0; i < vector.length - 1; i++)
            if (vector[i + 1].compareTo(vector[i]) < 0)
                return false;

        return true;
    }


    private static void prueba(String[] vector, boolean esperado) {
        System.out.format("Prueba con %s: ", Arrays.toString(vector));
        System.out.println(estáOrdenado(vector) == esperado ? "OK" : "ERROR");
    }


    public static void main(String[] args) {
        String[] v1 = {"sartén", "sincronizado", "sinfonia"};
        String[] v2 = {"sincronizado", "sinfonia", "sartén"};
        String[] v3 = {"arbol", "barrio", "casa", "coche"};
        String[] v4 = {"arbol", "barrio", "coche", "casa"};

        prueba(v1, true);
        prueba(v2, false);
        prueba(v3, true);
        prueba(v4, false);
    }
}
