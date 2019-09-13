package practica2.pruebas;

import practica2.Punto;
import practica2.Restaurante;

import java.io.FileNotFoundException;

public class RestaurantePruebas {

    private static boolean getNombreTest(String esperado, Restaurante restaurante) {
        return esperado.equals(restaurante.getNombre());
    }

    private static boolean getPosiciónTest(Punto esperado, Restaurante restaurante) {
        return esperado.toString().equals(restaurante.getPosición().toString());
    }

    private static boolean getValoraciónTest(int esperado, Restaurante restaurante) {
        return esperado == restaurante.getValoración();
    }

    private static boolean distanciaTest(double esperado, Restaurante restaurante, Punto punto) {
        return esperado == restaurante.distancia(punto);
    }

    private static boolean leeRestaurantesTest(Restaurante[] esperado, String fichero) throws FileNotFoundException {
        Restaurante[] restaurantes = Restaurante.leeRestaurantes(fichero);

        for (int i = 0; i < esperado.length; i++)
            if (! esperado[i].getNombre().equals(restaurantes[i].getNombre()))
                return false;

        return  true;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Restaurante res1 = new Restaurante("RestauranteUJI", new Punto(12.80, 11.60), 5);
        Restaurante res2 = new Restaurante("ResEsquina", new Punto(4.95, 6.97), 1);
        Restaurante res3 = new Restaurante("elRestaurante", new Punto(90.54, 87.45), 3);
        Restaurante res4 = new Restaurante("bazarComida", new Punto(30.45, 23.54), 2);
        Restaurante res5 = new Restaurante("foodRestaurant", new Punto(70.65, 38.65), 4);

        Restaurante[] v = {res1, res2, res3, res4, res5};

        System.out.println("getNombre:" + (getNombreTest("RestauranteUJI", res1) ? "OK" : "ERRROR"));
        System.out.println("getPosicion: " + (getPosiciónTest(new Punto(12.80, 11.60), res1) ? "OK" : "ERRROR"));
        System.out.println("getValoración: " + (getValoraciónTest(5, res1) ? "OK" : "ERROR"));

        System.out.println("distancia: " +
                ((distanciaTest(Math.sqrt(8.0), res1, new Punto(14.80, 13.60))) ? "OK" : "ERROR"));

        System.out.println("leeRestaurantes:  " +
                (leeRestaurantesTest(v, "ficheros/practica2/restaurantes.txt") ? "OK" : "ERROR"));
    }
}
