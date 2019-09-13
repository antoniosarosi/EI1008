package Examenes.Junio2016;

public class Juego {

    private String título;
    private int cantidad;

    public Juego(String título, int cantidad) {
        this.título = título;
        this.cantidad = cantidad;
    }

    public String getTítulo() {
        return título;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
