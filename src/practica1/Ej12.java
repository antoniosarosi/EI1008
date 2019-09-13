package practica1;

public class Ej12 {

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


    private static void prueba(String cadena, int esperado) {
        int numPalabras = contarPalabras(cadena);

        System.out.format("Prueba con '%s': ", cadena);

        if (numPalabras == esperado)
            System.out.println("OK");
        else
            System.out.println("ERROR");
    }


    public static void main(String[] args) {
        prueba("Una cadena de palabras", 4);
        prueba("   un texto   con  espacios    ", 4);
        prueba("1 2 3 4 5 6", 6);
        prueba("123456", 1);
        prueba("  otro ejemplo  ", 2);
    }
}