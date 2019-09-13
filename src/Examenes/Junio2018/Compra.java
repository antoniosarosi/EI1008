package Examenes.Junio2018;
 
public class Compra {

    private String dni;
    private int cantidad;

    public Compra(String dni, int cantidad) {
        this.dni = dni;
        this.cantidad = cantidad;
    }

    public String getDni() {
        return dni;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
