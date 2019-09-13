package tema3;

public class Ej07ConjuntoPruebas {

	public static void main(String[] args) {
		Conjunto c1 = new ConjuntoNodos();

		c1.insertar(3);
		c1.insertar(7);
		c1.insertar(3);
		c1.insertar(1);
		c1.insertar(5);
		c1.insertar(1);
		c1.insertar(3);
		System.out.println("c1 es " + c1);

		Conjunto c2 = new ConjuntoNodos();
		c2.insertar(5);
		c2.insertar(1);
		c2.insertar(2);
		c2.insertar(7);
		c2.insertar(3);
		System.out.println("c2 es " + c2);

		System.out.println("¿c1 y c2 son iguales? " + c1.equals(c2));

		c2.borrar(2);
		System.out.println("\nAhora c2 es " + c2);
		System.out.println("¿c1 y c2 son iguales? " + c1.equals(c2));
	}

}
