package Examenes.Junio2017.Ejercicio1;

public class NotaEstudiante {

    private String dni;
    private int convocatoria;
    private boolean presentado;
    private double nota;

    NotaEstudiante(String DNI, int convocatoria) {
        this.dni = DNI;
        this.convocatoria = convocatoria;
        this.presentado = false;
    }

    String getDNI() { return dni; }

    int getConvocatoria() { return convocatoria; }

    double getNota() { return nota; }

    void setNota(double nota) {
        this.nota = nota;
        presentado = true;
    }

    boolean getPresentado() { return presentado; }
}
