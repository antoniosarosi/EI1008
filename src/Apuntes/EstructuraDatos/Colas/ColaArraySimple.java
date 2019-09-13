package Apuntes.EstructuraDatos.Colas;

import Apuntes.EstructuraDatos.Listas.ArrayList.ListaArray;

public class ColaArraySimple implements ColaIntegerSimple {

    private ListaArray cola;

    public ColaArraySimple() { cola = new ListaArray(); }

    public ColaArraySimple(int e) { cola = new ListaArray(e); }

    public ColaArraySimple(int[] v) { cola = new ListaArray(v); }


    public void add(int e) { cola.append(e); }

    public int peek() { return cola.get(0); }

    public int poll() {
        int e = cola.get(0);
        cola.deleteIndex(0);
        return e;
    }

    public boolean isEmpty() { return cola.length() == 0; }

    @Override
    public String toString() { return cola.toString(); }

}
