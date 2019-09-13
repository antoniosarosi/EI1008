package Examenes.Julio2018;

class Estudiante {

    private String dni;
    private int suspensasBasicas;
    private int suspensasTotales;

    Estudiante(String dni) {
        this.dni = dni;
        suspensasBasicas = 0;
        suspensasTotales = 0;
    }

    String getDni() { return dni; }

    void contarSuspensa(boolean esBásica) {
        suspensasTotales++;
        if (esBásica)
            suspensasBasicas++;
    }

    int getTotalSuspensas() { return suspensasTotales; }

    int getBásicasSuspensas() { return suspensasTotales; }
}
