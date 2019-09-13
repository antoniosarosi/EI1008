package Apuntes.EstructuraDatos.Colas;

public interface ColaIntegerDoble {

    void addF(int e);
    void addL(int e);

    int peekF();
    int peekL();

    int pollF();
    int pollL();

    boolean isEmpty();

}
