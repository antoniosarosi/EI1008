package tema2;

public class Ej02ConjuntoPruebas {

	public static void main(String[] args) {
		Conjunto c1 = new Conjunto();
		
		c1.insertar("A");
		c1.insertar("U");
		c1.insertar("A");
		c1.insertar("I");
		c1.insertar("O");
		c1.insertar("I");
		c1.insertar("A");
		System.out.println("c1 es " + c1);
		
		Conjunto c2 = new Conjunto();
		c2.insertar("O");
		c2.insertar("I");
		c2.insertar("E");
		c2.insertar("U");
		c2.insertar("A");
		System.out.println("c2 es " + c2);
		
		System.out.println("¿c1 y c2 son iguales? " + c1.equals(c2));
		
		c2.borrar("E");
		System.out.println("\nAhora c2 es " + c2);
		System.out.println("¿c1 y c2 son iguales? " + c1.equals(c2));
	}

}
