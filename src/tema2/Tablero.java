package tema2;

public class Tablero {
    private static final int LADO = 3;
    private static final char VACÍO = ' ';

    private char[][] casillas = new char[LADO][LADO];
    private char ganador;
    private char turno;
    private int llenas;

    public Tablero() {
        for (int fila = 0 ; fila < LADO ; fila++)
            for (int columna = 0 ; columna < LADO ; columna++)
                casillas[fila][columna] = VACÍO;
        ganador = VACÍO;
        turno = 'O';
    }

    public boolean finPartida() {
        return ganador != VACÍO || llenas == LADO * LADO;
    }

    public boolean jugada(int fila, int columna) {
        if (fueraRango(fila) || fueraRango(columna) || casillas[fila - 1][columna - 1] != VACÍO)
            return false;
        fila--;
        columna--;
        casillas[fila][columna] = turno;
        llenas++;
        if (haceFila(fila) || haceColumna(columna) || haceDiagonal(fila, columna))
            ganador = turno;
        turno = turno == 'O' ? 'X' : 'O';
        return true;
    }

    private boolean haceFila(int fila) {
        for (char casilla : casillas[fila])
            if (casilla != turno)
                return false;
        return true;
    }

    private boolean haceColumna(int columna) {
        for (int fila = 0 ; fila < LADO ; fila++)
            if (casillas[fila][columna] != turno)
                return false;
        return true;
    }

    private boolean haceDiagonal(int fila, int columna) {
        if (fila == columna) {
            boolean hace = true;
            for (int i = 0; i < LADO; i++)
                if (casillas[i][i] != turno) {
                    hace = false;
                    break;
                }
            if (hace)
                return true;
        }
        if (fila == LADO - 1 - columna) {
            for (int i = 0 ; i < LADO ; i++)
                if (casillas[i][LADO - 1 - i] != turno)
                    return false;
            return true;
        }
        return false;
    }

    private boolean fueraRango(int n) {
        return n <= 0 || n > LADO;
    }

    public char getGanador() {
        return ganador;
    }

    public char getTurno() {
        return turno;
    }

    public boolean esEmpate() {
        return llenas == LADO * LADO && ganador == VACÍO;
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int fila = 0 ; fila < LADO ; fila++) {
            if (fila != 0) {
                for (int columna = 0; columna < LADO; columna++) {
                    if (columna != 0)
                        resultado += '+';
                    resultado += '-';
                }
                resultado += '\n';
            }
            for (int columna = 0; columna < LADO; columna++) {
                if (columna != 0)
                    resultado += '|';
                resultado += casillas[fila][columna];
            }
            resultado += '\n';

        }
        return resultado;
    }
}
