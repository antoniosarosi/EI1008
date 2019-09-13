package tema2;

public class Conjunto {

	// Atributos
	private String[] elementos;

	// Constructor
	public Conjunto() {
		elementos = new String[0]; // Crea un vector de 0 elementos. Evita que el vector sea null.
	}

	public boolean esVacío() {
		return elementos.length == 0;
	}

	public int longitud() {
		return elementos.length;
	}

	// Añade, si no estaba, el elemento dado al conjunto.
	// No mantiene ningún orden concreto
	public void insertar(String elemento) {
		if (! contiene(elemento)) {
			String[] nuevo = new String[elementos.length + 1];
			for (int i = 0; i < elementos.length; i++)
				nuevo[i] = elementos[i];
			nuevo[elementos.length] = elemento;
			elementos = nuevo;
		}
	}

	// Indica la posición donde se encuentra un elemento.
	// Devuelve un valor negativo si el elemento no está.
	private int posición(String elemento) {
		for (int i = 0; i < elementos.length; i++)
			if (elemento.equals(elementos[i]))
				return i;
		return -1;
	}

	// Devuelve true si el conjunto contiene el elemento dado.
	public boolean contiene(String elemento) {
		return posición(elemento) >= 0;
	}

	// Borra, si estaba, el elemento dado.
	public void borrar(String elemento) {
		int pos = posición(elemento);
		if (pos >= 0) {
			String[] nuevo = new String[elementos.length - 1];
			for (int i = 0, j = 0; i < elementos.length; i++)
				if (i != pos)
					nuevo[j++] = elementos[i];
			elementos = nuevo;
		}
	}

	// Borra todos los elementos del conjunto
	public void borrar() {
		elementos = new String[0];
	}

	public String toString() {
		if (esVacío())
			return "{}";
		else {
			String resultado = "{" + elementos[0];
			for (int i = 1; i < elementos.length; i++)
				resultado += ", " + elementos[i];
			return resultado + "}";
		}
	}

	public boolean equals(Object otroObjeto) {
		if (this == otroObjeto)
			return true;
		if (! (otroObjeto instanceof Conjunto))
			return false;
		Conjunto otroConjunto = (Conjunto) otroObjeto;
		if (longitud() != otroConjunto.longitud())
			return false;
		for (int i = 0; i < elementos.length; i++)
			if (!otroConjunto.contiene(elementos[i]))
				return false;
		return true;
	}

}
