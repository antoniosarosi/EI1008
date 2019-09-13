package tema2;

// Elige la forma de representación que prefieras para el número complejo
import tema2.binomica.Complejo;
// import tema2.polar.Complejo;

public class Ej01ComplejoPruebas {

	public static void main(String[] args) {

		Complejo c1 = new Complejo();
		Complejo c2 = new Complejo(1, 1);
		Complejo c3 = new Complejo(2, 2);
		Complejo c4;
		Complejo c5;

		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		System.out.println("c3: " + c3);

		System.out.println("Calculamos c4 = c2 + c2");
		c4= c2.sumar(c2);
		System.out.println("c4: " + c4);

		System.out.println("c3.equals(c4): " + c3.equals(c4));
		System.out.println("c3 == c4: " + (c3 == c4));
		
		System.out.println("c3.equals(2): " + c3.equals(2));
		System.out.println("c3.equals(\"Hola\"): " + c3.equals("Hola"));

		
		System.out.println("c2 + c3 * c4: " + c2.sumar(c3.multiplicar(c4)));
		System.out.println("(c2 + c3) * c4: " + c2.sumar(c3).multiplicar(c4));
		
		c5 = new Complejo(0, 1);
		System.out.println("c5: " + c5);
		System.out.println("c5 * c5: " + c5.multiplicar(c5));
		System.out.println(String.format("Parte real de c5: %.2f", c5.getParteReal()));
		System.out.println(String.format("Parte imaginaria de c5: %.2f", c5.getParteImag()));
		System.out.println(String.format("Módulo de c5: %.2f", c5.getMódulo()));
		System.out.println(String.format("Argumento de c5: %.4f (Debe ser PI/2 = %.4f)", c5.getArgumento(), Math.PI/2));

		// c1.parteReal = 3;
		// Sólo sería válido si los atributos fuesen públicos y se emplease la representación binómica.
		// No sería posible elegir la forma de representación.
	}

}
