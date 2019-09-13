package tema3;

import java.util.NoSuchElementException;

public class ColaDobleStringNodos implements ColaDobleString {

	// Clase anidada
	// Nodo con enlace doble
	private static class Nodo {
		String dato;
		Nodo sig;
		Nodo ant;

		Nodo(String dato, Nodo sig, Nodo ant) {
			this.dato = dato;
			this.sig = sig;
			this.ant = ant;
		}
	}

	private Nodo primero;
	private Nodo último;

	// Constructor (por defecto)

	public void insertarPrimero(String dato) {
		Nodo nuevo = new Nodo(dato, primero, null);
		if (esVacía()) {
			primero = nuevo;
			último = nuevo;
		} else {
			primero.ant = nuevo;
			primero = nuevo;
		}
	}

	public void insertarÚltimo(String dato) {
		Nodo nuevo = new Nodo(dato, null, último);
		if (esVacía()) {
			primero = nuevo;
			último = nuevo;
		} else {
			último.sig = nuevo;
			último = nuevo;
		}
	}

	public String extraerPrimero() {
		if (esVacía())
			throw new NoSuchElementException();
		String resultado = primero.dato;
		primero = primero.sig;
		if (primero == null)
			último = null;
		else
			primero.ant = null;
		return resultado;
	}

	public String extraerÚltimo() {
		if (esVacía())
			throw new NoSuchElementException();
		String resultado = último.dato;
		if (primero == último) { // 1 elemento
			primero = null;
			último = null;
		} else {
			último.ant.sig = null;
			último = último.ant;
		}
		return resultado;
	}

	public String consultarPrimero() {
		if (esVacía())
			throw new NoSuchElementException();
		return primero.dato;
	}

	public String consultarÚltimo() {
		if (esVacía())
			throw new NoSuchElementException();
		return último.dato;
	}

	public boolean esVacía() {
		return primero == null;
	}

}
