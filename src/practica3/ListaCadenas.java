package practica3; // Indica aquí el nombre del paquete que utilizas.

public interface ListaCadenas {

    boolean add(String s);

    void add(int i, String s);

    void clear();

    String get(int i);

    int indexOf(String s);

    int lastIndexOf(String s);

    boolean isEmpty();

    String remove(int i);

    boolean remove(String s);

    int removeAll(String s);

    String set(int i, String s);

    int size();

}
