package tema1;

public class Ej03Expresiones {

	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		System.out.println("La variable a vale " + a + " y la variable b vale " + b);
		System.out.print("¿Cuál es el resultado de evaluar a++ ? ");
		System.out.println(a++);
		System.out.print("¿Cuánto vale ahora a ? ");
		System.out.println(a);
		System.out.print("¿Cuál es el resultado de evaluar ++b ? ");
		System.out.println(++b);
		System.out.print("¿Cuánto vale ahora b ? ");
		System.out.println(b);

		int c;
		System.out.println("c es una variable entera");
		System.out.println("¿Cuál es el resultado de evaluar la siguiente expresión?   c = a == b ? a++ : b++ ");
		System.out.print("El resultado es: ");
		System.out.println(c = a == b ? a++ : b++);
		System.out.println("¿Cuánto vale ahora a ? " + a);
		System.out.println("¿Cuánto vale ahora b ? " + b);
		System.out.println("¿Cuánto vale ahora c ? " + c);
	}
}
