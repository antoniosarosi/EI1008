package practica2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ej03 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Indica el nombre del fichero de restaurantes: ");
        String fichero = entrada.nextLine();

        System.out.println("Indica tus coordenadas actuales");

        System.out.print("Coordenada X: ");
        double x = entrada.nextDouble();
        System.out.print("Coordenaeda Y: ");
        double y = entrada.nextDouble();
        entrada.close();

        Restaurante[] restaurantes = Restaurante.leeRestaurantes(fichero);
        Punto coordenadas = new Punto(x, y);

        Restaurante buscado = restauranteMásPróximo(restaurantes, coordenadas);

        System.out.format("El restaurante más cercano a su posición es %s, situado en el punto %s",
                buscado.getNombre(), buscado.getPosición());
    }

    public static Restaurante restauranteMásPróximo(Restaurante[] v, Punto p) {

        Restaurante masCercano = v[0];
        double distMin = v[0].distancia(p);

        for (Restaurante restaurante : v)
            if (restaurante.distancia(p) < distMin) {
                distMin = restaurante.distancia(p);
                masCercano = restaurante;
            }

        return masCercano;
    }

}
