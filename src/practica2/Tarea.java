package practica2;

public class Tarea {

    private Fecha fecha;
    private String descripción;

    public Tarea(Fecha fecha, String descripción) {
        this.fecha = fecha;
        this.descripción = descripción;
    }

    public Fecha getFecha() { return fecha; }
    public String getDescripción() { return descripción; }

    @Override
    public String toString() { return String.format("%s: %s", fecha, descripción); }
}
