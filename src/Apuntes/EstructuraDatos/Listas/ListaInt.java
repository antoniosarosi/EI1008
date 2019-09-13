package Apuntes.EstructuraDatos.Listas;

public interface ListaInt {

    int length();

    void append(int data);

    void insert(int posicion, int data);

    int get(int posicion);

    void set(int posicion, int data);

    void deleteIndex(int posicion);

    void clearList();

    void deleteLast();

    boolean delElement(int elemento);

    boolean delAllElements(int elemento);

}
