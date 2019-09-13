package Examenes.Junio2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cuentas {

    private static class Nodo {
        String nombre;
        double cantidad;
        Nodo sig;
        Nodo(String nombre, double cantidad, Nodo sig) {
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.sig = sig;
        }
    }

    private Nodo primero;

    private void insertar(String nombre, double cantidad) {
        Nodo anterior = primero;
        Nodo actual = primero;
        while (actual != null) {
            if (actual.nombre.equals(nombre)) {
                actual.cantidad += cantidad;
                return;
            }
            anterior = actual;
            actual = actual.sig;
        }
        anterior.sig = new Nodo(nombre, cantidad, null);
    }

    private void convertirASaldos() {
        double total = 0;
        int personas = 0;
        Nodo actual = primero;
        while (actual != null) {
            total += actual.cantidad;
            personas++;
            actual = actual.sig;
        }
        double gastMedio = total / personas;

        actual = primero;
        while (actual != null) {
            actual.cantidad -= gastMedio;
            actual = actual.sig;
        }
    }

    public Cuentas(String nombreFichero) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(nombreFichero));
        while (sc.hasNext()) {
            double cantidad = sc.nextDouble();
            String nombre = sc.next();
            insertar(nombre, cantidad);
        }
        sc.close();
        convertirASaldos();
    }

    public void asentarPago(String pagador, String receptor, double cantidad) {
        Nodo actual = primero;
        Nodo anterior = primero;

        while (actual != null) {
            if (actual.nombre.equals(pagador)) {
                actual.cantidad += cantidad;
                if (actual.cantidad == 0)
                    if (actual == primero)
                        primero = primero.sig;
                    else
                        anterior.sig = actual.sig;
            }
            else if (actual.nombre.equals(receptor)) {
                actual.cantidad -= cantidad;
                if (actual.cantidad == 0)
                    if (actual == primero)
                        primero = primero.sig;
                    else
                        anterior.sig = actual.sig;
            }
            anterior = actual;
            actual = actual.sig;
        }
    }

}
