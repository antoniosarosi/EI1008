package practica1;

import java.util.Arrays;

public class EJ16 {

    private static int contarOlasFrío(double[] vector, int n) {

        int olas = 0, diasConsecutivos = 0;

        for (double temp : vector) {

            if (temp < 0)
                diasConsecutivos++;
            else
                diasConsecutivos = 0;

            if (diasConsecutivos == n + 1)
                olas++;
        }

        return olas;
    }


    private static void prueba(double[] vector, int n, int esperado) {

        int olas = contarOlasFrío(vector, n);

        System.out.format("Prueba con %s y %d: ", Arrays.toString(vector), n);

        if (olas == esperado) System.out.println("OK");
        else System.out.println("ERROR");
    }


    public static void main(String[] args) {

        System.out.println("Para las pruebas consideraremos los años de 12 dias\n");

        double[] v1 = {-8.97, -3.56, -5.98, 7.98, 11.5, 23.5, 30.6, 34.89, 31.5, 0.98, 0, -1.76};
        double[] v2 = {-8.97, -3.56, -5.98, 7.98, 11.5, 23.5, 30.6, 34.89, 31.5, -1.12, -0.65, -1.76};
        double[] v3 = {-8.97, -3.56, -5.98, -7.98, -11.5, 23.5, -30.6, -34.89, -31.5, -1.12, -0.65, -1.76};
        double[] v4 = {-8.97, -3.56, 5.98, -7.98, -11.5, 23.5, -30.6, -34.89, 31.5, -1.12, -0.65, 1.76};


        prueba(v1, 2, 1);
        prueba(v2, 2, 2);
        prueba(v3, 2, 2);
        prueba(v3, 4, 2);
        prueba(v4, 1, 4);
    }
}
