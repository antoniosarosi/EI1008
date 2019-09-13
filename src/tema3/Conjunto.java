package tema3;

public interface Conjunto {

	boolean esVacío();

	int cardinalidad();

	void insertar(int elemento);

	boolean contiene(int elemento);

	void borrar(int elemento);

	void borrar();

}
