package tema2;

import java.util.Scanner;

public class TresEnRaya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tablero tablero = new Tablero();

        System.out.println(tablero);
        while (!tablero.finPartida()) {
            System.out.println("Turno de " + tablero.getTurno());
            System.out.print("Fila: ");
            int fila = sc.nextInt();
            System.out.print("Columna: ");
            int columna = sc.nextInt();

            boolean bien = tablero.jugada(fila, columna);
            if (bien) {
                System.out.println(tablero);
            } else
                System.out.println("Prueba otra vez.\n" + tablero);
        }

        if (tablero.esEmpate())
            System.out.println("Empate");
        else
            System.out.println("Ganador: " + tablero.getGanador());
    }
}
