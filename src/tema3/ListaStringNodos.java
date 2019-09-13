package tema3;

public class ListaStringNodos implements ListaString {

	// Clase anidada
	// Nodo con enlace simple
	private static class Nodo {
		String dato;
		Nodo sig;

		Nodo(String dato, Nodo sig) {
			this.dato = dato;
			this.sig = sig;
		}
	}

	// Atributos
	private Nodo primero; // Enlace al primer elemento
	private int talla;    // Número de elementos

	// Constructor (por defecto)

	public boolean esVacía() {
		return primero == null;
		// También podemos hacer return talla == 0;
	}

	public int longitud() {
		return talla;
	}

	// Devuelve el elemento en la posición indicada de la lista
	public String consultar(int posición) {
		if (posición < 0 || posición >= talla) {
			throw new IndexOutOfBoundsException();
		}
		Nodo actual = primero;
		for (int i = 0; i < posición; i++)
			actual = actual.sig;

		return actual.dato;
	}

	// Inserta en la posición indicada el elemento dado
	public void insertar(int posición, String elemento) {
		if (posición < 0 || posición > talla) {
			throw new IndexOutOfBoundsException();
		}
		if (posición == 0) {
			primero = new Nodo(elemento, primero);
		} else {
			Nodo anterior = primero;
			for (int i = 0; i < posición - 1; i++)
				anterior = anterior.sig;
			Nodo nuevo = new Nodo(elemento, anterior.sig);
			anterior.sig = nuevo;
		}
		talla++;
	}

	// Borra el elemento en la posición dada
	public void borrar(int posición) {
		if (posición < 0 || posición >= talla) {
			throw new IndexOutOfBoundsException();
		}
		if (posición == 0) {
			primero = primero.sig;
		} else {
			Nodo anterior = primero;
			for (int i = 0; i < posición - 1; i++)
				anterior = anterior.sig;
			anterior.sig = anterior.sig.sig;
		}
		talla--;
	}

	// Borrar todos los elementos de la lista
	public void borrar() {
		primero = null;
		talla = 0;
	}

	// Borrar la primera ocurrencia del elemento dado.
	// Devuelve true si el elemento ha sido borrado.
	public boolean borrarPrimera(String elemento) {
		Nodo anterior = null;
		Nodo actual = primero;
		while (actual != null) {
			if (actual.dato.equals(elemento)) { // Encontrado
				// Borrar elemento
				if (anterior != null) {
					anterior.sig = actual.sig;
				} else {
					primero = actual.sig;
				}
				talla--;
				return true;
			} else {
				// Avanzar anterior y actual
				anterior = actual;
				actual = actual.sig;
			}
		}
		return false;
	}

	// Borrar todas las ocurrencias del elemento dado.
	// Devuelve true si el elemento ha sido borrado.
	public boolean borrarTodas(String elemento) {
		boolean borrado = false;
		Nodo anterior = null;
		Nodo actual = primero;
		while (actual != null) {
			if (actual.dato.equals(elemento)) { // Encontrado
				// Borrar elemento
				if (anterior != null) {
					anterior.sig = actual.sig;
				} else {
					primero = actual.sig;
				}
				talla--;
				borrado = true;
				actual = actual.sig;
			} else {
				// Avanzar anterior y actual
				anterior = actual;
				actual = actual.sig;
			}
		}
		return borrado;
	}

	public String toString() {
		if (esVacía()) {
			return "[]";
		} else {
			String resultado = "[" + primero.dato;
			for (Nodo aux = primero.sig; aux != null; aux = aux.sig) {
				resultado += ", " + aux.dato;
			}
			return resultado + "]";
		}
	}

}
