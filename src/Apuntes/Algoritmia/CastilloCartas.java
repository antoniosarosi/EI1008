package Apuntes.Algoritmia;

public class CastilloCartas {

    private static int numCartas(int numPisos) {
        if (numPisos == 1)
            return 2;
        return numCartas(numPisos - 1) + numPisos * 2 + numPisos - 1;
    }

    public static void main(String[] args) {
        int pisos = 1;
        System.out.println("Para " + pisos + " obtenemos: " + numCartas(pisos));
    }
}
