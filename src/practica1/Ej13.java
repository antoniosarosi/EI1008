package practica1;

public class Ej13 {

    private static int contarPalabras(String cadena) {

        int cantidadPalabras = 0;
        char anterior = ' ';

        for (int i = 0; i < cadena.length(); i++) {
            if (anterior != ' ' && cadena.charAt(i) == ' ')
                cantidadPalabras++;
            anterior = cadena.charAt(i);
        }

        if (cadena.charAt(cadena.length() - 1) == ' ')
            cantidadPalabras--;

        return cantidadPalabras + 1;
    }


    private static int encontrarInicio(String cadena, int i) {

        // Encuentra la posición de comienzo de una palabra en una cadena y la devuelve

        int cambios = 0, inicio = 0;
        char anterior = ' ';

        for (int index = 0; index < cadena.length(); index++) {
            if (anterior == ' ' && cadena.charAt(index) != ' ')
                cambios++;
            anterior = cadena.charAt(index);

            if (cambios == i) {
                inicio = index;
                break;
            }
        }

        return inicio;
    }


    private static String obtenerPalabra(String cadena, int i) {

        // Si el índice no es correcto devolvemos null

        if (i > contarPalabras(cadena) || i < 1)
            return null;

        // Le pasamos la cadena y el índice a la función auxiliar encontrarInicio

        int inicio = encontrarInicio(cadena, i), fin = cadena.length();

        /* Si la palabra a devolver no es la última o la cadena acaba en espacios en blanco buscamos la posición de fin
        de la palabra dentro de la cadena.

        Si por el contrario da la casualidad de que la palabra a buscar es justo la última y además la cadena no acaba
        con espacios en blanco, ya nos hemos definido fin como el length de la cadena, es decir que si pasamos eso como
        parámetro a substring el final de la palabra será justo el final de la cadena. Consideramos también los casos
        en los que existen comas o puntos en la cadena. */

        char finalCadena = cadena.charAt(cadena.length() - 1);

        if (i != contarPalabras(cadena) || finalCadena == ' ' || finalCadena == ',' || finalCadena == '.')
            for (int j = inicio; cadena.charAt(j) != ' ' && cadena.charAt(j) != ',' && cadena.charAt(j) != '.'; j++)
                fin = j + 1;

        return cadena.substring(inicio, fin);
    }


    private static void prueba(String cadena, int i, String esperado) {

        System.out.format("Prueba con '%s' y %d: ", cadena, i);

        if (obtenerPalabra(cadena, i) != null) {
            if (obtenerPalabra(cadena, i).equals(esperado))
                System.out.println("OK");

            else
                System.out.println("ERROR");
        }

        else if (esperado == null)
            System.out.println("OK");
    }


    public static void main(String[] args) {
        prueba("una cadena de palabras", 2, "cadena");
        prueba("una cadena de palabras", 4, "palabras");
        prueba("    palabras con    espacios     ", 3, "espacios");
        prueba("1 2 3 4", 3, "3");
        prueba("un texto", 3, null);
        prueba("una cadena, con comas, y puntos.", 2, "cadena");
        prueba("una cadena, con comas, y puntos.", 4, "comas");
        prueba("una cadena, con comas, y puntos.", 6, "puntos");
    }
}
