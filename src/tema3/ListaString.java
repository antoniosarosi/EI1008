package tema3;

public interface ListaString {

	boolean esVacía();

	int longitud();

	String consultar(int posición);

	void insertar(int posición, String elemento);

	void borrar(int posición);

	void borrar();

	boolean borrarPrimera(String elemento);

	boolean borrarTodas(String elemento);

}
