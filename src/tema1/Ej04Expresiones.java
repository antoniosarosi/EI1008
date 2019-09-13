package tema1;

public class Ej04Expresiones {

	public static void main(String[] args) {
		int a = 0;
		int b = 2;
		System.out.println("La variable a vale " + a + " y la variable b vale " + b);
		System.out.println("¿Cuál es el resultado de evaluar la siguiente expresión?   (a = b) + 3  == 5 ? 1 : 4 ");
		System.out.print("El resultado es: ");
		System.out.println((a = b) + 3 == 5 ? 1 : 4);
		System.out.print("¿Cuánto vale ahora a ? ");
		System.out.println(a);
		System.out.print("¿Cuánto vale ahora b ? ");
		System.out.println(b);
		System.out.println();

		a = 0;
		b = 2;
		System.out.println("La variable a vale " + a + " y la variable b vale " + b);
		System.out.println("¿Cuál es el resultado de evaluar la siguiente expresión?   a++ == b  ? a++ : b++ ");
		System.out.print("El resultado es: ");
		System.out.println(a++ == b  ? a++ : b++);
		System.out.print("¿Cuánto vale ahora a ? ");
		System.out.println(a);
		System.out.print("¿Cuánto vale ahora b ? ");
		System.out.println(b);
	}

}
