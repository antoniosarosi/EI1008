package practica2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ej04 {

    public static Restaurante restauranteMejorValorado(Restaurante[] v, Punto p, double d) {

        boolean noHayRestaurantes = true;
        for (Restaurante restaurante : v)
            if (restaurante.distancia(p) <= d)
                noHayRestaurantes = false;

        if (noHayRestaurantes) return null;

        int mejorValoracion = v[0].getValoración();
        Restaurante mejorValorado = v[0];

        for (Restaurante restaurante : v)
            if (restaurante.distancia(p) <= d)
                if (restaurante.getValoración() > mejorValoracion) {
                    mejorValoracion = restaurante.getValoración();
                    mejorValorado = restaurante;
                }

        return mejorValorado;
    }


    public static void main(String[] args) throws FileNotFoundException {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Indica el nombre del fichero de restaurantes: ");
        String fichero = entrada.nextLine();

        System.out.println("Indica tus coordenadas actuales");

        System.out.print("Coordenada X: ");
        double x = entrada.nextDouble();
        System.out.print("Coordenaeda Y: ");
        double y = entrada.nextDouble();

        System.out.print("Indica la distancia máxima a la que quieres andar: ");
        double distancia = entrada.nextDouble();
        entrada.close();

        Punto coordenadas = new Punto(x, y);
        Restaurante[] restaurantes = Restaurante.leeRestaurantes(fichero);

        Restaurante buscado = restauranteMejorValorado(restaurantes, coordenadas, distancia);

        if (buscado != null)
            System.out.format("EL restaurante mejor valorado que se encuentra a una distancia menor o igual que" +
                    " %.2f es %s, ubicado en %s a una distancia de %.2f", distancia, buscado.getNombre(),
                    buscado.getPosición().toString(), buscado.distancia(coordenadas));
        else
            System.out.println("No hay restaurantes a esa distancia");
    }
}
