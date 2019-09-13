package practica2;

import java.util.Locale;

public class Punto {

    // Atributos
    private double x, y;

    // Constructores
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto() { x = y = 0; }

    // Métodos
    public double getX() {return x;}
    public double getY() {return y;}

    public Punto desplazar(double desplazamientoX, double desplazamientoY) {
        return new Punto(x + desplazamientoX, y + desplazamientoY);
    }

    public double distancia(Punto otroPunto) {
        return Math.sqrt(Math.pow((otroPunto.x - x), 2) + Math.pow((otroPunto.y - y), 2));
    }

    @Override
    public String toString() { return String.format(Locale.US, "(%.2f, %.2f)", x, y); }

    @Override
    public boolean equals(Object otroObjeto) {
        if (! (otroObjeto instanceof Punto)) return false;
        if (this == otroObjeto) return true;

        return x == ((Punto) otroObjeto).x && y == ((Punto) otroObjeto).y;
    }
}
