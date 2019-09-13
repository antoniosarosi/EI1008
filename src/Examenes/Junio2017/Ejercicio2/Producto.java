package Examenes.Junio2017.Ejercicio2;

import practica2.Fecha;

class Producto {

    private String código;
    private int cantidad;
    private Fecha fecha;

    Producto(String código, int cantidad, Fecha fecha) {
        this.código = código;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    String getCódigo() {
        return código;
    }

    int getCantidad() {
        return cantidad;
    }

    void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    Fecha getÚltimaFecha() {
        return fecha;
    }

    void setÚltimaFecha(Fecha fecha) {
        this.fecha = fecha;
    }
}
