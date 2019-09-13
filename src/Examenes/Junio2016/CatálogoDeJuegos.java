package Examenes.Junio2016;

import java.util.Arrays;

public class CatálogoDeJuegos {

    private static final int TAMAÑO_INICIAL = 10;

    private Juego[] vector;
    private int numJuegos;

    public CatálogoDeJuegos() {
        vector = new Juego[TAMAÑO_INICIAL];
        numJuegos = 0;
    }

    public int consultarEjemplares(String título) {
        return consultarEjemplares(título, 0, vector.length - 1);
    }

    private int consultarEjemplares(String título, int inicio, int fin) {
        if (inicio > fin)
            return 0;
        int mitad = (inicio + fin) / 2;
        if (vector[mitad].getTítulo().compareTo(título) < 0)
            return consultarEjemplares(título, mitad + 1, fin);
        else if (vector[mitad].getTítulo().compareTo(título) > 0)
            return consultarEjemplares(título, inicio, mitad - 1);
        else
            return vector[mitad].getCantidad();
    }

    public boolean agregarJuego(Juego nuevo) {
       for (int i = 0; i < vector.length; i++) {
           if (vector[i].getTítulo().equals(nuevo.getTítulo())) {
               vector[i].setCantidad(vector[i].getCantidad() + 1);
               return false;
           }
           if (nuevo.getTítulo().compareTo(vector[i].getTítulo()) < 0) {
               redimensionar();
               for (int j = i; j < numJuegos; j++)
                   vector[j + 1] = vector[j];
               vector[i] = nuevo;
               numJuegos++;
               return true;
           }
       }
       return false;
    }

    private void redimensionar() {
        if (numJuegos + 1 <= vector.length)
            return;
        Juego[] nuevo = new Juego[numJuegos * 2];
        System.arraycopy(vector, 0, nuevo, 0, numJuegos);
        vector = nuevo;
    }

    public boolean borrarJuego(String título) {
        for (int i = 0; i < vector.length; i++)
            if (vector[i].getTítulo().equals(título)) {
                vector[i].setCantidad(vector[i].getCantidad() - 1);
                if (vector[i].getCantidad() == 0) {
                    for (int j = numJuegos - 1; j > i; j--)
                        vector[j - 1] = vector[j];
                    vector[numJuegos - 1] = null;
                    numJuegos--;
                }
                return true;
            }
        return false;
    }

    public CatálogoDeJuegos mezclar(CatálogoDeJuegos otroCátalogo) {
        int i1 = 0, i2 = 0, i3 = 0;
        while (i1 < this.vector.length && i2 < otroCátalogo.vector.length) {

        }
        return null;
    }
}
